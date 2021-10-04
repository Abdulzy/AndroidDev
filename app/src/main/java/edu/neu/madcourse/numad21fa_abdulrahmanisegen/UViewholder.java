package edu.neu.madcourse.numad21fa_abdulrahmanisegen;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UViewholder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView url;

    public UViewholder(View itemView, final UrlListener listener) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        url = itemView.findViewById(R.id.url);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = getLayoutPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onURLClick(position);
                    }
                }
            }
        });
    }
}
