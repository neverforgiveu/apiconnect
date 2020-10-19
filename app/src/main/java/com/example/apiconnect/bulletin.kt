package com.example.apiconnect

class bulletin {


    data class BOnotify(var userid: Int, var accesstoken: String, var limit: Int, var page: Int) {

    }


    data class BOnotify２(
        var userid: Int,
        var accesstoken: String,
        var limit: Int,
        var id: Int,
        var content: String,
        var starttime: String,
        var endtime: String
    ) {

    }
}