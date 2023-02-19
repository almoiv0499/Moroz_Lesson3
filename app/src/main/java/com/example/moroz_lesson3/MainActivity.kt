package com.example.moroz_lesson3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.moroz_lesson3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actionAfterClick()
    }

    private fun actionAfterClick() {
        with(binding) {
            buttonContacts.setOnClickListener {
                groupVisibility.visibility = View.GONE
                progress.visibility = View.VISIBLE
            }

            buttonVacancies.setOnClickListener {
                groupVisibility.visibility = View.GONE
                progress.visibility = View.VISIBLE
            }

            buttonGallery.setOnClickListener {
                groupVisibility.visibility = View.GONE
                progress.visibility = View.VISIBLE
            }
        }
    }

}