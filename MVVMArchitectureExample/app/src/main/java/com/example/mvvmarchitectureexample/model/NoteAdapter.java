package com.example.mvvmarchitectureexample.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmarchitectureexample.R;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> notes = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {

        Note currentNote = notes.get(position);
        holder.tv_title.setText(currentNote.getTitle());
        holder.tv_description.setText(currentNote.getDescription());
        holder.tv_priority.setText(String.valueOf(currentNote.getPriority()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public Note getNoteAt(int position) {
        return notes.get(position);
    }

    class NoteHolder extends RecyclerView.ViewHolder {

        private final TextView tv_title;
        private final TextView tv_description;
        private final TextView tv_priority;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_priority = itemView.findViewById(R.id.tv_priority);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAbsoluteAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(notes.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Note note);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {

        this.listener = listener;
    }
}
