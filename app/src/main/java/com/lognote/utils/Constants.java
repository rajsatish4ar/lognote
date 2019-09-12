package com.lognote.utils;

import android.view.View;

import androidx.databinding.BindingAdapter;


public class Constants {
    public static final int INSERT = 0;
    public static final int DELETE = 1;
    public static final int UPDATE = 2;
    public static final int DELETE_ALL = 3;
    public static final int VIEW = 4;
    public static final int ADD_TEMP = 5;
    public static final String LOG_EXTRA="LOG_EXTRA";
    @BindingAdapter("app:hideIfZero")
   static public void hideifZero(View view,int count){
        if (count<5)
            view.setVisibility(View.VISIBLE);
        else view.setVisibility(View.GONE);
    }
}
