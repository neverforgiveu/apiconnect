package com.example.apiconnect

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.text.style.BulletSpan
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_bulletin.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.bt1
import kotlinx.android.synthetic.main.activity_main.tv1
import okhttp3.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

import java.io.IOException
import kotlin.math.log


class MainActivityBulletin : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bulletin)




       /* val newUser = Gson().fromJson(json,BOuserlogin.BOuseraccount::class.java )
            tv1.text = "\nuserId: ${newUser.userid}"  + "\naccount ${newUser.account} "+  "\naccesstoken: ${newUser.accesstoken}"  */

        btget.setOnClickListener {
            val getbulletin = Bulletin.getbulletin(userid = 1,accesstoken = "fafaffff",limit = 1,page = 1)
            val json =  Gson().toJson(getbulletin)
            val newUser = Gson().fromJson(json,Bulletin.getbulletin::class.java )
            tv1.text ="userid: ${newUser.userid}\n"+"accesstoken ${newUser.accesstoken}\n"+"limit: ${newUser.limit}\n"+"page: ${newUser.page}\n"
        }

        btset.setOnClickListener {
            val setbulletin = Bulletin.setbulletin(userid = 1,accesstoken = "fafaffff",id = 1,content = "公告內文",disable = "N",starttime = "YYYYMMDDHHMMSS",endtime = "YYYYMMDDHHMMSS")
            val json =  Gson().toJson(setbulletin)
            val newUser = Gson().fromJson(json,Bulletin.setbulletin::class.java )
            tv1.text ="userid: ${newUser.userid}\n"+"accesstoken ${newUser.accesstoken}\n"+ "id: ${newUser.id}\n"+"content: ${newUser.content}\n"+"disable: ${newUser.disable}\n"+"starttime: ${newUser.starttime}\n"+
                    "endtime: ${newUser.endtime}\n"
        }




    }






















}
