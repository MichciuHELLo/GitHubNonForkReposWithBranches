package github.nonForks.GitHubNonForks_recruitment.model.dto;

import github.nonForks.GitHubNonForks_recruitment.model.Owner;
import github.nonForks.GitHubNonForks_recruitment.model.ReposBranches;

import java.util.List;

public record UserRepositoryDto(String name, Owner owner, List<ReposBranches> reposBranches) {
}
