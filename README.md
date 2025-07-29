# GitHub non fork repositories with branches

## Introduction
This is recruitment project where goal was to write an API that connects with GitHub API to pull all repositories of the indicated user, filter all non fork repositories and pull every repository branch with it's name and last commit SHU.

## Tecnology used
- Java 21
- Spring Boot 3.5.4
- Maven

## Project Structure
- Main Application Class: GitHubNonForksRecruitmentApplication.java
- Controller: Contains endpoint for handling HTTP requests (GitHubDataController.java)
- Service Layer: Contains business logic (GitHubDataService.java, GitHubDataServiceImpl.java)
- Model: Contains data models (UserRepository.java, Owner.java, ReposBranches.java, Commit.java, UserRepositoryDto.java)
- Exception Handling: Custom exceptions and exception handler (GlobalExceptionHandler.java, ResponseNotFoundException.java)
- Intergration Test: Test case for whole process from Controller throug Service Leyer to Response (GitHubReposTests.java).

## Running the Application
- Clone the repository.
- Run the application using Maven or an IDE.
- Use tools like Postman or cURL to make API requests.

## Endpoints
http://localhost:8080/users/{username}/repositories

Where **{username}** is a name of a user that we want to pull repositories

**Success action view:**
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

**Exception handling:**
```
{
    "message": "404 Not Found on GET request,
    "status": "NOT_FOUND"
}
```
