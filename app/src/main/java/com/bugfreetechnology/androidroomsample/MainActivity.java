package com.bugfreetechnology.androidroomsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.bugfreetechnology.androidroomsample.pojo.User;
import com.bugfreetechnology.androidroomsample.room_component.AppDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etUsername = null;

        final User user = new User();
//        user.setUid(1000);
        user.setFirstName("Avinash");
        user.setLastName("Pandey");

        final User user1 = new User();
//        user.setUid(1000);
        user1.setFirstName("Ram");
        user1.setLastName("Ravan");

        AppDatabase.getInstance(MainActivity.this).getUserDao().insertAll(user,user1);

//        AppDatabase.getInstance(this).getUserDao().insertAll(user);


        List<User> mUserList = AppDatabase.getInstance(MainActivity.this).getUserDao().getAll();
        for (int i = 0; i < mUserList.size(); i++) {
            Log.d(TAG, "onCreate: " + mUserList.get(i).getFirstName() + ": "+
                    mUserList.get(i).getLastName()
                    +":"+ mUserList.get(i).getUid()
            );
        }
    }
}
