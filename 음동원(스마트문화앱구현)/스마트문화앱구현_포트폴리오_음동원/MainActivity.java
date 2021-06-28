package org.techtown.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Fragment fragment1,fragment2,fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

    }
    public void onButton1(View v){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();
    }
    public void onButton2(View v){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment3).commit();
    }
    public void onGotoMainFragment(View v){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();
    }

}