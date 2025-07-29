package github.nonForks.GitHubNonForks_recruitment.model;

import java.io.Serializable;

public record UserRepository(String name, Owner owner, boolean fork) implements Serializable {
}
