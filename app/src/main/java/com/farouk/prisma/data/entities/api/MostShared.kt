package com.farouk.prisma.data.entities.api
import com.google.gson.annotations.SerializedName

data class MostShared (

	@SerializedName("date") val date : String,
	@SerializedName("count") val count : Int
)