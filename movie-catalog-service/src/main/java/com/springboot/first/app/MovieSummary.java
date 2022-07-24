package com.springboot.first.app;

public class MovieSummary {

    private String Title;
    private String Overview;
    private String movieId;

    public MovieSummary() {
    }

    public MovieSummary( String movieId,String title, String overview) {
        Title = title;
        Overview = overview;
        this.movieId = movieId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getOverview() {
        return Overview;
    }

    public void setOverview(String overview) {
        Overview = overview;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
