package com.codesorbit.assesment.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codesorbit.assesment.R;
import com.codesorbit.assesment.adapters.ServicesItemAdapter;
import com.codesorbit.assesment.databinding.ServiceFragmentBinding;
import com.codesorbit.assesment.interfaces.OnMyFragmentListner;
import com.codesorbit.assesment.models.ServicesItem;
import com.codesorbit.assesment.models.SubServicesItem;

import java.util.ArrayList;
import java.util.List;

public class ServicesFragment extends Fragment {
    ServiceFragmentBinding viewBinding;
    OnMyFragmentListner onMyFragmentListner;
    String[] type = new String[]{"IMAGE", "IMAGE", "IMAGE", "IMAGE","TEXT", "TEXT", "TEXT", "TEXT"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewBinding = ServiceFragmentBinding.inflate(inflater);
        if (getActivity() instanceof OnMyFragmentListner) {
            onMyFragmentListner = (OnMyFragmentListner) getActivity();
            onMyFragmentListner.OnFragmentListner("Service");
        } else {
            throw new RuntimeException(requireActivity().toString());
        }
        return viewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvItem = view.findViewById(R.id.rcv_services);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity());
        ServicesItemAdapter itemAdapter = new ServicesItemAdapter(buildItemList(), requireActivity());
        rvItem.setAdapter(itemAdapter);
        rvItem.setLayoutManager(layoutManager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        onMyFragmentListner.OnFragmentListner("Government Service");
    }

    private List<ServicesItem> buildItemList() {
        List<ServicesItem> itemList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ServicesItem item = new ServicesItem("", buildSubItemList());
            itemList.add(item);
        }
        return itemList;
    }

    private List<SubServicesItem> buildSubItemList() {
        List<SubServicesItem> subItemList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            SubServicesItem subServicesItem = new SubServicesItem("https://cdn.pixabay.com/photo/2016/12/16/15/25/christmas-1911637_960_720.jpg", "Description" + i, type[i]);
            subItemList.add(subServicesItem);
        }
        return subItemList;
    }
}
