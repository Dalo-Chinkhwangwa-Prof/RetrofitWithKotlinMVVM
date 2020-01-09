package com.illicitintelligence.mykotlinapiapp.network

import com.illicitintelligence.mykotlinapiapp.model.RepoResult
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GitRetrofit {

    private lateinit var gitService: GitService

    private val BASE_URL = "https://api.github.com"

    init {
        gitService = createService(retrofitInstance())
    }

    private fun retrofitInstance(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun createService(retrofit: Retrofit) : GitService {
        return retrofit.create(GitService::class.java)
    }

    fun getRepositories(): Observable<List<RepoResult>> {
        return gitService.getRepositories("Dalo-Chinkhwangwa-Prof")
    }

}