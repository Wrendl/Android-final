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

class FirstFragment : Fragment() {

    var list = ArrayList<Country>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        list.add(Country(0,"India","in"))
        list.add(Country(1,"USA","us"))
        list.add(Country(2,"Australia","au"))
        list.add(Country(3,"Russia","ru"))
        list.add(Country(4,"France","fr"))
        list.add(Country(5,"United Kingdom","gb"))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        country_list_recycler.layoutManager = LinearLayoutManager(activity)
        country_list_recycler.adapter = context?.let { CountryListAdapter(list, it) }

    }
}