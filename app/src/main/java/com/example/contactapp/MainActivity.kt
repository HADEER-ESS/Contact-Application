package com.example.contactapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.data.Account
import com.example.contactapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var recyclerViewAccountData : RecyclerView;
    var accountData : ArrayList<Account> = ArrayList();
    var count : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        recyclerViewAccountData = binding.accountRecyclerView

        recyclerViewAccountData.layoutManager = LinearLayoutManager(this)

        val adaptor = AccountItemAdaptor(recyclerViewAccountData , accountData)

        recyclerViewAccountData.adapter = adaptor

        binding.accountSaveBtn.setOnClickListener {addAccountButtonHandler(accountData , count , adaptor)}


    }



    private fun addAccountButtonHandler (accountData : ArrayList<Account> , count : Int , adaptor: AccountItemAdaptor) {
        val name = binding.accountNameEt;
        val phone = binding.accountPhoneEt;
        val desc =  binding.accountDescriptionEt;
        this@MainActivity.count += 1;

        if (name.text?.length!! < 2){
            Toast.makeText(this, "Please Enter Contact Name" , Toast.LENGTH_LONG).show()
        }
        if(phone.text?.length !== 11){
            Toast.makeText(this, "Please Enter Contact Name" , Toast.LENGTH_LONG).show()
        }

        else{

            println(name.text.toString())
            println(phone.text.toString())
            println(desc.text.toString())

            val accountData = Account(count , name.text.toString(), phone.text.toString(), desc.text.toString())

            adaptor.addAccount(accountData)

            name.setText("")
            phone.setText("")
            desc.setText("")
        }
    }

}



