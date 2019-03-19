package com.semantic.model;

/**
 * POJO-Modell fuer die Datenbank-Tabelle "Saal'
 */
public class Saal {

    private int id;
    private String name;

    public Saal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Saal{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
