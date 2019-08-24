package com.lognote.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;


import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lognote.R;
import com.lognote.holder.NoteViewHolder;
import com.lognote.modal.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    private List<Note> list = new ArrayList<>();
    private Context context;
    public NoteAdapter(Context context) {
            this.context=context;
        }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.note_card_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
                holder.setItems(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public Note getItemAt(int pos){
        return list.get(pos);
    }
    public void setList(List<Note> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}