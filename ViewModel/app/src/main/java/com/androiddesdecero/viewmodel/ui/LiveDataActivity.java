package com.androiddesdecero.viewmodel.ui;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androiddesdecero.viewmodel.R;
import com.androiddesdecero.viewmodel.User;
import com.androiddesdecero.viewmodel.viewmodel.LiveDataUserViewModel;

import java.util.List;

public class LiveDataActivity extends AppCompatActivity {

    private TextView tv_liveData;
    private int number = 0;
    private LiveDataUserViewModel liveDataUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        configView();
    }

    private void configView() {

        liveDataUserViewModel = new ViewModelProvider(this).get(LiveDataUserViewModel.class);
        tv_liveData = findViewById(R.id.tv_liveData);

        Button btn_save = findViewById(R.id.btn_saveLiveData);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number == 0) {
                    User user = new User();
                    user.setName("Alberto");
                    user.setAge("30");
                    liveDataUserViewModel.addUser(user);
                } else if (number == 1) {
                    User user = new User();
                    user.setName("Maria");
                    user.setAge("23");
                    liveDataUserViewModel.addUser(user);
                } else if (number == 2) {
                    User user = new User();
                    user.setName("Manuel");
                    user.setAge("40");
                    liveDataUserViewModel.addUser(user);
                }
                number++;
            }
        });

        final Observer<List<User>> listObserver = new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> userList) {
                String texto = "";
                for (int i = 0; i < userList.size(); i++) {
                    texto += userList.get(i).getName() + " " + userList.get(i).getAge() + "\n";
                }
                tv_liveData.setText(texto);
            }
        };

        // if there are changes in list, the listObserver is act
        liveDataUserViewModel.getUserList().observe(this, listObserver);
    }
}
