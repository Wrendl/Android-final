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
import kotlinx.android.synthetic.main.fragment_third.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ThirdFragment : Fragment() {

    var list2 = ArrayList<News>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://saurav.tech/NewsAPI/top-headlines/category/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        val country = arguments?.getString("country")
        val category = arguments?.getString("category")

        if (category != null) {
            if (country != null) {
                apiService.getNews(category,country).enqueue(object : Callback<List<News>> {
                    override fun onFailure(call: Call<List<News>>, t: Throwable) {
                        t.message?.let { Log.e("Error", it) }
                    }

                    override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                        Log.e("Response size: ", response.body()!!.size.toString() + "")
                        list2.addAll(response.body()!!)
                        first.text = list2[0].title
//                        post_list_recycler.layoutManager = LinearLayoutManager(activity)
//                        post_list_recycler.adapter = context?.let { PostListAdapter(list1, it) }
                    }
                })
            }
        }

        first.text = country
        second.text = category
    }
}