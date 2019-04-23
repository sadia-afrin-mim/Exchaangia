package com.example.sadia.firebasetutorials;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class All_post extends ArrayAdapter<posts> {
    private Activity context;
    private List<posts> artistlist;

    public All_post(Activity context, List<posts> artistList) {
        super(context, R.layout.list_layout, artistList);
        this.context = context;
        this.artistlist = artistList;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewGenre = (TextView) listViewItem.findViewById(R.id.textViewGenre);
        TextView textViewPhone = (TextView) listViewItem.findViewById(R.id.textViewPhone);
        TextView textViewType = (TextView) listViewItem.findViewById(R.id.textViewEmail);

        TextView d_t = (TextView) listViewItem.findViewById(R.id.textViewdate);
        posts artist = artistlist.get(position);
        textViewName.setText(artist.getName());
        textViewGenre.setText(artist.getGenre());

        textViewType.setText(artist.getPhone());
        textViewPhone.setText(artist.getCatagory());

        d_t.setText(artist. getDate());



        return listViewItem;
    }

}