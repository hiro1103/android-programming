package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gu.setOnClickListener{onJankenButtonTapped(it)}
        binding.choki.setOnClickListener{onJankenButtonTapped(it)}
        binding.pa.setOnClickListener{onJankenButtonTapped(it)}

    }

    fun onJankenButtonTapped(view: View?){
        val intent = Intent(this,ResultActivity::class.java)
        intent.putExtra("My_HAND",view?.id)
        startActivity(intent)
    }
}