package com.semantic.sparql;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SparqlServiceImpl2 implements SparqlService {
    @Override
    public List<ErgebnisDto> findLehrveranstaltungenByFilter(List<FilterDto> filters) {
        return null;
    }

    @Override
    public List<ErgebnisDto> findProfessorenByFilter(List<FilterDto> filters) {
        return null;
    }

    @Override
    public List<ErgebnisDto> findPapersByFilter(List<FilterDto> filters) {
        return null;
    }

    @Override
    public List<String> getSuchfilterForLehrveranstaltungen() {
        String queryString = "SELECT DISTINCT ?predicate " +
                "WHERE { ?subject ?predicate ?object." +
                " FILTER regex(str(?subject), \"LVA\")" +
                "}";

        return performQueryAndExtractFilterPredicates(queryString);
    }

    @Override
    public List<String> getSuchfilterForProfessoren() {
        String queryString = "SELECT DISTINCT ?predicate " +
                "WHERE { ?subject ?predicate ?object." +
                " FILTER regex(str(?subject), \"Prof\")" +
                "}";

        return performQueryAndExtractFilterPredicates(queryString);
    }

    @Override
    public List<String> getSuchfilterForPapers() {
        String queryString = "SELECT DISTINCT ?predicate " +
                "WHERE { ?subject ?predicate ?object." +
                " FILTER regex(str(?subject), \"Paper\")" +
                "}";

        return performQueryAndExtractFilterPredicates(queryString);
    }

    /**
     * Performs the given SPARQL Query towards the given server URL and returns a distinct list of all filter predicates
     *
     * @param queryString the Sparql-Query
     * @return a list of all filter predicates
     */
    private List<String> performQueryAndExtractFilterPredicates(String queryString) {
        String strippedPredicate;
        LinkedList<String> filters = new LinkedList<>();

        for (String server : ServerList.getServers()) {
            QueryExecution queryExecution = QueryExecutionFactory.sparqlService(server, queryString);
            ResultSet resultSet = queryExecution.execSelect();

            while (resultSet.hasNext()) {
                QuerySolution qs = resultSet.next();
                RDFNode x = qs.get("predicate");
                Resource r = x.asResource();
                strippedPredicate = SparqlUtil.stripURI(r.getURI());
                filters.add(strippedPredicate);
            }
        }

        return filters.stream().distinct().collect(Collectors.toList());
    }
}
