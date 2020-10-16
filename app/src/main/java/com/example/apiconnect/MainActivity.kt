package com.example.apiconnect

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

import java.io.IOException


class MainActivity : AppCompatActivity() {

    private val user = BOuserlogin.BOuseraccount(1,"111","jeff")
    private val json =  Gson().toJson(user)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        view.setBackgroundColor(Color.rgb(133, 194, 255))




        bttest.setOnClickListener {
        val newUser = Gson().fromJson(json,BOuserlogin.BOuseraccount::class.java )
            tv1.text = "\nuserId: ${newUser.userid}"  + "\naccount ${newUser.account} "+  "\naccesstoken: ${newUser.accesstoken}"

        }




        bt1.setOnClickListener {

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
           R.id.getuser -> getUSERdata()
        }
        return true
    }

    fun getUSERdata(){

        val client = OkHttpClient()
        val request = Request.Builder()
            .url("http://demoeapi.meya.com.tw/Api/index.php")
            .build()



        // val sb = StringBuffer()
        doAsync(){

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    tv1.text = e.toString()
                }

                override fun onResponse(call: Call, response: Response) {
                    val resStr = response.body()?.string()
                    val test = Gson().fromJson(resStr,test::class.java )
                    uiThread {
                        tv1.text = "isSuccess: "+test.IsSuccess.toString()+ "\nMessage: "+test.Message
                    }
                    //val tests: List<test> = Gson().fromJson(resStr, Array<test>::class.java).toList()
                    /* for(item in tests){
                        var  result ="\nuserId: " + item.userId + "\ntitle: "+ item.title + "\n"+ "\nbody: "+ item.body+ "\nid: "+ item.id

                         uiThread {

                             /*Log.e("id", "id: " + item.id)
                             Log.e("title", "title: " + item.title)
                             Log.e("body", "body: " + item.body)
                             Log.e("userId", "userId: " + item.userId)*/
                             tv1.text = "isSuccess: "+item.IsSuccess +"\nMessage:" + item.Message
                         }
                     }*/

                }
            })
        }
    }




}
