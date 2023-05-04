package com.example.pamo2023

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class GraphActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)
        val graph = findViewById<WebView>(R.id.graph)
        graph.settings.javaScriptEnabled = true
        graph.setInitialScale(1)
        graph.settings.loadWithOverviewMode = true
        graph.settings.useWideViewPort = true
        graph.loadUrl("https://www.vertex42.com/ExcelTemplates/Images/bmi-chart.gif")
    }
}