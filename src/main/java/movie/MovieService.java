package movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {
    private List<Movie> movies = new ArrayList<>();

    public void save(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }

    public Movie newestMovie() {
        if (movies.isEmpty()) {
            throw new IllegalArgumentException("Movie list most be empty!");
        }
        List<Movie> sorted = movies.stream()
                .sorted(Comparator.comparing(Movie::getReleaseDate))
                .collect(Collectors.toList());
        return sorted.get(0);
    }

    public Movie findMovie(String pattern) {
        return movies.stream()
                .filter(m -> m.getName().contains(pattern))
                .findFirst()
                .orElse(null);
    }
}
