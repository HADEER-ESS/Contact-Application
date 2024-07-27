package com.example.contactapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.contactapp.databinding.ActivityContactDetailsBinding
import com.example.contactapp.databinding.ActivityMainBinding

class ContactDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactDetailsBinding
    lateinit var incomeContentName :String;
    lateinit var incomeContentPhone : String;
    lateinit var incomeContentDescription : String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        incomeContentName = intent.getStringExtra("ContentName").toString();
        incomeContentPhone = intent.getStringExtra("ContentPhone").toString();
        incomeContentDescription = intent.getStringExtra("ContentDesc").toString();

        binding.contentNameContent.text = incomeContentName;
        binding.contentPhoneContent.text = incomeContentPhone;
        binding.contentDescriptionContent.text = incomeContentDescription;

    }
}