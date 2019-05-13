package com.semantic.sparql;

public class SparqlUtil {
    private static final String URI_TEXT = "http://jku.at.dke/";

    public static String stripURI(String predicate) {
        return predicate.replace(URI_TEXT, "");
    }

    public static String addUriToString(String filter) {
        return URI_TEXT + filter;
    }
}
