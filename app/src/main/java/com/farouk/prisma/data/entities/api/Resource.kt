package com.farouk.prisma.data.entities.api

import com.google.gson.annotations.SerializedName

data class Resource (

	@SerializedName("path") val path : String,
	@SerializedName("indexed") val indexed : String,
	@SerializedName("index") val index : String,
	@SerializedName("modified") val modified : String,
	@SerializedName("id") val id : String,
	@SerializedName("source") val source : String,
	@SerializedName("published") val published : String,
	@SerializedName("type") val type : String,
	@SerializedName("url") val url : String,
	@SerializedName("href") val href : String
)