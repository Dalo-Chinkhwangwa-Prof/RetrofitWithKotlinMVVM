package com.illicitintelligence.mykotlinapiapp.network

import com.illicitintelligence.mykotlinapiapp.model.RepoResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GitService {

    @GET("/users/{userName}/repos")
    fun getRepositories(@Path("userName") userName: String): Observable<List<RepoResult>>

}