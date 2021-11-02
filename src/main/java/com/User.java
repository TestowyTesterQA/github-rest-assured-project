package com;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    public String login;
    public int id;

    @JsonProperty("public_repos")
    // publicRepos - name in java convention
    // but jackson won't recognize it - In API JSON name is "public_repos"
    public int publicRepos;

    public String getLogin() { return login; }
    public int getId() { return id; }
    public int getPublicRepos() {
        return publicRepos;
    }
}
