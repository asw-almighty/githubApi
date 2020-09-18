package com.example.githubapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    val BASE_URL = "https://api.github.com/search/"
    val arr = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //retrofit 선언
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //api 가져오기
        val api = retrofit.create(API::class.java)

        var call = api.getUsers()

        //API 요청
        call.enqueue(object : Callback<UserData> {

            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                //호출이 성공했을 때 실행
                Log.e("MAINACTIVITY", response?.body()?.items.toString())

                for (str in response?.body()?.items!!) {
                    Log.e("MAINACTIVITY", str.login)
                    arr.add(str.login)
                }

                val list_adapter = MainListAdapter(this@MainActivity, arr)
                listview_api_id.adapter = list_adapter
            }

            override fun onFailure(call: Call<UserData>?, t: Throwable?) {
                //호출이 실패했을 때 실행
            }

        })

        // 각각 item마다 클릭했을때 이벤트 설정하는 방법
        listview_api_id.setOnItemClickListener {parent, view, position, id ->
            Toast.makeText(this, arr.get(position), Toast.LENGTH_SHORT).show()
        }
    }
}