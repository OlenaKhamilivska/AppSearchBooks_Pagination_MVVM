package com.example.paginationexamplejavacorrect.model;

public class QueryPOJO {

    private static String searchQueryString;

    public static String getSearchQueryString() {
        return searchQueryString;
    }

    public static void setSearchQueryString(String searchQueryString) {
        QueryPOJO.searchQueryString = searchQueryString;
    }
}
