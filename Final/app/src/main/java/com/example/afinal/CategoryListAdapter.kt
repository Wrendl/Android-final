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

class CategoryListAdapter(val category: ArrayList<Category> , val context: Context, string: String): RecyclerView.Adapter<CategoryListAdapter.MyViewHolder>() {

    var st = string
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_content, parent, false)

        return MyViewHolder(view,context)
    }

    override fun getItemCount(): Int {
        return category.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val category = category.get(position)
        holder.category.text = category.category

        holder.itemView.setOnClickListener{
            val bundle = bundleOf("country" to st, "category" to category.category )
            it.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
        }
    }

    class MyViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view){
        var category : TextView = view.findViewById(R.id.category_name)
    }

}