package com.example.moroz_lesson3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moroz_lesson3.databinding.ActivityLinearLayoutBinding

class LinearLayoutActivity : AppCompatActivity() {
    companion object {
        private const val LAYOUT_NAME = "LinearLayout"
    }

    private lateinit var binding: ActivityLinearLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLinearLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = LAYOUT_NAME

        navigateToGridLayoutActivity()
        navigateToFrameLayoutActivity()
    }

    private fun navigateToGridLayoutActivity() {
        binding.denmarkFlagFrameLinear.setOnClickListener {
            val intent = Intent(this, GridLayoutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun navigateToFrameLayoutActivity() {
        binding.switzerlandFlagFrameLinear.setOnClickListener {
            val intent = Intent(this, FrameLayoutActivity::class.java)
            startActivity(intent)
        }
    }
}