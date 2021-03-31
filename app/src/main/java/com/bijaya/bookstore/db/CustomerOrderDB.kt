package com.bijaya.bookstore.db

import android.content.Context
import androidx.room.*
import com.bijaya.bookstore.dao.CustomerOrderDAO
import com.bijaya.bookstore.dao.ProductDAO
import com.bijaya.bookstore.entity.CustomerOrderEntity
import com.bijaya.bookstore.entity.Product

@Database(entities = ([CustomerOrderEntity::class]), version = 1, exportSchema = false)
abstract class CustomerOrderDB : RoomDatabase() {
    //    abstract fun getUserDao(): ProductDAO
    abstract fun getProductDao(): CustomerOrderDAO;


    companion object {
        @Volatile
        private var instance: CustomerOrderDB? = null

        fun getInstance(context: Context): CustomerOrderDB {
            if (instance == null) {
                synchronized(CustomerOrderDB::class) {
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CustomerOrderDB::class.java,
                "ProductDB"
            ).fallbackToDestructiveMigration()
                .build()

    }
}