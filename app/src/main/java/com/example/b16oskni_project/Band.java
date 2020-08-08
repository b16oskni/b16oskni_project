package com.example.b16oskni_project;

import androidx.annotation.NonNull;

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

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
