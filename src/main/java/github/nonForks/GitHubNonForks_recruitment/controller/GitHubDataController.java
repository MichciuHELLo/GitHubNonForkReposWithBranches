package github.nonForks.GitHubNonForks_recruitment.controller;

import github.nonForks.GitHubNonForks_recruitment.service.GitHubDataService;
import github.nonForks.GitHubNonForks_recruitment.model.dto.UserRepositoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GitHubDataController {
    @Autowired
    private GitHubDataService gitHubDataService;

    @GetMapping("/users/{username}/repositories")
    public ResponseEntity<List<UserRepositoryDto>> getRepositoriesByUsername(@PathVariable String username) {
        return ResponseEntity.ok(gitHubDataService.getRepositoriesByUsername(username));
    }
}
