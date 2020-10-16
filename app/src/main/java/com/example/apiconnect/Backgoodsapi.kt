package com.example.apiconnect

import org.json.JSONStringer
import java.io.File

data class good1 (var typeid: Int,var limit:Int,var page:Int, var userid:Int,var accesstoken: String){


    data class good2(var limit: Int,var page: Int,var userid: Int,var accesstoken: String){

    }

    data class  good3(var sdate: String,var edate:String,var keyword:String,var limit: Int,var page: Int,var userid: Int,var accesstoken: String){

    }

    data class good4(var typeid: Int,var limit: Int,var page: Int,var userid: Int,var accesstoken: String){

    }

    data class good5(var goodsid: Int,var userid: Int,var accesstoken: String){

    }

    data class good6(var ordertime:String, var data : JSONStringer,var userid: Int,var accesstoken: String){

    }

    data class good7(var id: Int,var typeid: Int,var namecn:String,var nameen: String,var descryptioncn:String,var descryptionen: String,var allowshipping: String,var price: Int,var userid: Int,var accesstoken: String){

    }

    data class good8(var goodsid: Int,var disable: String,var userid: Int, var accesstoken: String){

    }

    data class good9(var id: Int, var picid:Int, var file: File,var userid: Int,var accesstoken: String){

    }

    data class good10(var id: Int,var namecn: String,var nameen: String,var disable: String,var deleted:String,var userid: Int,var accesstoken: String){

    }

    data class  good11(var id: Int,var disable: String,var userid: Int,var accesstoken: String){

    }

    data class  good12(var id: Int,var file: File,var userid: Int,var accesstoken: String){

    }

    data class  good13(var goodsid: Int,var level: Int,var price: Int,var minimumorder: Int,var userid: Int,var accesstoken: String){

    }








}