package com.mulama.trends.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mulama.trends.ClothModel;
import com.mulama.trends.Constants;
import com.mulama.trends.R;
import com.mulama.trends.adapters.FirebaseClothAdapters;
import com.mulama.trends.adapters.FirebaseClothViewholder;


import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {

    @BindView(R.id.itemsRecyclerview) RecyclerView mItemsRecyclerView;

    private FirebaseRecyclerAdapter<ClothModel , FirebaseClothViewholder> firebaseRecyclerAdapter;
    private DatabaseReference databaseReference;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
        fetchData();
        return view;
    }

    public void fetchData(){
        databaseReference= FirebaseDatabase
                .getInstance()
                .getReference().child("ClothModel");
        FirebaseRecyclerOptions<ClothModel>  options=
                new FirebaseRecyclerOptions.Builder<ClothModel>()
                .setQuery(databaseReference,ClothModel.class)
                .build();
       firebaseRecyclerAdapter= new FirebaseClothAdapters(options,databaseReference,getActivity());
        mItemsRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        mItemsRecyclerView.setAdapter(firebaseRecyclerAdapter);



   }

    @Override
    public void onStart() {
        super.onStart();
        firebaseRecyclerAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        firebaseRecyclerAdapter.stopListening();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        firebaseRecyclerAdapter.stopListening();
    }
};



