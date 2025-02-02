package com.example.five

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var mobile:EditText;
    private lateinit var captcha:TextView;
    private lateinit var refcaptcha:Button;
    private lateinit var userInput:EditText;
    private lateinit var submit:Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        mobile=findViewById(R.id.editTextPhone4);
        captcha=findViewById(R.id.textView5);
        refcaptcha=findViewById(R.id.button);
        submit=findViewById(R.id.button2);
        userInput=findViewById(R.id.editTextPhone5)

        captcharandom();
        refcaptcha.setOnClickListener {
            captcharandom();
        };

        submit.setOnClickListener {
            val user=userInput.text.toString().trim()
            if(user==captcha.text.toString() && mobile.text.toString().trim().matches(Regex("\\d{10}"))){
                val intent=Intent(this,MainActivity2::class.java);
                startActivity(intent)
            }else{
                Toast.makeText(this,"Enter the captcha Correctly and Enter the mobile number ",Toast.LENGTH_SHORT).show()
                captcharandom()
            }
        }

    }

    private fun captcharandom(){
        val current=generate(5);
        captcha.text=current;
    }

    private fun generate(length:Int) :String{
        val char="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        return (1..length).map { char.random() }.joinToString ("")
    }

}