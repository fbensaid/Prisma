package com.farouk.prisma.data.entities.api
import com.google.gson.annotations.SerializedName

data class Medias (

	@SerializedName("imageCount") val imageCount : Int,
	@SerializedName("videoCount") val videoCount : Int,
	@SerializedName("images") val images : List<Images>,
	@SerializedName("videos") val videos : String,
	@SerializedName("podcast") val podcast : String
)