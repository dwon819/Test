package org.techtown.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import org.techtown.test.R;

import java.util.ArrayList;
import java.util.WeakHashMap;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    WebView webView;
    Button button,frontbtn,backbtn;
    String[] urls =new String[30];
    static int i =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.edit_text);
        webView = findViewById(R.id.webView);
        button = findViewById(R.id.button);
        frontbtn = findViewById(R.id.front);
        backbtn = findViewById(R.id.back);


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());
        Stack stack = new Stack();

        button.setOnClickListener(new View.OnClickListener() { //---------열기버튼
            @Override
            public void onClick(View v) {
                i++;
                String url = "http://"+editText.getText().toString();
                webView.loadUrl(url);
                stack.run(url);

            }
        });

        frontbtn.setOnClickListener(new View.OnClickListener() {//---------다음버튼
            @Override
            public void onClick(View v) {

                    ++i;
                    String url = urls[i];
                    webView.loadUrl(url);
                    stack.run(url);


            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {//---------이전버튼
            @Override
            public void onClick(View v) {

                    --i;
                    String url = urls[i];
                    webView.loadUrl(url);
                    stack.run(url);
                    



            }
        });
        
    }
    private class ViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    public class Stack{
        public void run(String url){
            urls[i]=url;
        }
    }
}