package com.codesorbit.assesment.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.codesorbit.assesment.models.HistoryModel;
import com.codesorbit.assesment.models.NewsModel;
import com.codesorbit.assesment.models.PostResponse;
import com.codesorbit.assesment.webservices.RetroClient;
import com.codesorbit.assesment.webservices.RetroRequest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private final ArrayList<NewsModel> newsModelArrayList = new ArrayList<>();
    private final ArrayList<HistoryModel> historyModelArrayList = new ArrayList<>();
    private final RetroRequest request;
    private MutableLiveData<ArrayList<NewsModel>> newsMutableLiveModel;
    private MutableLiveData<ArrayList<HistoryModel>> historyMutableLiveModel;
    private MutableLiveData<List<PostResponse>> responseData;

    public Repository() {
        request = RetroClient.getRetrofit().create(RetroRequest.class);
    }

    public MutableLiveData<List<PostResponse>> getResponseData() {
        if (responseData == null) {
            responseData = new MutableLiveData<>();
            setPostResponse();
        }
        return responseData;
    }

    private void setPostResponse() {
        request.getPost().enqueue(new Callback<List<PostResponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<PostResponse>> call, @NonNull Response<List<PostResponse>> response) {
                if (response.isSuccessful()) {
                    responseData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<PostResponse>> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public MutableLiveData<ArrayList<NewsModel>> getNewsModel() {
        if (newsMutableLiveModel == null) {
            newsMutableLiveModel = new MutableLiveData<>();
            setNewsData();
        }
        return newsMutableLiveModel;
    }

    public MutableLiveData<ArrayList<HistoryModel>> gethistoryModel() {
        if (historyMutableLiveModel == null) {
            historyMutableLiveModel = new MutableLiveData<>();
            setHisoryData();
        }
        return historyMutableLiveModel;
    }

    private void setNewsData() {
        newsModelArrayList.add(new NewsModel("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, "));
        newsModelArrayList.add(new NewsModel("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."));
        newsModelArrayList.add(new NewsModel("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,"));
        newsModelArrayList.add(new NewsModel("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, "));
        newsModelArrayList.add(new NewsModel("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,"));
        newsMutableLiveModel.setValue(newsModelArrayList);
    }

    private void setHisoryData() {
        historyModelArrayList.add(new HistoryModel("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg", "Payment History"));
        historyModelArrayList.add(new HistoryModel("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg", "Payment History"));
        historyModelArrayList.add(new HistoryModel("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg", "Payment History"));
        historyModelArrayList.add(new HistoryModel("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg", "Payment History"));
        historyModelArrayList.add(new HistoryModel("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg", "Payment History"));
        historyMutableLiveModel.setValue(historyModelArrayList);
    }
}
