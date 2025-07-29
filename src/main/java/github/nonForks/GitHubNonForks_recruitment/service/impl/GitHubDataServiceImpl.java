package github.nonForks.GitHubNonForks_recruitment.service.impl;

import github.nonForks.GitHubNonForks_recruitment.exception.ResponseNotFoundException;
import github.nonForks.GitHubNonForks_recruitment.model.ReposBranches;
import github.nonForks.GitHubNonForks_recruitment.model.UserRepository;
import github.nonForks.GitHubNonForks_recruitment.model.dto.UserRepositoryDto;
import github.nonForks.GitHubNonForks_recruitment.service.GitHubDataService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GitHubDataServiceImpl implements GitHubDataService {

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<UserRepositoryDto> getRepositoriesByUsername(String username) {

        final String url = "https://api.github.com/users/" + username + "/repos";

        try {
            UserRepository[] response = restTemplate.getForObject(url, UserRepository[].class);
            List<UserRepository> nonForkRepos = Arrays.stream(response)
                    .filter(repo -> !repo.fork())
                    .toList();

            List<UserRepositoryDto> userRepositoryDto = new ArrayList<>();
            nonForkRepos.forEach(repo -> userRepositoryDto.add(new UserRepositoryDto(repo.name(), repo.owner(), getBranches(username, repo.name()))));

            return userRepositoryDto;

        } catch (RestClientException e) {
            throw new ResponseNotFoundException(e.getMessage());
        }
    }

    List<ReposBranches> getBranches(String username, String repoName) {

        final String url = "https://api.github.com/repos/" + username + "/" + repoName + "/branches";

        ReposBranches[] response = restTemplate.getForObject(url, ReposBranches[].class);
        return Arrays.stream(response).toList();
    }
}
