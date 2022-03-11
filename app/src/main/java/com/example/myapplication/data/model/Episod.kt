package com.example.myapplication.data.model

import com.example.myapplication.common.base.IBaseDiffModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Episod(

    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("episodes")
    @Expose
    val episodes: String? = null,

    @SerializedName("url")
    @Expose
    private var url: String? = null

) : IBaseDiffModel
