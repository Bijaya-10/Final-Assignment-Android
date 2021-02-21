package com.bijaya.bookstore.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bijaya.bookstore.dao.UserDAO
import com.bijaya.bookstore.entity.Customer

@Database(
entities = [(Customer::class)],
        version = 1
)
abstract class CustomerDB :RoomDatabase(){

    abstract fun getUserDao() : UserDAO

    companion object{
        @Volatile
        private  var instance : CustomerDB? = null
       fun  getInstance(context: Context): CustomerDB{
       if(instance==null){
           synchronized(CustomerDB::class){
               instance = buildDatabase(context)
           }
       }
           return instance!!
       }
        private fun  buildDatabase(context: Context)=
                Room.databaseBuilder(
                        context.applicationContext,
                        CustomerDB::class.java,
                        "CustomerDB"
                ).build()


    }



}