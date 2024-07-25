package com.example.contactapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.data.Account

class AccountItemAdaptor(val itemView: View ,private val accountData : ArrayList<Account>) : RecyclerView.Adapter<AccountItemAdaptor.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context;
        val inflater  = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.account_item , parent , false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return accountData.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val account = accountData[position];

        holder.accountNameTextView.text = account.name;
        holder.accountPhoneTextView.text = account.phone;

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val accountNameTextView : TextView = itemView.findViewById(R.id.user_name_tv);
        val accountPhoneTextView : TextView = itemView.findViewById(R.id.user_phone_tv);

    }

    public fun addAccount(account: Account){
        accountData.add(account)
        notifyItemInserted(accountData.size+1)
    }

}