package com.semantic.sparql;

/**
 * allgemeine Klasse zur Abbildung eines Daten-Triplets.
 * Kann verwendet werden, um die gefundenen Daten abzubilden
 * <p>
 * Beispiel Suche nach LVAa:   name    predicate   object
 * DKE VO  hatECTS         6
 * DKE VO  hatTyp      LVA
 * DKE UE  hatTyp      Uebung
 * <p>
 * Suche nach Papers            name    predicate   object
 * Einführung DKE     hatAutor    Schrefl
 * Einführung DKE     hatAutor    Maier
 * Advanced DKE       isUsedFor   DKE VO
 */
public class ErgebnisDto {


    private String subject;

    private String predicate;

    private String object;

    public ErgebnisDto(String subject, String predicate, String object) {
        this.subject = subject;
        this.predicate = predicate;
        this.object = object;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

}
