package ma.usf.examples.graphqlserver;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.usf.examples.graphqlserver.entity.Movie;
import ma.usf.examples.graphqlserver.service.MovieService;

@SpringBootApplication
public class FavoriteMoviesGraphQlServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavoriteMoviesGraphQlServerApplication.class, args);
	}

	@Bean
	ApplicationRunner init(MovieService movieService) {
		return args -> {
			Stream.of("m1", "m2", "m3", "m4").forEach(name -> {
				Movie movie = new Movie();
				movie.setName(name);
				movieService.save(movie);
			});
			movieService.getAll().forEach(System.out::println);
		};
	}

}
