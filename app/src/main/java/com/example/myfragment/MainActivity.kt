package com.example.myfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button:Button = findViewById(R.id.transfer_button)

        button.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                add(R.id.main_frame, FirstFragment.newInstance("Activityからもらったよ"))
                addToBackStack(null)
                commit()
            }
        }
    }
}