package com.example.apiconnect

data class BOgetcustomeraccount(var account: String){

    data class BOgetuser(var userid: Int, var accesstoken: String, var limit: Int, var page: Int,var keyword: String, var orderby: String, var sortby: String){

    }

    data class  BOgetbackofficeoffline(var userid: Int,var accesstoken: String,var id: String){

    }

    data class  BOgetcustomerloginrecord(var userid: Int,var accesstoken: String,var keyword: String,var id: Int, var limit: Int,var page: Int,var sdate: String, var edate: String){

    }

    data class BOgetcustomphone(var mobilephone: String){

    }

    data class BOcustomsignup(var account: String,var password: String, var namecn: String,var nameen: String,var mobilephone: String,var parentid: Int,var wechatid: String, var gender: String){

    }

    data class BOsetcustomstart(var customerid: Int,var disable: String){

    }

    data class  BOcustomsignup2(var id: Int, var account: String,var password: String,var namecn: String,var nameen: String,var addresscn: String,var addressen: String, var mobilephone: String, var parentid: Int,var wechatid: String,var gender: String){

    }


}