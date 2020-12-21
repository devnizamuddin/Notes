package com.example.notes.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes.Model.Note;
import com.example.notes.R;

import java.util.ArrayList;
import java.util.List;


public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Note>notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_single_item,parent,false);

        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

        Note note = notes.get(position);
        holder.title_tv.setText(note.getTitle());
        holder.description_tv.setText(note.getDescription());
        holder.priority_tv.setText(String.valueOf(note.getPriority()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes){

        this.notes = notes;
        notifyDataSetChanged();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        TextView title_tv,description_tv,priority_tv;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);

            title_tv = itemView.findViewById(R.id.title_tv);
            description_tv = itemView.findViewById(R.id.description_tv);
            priority_tv = itemView.findViewById(R.id.priority_tv);

        }
    }
}
