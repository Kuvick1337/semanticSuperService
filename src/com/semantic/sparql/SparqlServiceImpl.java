package com.semantic.sparql;

import java.util.LinkedList;
import java.util.List;

public class SparqlServiceImpl implements SparqlService {

    @Override
    public List<ErgebnisDto> findLehrveranstaltungenByFilter(List<FilterDto> filters) {
        List<ErgebnisDto> list = new LinkedList<>();
        list.add(new ErgebnisDto("DKE VO", "hatECTS", "6"));
        list.add(new ErgebnisDto("DKE UE", "hatECTS", "6"));
        list.add(new ErgebnisDto("Datenmodellierung VO", "hatTyp", "LVA"));
        list.add(new ErgebnisDto("Datenmodellierung UE", "hatTyp", "Übung"));

        return list;
    }

    @Override
    public List<ErgebnisDto> findProfessorenByFilter(List<FilterDto> filters) {
        List<ErgebnisDto> list = new LinkedList<>();
        list.add(new ErgebnisDto("Schrefl", "hatTitel", "Dr."));
        list.add(new ErgebnisDto("Queleshi", "hatTitel", "Dr."));
        list.add(new ErgebnisDto("Kovacic", "hatTitel", "MSc."));
        list.add(new ErgebnisDto("Schrefl", "gehoertZu", "JKU DKE Institut"));

        return list;
    }

    @Override
    public List<ErgebnisDto> findPapersByFilter(List<FilterDto> filters) {
        List<ErgebnisDto> list = new LinkedList<>();
        list.add(new ErgebnisDto("Einführung DKE", "isUsedFor", "DKE"));
        list.add(new ErgebnisDto("Queleshi", "hatTitel", "Dr."));
        list.add(new ErgebnisDto("Kovacic", "hatTitel", "MSc."));
        list.add(new ErgebnisDto("Schrefl", "gehoertZu", "JKU DKE Institut"));

        return list;
    }

    @Override
    public List<String> getSuchfilterForLehrveranstaltungen() {
        List<String> list = new LinkedList<>();
        list.add("hasECTS");
        list.add("hasPaper");
        list.add("isLvaType");

        return list;
    }

    @Override
    public List<String> getSuchfilterForProfessoren() {
        List<String> list = new LinkedList<>();
        list.add("hasTitel");
        list.add("hasPaper");
        list.add("hasLva");

        return list;
    }

    @Override
    public List<String> getSuchfilterForPapers() {
        List<String> list = new LinkedList<>();
        list.add("hasAutor");
        list.add("isUsedForLVA");
        list.add("isSimilarTo");

        return list;
    }
}
