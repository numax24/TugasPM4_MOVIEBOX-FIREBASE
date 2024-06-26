package com.example.lgf

class ItemData {
    var detailbox:String? = null
    var gambarbox:String? = null
    var genrebox:String? = null
    var namabox:String? = null
    var ratingbox:String? = null
    var rilisbox:String? = null
    var waktubox:String? = null
    constructor(){}

    constructor(
        detailbox:String?,
        gambarbox:String?,
        genrebox:String?,
        namabox:String?,
        ratingbox:String?,
        rilisbox:String?,
        waktubox:String?
    )
    {
        this.detailbox = detailbox
        this.gambarbox = gambarbox
        this.genrebox = genrebox
        this.namabox = namabox
        this.ratingbox = ratingbox
        this.rilisbox = rilisbox
        this.waktubox = waktubox
    }
}
