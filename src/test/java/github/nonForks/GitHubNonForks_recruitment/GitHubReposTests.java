package github.nonForks.GitHubNonForks_recruitment;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import github.nonForks.GitHubNonForks_recruitment.model.dto.UserRepositoryDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GitHubReposTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void getRepositoriesWithBranchesByUsername_shouldReturn200() throws Exception {

		// given
		final String CORRECT_USERNAME = "MichciuHELLo";

		// when
		MvcResult response = mockMvc.perform(get("/users/" + CORRECT_USERNAME + "/repositories"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		List<UserRepositoryDto> reposWithBranches = objectMapper.readValue(response.getResponse().getContentAsString(), new TypeReference<>() {
		});

		// then
		assertNotNull(reposWithBranches);
        assertFalse(reposWithBranches.isEmpty(), "Should return at least one non-fork repository");

		reposWithBranches.forEach(repo -> {
			assertNotNull(repo.name());
			assertNotNull(repo.owner().login());
			assertNotNull(repo.reposBranches());

			repo.reposBranches().forEach(branch -> {
				assertNotNull(branch.name());
				assertNotNull(branch.commit());
			});

		});
	}
}
