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
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

import java.io.IOException
import kotlin.math.log


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //view.setBackgroundColor(Color.rgb(133, 194, 255))




       /* val newUser = Gson().fromJson(json,BOuserlogin.BOuseraccount::class.java )
            tv1.text = "\nuserId: ${newUser.userid}"  + "\naccount ${newUser.account} "+  "\naccesstoken: ${newUser.accesstoken}"  */




        bt1.setOnClickListener {
            val user = User.login("jeff","123")
            val json =  Gson().toJson(user)
            val newUser = Gson().fromJson(json,User.login::class.java )
            tv1.text = "account: ${newUser.account}\n"+"password: ${newUser.password}"
        }

        btbull.setOnClickListener {
            startActivity<MainActivityBulletin>()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
           R.id.getaccount-> getaccount()
           R.id.getloginlog -> getloginlog()
            R.id.getoperationlog -> getoperationlog()
            R.id.getpermission -> getpermission()
            R.id.logout -> logout()
            R.id.settranslation -> settranslation()
            R.id.setuser -> setuser()
        }
        return true
    }







    fun getaccount(){
      var getaccount = User.getaccount(userid = 1,accesstoken = "fafaffff",account = "jeff@gmail.com")
        val json =  Gson().toJson(getaccount)
        val newUser = Gson().fromJson(json,User.getaccount::class.java )
        tv1.text = "userid: ${newUser.userid}\n"+"accesstoken: ${newUser.accesstoken} \n" + "account: ${newUser.account}\n"
    }
    fun getloginlog(){
        var getloginlog = User.getloginlog(userid = 1,accesstoken = "fafaffff",sdate = "YYYY-MM-01",edate = "YYYY-MM-TT",limit = 0,page = 0,keyword = "key",id = 1)
        val json =  Gson().toJson(getloginlog)
        val newUser = Gson().fromJson(json,User.getloginlog::class.java )
        tv1.text = "userid: ${newUser.userid}\n"+"accesstoken: ${newUser.accesstoken} \n" + "sdate: ${newUser.sdate}\n"+"edate: ${newUser.edate}\n"+"limit: ${newUser.limit}\n"+"page: ${newUser.page}\n"+
                "keyword: ${newUser.keyword}\n"+"id: ${newUser.id}\n"
    }
    fun getoperationlog(){
        var getoperationlog = User.getoperationlog(userid = 1,accesstoken = "fafaffff",sdate = "YYYY-MM-01",edate = "YYYY-MM-TT",limit = 0,page = 0,keyword = "key",id = 1)
        val json =  Gson().toJson(getoperationlog)
        val newUser = Gson().fromJson(json,User.getoperationlog::class.java )
        tv1.text ="userid: ${newUser.userid}\n"+"accesstoken: ${newUser.accesstoken} \n" + "sdate: ${newUser.sdate}\n"+"edate: ${newUser.edate}\n"+"limit: ${newUser.limit}\n"+"page: ${newUser.page}\n"+
                "keyword: ${newUser.keyword}\n"+"id: ${newUser.id}\n"
    }
    fun getpermission(){
        var getpermission = User.getpermission(userid = 1,accesstoken = "fafaffff",account = "jeff@gmail.com")
        val json =  Gson().toJson(getpermission)
        val newUser = Gson().fromJson(json,User.getpermission::class.java )
        tv1.text ="userid: ${newUser.userid}\n"+"accesstoken: ${newUser.accesstoken} \n" + "account: ${newUser.account}\n"
    }

    fun logout(){
        var logout = User.logout(userid = 1,accesstoken = "fafaffff")
        val json =  Gson().toJson(logout)
        val newUser = Gson().fromJson(json,User.logout::class.java )
        tv1.text = "userid: ${newUser.userid}\n"+"accesstoken: ${newUser.accesstoken} \n"
    }
    fun settranslation(){
        var settranslation = User.settranslation(userid = 1,accesstoken = "fafaffff",chinesetext = "chinese",englishtext = "english",module = "module",objectkey = "key")
        val json =  Gson().toJson(settranslation)
        val newUser = Gson().fromJson(json,User.settranslation::class.java )
        tv1.text = "userid: ${newUser.userid}\n"+"accesstoken: ${newUser.accesstoken} \n"+"chinesetext: ${newUser.chinesetext}\n"+"englishtext: ${newUser.englishtext}\n"+"module: ${newUser.module}\n"+
                "objectkey: ${newUser.objectkey}\n"
    }
    fun setuser(){
        var setuser = User.setuser(userid = 1,accesstoken = "fafaffff",id = 1,delete = "N",name = "jeff",account = "jeff@gmail.com",password = "123",email = "jeff@gmail.com",acl = 1,disable = "N")
        val json =  Gson().toJson(setuser)
        val newUser = Gson().fromJson(json,User.setuser::class.java )
        tv1.text = "userid: ${newUser.userid}\n"+"accesstoken: ${newUser.accesstoken} \n" +"delete: ${newUser.delete}\n"+ "account: ${newUser.account}\n"+"password ${newUser.password}\n"+"email: ${newUser.email}\n"+
                "acl: ${newUser.acl}\n"+"disable: ${newUser.disable}\n"
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
    }













}
