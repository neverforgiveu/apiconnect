package com.example.apiconnect

data class FEnotify(var limit: Int,var page:Int){


    data class FEact(var limit: Int,var page: Int){

    }

    data class FEpresent(var sdate: String,var edate:String,var userid:Int,var accesstoken:String){

    }

    data class FEpresent2(var date:String,var userid: Int,var accesstoken: String) {

    }



}