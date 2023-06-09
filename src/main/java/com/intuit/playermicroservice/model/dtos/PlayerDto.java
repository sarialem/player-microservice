package com.intuit.playermicroservice.model.dtos;

import com.intuit.playermicroservice.model.entity.Player;
import com.intuit.playermicroservice.model.Hand;

import java.util.Date;
import java.util.Objects;

public class PlayerDto {

    String id;

    Integer birthYear;

    Short birthMonth;

    Short birthDay;

    String birthCountry;

    String birthState;

    String birthCity;

    Integer deathYear;

    Short deathMonth;

    Short deathDay;

    String deathCountry;

    String deathState;

    String deathCity;

    String nameFirst;

    String nameLast;

    String nameGiven;

    Double weight;

    Double height;

    Hand battingHand;

    Hand throwingHand;

    Date debut;
    Date finalGame;

    String retroID;
    String bbrefID;


    public PlayerDto(Player player) {
        this(player.getId(),
                player.getBirthYear(),
                player.getBirthMonth(),
                player.getBirthDay(),
                player.getBirthCountry(),
                player.getBirthState(),
                player.getBirthCity(),
                player.getDeathYear(),
                player.getDeathMonth(),
                player.getDeathDay(),
                player.getDeathCountry(),
                player.getDeathState(),
                player.getDeathCity(),
                player.getNameFirst(),
                player.getNameLast(),
                player.getNameGiven(),
                player.getWeight(),
                player.getHeight(),
                player.getBattingHand(),
                player.getThrowingHand(),
                player.getDebut(),
                player.getFinalGame(),
                player.getRetroID(),
                player.getBbrefID());
    }

    public PlayerDto(String id,
                     Integer birthYear,
                     Short birthMonth, Short birthDay,
                     String birthCountry,
                     String birthState,
                     String birthCity,
                     Integer deathYear,
                     Short deathMonth,
                     Short deathDay,
                     String deathCountry,
                     String deathState,
                     String deathCity,
                     String nameFirst,
                     String nameLast,
                     String nameGiven,
                     Double weight,
                     Double height,
                     Hand battingHand,
                     Hand throwingHand,
                     Date debut,
                     Date finalGame,
                     String retroID,
                     String bbrefID) {

        this.id = id;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthCountry = birthCountry;
        this.birthState = birthState;
        this.birthCity = birthCity;
        this.deathYear = deathYear;
        this.deathMonth = deathMonth;
        this.deathDay = deathDay;
        this.deathCountry = deathCountry;
        this.deathState = deathState;
        this.deathCity = deathCity;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.nameGiven = nameGiven;
        this.weight = weight;
        this.height = height;
        this.battingHand = battingHand;
        this.throwingHand = throwingHand;
        this.debut = debut;
        this.finalGame = finalGame;
        this.retroID = retroID;
        this.bbrefID = bbrefID;
    }

    public PlayerDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Short getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(Short birthMonth) {
        this.birthMonth = birthMonth;
    }

    public Short getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Short birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getBirthState() {
        return birthState;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public Short getDeathMonth() {
        return deathMonth;
    }

    public void setDeathMonth(Short deathMonth) {
        this.deathMonth = deathMonth;
    }

    public Short getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(Short deathDay) {
        this.deathDay = deathDay;
    }

    public String getDeathCountry() {
        return deathCountry;
    }

    public void setDeathCountry(String deathCountry) {
        this.deathCountry = deathCountry;
    }

    public String getDeathState() {
        return deathState;
    }

    public void setDeathState(String deathState) {
        this.deathState = deathState;
    }

    public String getDeathCity() {
        return deathCity;
    }

    public void setDeathCity(String deathCity) {
        this.deathCity = deathCity;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getNameGiven() {
        return nameGiven;
    }

    public void setNameGiven(String nameGiven) {
        this.nameGiven = nameGiven;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Hand getBattingHand() {
        return battingHand;
    }

    public void setBattingHand(Hand battingHand) {
        this.battingHand = battingHand;
    }

    public Hand getThrowingHand() {
        return throwingHand;
    }

    public void setThrowingHand(Hand throwingHand) {
        this.throwingHand = throwingHand;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFinalGame() {
        return finalGame;
    }

    public void setFinalGame(Date finalGame) {
        this.finalGame = finalGame;
    }

    public String getRetroID() {
        return retroID;
    }

    public void setRetroID(String retroID) {
        this.retroID = retroID;
    }

    public String getBbrefID() {
        return bbrefID;
    }

    public void setBbrefID(String bbrefID) {
        this.bbrefID = bbrefID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerDto playerDto = (PlayerDto) o;
        return Objects.equals(id, playerDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
