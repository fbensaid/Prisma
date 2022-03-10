package com.farouk.prisma.data.entities.api
import com.google.gson.annotations.SerializedName

data class Category (

	@SerializedName("depth") val depth : Int,
	@SerializedName("resource") val resource : Resource,
	@SerializedName("descriptionSeo") val descriptionSeo : String,
	@SerializedName("title") val title : String,
	@SerializedName("titleSeo") val titleSeo : String
)