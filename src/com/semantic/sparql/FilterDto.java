package com.semantic.sparql;

public class FilterDto {
    /**
     * das Prädikat nach dem gesucht wird.
     * Beispiel: im Satz "Paper hatAutor Stary" ist hatAutor das Prädikat
     */
    private String searchPredicate;

    /**
     * der konkrete Wert, nach dem gesucht wird (User-Eingabe, zB "Stary")
     */
    private String searchValue;

    public FilterDto(String searchPredicate, String searchValue) {
        this.searchPredicate = searchPredicate;
        this.searchValue = searchValue;
    }

    public String getSearchPredicate() {
        return searchPredicate;
    }

    public void setSearchPredicate(String searchPredicate) {
        this.searchPredicate = searchPredicate;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
}
