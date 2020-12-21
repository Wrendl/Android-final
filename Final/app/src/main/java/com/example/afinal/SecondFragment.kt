package com.example.afinal

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    var list1 = ArrayList<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        list1.add(Category(0,"business"))
        list1.add(Category(1,"entertainment"))
        list1.add(Category(2,"general"))
        list1.add(Category(3,"health"))
        list1.add(Category(4,"science"))
        list1.add(Category(5,"sports"))
        list1.add(Category(6,"technology"))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Log.e("SecondFragment", list1.size.toString())

        val country = arguments?.getString("country")

        if (country != null){
            category_list_recycler.layoutManager = LinearLayoutManager(activity)
            category_list_recycler.adapter = context?.let { CategoryListAdapter(list1, it, country) }
        }

//        category_list_recycler.layoutManager = LinearLayoutManager(activity)
//        category_list_recycler.adapter = context?.let { CategoryListAdapter(list1, it) }

    }
}