package com.example.apiconnect

class test{
    data class  test(var IsSuccess: Boolean, var Message: String){

    }

    data class userInfo(var account: String = "", var password:String = "", var userid:Int = 0, val accesstoken:String = ""){

    }
    data class Posts(
        var userId: Int,

        var id: Int ,

        var title: String,

        var body: String){

    }


}
