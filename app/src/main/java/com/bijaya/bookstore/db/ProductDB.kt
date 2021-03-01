package com.bijaya.bookstore.db

import android.content.Context
import androidx.room.*
import com.bijaya.bookstore.dao.ProductDAO
import com.bijaya.bookstore.entity.Product

@Dao
abstract class ProductDB : RoomDatabase() {
    abstract fun getUserDao(): ProductDAO


    companion object {
        @Volatile
        private var instance: ProductDB? = null

        fun getInstance(context: Context): ProductDB {
            if (instance == null) {
                synchronized(ProductDB::class) {
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ProductDB::class.java,
                "StudentDB"
            ).build()

    }
}