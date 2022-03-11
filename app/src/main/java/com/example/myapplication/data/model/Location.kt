package com.example.myapplication.data.model

import com.example.myapplication.common.base.IBaseDiffModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Location(

    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("type")
    @Expose
    val type: String? = null,

    @SerializedName("url")
    @Expose
    private var url: String? = null

) : IBaseDiffModel
