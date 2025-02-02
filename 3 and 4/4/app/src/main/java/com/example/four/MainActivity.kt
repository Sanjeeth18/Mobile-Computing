package com.example.four

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val first = findViewById<EditText>(R.id.editTextText);
        val last = findViewById<EditText>(R.id.editTextText2);
        val visited=findViewById<RadioGroup>(R.id.radioGroup);
        val country=findViewById<Spinner>(R.id.spinner);
        val submit=findViewById<Button>(R.id.button);

        submit.setOnClickListener {

            if(first.text.toString()=="" || last.text.toString()=="" || visited.checkedRadioButtonId==-1 || country.selectedItem.toString()=="Select a Country"){
                Toast.makeText(this,"Enter all field",Toast.LENGTH_SHORT).show();
                return@setOnClickListener
            }else{
                val radiovalue=findViewById<RadioButton>(visited.checkedRadioButtonId);

                val intent=Intent(this,MainActivity2::class.java).also{
                    it.putExtra("First_Name",first.text.toString())
                    it.putExtra("Last_Name",last.text.toString())
                    it.putExtra("Type",radiovalue.text.toString())
                    it.putExtra("Country",country.selectedItem.toString())
                }
                startActivity(intent)
            }

        }


    }
}