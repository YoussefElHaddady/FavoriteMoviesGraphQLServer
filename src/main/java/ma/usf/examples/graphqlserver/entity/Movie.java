package ma.usf.examples.graphqlserver.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Movie implements Serializable {

	private static final long serialVersionUID = 102820234475696012L;

	@Id
	@GeneratedValue
	@GraphQLQuery(name = "id", description = "A movie's id")
	private long id;

	@GraphQLQuery(name = "name", description = "A movie's name")
	private String name;

	@GraphQLQuery(name = "rate")
	private double rate;
}
