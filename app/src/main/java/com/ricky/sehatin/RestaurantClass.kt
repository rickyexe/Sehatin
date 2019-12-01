package com.ricky.sehatin

data class Restaurant(var id:Int, var name:String,
                var alamat:String, var logo:String)
{
    override fun toString(): String {
        return name
    }
}

