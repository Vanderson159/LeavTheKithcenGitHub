package com.example.leavingthekithcen

import android.app.IntentService
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.Window
import android.webkit.JavascriptInterface
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main4.*
import javax.security.auth.callback.Callback

class Main4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val myWebView: WebView = findViewById(R.id.webview)
        var url = intent.getStringExtra("redeSocial")!!
        var choise = intent.getIntExtra("choise", 0)
        if (choise == 1) {
            myWebView.loadUrl(url)
            val webSettings: WebSettings = webview.settings
            webSettings.javaScriptEnabled = true
        } else {
            if (choise == 2) {
                myWebView.loadUrl(url)
                val webSettings: WebSettings = webview.settings
                webSettings.javaScriptEnabled = true
            } else {
                if (choise == 3) {
                    myWebView.loadUrl(url)
                    val webSettings: WebSettings = webview.settings
                    webSettings.javaScriptEnabled = true
                } else {
                    Toast.makeText(this, "Não possui esta rede", Toast.LENGTH_LONG).show()
                }
            }
        }
        onBackPressed()
    }
}


