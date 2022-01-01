package com.example.co.designapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
             val edit_name:MaterialButton=findViewById(R.id.btn_Edit_Profile)
        edit_name.setOnClickListener {
            Toast.makeText(this,"you want edit",Toast.LENGTH_LONG).show()
        }
    }
}