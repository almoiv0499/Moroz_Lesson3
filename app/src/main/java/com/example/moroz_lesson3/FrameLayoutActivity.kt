package com.example.moroz_lesson3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moroz_lesson3.databinding.ActivityFrameLayoutBinding

class FrameLayoutActivity : AppCompatActivity() {

    companion object {
        private const val LAYOUT_NAME = "FrameLayout"
    }

    private lateinit var binding: ActivityFrameLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrameLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = LAYOUT_NAME

        navigateToLinearLayoutActivity()
        navigateToGridLayoutActivity()
    }

    private fun navigateToLinearLayoutActivity() {
        binding.denmarkFlagFrame.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun navigateToGridLayoutActivity() {
        binding.switzerlandFlagFrame.setOnClickListener {
            val intent = Intent(this, GridLayoutActivity::class.java)
            startActivity(intent)
        }
    }
}