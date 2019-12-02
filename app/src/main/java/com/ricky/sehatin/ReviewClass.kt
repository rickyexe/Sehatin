package com.ricky.sehatin

data class Review(var username:String, var date:String, var komen:String)
{
    override fun toString(): String {
        return komen
    }
}