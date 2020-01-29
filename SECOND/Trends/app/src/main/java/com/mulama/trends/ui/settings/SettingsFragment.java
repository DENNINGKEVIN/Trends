package com.mulama.trends.ui.settings;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.mulama.trends.ClothModel;
import com.mulama.trends.Constants;
import com.mulama.trends.MainActivity;
import com.mulama.trends.R;
import com.mulama.trends.ui.home.HomeFragment;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.app.Activity.RESULT_OK;



public class SettingsFragment extends Fragment implements View.OnClickListener{

    private SettingsViewModel settingsViewModel;
    @BindView(R.id.name) EditText name;
    @BindView(R.id.price) EditText price;
    @BindView(R.id.design) EditText design;
    @BindView(R.id.origin) EditText origin;
    @BindView(R.id.addCloth) Button addCloth;
    @BindView(R.id.addClothImage) ImageView addClothImage;


    FirebaseStorage storage;
    StorageReference storageReference;
    DatabaseReference ref;
    ClothModel clothModel;

    public static final int IMAGE_PICKED=100;
    private Uri filepath;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingsViewModel =
                ViewModelProviders.of(this).get(SettingsViewModel.class);
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        ButterKnife.bind(this,view);

        addClothImage.setOnClickListener(this);
        addCloth.setOnClickListener(this);

        ref= FirebaseDatabase.getInstance().getReference().child("ClothModel");
//        storage=FirebaseStorage.getInstance();
//        storageReference=storage.getReference();

        clothModel=new ClothModel();

        return view;
    }

    @Override
    public void onClick(View v) {


        if(v == addClothImage){
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, IMAGE_PICKED);
        }
        if(v==addCloth){
            upload();
//            Intent intent=new Intent(getActivity(), MainActivity.class);
//            startActivity(intent);
        }
    }


  private  void upload(){

      final ProgressDialog progressDialog = new ProgressDialog(getActivity());
      progressDialog.setTitle("Uploading...");
      progressDialog.show();

      clothModel.setName(name.getText().toString());
      clothModel.setDesign(design.getText().toString());
      clothModel.setOrigin(origin.getText().toString());
      clothModel.setPrice(price.getText().toString());


      if(TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(design.getText().toString()) || TextUtils.isEmpty(origin.getText().toString()) || TextUtils.isEmpty(price.getText().toString())){
          Toast.makeText(getActivity(), "missing details",
                  Toast.LENGTH_SHORT).show();
      }else {

          ref.push().setValue(clothModel);
          progressDialog.hide();
          Toast.makeText(getActivity(), "data added",
                  Toast.LENGTH_SHORT).show();
      }

//      StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());
//      ref.putFile(filepath)
//              .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                  @Override
//                  public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                      progressDialog.dismiss();
//                      Toast.makeText(getActivity(), "Uploaded", Toast.LENGTH_SHORT).show();
//                  }
//              })
//              .addOnFailureListener(new OnFailureListener() {
//                  @Override
//                  public void onFailure(@NonNull Exception e) {
//                      progressDialog.dismiss();
//                      Toast.makeText(getActivity(), "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
//                  }
//              })
//              .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//                  @Override
//                  public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
//                      double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
//                              .getTotalByteCount());
//                      progressDialog.setMessage("Uploaded "+(int)progress+"%");
//                  }
//              });





  }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if( resultCode == RESULT_OK && requestCode== IMAGE_PICKED && data != null && data.getData() != null){
//            Bundle extras=data.getExtras();
//            Bitmap imageBitmap=(Bitmap) extras.get("data");
//            addClothImage.setImageBitmap(imageBitmap);
//            encodeBitmapAndSaveToFirebase(imageBitmap);
            //insert image
//            addClothImage.setImageURI(data.getData());
            //or
            Picasso.get().load(data.getData()).into(addClothImage);
        }
    }

//    private void encodeBitmapAndSaveToFirebase(Bitmap imageBitmap) {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
//        String imageEncoded = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
//        DatabaseReference ref = FirebaseDatabase.getInstance()
//                .getReference(Constants.FIREBASE_CHILD_CLOTHES)
//                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                .child(clothModel.getPushId())
//                .child("imageUrl");
//        ref.setValue(imageEncoded);
//    }
}

