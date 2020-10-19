package com.example.apiconnect

class Bulletin {


    data class getbulletin(var userid: Int, var accesstoken: String, var limit: Int, var page: Int) {

    }


    data class setbulletin(
        var userid: Int,
        var accesstoken: String,
        var id: Int,
        var content: String,
        var disable:String,
        var starttime: String,
        var endtime: String
    ) {

    }
}