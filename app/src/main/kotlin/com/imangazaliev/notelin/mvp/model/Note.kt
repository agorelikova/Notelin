package com.imangazaliev.notelin.mvp.model

import com.google.gson.annotations.SerializedName
import com.imangazaliev.notelin.utils.formatDate
import com.reactiveandroid.annotation.Table
import java.util.*

@Table(name = "Notes", database = AppDatabase::class)
class Note {

//    @PrimaryKey
    var id: String = ""
//    @Column(name = "title")
    var title: String? = null
//    @Column(name = "text")
    var text: String? = null
//    @Column(name = "created_at")
    @SerializedName("created")
    var createAt: Date? = null
//    @Column(name = "change_at")
    @SerializedName("modified")
    var changedAt: Date? = null

    constructor(title: String, createDate: Date) {
        this.title = title
        this.createAt = createDate
        this.changedAt = createDate
    }

    constructor()

    fun getInfo(): String = "Title:\n$title\n" +
            "Created at:\n${formatDate(createAt)}\n" +
            "Changed at:\n${formatDate(changedAt)}"

}