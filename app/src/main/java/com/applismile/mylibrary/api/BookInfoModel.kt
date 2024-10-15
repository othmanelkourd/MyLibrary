package com.applismile.mylibrary.api


class BookInfoResponse(
    val kind: String,
    val totalItems: Int,
    val items: List<ItemModel>
)

class ItemModel(
    val id: String,
    val volumeInfo: VolumeInfoModel
)

class VolumeInfoModel(
    val title: String?,
    val subtitle: String?,
    val authors: List<String>?,
    val description: String?,
    val industryIdentifiers: List<IndustryIdentifierModel>,
    val imageLinks: ImageLinksModel?,
)

class ImageLinksModel(
    val smallThumbnail: String?,
    val thumbnail: String?,
    val small: String?,
    val medium: String?,
    val large: String?,
    val extraLarge: String?,
)

class IndustryIdentifierModel(
    val type: String,
    val identifier: String
)
