package com.semantic.semantic;

import com.semantic.model.Lehrveranstaltung;

import java.util.List;

public interface SparqlService {

    List<Lehrveranstaltung> findLehrveranstaltungenByName(String name);
}
