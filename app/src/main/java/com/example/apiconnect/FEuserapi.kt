package com.example.apiconnect

import java.net.Inet4Address

data class FEuserlogin(var account: String,var password:String){


    data class FEstoredlogin(var account: String,var password: String){

    }

    data class  FEstored(var amount:Int,var userid:Int, var accesstoken:String){

    }

    data class FEgetbackgoods(var limit:Int,var page: Int){

    }

    data class FElogout(var userid: Int,var accesstoken: String){

    }

    data class FEdataupdate(var name:String,var password: String,var email:String,var gender:String,var mobilephone:String,var address: String,var disable:String,var delete:String,var userid: Int,var accesstoken: String){

    }



}