package com.lognote.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;


import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lognote.R;
import com.lognote.holder.NoteViewHolder;
import com.lognote.listener.LogClickListener;
import com.lognote.modal.LogNote;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    private List<LogNote> list = new ArrayList<>();
    private Context context;
    private LogClickListener logClickListener;
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
                final int k=position;
                holder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        logClickListener.onClick(list.get(k));
                    }
                });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public LogNote getItemAt(int pos){
        return list.get(pos);
    }
    public void setList(List<LogNote> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setLogClickListener(LogClickListener logClickListenerL) {
        this.logClickListener = logClickListenerL;
    }
}