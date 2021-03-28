package com.bijaya.bookstore

class Model: serializable {
    var name:String?=null
    var image:Int?=null

    constructor(name:String, image:Int){
        this.name = name;
        this.image = image;
    }
}