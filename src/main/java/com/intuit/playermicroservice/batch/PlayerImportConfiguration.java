package com.intuit.playermicroservice.batch;

import com.intuit.playermicroservice.entity.Player;
import com.intuit.playermicroservice.repository.PlayerRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import java.text.SimpleDateFormat;
import java.util.HashMap;

@Configuration
public class PlayerImportConfiguration {
    PlayerRepository playerRepository;

    public PlayerImportConfiguration(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Bean
    public FlatFileItemReader<Player> reader() {
        return new FlatFileItemReaderBuilder<Player>()
                .name("personItemReader")
                .resource(new ClassPathResource("static/Player.csv"))
                .delimited()
                .names(new String[]{"id", "birthYear","birthMonth","birthDay","birthCountry","birthState","birthCity","deathYear","deathMonth","deathDay","deathCountry","deathState","deathCity","nameFirst","nameLast","nameGiven","weight","height","battingHand","throwingHand","debut","finalGame","retroID","bbrefID"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Player.class);
                    setCustomEditors(new HashMap<>(){{
                        put("java.util.Date", new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
                    }});
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public PlayerItemProcessor processor() {
        return new PlayerItemProcessor();
    }

    @Bean
    public RepositoryItemWriter<Player> writer() {
        RepositoryItemWriter<Player> writer = new RepositoryItemWriter<>();
        writer.setRepository(playerRepository);
        writer.setMethodName("save");
        return writer;
    }


    @Bean
    public Job importUserJob(JobRepository jobRepository,
                             JobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, RepositoryItemWriter<Player> writer) {
        return new StepBuilder("step1", jobRepository)
                .<Player, Player> chunk(100, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }

}
