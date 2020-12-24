package ma.usf.examples.graphqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.usf.examples.graphqlserver.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
