package edu.neu.madcourse.numad21fa_abdulrahmanisegen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UViewAdapter extends RecyclerView.Adapter<UViewholder> {
    private final ArrayList<URLCard> urlList;
    private UrlListener listener;

    public UViewAdapter(ArrayList<URLCard> list) {
        this.urlList = list;
    }

    public void setOnUrlListener(UrlListener listener) {
        this.listener = listener;
    }

    @Override
    public UViewholder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.url_card, parent, false);
        return new UViewholder(view, listener);
    }

    @Override
    public void onBindViewHolder( UViewholder holder, int position) {
        URLCard currentItem = urlList.get(position);
        holder.name.setText(currentItem.getName());
        holder.url.setText(currentItem.getUrl());
    }

    @Override
    public int getItemCount() {
        return urlList.size();
    }
}
