package com.mulama.trends;

import butterknife.BindView;

public class CategoryItem {
   private int mImageResource;
   private String mText;

    public CategoryItem(int imageResource, String text){
      mImageResource=imageResource;
      mText=text;
   }


    public int getmImageResource() {
        return mImageResource;
    }
    public String getmText() {
        return mText;
    }

}
