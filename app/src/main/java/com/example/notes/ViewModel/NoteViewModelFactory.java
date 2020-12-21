package com.example.notes.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;

public class NoteViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {
    /**
     * Creates a {@code AndroidViewModelFactory}
     *
     * @param application an application to pass in {@link AndroidViewModel}
     */
    public NoteViewModelFactory(@NonNull Application application) {
        super(application);
    }
}
