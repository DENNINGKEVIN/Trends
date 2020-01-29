//package com.mulama.trends.adapters;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//
//import com.mulama.trends.ClothModel;
//import com.mulama.trends.Item;
//import com.mulama.trends.R;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {
//
//    Context mContext;
//    private ArrayList<ClothModel> itemsArray;
//
//    public static class ItemViewHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.clothImage) ImageView mClothImage;
//        @BindView(R.id.clothPrice) TextView mClothPrice;
//        @BindView(R.id.clothText) TextView mClothText;
//        @BindView(R.id.clothType) TextView mClothDesign;
//        @BindView(R.id.clothOrigin) TextView mClothOrigin;
//
//
//        public ItemViewHolder(@NonNull View itemView) {
//            super(itemView);
//            ButterKnife.bind(this,itemView);
//        }
//        public void bindItem(ClothModel item) {
//            mClothText.setText(item.getName());
//            mClothPrice.setText(item.getPrice());
//            mClothDesign.setText(item.getDesign());
//            mClothOrigin.setText(item.getOrigin());
//            Picasso.get().load(item.getImage()).into(mClothImage);
//        }
//    }
//    public ItemListAdapter(ArrayList<ClothModel> items){
//        itemsArray=items;
//    }
//
//
//    @NonNull
//    @Override
//    public ItemListAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        mContext=parent.getContext();
//        View view= LayoutInflater.from(mContext).inflate(R.layout.cloth_item,parent,false);
//        return new ItemListAdapter.ItemViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ItemListAdapter.ItemViewHolder holder, int position) {
//        ClothModel item=itemsArray.get(position);
//        holder.bindItem(item);
//    }
//
//    @Override
//    public int getItemCount() {
//        return itemsArray.size();
//    }
//
//}
//
//
//
