package com.ricky.sehatin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import kotlinx.android.synthetic.main.activity_berita.*
import android.webkit.WebViewClient



class BeritaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita)



        val intent = this.intent
        val link = intent.getStringExtra(link)

        webBerita.settings.javaScriptEnabled = true
        webBerita.webViewClient = WebViewClient();
        webBerita.loadUrl(link)




    }


    companion object{
        const val link = "LINK"
    }
}
