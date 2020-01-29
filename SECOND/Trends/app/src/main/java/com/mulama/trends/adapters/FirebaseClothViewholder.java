package com.mulama.trends.adapters;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mulama.trends.ClothModel;
import com.mulama.trends.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirebaseClothViewholder extends RecyclerView.ViewHolder {

        @BindView(R.id.clothImage) ImageView mClothImage;
        @BindView(R.id.clothPrice) TextView mClothPrice;
        @BindView(R.id.clothText) TextView mClothText;
        @BindView(R.id.clothOrigin) TextView mClothOrigin;
        @BindView(R.id.clothType) TextView mClothDesign;


    public FirebaseClothViewholder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bindCloth(ClothModel clothModel) {

       mClothText.setText(clothModel.getName());
        mClothPrice.setText(clothModel.getPrice());
        mClothOrigin.setText(clothModel.getOrigin());
        mClothDesign.setText(clothModel.getDesign());


    }

    }

