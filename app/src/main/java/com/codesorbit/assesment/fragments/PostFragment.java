package com.codesorbit.assesment.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.codesorbit.assesment.adapters.PostAdapter;
import com.codesorbit.assesment.databinding.PostFragmentBinding;
import com.codesorbit.assesment.interfaces.OnMyFragmentListner;
import com.codesorbit.assesment.repository.RepoViewModel;

public class PostFragment extends Fragment {
    PostFragmentBinding viewBinding;
    OnMyFragmentListner onMyFragmentListner;
    RepoViewModel repoViewModel;
    PostAdapter postAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewBinding = PostFragmentBinding.inflate(inflater);
        if (getActivity() instanceof OnMyFragmentListner) {
            onMyFragmentListner = (OnMyFragmentListner) getActivity();
            onMyFragmentListner.OnFragmentListner("Post");
        } else {
            throw new RuntimeException(requireActivity().toString());
        }
        return viewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        repoViewModel = new ViewModelProvider(requireActivity()).get(RepoViewModel.class);
        viewBinding.postProgressBar.setVisibility(View.VISIBLE);
        setPosts();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void setPosts() {
        repoViewModel.getResponseLiveData().observe(requireActivity(), postResponses -> {
            if (postResponses != null) {
                viewBinding.postProgressBar.setVisibility(View.GONE);
                postAdapter = new PostAdapter(postResponses);
                viewBinding.rcvPosts.setHasFixedSize(true);
                viewBinding.rcvPosts.setAdapter(postAdapter);
                viewBinding.rcvPosts.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false));
                postAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        onMyFragmentListner.OnFragmentListner("Post");
    }
}
