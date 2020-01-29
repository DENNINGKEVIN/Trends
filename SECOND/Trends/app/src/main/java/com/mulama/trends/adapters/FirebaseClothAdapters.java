package com.mulama.trends.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.mulama.trends.ClothModel;
import com.mulama.trends.Item;
import com.mulama.trends.R;

import java.util.List;
import java.util.zip.Inflater;

public class FirebaseClothAdapters extends FirebaseRecyclerAdapter<ClothModel , FirebaseClothViewholder> {

    DatabaseReference databaseReference;

    Context mContext;

    public FirebaseClothAdapters(@NonNull FirebaseRecyclerOptions<ClothModel> options, DatabaseReference databaseReference, Context mContext) {
        super(options);
        this.databaseReference = databaseReference;
        this.mContext = mContext;
    }

    @Override
    protected void onBindViewHolder(@NonNull FirebaseClothViewholder firebaseClothViewholder, int i, @NonNull ClothModel clothModel) {
        firebaseClothViewholder.bindCloth(clothModel);
    }

    @NonNull
    @Override
    public FirebaseClothViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cloth_item,parent,false);
        FirebaseClothViewholder firebaseClothViewholder=new FirebaseClothViewholder(view);
        return firebaseClothViewholder;
    }
}
