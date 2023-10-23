package objectsort;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieTest {
    @Test
    public void testSortByTitleIgnoringArticles() {
        // Create test data
        List<Movie> movies = new ArrayList<>(Arrays.asList(
                new Movie("The Shawshank Redemption", 1994, Arrays.asList("Drama")),
                new Movie("The Matrix", 1999, Arrays.asList("Action", "Science Fiction")),
                new Movie("A Beautiful Mind", 2001, Arrays.asList("Biography", "Drama"))
        ));

        List<Movie> sortedMovies = Movie.sortByTitleIgnoringArticles(movies);

        assertEquals("A Beautiful Mind", sortedMovies.get(0).getTitle());
        assertEquals("The Matrix", sortedMovies.get(1).getTitle());
        assertEquals("The Shawshank Redemption", sortedMovies.get(2).getTitle());
    }
}