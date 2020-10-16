package com.example.apiconnect

import org.json.JSONStringer

data class FEorderapi(var amount:Int,var userid:Int,var accesstoken:String){


    data class FEorderapi2(var id:Int,var amount: Int,var userid: Int,var accesstoken: String){

    }

    data class FEorderapi3(var limit:Int,var page:Int){

    }

    data class FEorderapi4(var limit: Int,var page: Int,var userid: Int,var accesstoken: String){

    }

    data class FEorderapi5(var id: Int,var userid: Int,var accesstoken: String){

    }

    data class FEorderapi6(var shippingreceiver:String,var shippingaddress: String,var shippingtelephone: String,var currency:String,var data:JSONStringer,var userid: Int,var accesstoken: String){

    }


}
