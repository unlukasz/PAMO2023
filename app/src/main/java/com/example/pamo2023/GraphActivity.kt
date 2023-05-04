package com.example.pamo2023;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class GraphActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        WebView graph = findViewById(R.id.graph);
        graph.getSettings().setJavaScriptEnabled(true);
        graph.setInitialScale(1);
        graph.getSettings().setLoadWithOverviewMode(true);
        graph.getSettings().setUseWideViewPort(true);
        graph.loadUrl("https://www.vertex42.com/ExcelTemplates/Images/bmi-chart.gif");
    }
}