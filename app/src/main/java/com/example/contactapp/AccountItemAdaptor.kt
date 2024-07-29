package com.example.contactapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.data.Account
import com.example.contactapp.databinding.AccountItemBinding
import com.example.contactapp.databinding.ActivityContactDetailsBinding
import com.example.contactapp.databinding.ActivityMainBinding

class AccountItemAdaptor(
    private val accountData : ArrayList<Account>,
    private val listener : OnItemClickListener
) : RecyclerView.Adapter<AccountItemAdaptor.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context;
        val inflater  = LayoutInflater.from(context)
        val binding = AccountItemBinding.inflate(inflater , parent , false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return accountData.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val account = accountData[position];
        holder.accountNameTextView.text = account.name;
        holder.accountPhoneTextView.text = account.phone;

        holder.accountNavigateImage.setOnClickListener {
            listener.onItemClick(account)

        }

    }

     class ViewHolder(private val binding: AccountItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val accountNavigateImage : ImageView = binding.navigateAccountImage;
        val accountNameTextView : TextView = binding.userNameTv;
        val accountPhoneTextView : TextView = binding.userPhoneTv;

    }

     fun addAccount(account: Account){
        accountData.add(account)
        notifyItemInserted(accountData.size+1)
    }

}