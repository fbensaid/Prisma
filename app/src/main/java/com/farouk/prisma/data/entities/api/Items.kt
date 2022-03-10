
package com.farouk.prisma.data.entities.api
import com.google.gson.annotations.SerializedName

data class Items (

	@SerializedName("mostViewed") val mostViewed : MostViewed,
	@SerializedName("resource") val resource : Resource,
	@SerializedName("published") val published : String,
	@SerializedName("body") val body : String,
	@SerializedName("title") val title : String,
	@SerializedName("dateIndexed") val dateIndexed : String,
	@SerializedName("universalUniqueIdentifier") val universalUniqueIdentifier : String,
	@SerializedName("lead") val lead : String,
	@SerializedName("medias") val medias : Medias,
	@SerializedName("path") val path : List<String>,
	@SerializedName("bodySize") val bodySize : Int,
	@SerializedName("category") val category : Category,
	@SerializedName("contentTypes") val contentTypes : List<String>,
	@SerializedName("mostShared") val mostShared : MostShared,
	//@SerializedName("authors") val authors : List<String>,
	@SerializedName("keywords") val keywordswords : List<String>
)