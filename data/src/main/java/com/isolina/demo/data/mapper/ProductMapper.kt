package com.isolina.demo.data.mapper

import com.isolina.demo.data.local.entity.ProductEntity
import com.isolina.demo.domain.models.Links
import com.isolina.demo.domain.models.Patch
import com.isolina.demo.domain.models.Product

fun convertProductsToEntities(products: List<Product>): List<ProductEntity> {
    var entities: MutableList<ProductEntity> = mutableListOf()
    products.forEach { product ->
        entities.add(ProductEntity(
            id = product.id,
            name = product.name,
            details = product.details ?: "",
            date_unix = product.date_unix,
            date_precision = product.date_precision,
            flight_number = product.flight_number,
            success = product.success,
            image_small = product.getImageSmall(),
            image_large = product.getImageLarge()
        ))
    }
    return entities
}

fun convertEntitiesToProducts(entities: List<ProductEntity>): List<Product> {
    var products: MutableList<Product> = mutableListOf()
    entities.forEach { product ->
        val patch = Patch(small = product.image_small, large = product.image_large)
        products.add(Product(
            id = product.id,
            name = product.name,
            details = product.details,
            date_unix = product.date_unix,
            date_precision = product.date_precision,
            flight_number = product.flight_number,
            success = product.success,
            links = Links(patch = patch)
        ))
    }
    return products
}