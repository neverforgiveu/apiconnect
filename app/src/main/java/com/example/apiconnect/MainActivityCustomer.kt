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
import kotlinx.android.synthetic.main.activity_customer.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.tv1
import okhttp3.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

import java.io.IOException
import kotlin.math.log


class MainActivityCustomer : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)
        //view.setBackgroundColor(Color.rgb(133, 194, 255))




       /* val newUser = Gson().fromJson(json,BOuserlogin.BOuseraccount::class.java )
            tv1.text = "\nuserId: ${newUser.userid}"  + "\naccount ${newUser.account} "+  "\naccesstoken: ${newUser.accesstoken}"  */




        btcustlogin.setOnClickListener {
            val user = Customer.getaccount("jeff＠gmail.com")
            val json =  Gson().toJson(user)
            val newUser = Gson().fromJson(json,Customer.getaccount::class.java )
            tv1.text = "account: ${newUser.account}\n"
        }

       btback.setOnClickListener {
            //startActivity<MainActivityBulletin>()
            //getUSERdata()
           finish()
        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_optioncustomer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
         R.id.getcustomer -> getcustomer()
            R.id.getdownline -> getdownline()
            R.id.getloginlog -> getloginlog()
            R.id.getphone -> getphone()




        }
        return true
    }

    fun getcustomer(){
        val getcustomer = Customer.getcustomer(1,"fafaffff",1,1,"keyword","order","A")
        val json =  Gson().toJson(getcustomer)
        val newUser = Gson().fromJson(json,Customer.getcustomer::class.java )
        tv1.text = "userid: ${newUser.userid}\n"+ "accesstoken: ${newUser.accesstoken}\n"+"limit: ${newUser.limit}\n"+"page: ${newUser.page}\n"+"keyword: ${newUser.keyword}\n"+
                "orderby: ${newUser.orderby}\n"+"sortby: ${newUser.sortby}\n"
    }
    fun getdownline(){
        val getdownline = Customer.getdownline(1,"fafaffff","1")
        val json =  Gson().toJson(getdownline)
        val newUser = Gson().fromJson(json,Customer.getdownline::class.java )
        tv1.text = "userid: ${newUser.userid}\n"+ "accesstoken: ${newUser.accesstoken}\n"+"id: ${newUser.id}\n"
    }
    fun getloginlog(){
        val getloginlog = Customer.getloginlog(1,"fafaffff",keyword = "keyword",id = 1,1,1,"YYYY-MM-01","YYYY-MM-TT")
        val json =  Gson().toJson(getloginlog)
        val newUser = Gson().fromJson(json,Customer.getloginlog::class.java )
        tv1.text = "userid: ${newUser.userid}\n"+ "accesstoken: ${newUser.accesstoken}\n"+"limit: ${newUser.limit}\n"+"page: ${newUser.page}\n"+"keyword: ${newUser.keyword}\n"+
                "id: ${newUser.id}\n"+"sdate: ${newUser.sdate}\n"+"edate: ${newUser.edate}\n"
    }
    fun getphone(){
        val getphone = Customer.getphone("0900000000")
        val json =  Gson().toJson(getphone)
        val newUser = Gson().fromJson(json,Customer.getphone::class.java )
        tv1.text = "mobilephone: ${newUser.mobilephone}\n"
    }



























































   var tmp = ""
    fun getUSERdata(){
        doAsync() {

            val client = OkHttpClient()
            val request = Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {

                }

                override fun onResponse(call: Call, response: Response) {
                    val resStr = response.body()?.string()
                    val tests: List<test.Posts> =
                        Gson().fromJson(resStr, Array<test.Posts>::class.java).toList()
                    val sb = StringBuffer()

                    for (item in tests) {
                        sb.append("userId: ")
                        sb.append(item.userId)
                        sb.append("\n")
                        sb.append("title: ")
                        sb.append(item.title)
                        sb.append("\n")
                        sb.append("body: ")
                        sb.append(item.body)
                        sb.append("\n")
                        sb.append("id: ")
                        sb.append(item.id)
                        sb.append("\n")
                    }
                     tmp = sb.toString()
                    runOnUiThread() {
                        tv1.text = tmp
                    }

                }

            })


        }


       /*
        doAsync(){

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    tv1.text = e.toString()
                }

                override fun onResponse(call: Call, response: Response) {
                    val resStr = response.body()?.string()
                    val test = Gson().fromJson(resStr,test.test::class.java )
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

        */



    }













}
