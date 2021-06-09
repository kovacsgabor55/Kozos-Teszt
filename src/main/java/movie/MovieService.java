package movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private List<Movie> movies = new ArrayList<>();

    public void save(Movie movie) {
        movies.add(movie);
    }

    public Movie findMovie(Strig pattern) {
        return movies.stream()
                .filter(m -> m.getName().contains(pattern))
                .finfirst().
                .orElse(null);
    }
}
