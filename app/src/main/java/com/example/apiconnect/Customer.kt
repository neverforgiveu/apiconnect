package com.example.apiconnect

class Customer {
    data class getaccount(var account: String){

    }

    data class getcustomer(var userid: Int, var accesstoken: String, var limit: Int, var page: Int,var keyword: String, var orderby: String, var sortby: String){

    }

    data class  getdownline(var userid: Int,var accesstoken: String,var id: String){

    }

    data class  getloginlog(var userid: Int,var accesstoken: String,var keyword: String,var id: Int, var limit: Int,var page: Int,var sdate: String, var edate: String){

    }

    data class getphone(var mobilephone: String){

    }

    data class regist(var account: String,var password: String, var namecn: String,var nameen: String,var mobilephone: String,var parentid: Int,var wechatid: String, var gender: String){

    }

    data class setavailable(var customerid: Int,var disable: String){

    }

    data class  setcustomer(var id: Int, var account: String,var password: String,var namecn: String,var nameen: String,var addresscn: String,var addressen: String, var mobilephone: String, var parentid: Int,var wechatid: String,var gender: String){

    }

}