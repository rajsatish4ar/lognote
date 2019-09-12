package com.lognote.holder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.lognote.R;
import com.lognote.modal.LogNote;


public class NoteViewHolder extends RecyclerView.ViewHolder {
    public View view;
    private TextView title;
    private TextView noteContent;
    private TextView time;
    public NoteViewHolder(View itemView) {
        super(itemView);
        view = itemView;
        title = itemView.findViewById(R.id.cardTitle);
        noteContent = itemView.findViewById(R.id.cardNote);
        time = itemView.findViewById(R.id.cardTime);
    }

    public void setItems(LogNote note) {
        title.setText(note.getTitle());
        noteContent.setText(note.getDescription());
//        time.setText();
    }
}