package com.example.two

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge();
        setContentView(R.layout.activity_main);
        val text=findViewById<TextView>(R.id.textView2);
        val toggle=findViewById<ToggleButton>(R.id.toggleButton);
        val image=findViewById<ImageView>(R.id.imageView);

        toggle.setOnCheckedChangeListener{_,isChecked->

            if(isChecked){
                image.setImageResource(R.drawable.hungry);
                 text.text="I'm so Full"
                toggle.textOn="Done";
            }
            else{
                image.setImageResource(R.drawable.unhappy);
                text.text="I'm so Hungry"
                toggle.text="Eat Cookie";

            }
        }

        }

}