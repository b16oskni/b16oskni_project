package com.example.b16oskni_project;

import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

public class Band {
    //Member var
    private String name;
    private String company;
    private String category;
    private String url;

    Band(String inName, String inCompany, String inCategory, String inUrl){
        name = inName;
        company = inCompany;
        category = inCategory;
        url = inUrl;
    }

    String info(){
        String tmp = "";
        tmp += name+" is a Swedish "+category+ " band published by the company "+company+".";
        return tmp;
    }

    @Override
    public String toString(){

        return name;
    }

    public String getName() {
        return name;
    }
    
    public String getUrl() {
        return url;
    }

}
