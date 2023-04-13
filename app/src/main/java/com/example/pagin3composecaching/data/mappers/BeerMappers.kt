package com.example.pagin3composecaching.data.mappers

import com.example.pagin3composecaching.data.local.BeerEntity
import com.example.pagin3composecaching.data.remote.BeerDto
import com.example.pagin3composecaching.domain.Beer

fun BeerDto.toBeerEntity(): BeerEntity{

    return BeerEntity(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = first_brewed,
        imageUrl = image_url
    )
}


fun BeerEntity.toBeer(): Beer{
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = firstBrewed,
        imageUrl = imageUrl
    )
}