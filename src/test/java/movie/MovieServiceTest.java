package movie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {
    private MovieService service = new MovieService();
    private Movie movie1 = new Movie("Batman 2", 120, LocalDate.parse("2017-06-22"));
    private Movie movie2 = new Movie("Star Wars", 180, LocalDate.parse("2015-04-15"));
    private Movie movie3 = new Movie("Motel", 60, LocalDate.parse("2014-07-28"));
    private Movie movie4 = new Movie("Batman", 150, LocalDate.parse("2011-05-15"));

    @BeforeEach
    void init() {
        service = new MovieService();
        service.save(movie1);
        service.save(movie2);
        service.save(movie3);
        service.save(movie4);
    }

    @Test
    void saveTest() {
        assertEquals(4, service.getMovies().size());
    }

    @Test
    void newestMovieTest() {
        Movie movie = service.newestMovie();
        assertEquals("Batman", movie.getName());
    }

    @Test
    void findTest() {
         List<Movie> movies = service.findMovie("at");
        assertEquals(2, movies.size());
    }
}