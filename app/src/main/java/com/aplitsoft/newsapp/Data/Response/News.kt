package com.aplitsoft.newsapp.Data.Response

data class News (val status:String, val totalResults : Int, val articles : MutableList<Articles>)