package com.example.moroz_lesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
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
            contacts.setOnClickListener {
                group.visibility = View.GONE
                progress.visibility = View.VISIBLE
            }
        }
    }

    private fun actionAfterClickInVacancies() {
        with(binding) {
            vacancies.setOnClickListener {
                group.visibility = View.GONE
                progress.visibility = View.VISIBLE
            }
        }
    }

    private fun actionAfterClickInGallery() {
        with(binding) {
            gallery.setOnClickListener {
                group.visibility = View.GONE
                progress.visibility = View.VISIBLE
            }
        }
    }

}