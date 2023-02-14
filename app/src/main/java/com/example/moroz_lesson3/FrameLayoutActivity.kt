package com.example.moroz_lesson3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moroz_lesson3.databinding.ActivityFrameLayoutBinding

class FrameLayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFrameLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrameLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToLinearActivity()
        navigateToGridActivity()
    }

    private fun navigateToLinearActivity() {
        binding.denmarkFlag.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun navigateToGridActivity() {
        binding.switzerlandFlag.setOnClickListener {
            val intent = Intent(this, GridLayoutActivity::class.java)
            startActivity(intent)
        }
    }

}