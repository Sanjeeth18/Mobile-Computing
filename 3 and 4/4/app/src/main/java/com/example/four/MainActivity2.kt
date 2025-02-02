package com.example.four

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val first=intent.getStringExtra("First_Name")
        val last = intent.getStringExtra("Last_Name")
        val type= intent.getStringExtra("Type")
        val country = intent.getStringExtra("Country")
        val res=findViewById<TextView>(R.id.textView).apply {
                text="Name  : $first $last\nType  : $type\nCountry : $country"
        }
    }
}