package com.fesss.model;

import java.sql.Timestamp;

/**
 * POJO-Modell fuer die Datenbank-Tabelle "termin"
 */
public class Termin {

    private Integer id;
    private int saalId;
    private String name;
    private Timestamp startDatum;
    private Timestamp endDatum;
    private int participants;
    private Boolean needFood;

    public Termin(Integer id, int saalId, String name, Timestamp startDatum, Timestamp endDatum, int participants, Boolean needFood) {
        this.id = id;
        this.saalId = saalId;
        this.name = name;
        this.startDatum = startDatum;
        this.endDatum = endDatum;
        this.participants = participants;
        this.needFood = needFood;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSaalId() {
        return saalId;
    }

    public void setSaalId(int saalId) {
        this.saalId = saalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(Timestamp startDatum) {
        this.startDatum = startDatum;
    }

    public Timestamp getEndDatum() {
        return endDatum;
    }

    public void setEndDatum(Timestamp endDatum) {
        this.endDatum = endDatum;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public Boolean getNeedFood() {
        return needFood;
    }

    public void setNeedFood(Boolean needFood) {
        this.needFood = needFood;
    }
}
