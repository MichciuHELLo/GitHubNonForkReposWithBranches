package github.nonForks.GitHubNonForks_recruitment.service;

import github.nonForks.GitHubNonForks_recruitment.model.dto.UserRepositoryDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GitHubDataService {
    List<UserRepositoryDto> getRepositoriesByUsername(String username);
}
