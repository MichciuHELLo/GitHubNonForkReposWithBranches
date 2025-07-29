# GitHub non fork repositories with branches

## Introduction
This is a recruitment project. The goal was to build a REST API that connects with the GitHub API to:
- fetch all public repositories of a given user,
- filter out forked repositories,
- and return all branches for each repository, including branch name and last commit SHA.

## Tecnology used
- Java 21
- Spring Boot 3.5.4
- Maven

## Project Structure
- **Main Application**: GitHubNonForksRecruitmentApplication.java
- **Controller**: Exposes the REST endpoint (GitHubDataController.java)
- **Service Layer**: Contains business logic (GitHubDataService.java, GitHubDataServiceImpl.java)
- **Model / DTO**: Data structures used for API responses (UserRepository.java, Owner.java, ReposBranches.java, Commit.java, UserRepositoryDto.java)
- **Exception Handling**: Custom exception and global handler (GlobalExceptionHandler.java, ResponseNotFoundException.java)
- **Intergration Test**: End-to-end test covering the full flow from controller to GitHub API (GitHubReposTests.java).

## Running the Application
- Clone the repository.
- Run the application using Maven or an IDE.
- Use tools like Postman or cURL to make API requests.

## Endpoints
http://localhost:8080/users/{username}/repositories

Where **{username}** is a name of a user that we want to pull repositories

**For example:** http://localhost:8080/users/MichciuHello/repositories
**Success action view**
```
[
    {
        "name": "GitHubNonForkReposWithBranches",
        "owner": {
            "login": "MichciuHELLo"
        },
        "reposBranches": [
            {
                "name": "main",
                "commit": {
                    "sha": "06b06..."
                }
            }
        ]
    }
]
```

**Error Response (e.g. user does not exist)**
```
{
    "message": "404 Not Found on GET request,
    "status": "NOT_FOUND"
}
```
