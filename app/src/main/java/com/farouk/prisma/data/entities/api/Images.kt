package com.farouk.prisma.data.entities.api
import com.google.gson.annotations.SerializedName

data class Images (

	@SerializedName("copyright") val copyright : String,
	@SerializedName("original") val original : Original
)