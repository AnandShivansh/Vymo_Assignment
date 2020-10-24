package com.example.vymoassignment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface github_client {
    @GET("/repos/{github_owner_name}/{github_repo_name}/pulls")
    Call<List<git_class>> pulls_for_repo(@Path("github_owner_name") String github_owner_name, @Path("github_repo_name") String github_repo_name);
}
