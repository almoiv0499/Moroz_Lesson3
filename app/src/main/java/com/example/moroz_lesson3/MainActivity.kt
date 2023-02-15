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

        actionAfterClickInContacts()
        actionAfterClickInVacancies()
        actionAfterClickInGallery()
    }

    private fun actionAfterClickInContacts() {
        with(binding) {
            buttonContacts.setOnClickListener {
                groupVisibility.visibility = View.GONE
                progress.visibility = View.VISIBLE
            }
        }
    }

    private fun actionAfterClickInVacancies() {
        with(binding) {
            buttonVacancies.setOnClickListener {
                groupVisibility.visibility = View.GONE
                progress.visibility = View.VISIBLE
            }
        }
    }

    private fun actionAfterClickInGallery() {
        with(binding) {
            buttonGallery.setOnClickListener {
                groupVisibility.visibility = View.GONE
                progress.visibility = View.VISIBLE
            }
        }
    }

}