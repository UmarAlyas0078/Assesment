package com.codesorbit.assesment.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.codesorbit.assesment.R;
import com.codesorbit.assesment.adapters.HistoryAdapter;
import com.codesorbit.assesment.adapters.NewsAdapter;
import com.codesorbit.assesment.databinding.HomeFragmentBinding;
import com.codesorbit.assesment.interfaces.OnMyFragmentListner;
import com.codesorbit.assesment.repository.RepoViewModel;
import com.codesorbit.assesment.utils.EqualSpacingItemDecoration;

public class HomeFragment extends Fragment {
    HomeFragmentBinding viewBinding;
    OnMyFragmentListner onMyFragmentListner;
    RepoViewModel repoViewModel;
    NewsAdapter newsAdapter;
    HistoryAdapter historyAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewBinding = HomeFragmentBinding.inflate(inflater);
        if (getActivity() instanceof OnMyFragmentListner) {
            onMyFragmentListner = (OnMyFragmentListner) getActivity();
            onMyFragmentListner.OnFragmentListner("Home");
        } else {
            throw new RuntimeException(requireActivity().toString());
        }
        return viewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        repoViewModel = new ViewModelProvider(requireActivity()).get(RepoViewModel.class);
        setData();
        setGovernmentServices();
        setOtherServices();
        clickListner();
    }

    private void clickListner() {
        viewBinding.imgGovernmentHistory.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_servicesFragment));
    }

    private void setGovernmentServices() {
        Glide.with(requireActivity()).asBitmap().load("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg")
                .into(viewBinding.lnlGovernment.imgGovernment);
        Glide.with(requireActivity()).asBitmap().load("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg")
                .into(viewBinding.lnlGovernment.imgGovernment1);
        Glide.with(requireActivity()).asBitmap().load("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg")
                .into(viewBinding.lnlGovernment.imgGovernment2);
        Glide.with(requireActivity()).asBitmap().load("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg")
                .into(viewBinding.lnlGovernment.imgGovernment3);
    }

    private void setOtherServices() {
        Glide.with(requireActivity()).asBitmap().load("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg")
                .into(viewBinding.lnlOthersServices.imgGovernment);
        Glide.with(requireActivity()).asBitmap().load("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg")
                .into(viewBinding.lnlOthersServices.imgGovernment1);
        Glide.with(requireActivity()).asBitmap().load("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg")
                .into(viewBinding.lnlOthersServices.imgGovernment2);
        Glide.with(requireActivity()).asBitmap().load("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg")
                .into(viewBinding.lnlOthersServices.imgGovernment3);
    }

    private void setData() {
        repoViewModel.getLiveDataNews().observe(requireActivity(), newsModels -> {
            newsAdapter = new NewsAdapter(requireActivity(), newsModels);
            viewBinding.rcvNews.setHasFixedSize(true);
            viewBinding.rcvNews.setAdapter(newsAdapter);
            viewBinding.rcvNews.addItemDecoration(new EqualSpacingItemDecoration(20, EqualSpacingItemDecoration.HORIZONTAL));
            viewBinding.rcvNews.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            newsAdapter.notifyDataSetChanged();
        });
        repoViewModel.getLiveDataHistory().observe(requireActivity(), historyModels -> {
            historyAdapter = new HistoryAdapter(requireActivity(), historyModels);
            viewBinding.rcvHistory.setHasFixedSize(true);
            viewBinding.rcvHistory.setAdapter(historyAdapter);
            viewBinding.rcvHistory.addItemDecoration(new EqualSpacingItemDecoration(20, EqualSpacingItemDecoration.HORIZONTAL));
            viewBinding.rcvHistory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            historyAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        onMyFragmentListner.OnFragmentListner("Home");
    }
}
