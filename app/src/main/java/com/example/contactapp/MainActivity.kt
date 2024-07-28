package com.example.contactapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.data.Account
import com.example.contactapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var recyclerViewAccountData : RecyclerView;
    private lateinit var adaptor: AccountItemAdaptor;
    private lateinit var  phoneEditText : EditText ;
    private var accountData : ArrayList<Account> = ArrayList();
    private var count : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerViewAccountData = binding.accountRecyclerView
        phoneEditText = binding.accountPhoneEt

        recyclerViewAccountData.layoutManager = LinearLayoutManager(this)

        adaptor = AccountItemAdaptor(accountData)

        recyclerViewAccountData.adapter = adaptor

        binding.accountSaveBtn.setOnClickListener {addAccountButtonHandler()}

        phoneEditText.addTextChangedListener(phoneTextWatcher)

        phoneEditText.setOnFocusChangeListener { v, hasFocus ->

            if(!hasFocus){
                val phoneLength = phoneEditText.text?.length;
                if(phoneLength!! < 11){
                    Toast.makeText(this , "Phone number must be 11 in length" , Toast.LENGTH_LONG).show();
                }
            }
        }

    }



    private fun addAccountButtonHandler () {
        val name = binding.accountNameEt;
        val phone = binding.accountPhoneEt;
        val desc =  binding.accountDescriptionEt;
        this@MainActivity.count += 1;

        if (name.text?.length!! < 2  || phone.text?.length !== 11){
            Toast.makeText(this, "Please Enter Content Data Correctly" , Toast.LENGTH_LONG).show()
        }

        else{

            val accountData = Account(count , name.text.toString(), phone.text.toString(), desc.text.toString())

            adaptor.addAccount(accountData)

            name.setText("")
            phone.setText("")
            desc.setText("")
        }
    }


    private val phoneTextWatcher = object : TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val textLength = s?.length;
            binding.phoneInputHint.text = "$textLength / 11";
        }

        override fun afterTextChanged(s: Editable?) {
        }

    }

}



