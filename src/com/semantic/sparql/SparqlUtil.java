package com.semantic.sparql;

import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;

public class SparqlUtil {
    private static final String URI_TEXT = "http://jku.at.dke/";

    static String stripURI(String predicate) {
        // TODO maybe also strip /StudyDirection and /Topic
        return predicate.replace(URI_TEXT, "");
    }

    /**
     * adds the service-specific URI to the search predicate
     *
     * @param filter
     * @return search predicate with URI
     */
    static String addUriToFilter(String filter) {
        return "<" + URI_TEXT + filter + ">";
    }

    /**
     * Adds the URI to the searched value depending on the filter value.
     * Some domains reside in a certain sub domain, eg. /Topics or /StudyDirection
     *
     * @param dto
     * @return
     */
    static String addUriToSearchSubject(FilterDto dto) {
        String filterWithUri;

        if ("educate".equalsIgnoreCase(dto.getSearchPredicate()) || "isAbout".equalsIgnoreCase(dto.getSearchPredicate())) {
            filterWithUri = "<" + URI_TEXT + "StudyDirection/" + dto.getSearchValue() + ">";
        } else if ("hasJournal".equalsIgnoreCase(dto.getSearchPredicate()) || "hasTopic".equalsIgnoreCase(dto.getSearchPredicate())) {
            filterWithUri = "<" + URI_TEXT + "Topic/" + dto.getSearchValue() + ">";
        } else if ("hasLVA".equalsIgnoreCase(dto.getSearchPredicate())) {
            filterWithUri = "<" + URI_TEXT + "LVA/" + dto.getSearchValue() + ">";
        } else if ("write".equalsIgnoreCase(dto.getSearchPredicate())) {
            filterWithUri = "<" + URI_TEXT + "Paper/" + dto.getSearchValue() + ">";
        } else {
            filterWithUri = "<" + URI_TEXT + dto.getSearchPredicate() + ">";
        }

        return filterWithUri;
    }

    /**
     * educate      -> http://jku.at.dke/StudyDirection
     * isAbout      -> http://jku.at.dke/StudyDirection
     * <p>
     * hasLVA       -> http://jku.at.dke/LVA
     * write        -> http://jku.at.dke/Paper
     * <p>
     * hasJournal   -> http://jku.at.dke/Topic
     * hasTopic     -> http://jku.at.dke/Topic
     */
    static String extractInfoFromNode(RDFNode node) {
        if (node != null) {
            Resource r = node.asResource();
            return stripURI(r.getURI());
        }
        return " ";
    }
}
