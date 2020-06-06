package com.androiddesdecero.viewmodel.viewmodel;

import androidx.lifecycle.ViewModel;

import com.androiddesdecero.viewmodel.User;

import java.util.ArrayList;
import java.util.List;


public class UserViewModel extends ViewModel {

    private List<User> userList;

    public UserViewModel(){
        userList = new ArrayList<>();
    }

    public void addUser(User user){
        userList.add(user);
    }

    private UserViewModel(List<User> userList){
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
