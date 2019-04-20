package com.semantic.sparql;


import java.util.List;

public interface SparqlService {

    List<ErgebnisDto> findLehrveranstaltungenByFilter(List<FilterDto> filters);

    List<ErgebnisDto> findProfessorenByFilter(List<FilterDto> filters);

    List<ErgebnisDto> findPapersByFilter(List<FilterDto> filters);

    List<String> getSuchfilterForLehrveranstaltungen();

    List<String> getSuchfilterForProfessoren();

    List<String> getSuchfilterForPapers();
}
