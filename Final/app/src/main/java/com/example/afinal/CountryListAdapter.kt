package com.example.afinal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class CountryListAdapter(val country: ArrayList<Country> , val context: Context): RecyclerView.Adapter<CountryListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.coutry_content, parent, false)

        return MyViewHolder(view,context)
    }

    override fun getItemCount(): Int {
        return country.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val country = country.get(position)
        holder.country.text = country.country
        holder.short.text = country.short

        holder.itemView.setOnClickListener{
            val bundle = bundleOf("country" to country.short)
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }
    }

    class MyViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view){
        var country : TextView = view.findViewById(R.id.country_name)
        var short : TextView = view.findViewById(R.id.country_short)
    }

}