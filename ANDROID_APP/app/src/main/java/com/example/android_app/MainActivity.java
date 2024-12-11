package com.example.android_app; // Adjust this package name to match your app's package structure

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

import com.example.webview.R;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure 'activity_main.xml' exists in 'res/layout'

        // Find the WebView by its ID
        WebView webView = findViewById(R.id.android_app);

        // Configure WebView settings
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enable JavaScript
        webSettings.setDomStorageEnabled(true); // Enable DOM storage for modern web apps

        // Set a WebViewClient to handle navigation within the WebView
        webView.setWebViewClient(new WebViewClient());

        // Load the website
        webView.loadUrl("https://jade.insure/login");

        // execute javascript to modify the page
        webView.evaluateJavascript(
                "(function() { " +
                        "document.querySelector('.element-to-remove').remove();" +
                        "document.querySelector('.element-to-modify').style.color = 'red';" +
                        "})();",
                null
        );
    }
}
