package com.example.notes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.notes.Adapter.NoteAdapter;
import com.example.notes.Model.Note;
import com.example.notes.ViewModel.NoteViewModel;
import com.example.notes.ViewModel.NoteViewModelFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        noteViewModel = new ViewModelProvider(this, new NoteViewModelFactory(this.getApplication())).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                //update RecyclerView
                Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_SHORT).show();
                NoteAdapter noteAdapter = new NoteAdapter(notes);
                recyclerView.setAdapter(noteAdapter);
            }
        });


    }
}