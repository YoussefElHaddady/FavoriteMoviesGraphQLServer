package ma.usf.examples.graphqlserver;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class FavoriteMoviesGraphQlServerApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void listMovies() throws Exception{
		String expectedResponse = "{\"data\":{\"movies\":[{\"id\":1,\"name\":\"m1\",\"rate\":0.0},{\"id\":2,\"name\":\"m2\",\"rate\":0.0},{\"id\":3,\"name\":\"m3\",\"rate\":0.0},{\"id\":4,\"name\":\"m4\",\"rate\":0.0}]}}";

		String query = "{\"query\":\"{movies {id name rate}}\"}";
		
		mockMvc.perform(MockMvcRequestBuilders.post("/graphql")
                .content(query)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse))
                .andReturn();
	}

	@Test
	void contextLoads() {
	}

}
