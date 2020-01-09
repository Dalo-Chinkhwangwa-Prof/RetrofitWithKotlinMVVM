package com.illicitintelligence.mykotlinapiapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.illicitintelligence.mykotlinapiapp.R
import com.illicitintelligence.mykotlinapiapp.model.RepoResult
import com.illicitintelligence.mykotlinapiapp.viewmodel.GitViewModel
import io.reactivex.disposables.CompositeDisposable

class MainActivity : AppCompatActivity() {

    val compositeDisposable = CompositeDisposable()

    lateinit var viewModel: GitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(GitViewModel::class.java)

        compositeDisposable.add(
            viewModel.getRepositories()
                .subscribe( { repositoryList ->
                    printResults(repositoryList)
                }, { throwable ->
                    Log.d("TAG_X", throwable.message)
                })
        )

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()

    }

    private fun printResults(repositoryList: List<RepoResult>) {
        repositoryList.forEach { listItem ->
            Log.d("TAG_X", listItem.name)
        }
    }

}
