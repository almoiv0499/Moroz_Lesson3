package com.example.moroz_lesson3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moroz_lesson3.databinding.ActivityGridLayoutBinding

class GridLayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGridLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToFrameLayoutActivity()
        navigateToLinearLayoutActivity()
    }

    private fun navigateToFrameLayoutActivity() {
        binding.denmarkFlagFrame.setOnClickListener {
            val intent = Intent(this, FrameLayoutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun navigateToLinearLayoutActivity() {
        binding.switzerlandFlagFrame.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }
    }
}