package com.example.apiconnect

import org.json.JSONStringer
import java.io.File

data class act1(var onlyfinish: Int,var limit: Int,var page:Int,var userid:Int,var accesstoken: String){

    data class act2(var id: Int,var disable:String,var userid:Int,var accesstoken: String){

    }

    data class act3(var id: Int,var file:File,var userid: Int,var accesstoken: String){

    }

    data class  act4(var id: Int,var starttime:String,var endtime:String,var content:String,var linkurl: String,var sortnum: Int,var split:Float,var disable: String,var data:JSONStringer,var userid:Int,var accesstoken: String){

    }
}
