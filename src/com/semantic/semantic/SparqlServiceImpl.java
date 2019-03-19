package com.semantic.semantic;

import com.semantic.model.Lehrveranstaltung;

import java.util.LinkedList;
import java.util.List;

public class SparqlServiceImpl implements SparqlService {

    @Override
    public List<Lehrveranstaltung> findLehrveranstaltungenByName(String name) {
        List<Lehrveranstaltung> list = new LinkedList<>();
        list.add(new Lehrveranstaltung(1, "test"));

        return list;
    }
}
