package com.farouk.prisma.data.entities.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "article")
class ArticleDB(@PrimaryKey(autoGenerate = true) val id: Int) {
    constructor() : this(0)
    constructor(
        copyright: String?,
        url: String?,
        date: String?,
        idArticle:String?
    ) : this() {
        this.copyright = copyright
        this.url = url
        this.date = date
        this.idArticle=idArticle
    }

    var copyright: String? = null
    var url: String? = null
    var date: String? = null
    var idArticle: String? = null

}



