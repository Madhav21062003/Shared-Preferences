package com.madhavsolanki.sharedpreferences

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.madhavsolanki.sharedpreferences.databinding.ActivityMain2Binding
import com.madhavsolanki.sharedpreferences.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding:ActivityMain2Binding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE)
        binding.tvEmail.setText("Hey your email is: \n ${editor.getString("email", null)}")
        binding.tvPassword.setText("Hey your email is: \n ${editor.getString("password", null)}")
    }
}