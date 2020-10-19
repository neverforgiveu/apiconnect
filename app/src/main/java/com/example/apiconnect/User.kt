package com.example.apiconnect



class User {


    data class login(var account: String, var password: String) {

    }



    data class getaccount(var userid: Int, var accesstoken: String, var account: String) {

    }

    data class logout(var userid: Int, var accesstoken: String) {

    }


    data class getloginlog(
        var userid: Int, var accesstoken: String, var sdate: String, var edate: String,

        var limit: Int, var page: Int, var keyword: String, var id: Int
    ) {

    }

    data class getoperationlog(
        var userid: Int, var accesstoken: String, var sdate: String, var edate: String,

        var limit: Int, var page: Int, var keyword: String, var id: Int
    )


    data class getpermission(var userid: Int, var accesstoken: String, var account: String) {

    }

    data class settranslation(var userid: Int, var accesstoken: String, var chinesetext:String,var englishtext: String,var module:String,var objectkey: String) {

    }

    data class setuser(
        var userid: Int,
        var accesstoken: String,
        var id: Int,
        var delete: String,
        var name: String,
        var account: String,
        var password: String,
        var email: String,
        var acl: Int,
        var disable: String
    ) {

    }






    data class BOuserlogout(var userid: Int, var accesstoken: String) {

    }

    data class BOsetdict(
        var userid: Int,
        var accesstoken: String,
        var chinesetext: String,
        var englishtext: String
    ) {

    }

    data class BOaddorupdate(
        var userid: Int,
        var accesstoken: String,
        var id: Int,
        var delete: String,
        var name: String,
        var account: String,
        var password: String,
        var email: String,
        var acl: Int,
        var disable: String
    ) {

    }


}
