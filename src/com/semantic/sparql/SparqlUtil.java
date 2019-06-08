package com.semantic.sparql;

import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;

public class SparqlUtil {
    private static final String URI_TEXT = "http://jku.at.dke/";
    private static final String STUDY_DIRECTION = "StudyDirection/";
    private static final String TOPIC = "Topic/";
    private static final String LVA = "LVA/";
    private static final String PAPER = "Paper/";
    private static final String PROFESSOR = "Prof/";

    /**
     * Strips away all unneccessary URI components contained in the data
     *
     * @param predicate the predicate to be stripped
     * @return naked predixcate
     */
    static String stripURI(String predicate) {
        String s = predicate.replace(URI_TEXT, "");
        s = s.replace(STUDY_DIRECTION, "");
        s = s.replace(TOPIC, "");
        s = s.replace(LVA, "");
        s = s.replace(PAPER, "");
        s = s.replace(PROFESSOR, "");
        return s;
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
     * @return search subject with URI if needed
     */
    static String addUriToSearchSubject(FilterDto dto) {
        String filterWithUri;

        if ("educate".equalsIgnoreCase(dto.getSearchPredicate()) || "isAbout".equalsIgnoreCase(dto.getSearchPredicate())) {
            filterWithUri = "<" + URI_TEXT + STUDY_DIRECTION + dto.getSearchValue() + ">";
        } else if ("hasJournal".equalsIgnoreCase(dto.getSearchPredicate()) || "hasTopic".equalsIgnoreCase(dto.getSearchPredicate())) {
            filterWithUri = "<" + URI_TEXT + TOPIC + dto.getSearchValue() + ">";
        } else if ("hasLVA".equalsIgnoreCase(dto.getSearchPredicate())) {
            filterWithUri = "<" + URI_TEXT + LVA + dto.getSearchValue() + ">";
        } else if ("write".equalsIgnoreCase(dto.getSearchPredicate())) {
            filterWithUri = "<" + URI_TEXT + PAPER + dto.getSearchValue() + ">";
        } else {
            filterWithUri = "\"" + dto.getSearchValue() + "\"";
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
