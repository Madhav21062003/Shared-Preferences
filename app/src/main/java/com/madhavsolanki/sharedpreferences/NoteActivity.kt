package com.madhavsolanki.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.madhavsolanki.sharedpreferences.databinding.ActivityNoteBinding


class NoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("NoteData", Context.MODE_PRIVATE)

        binding.addNote.setOnClickListener {
            val note = binding.etNote.text.toString()

            val sharedEdit = sharedPreferences.edit()
            sharedEdit.putString("note", note)
            sharedEdit.apply()
            Toast.makeText(this@NoteActivity, "Note Added", Toast.LENGTH_SHORT).show()
            binding.etNote.text.clear()
        }

        binding.btnDisplayNote.setOnClickListener {
            val storedNote  = sharedPreferences.getString("note", "")
            binding.tvNote.text = "$storedNote"
        }




    }
}