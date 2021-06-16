package org.techtown.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    Button cus,sell,item;
    public static final int CUSTOM_MENU = 111;
    public static final int SELL_MENU = 222;
    public static final int ITEM_MENU = 333;
    public static final int REQUEST_CODE = 101;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CUSTOM_MENU){
            Toast.makeText(getApplicationContext(),"관리 화면 메뉴",Toast.LENGTH_SHORT).show();
            if(resultCode == REQUEST_CODE){
                finish();
            }
        }
        if(requestCode == SELL_MENU){
            Toast.makeText(getApplicationContext(),"관리 화면 메뉴",Toast.LENGTH_SHORT).show();
            if(resultCode == REQUEST_CODE){
                finish();
            }
        }
        if(requestCode == ITEM_MENU){
            Toast.makeText(getApplicationContext(),"관리 화면 메뉴",Toast.LENGTH_SHORT).show();
            if(resultCode == REQUEST_CODE){
                finish();
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toast.makeText(getApplicationContext(),"관리 화면 메뉴",Toast.LENGTH_LONG).show();

        cus = findViewById(R.id.custom);
        sell = findViewById(R.id.sell);
        item = findViewById(R.id.item);


        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
                startActivityForResult(intent, CUSTOM_MENU);
            }
        });

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SellActivity.class);
                startActivityForResult(intent, SELL_MENU);
            }
        });

        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ItemActivity.class);
                startActivityForResult(intent, ITEM_MENU);
            }
        });

    }
}