
package com.farouk.prisma.data.entities.api
import com.google.gson.annotations.SerializedName

data class Article (

	@SerializedName("apiVersion") val apiVersion : Double,
	@SerializedName("data") val data : Data
)