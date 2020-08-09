package com.example.b16oskni_project;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter<Band> {

    ArrayList<Band> bandList;
    Context context;
    int resource;
    public CustomListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Band> bandList) {
        super(context, resource, bandList);
        this.bandList = bandList;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            assert layoutInflater != null;
            convertView = layoutInflater.inflate(R.layout.list_item_textview, null, true);

        }
        Band band = getItem(position);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.my_imageview);
        assert band != null;
        Picasso.get().load(band.getUrl()).into(imageView);
        TextView txtName = (TextView) convertView.findViewById(R.id.my_item_textview);
        txtName.setText(band.getName());
        return convertView;
    }
}
