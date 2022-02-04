package com.example.co.designapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.co.designapp.databinding.SelfLayoutBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: SelfLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= SelfLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle:Bundle?=intent.extras
        bundle?.let {
            val username=bundle.getString(Constants.username)
            binding.textView2.text = username
        }
        binding.buttonGet.setOnClickListener {
            val intent = Intent()
            val name = binding.textView2.text.toString()
            intent.putExtra("name", name)
            setResult(Activity.RESULT_OK)
            finish()
        }
    }

}