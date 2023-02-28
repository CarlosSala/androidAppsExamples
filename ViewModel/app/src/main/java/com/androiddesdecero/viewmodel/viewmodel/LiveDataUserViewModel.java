package com.androiddesdecero.viewmodel.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.androiddesdecero.viewmodel.model.User;

import java.util.ArrayList;
import java.util.List;


public class LiveDataUserViewModel extends ViewModel {

    // Observable object, Mutable is react to show info,
    // also allow read and write data
    private MutableLiveData<List<User>> listMutableLiveData;
    private List<User> userList;

    public void addUser(User user) {
        userList.add(user);
        listMutableLiveData.setValue(userList);
    }

    // LiveData is read only
    public LiveData<List<User>> getUserList() {
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<List<User>>();
            userList = new ArrayList<>();
        }
        return listMutableLiveData;
    }
}
