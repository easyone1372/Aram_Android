package com.example.aram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private MainMenuHomeFragment fragmentHome = new MainMenuHomeFragment();
    private MainMenuSearchFragment fragmentSearch = new MainMenuSearchFragment();
    private MainMenuQuestFragment fragmentQuest = new MainMenuQuestFragment();
    private MainMenuProfileFragment fragmentProfile = new MainMenuProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You cliked on fab button",Toast.LENGTH_SHORT).show();
            }
        });
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_frame_layout, fragmentHome).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());

    }
    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();


            switch (item.getItemId()){
                case R.id.menu_home:
                    transaction.replace(R.id.menu_frame_layout,fragmentHome).commitAllowingStateLoss();
                    break;
                case R.id.menu_search:
                    transaction.replace(R.id.menu_frame_layout,fragmentSearch).commitAllowingStateLoss();
                    break;
                case R.id.menu_quest:
                    transaction.replace(R.id.menu_frame_layout,fragmentQuest).commitAllowingStateLoss();
                    break;
                case R.id.menu_profile:
                    transaction.replace(R.id.menu_frame_layout,fragmentProfile).commitAllowingStateLoss();
                    break;
            }
            return true;

//            @Override
//            protected void onCreate(Bundle savedInstanceState) {
//                super.onCreate( savedInstanceState );
//                setContentView(R.layout.activity_main);
//
//
//                userid1 = findViewById(R.id.userID);
//                userpassword1 = findViewById(R.id.userPassword);
//                username1 = findViewById(R.id.userName);
//                useremail1 = findViewById(R.id.userEmail);
//
//
//                Intent intent = getIntent();
//                String userID = intent.getStringExtra("userID");
//                String userPass = intent.getStringExtra("userPass");
//                String userName = intent.getStringExtra("userName");
//                String userAge = intent.getStringExtra("userEmail");
//
//
//                userid1.setText(userID);
//                userpassword1.setText(userPass);
//                username1.setText(userName);
//                useremail1.setText(userEmail);
//
//            }
//       }


        }
    }
}