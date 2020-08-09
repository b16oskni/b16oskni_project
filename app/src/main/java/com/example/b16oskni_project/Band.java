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

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
