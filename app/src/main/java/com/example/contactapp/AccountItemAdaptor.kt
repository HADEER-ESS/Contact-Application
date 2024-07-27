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
        val context = holder.itemView.context

        holder.accountNameTextView.text = account.name;
        holder.accountPhoneTextView.text = account.phone;

        holder.accountNavigateImage.setOnClickListener {
//            Toast.makeText(context, "Navigate work" , Toast.LENGTH_LONG).show()
            val intent : Intent = Intent(context , ContactDetailsActivity::class.java)
            intent.putExtra("ContentName" , account.name)
            intent.putExtra("ContentPhone" , account.phone)
            intent.putExtra("ContentDesc" , account.description)

            context.startActivity(intent)
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val accountNavigateImage : ImageView = itemView.findViewById(R.id.navigate_account_image)
        val accountNameTextView : TextView = itemView.findViewById(R.id.user_name_tv);
        val accountPhoneTextView : TextView = itemView.findViewById(R.id.user_phone_tv);

    }

    public fun addAccount(account: Account){
        accountData.add(account)
        notifyItemInserted(accountData.size+1)
    }

}