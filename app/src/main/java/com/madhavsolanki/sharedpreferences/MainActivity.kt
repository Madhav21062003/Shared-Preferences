package com.madhavsolanki.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.madhavsolanki.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // This code species when we closes the app and again open the app we can able
        // to see the previous entered data
        val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE)
        binding.email.setText(editor.getString("email",null))
        binding.password.setText(editor.getString("password",null))

        // When user click the button the user data will write into the shared preferences
        binding.login.setOnClickListener {
            // This code species when we enter the data to the app we can able
            // to enter data
            val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE).edit()
            editor.putString("email", binding.email.text.toString())
            editor.putString("password", binding.password.text.toString())
            editor.apply()
            Toast.makeText(this,"Data added Successfully", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity2::class.java))
        }

    }
}