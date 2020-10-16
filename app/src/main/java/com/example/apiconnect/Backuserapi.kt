package com.example.apiconnect



    data class BOuserlogin(var account: String, var password: String) {




    data class BOuseraccount(var userid: Int, var accesstoken: String, var account:String) {
    }

    data class BOloginrecord(var userid: Int, var accesstoken: String,var sdate: String, var edate: String,

                             var limit: Int, var page: Int,var keyword: String, var id: Int) {

    }
    data class BOoperateRecord(var userid: Int, var accesstoken: String,var sdate: String, var edate: String,

                               var limit: Int, var page: Int,var keyword: String, var id: Int)


    data class BOuserpermission(var userid: Int, var accesstoken: String, var account:String){

    }

    data class BOgetdict(var userid: Int, var accesstoken: String, var account:String){

    }

    data class BOgetuser(var userid: Int, var accesstoken: String,var limit: Int, var page: Int,var keyword: String){

    }

    data class BOuserlogout(var userid: Int, var accesstoken: String){

    }

    data class BOsetdict(var userid: Int, var accesstoken: String,var chinesetext: String, var englishtext: String){

    }

}