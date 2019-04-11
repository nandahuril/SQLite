package com.example.nanda.sqlite;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.nanda.sqlite.models.User;
import com.example.nanda.sqlite.repositories.UserRepository;

public class UserViewModel extends AndroidViewModel {
    private UserRepository repository;
    private LiveData<User> user;

    public UserViewModel(@NonNull Application application) {
        super(application);
        this.repository = new UserRepository(application);
    }

    public LiveData<User> getUser(String username) {
        user = repository.getUserByUsername(username);
        return user;
    }

    public void insert(User user) {
        repository.insert(user);
    }
}
