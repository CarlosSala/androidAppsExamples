package com.androiddesdecero.viewmodel.view;

import androidx.lifecycle.ViewModelProvider;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.androiddesdecero.viewmodel.R;
import com.androiddesdecero.viewmodel.model.User;
import com.androiddesdecero.viewmodel.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    private EditText et_name, et_age;
    private TextView tv_user, tv_userViewModel;
    private List<User> userList;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        configView();
    }

    private void configView() {

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userList = new ArrayList<>();

        tv_user = findViewById(R.id.tv_userActivity);
        tv_userViewModel = findViewById(R.id.tv_userActivityViewModel);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);

        Button btn_save = findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User();
                user.setAge(et_age.getText().toString());
                user.setName(et_name.getText().toString());
                userList.add(user);
                userViewModel.addUser(user);
            }
        });

        Button btn_see = findViewById(R.id.btn_see);
        btn_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuilder text = new StringBuilder();
                for (int i = 0; i < userList.size(); i++) {
                    text.append(userList.get(i).getName()).append(" ").append(userList.get(i).getAge()).append("\n");
                }
                tv_user.setText(text.toString());

                text = new StringBuilder();
                for (User user : userViewModel.getUserList()) {
                    text.append(user.getName()).append(" ").append(user.getAge()).append("\n");
                }
                tv_userViewModel.setText(text.toString());
            }
        });
    }
}
