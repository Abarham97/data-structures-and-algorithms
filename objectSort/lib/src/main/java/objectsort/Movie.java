package objectsort;


import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class Movie {
    private String title;
    private int year;
    private List<String> genres;

    public Movie(String title, int year, List<String> genres) {
        this.title = title;
        this.year = year;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getGenres() {
        return genres;
    }

    public static List<Movie> sortByTitleIgnoringArticles(List<Movie> movies) {
        movies.sort(Comparator.comparing(movie -> removeLeadingArticles(movie.getTitle())));
        return movies;
    }

    private static String removeLeadingArticles(String title) {
        Pattern articlePattern = Pattern.compile("^(?i)(The|An|A)\\s");
        return articlePattern.matcher(title).replaceAll("").trim();
    }
}
