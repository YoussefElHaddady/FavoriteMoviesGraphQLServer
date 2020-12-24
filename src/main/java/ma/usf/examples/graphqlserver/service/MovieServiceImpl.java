package ma.usf.examples.graphqlserver.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import ma.usf.examples.graphqlserver.entity.Movie;
import ma.usf.examples.graphqlserver.repository.MovieRepository;

@Service
@GraphQLApi
public class MovieServiceImpl implements MovieService {

	private final MovieRepository movieRepository;

	public MovieServiceImpl(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	@Override
	@GraphQLQuery(name = "movies")
	public List<Movie> getAll() {
		return movieRepository.findAll();
	}

	@Override
	@GraphQLQuery(name = "movie")
	public Optional<Movie> getById(@GraphQLArgument(name = "id") long id) {
		return movieRepository.findById(id);
	}

	@Override
	@GraphQLMutation(name = "save")
	public Movie save(@GraphQLArgument(name = "movie") Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	@GraphQLMutation(name = "delete")
	public void delete(@GraphQLArgument(name = "id") long id) {
		movieRepository.deleteById(id);
	}

	@Override
	@GraphQLQuery(name = "isRecommended")
	public boolean isRecommended(Movie movie) {
		return movie != null && movie.getRate() >= 9;
	}

}
