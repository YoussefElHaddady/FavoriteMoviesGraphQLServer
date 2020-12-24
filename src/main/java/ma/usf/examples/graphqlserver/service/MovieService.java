package ma.usf.examples.graphqlserver.service;

import java.util.List;
import java.util.Optional;

import ma.usf.examples.graphqlserver.entity.Movie;

public interface MovieService {

	public List<Movie> getAll();

	public Optional<Movie> getById(long id);

	public Movie save(Movie movie);

	public void delete(long id);

	public boolean isRecommended(Movie movie);
}
