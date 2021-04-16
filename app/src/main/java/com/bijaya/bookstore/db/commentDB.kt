package com.bijaya.bookstore.db

import android.content.Context
import androidx.room.*
import com.bijaya.bookstore.dao.ProductDAO
import com.bijaya.bookstore.dao.commentDAO
import com.bijaya.bookstore.entity.Product
import com.bijaya.bookstore.entity.comment

@Database(entities = ([comment::class]), version = 1, exportSchema = false)
abstract class commentDB : RoomDatabase() {
    //    abstract fun getUserDao(): ProductDAO
    abstract fun getProductDao(): commentDAO;


    companion object {
        @Volatile
        private var instance: commentDB? = null

        fun getInstance(context: Context): commentDB {
            if (instance == null) {
                synchronized(commentDB::class) {
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                commentDB::class.java,
                "commentDB"
            ).fallbackToDestructiveMigration()
                .build()

    }
}