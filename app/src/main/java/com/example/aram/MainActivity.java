package com.example.aram;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private MainMenuHomeFragment fragmentHome = new MainMenuHomeFragment();
    private MainMenuSearchFragment fragmentSearch = new MainMenuSearchFragment();
    private MainMenuQuestFragment fragmentQuest = new MainMenuQuestFragment();
    private MainMenuProfileFragment fragmentProfile = new MainMenuProfileFragment();


    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        FloatingActionButton fab = findViewById(R.id.fab_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this,"You cliked on fab button",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,1);

            }
        });
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_frame_layout, fragmentHome).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    Uri uri = data.getData();
                    imageView.setImageURI(uri);
                }
                break;
        }
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