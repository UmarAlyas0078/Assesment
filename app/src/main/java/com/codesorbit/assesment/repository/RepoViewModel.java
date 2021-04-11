package com.codesorbit.assesment.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.codesorbit.assesment.models.HistoryModel;
import com.codesorbit.assesment.models.NewsModel;
import com.codesorbit.assesment.models.PostResponse;

import java.util.ArrayList;
import java.util.List;

public class RepoViewModel extends ViewModel {
    Repository repository;
    private LiveData<ArrayList<NewsModel>> liveData;
    private LiveData<ArrayList<HistoryModel>> liveDataHistory;
    private LiveData<List<PostResponse>> responseLiveData;

    public RepoViewModel() {
        repository = new Repository();
    }

    public LiveData<ArrayList<NewsModel>> getLiveDataNews() {
        if (liveData == null) {
            liveData = repository.getNewsModel();
        }
        return liveData;
    }

    public LiveData<List<PostResponse>> getResponseLiveData() {
        if (responseLiveData == null) {
            responseLiveData = repository.getResponseData();
        }
        return responseLiveData;
    }

    public LiveData<ArrayList<HistoryModel>> getLiveDataHistory() {
        if (liveDataHistory == null) {
            liveDataHistory = repository.gethistoryModel();
        }
        return liveDataHistory;
    }
}
