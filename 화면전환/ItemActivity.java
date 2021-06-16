package org.techtown.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ItemActivity extends AppCompatActivity {
    Button login, menu;
    public static final int REQUEST_CODE = 101;
    public static final int ITEM_MENU = 333;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        Toast.makeText(getApplicationContext(),"상품 관리 화면",Toast.LENGTH_LONG).show();

        login = findViewById(R.id.item_login);
        menu = findViewById(R.id.item_menu);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                setResult(REQUEST_CODE,intent);
                finish();
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                setResult(ITEM_MENU,intent);
                finish();
            }
        });
    }

}