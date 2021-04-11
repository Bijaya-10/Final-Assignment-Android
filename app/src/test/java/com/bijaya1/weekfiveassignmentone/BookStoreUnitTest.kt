package com.bijaya1.weekfiveassignmentone

import com.bijaya.bookstore.API.ServiceBuilder
import com.bijaya.bookstore.entity.CustomerOrderEntity
import com.bijaya.bookstore.entity.Product
import com.bijaya.bookstore.entity.customer
import com.bijaya.bookstore.repository.CustomerRepository
import com.bijaya.bookstore.repository.ProductRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class BookStoreUnitTest {

    private lateinit var customerRepo: CustomerRepository;
    @Test
    fun loginTest() = runBlocking {
        customerRepo = CustomerRepository();
        val response = customerRepo.checkUser("ooooo","ppppp")
        val expectedResult: Boolean = true;
        val actualResult = response.success;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    fun loginTestFailed() = runBlocking {
        customerRepo = CustomerRepository();
        val response = customerRepo.checkUser("oooo1o","ppppp")
        val expectedResult: Boolean = true;
        val actualResult = response.success;
        Assert.assertEquals(expectedResult, actualResult);
    }

    //User SignUp Test
    @Test
    fun signUpTest() = runBlocking {
        customerRepo = CustomerRepository();
        val Customer = customer(
            firstname = "Bijaya",
            lastname = "Pokhrel",
            username = "ooooo",
            password = "ppppp",

        );
        val response = customerRepo.registerUser(Customer);
        val expectedResult: Boolean = true;
        val actualResult = response.success;
        Assert.assertEquals(expectedResult, actualResult);
    }


    @Test
    fun addProduct()= runBlocking {

        customerRepo = CustomerRepository();
        val responseCustomer = customerRepo.checkUser("ooooo","ppppp");
        ServiceBuilder.token = "Bearer " + responseCustomer.token

        val productRepo = ProductRepository();
        val response = productRepo.addProduct(Product(Customer_Name = "dsfds",Customer_Email = "fsdafds",Customer_Address = "fdsfds",Book_Image = "", Customer_Book = ""));
        val expectedResult:Boolean = true;
        val actualResult:Boolean = response.success!!;
        Assert.assertEquals(expectedResult, actualResult);

    }


    @Test
    fun addProductFail()= runBlocking {

        customerRepo = CustomerRepository();
        val responseCustomer = customerRepo.checkUser("oodvooo","ppdfppp");
        ServiceBuilder.token = "Bearer " + responseCustomer.token

        val productRepo = ProductRepository();
        val response = productRepo.addProduct(Product(Customer_Name = "dsfds",Customer_Email = "fsdafds",Customer_Address = "fdsfds",Book_Image = "", Customer_Book = ""));
        val expectedResult:Boolean = true;
        val actualResult:Boolean = response.success!!;
        Assert.assertEquals(expectedResult, actualResult);

    }
}











