package com.tecc0.kotlintest.viewmodel

class Gallery(imageId: Int, title: String, url: String, userName: String) {

    var imageId: Int = -1
    var title: String = ""
    var url: String = ""
    var userName: String = ""

    init {
        this.imageId = imageId
        this.title = title
        this.url = url
        this.userName = userName
    }
}
