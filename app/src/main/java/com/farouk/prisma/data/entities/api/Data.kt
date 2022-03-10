package com.farouk.prisma.data.entities.api

import com.google.gson.annotations.SerializedName

data class Data (

	@SerializedName("date") val date : String,
	@SerializedName("currentItemCount") val currentItemCount : Int,
	@SerializedName("totalItems") val totalItems : Int,
	@SerializedName("startIndex") val startIndex : Int,
	@SerializedName("itemsPerPage") val itemsPerPage : Int,
	@SerializedName("items") val items : List<Items>
)