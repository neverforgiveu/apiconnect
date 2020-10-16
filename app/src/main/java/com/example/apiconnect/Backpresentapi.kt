package com.example.apiconnect

data class BOpresent(var keyword: String, var limit: Int,var page: Int,var sdate:String,var edate: String,var userid: Int,var accesstoken:String){

    data class BOpresent2(var date: String,var userid: Int,var accesstoken: String){

    }

}

