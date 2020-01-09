package com.illicitintelligence.mykotlinapiapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.illicitintelligence.mykotlinapiapp.model.RepoResult
import com.illicitintelligence.mykotlinapiapp.network.GitRetrofit
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GitViewModel(application: Application) : AndroidViewModel(application) {
    /*
    *
    *   GitViewModel(Applcication application){
    *       super.AndroidViewModel(application);
    *   }
    *
    *
    * */

    val gitRetrofit = GitRetrofit()

    fun getRepositories(): Observable<List<RepoResult>> {

        return gitRetrofit.getRepositories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


}