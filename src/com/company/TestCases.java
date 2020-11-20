package com.company;

import com.company.Product;
import com.company.ProductNotFoundException;
import com.company.ShoppingCart;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

class TestJunit {
    @Test
    public void testAdd() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine", str);
    }

    @Test
    public void testCreateShoppingCart() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(cart.getItemCount(), 0);
    }

    @Test
    public void testEmptyShoppingCart() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Product("apple", 10));
        cart.empty();
        assertEquals(cart.getItemCount(), 0);
    }

    @Test
    public void testItemIncrese() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Product("apple", 10));
        int num1 = cart.getItemCount();
        cart.addItem(new Product("pear", 5));
        assertEquals(cart.getItemCount(), num1 + 1);
    }

    @Test
    public void testItemDecrese() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Product("apple", 10));
        Product pear = new Product("pear", 5);
        cart.addItem(pear);
        int num1 = cart.getItemCount();
        try {
            cart.removeItem(pear);
        }
        catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(cart.getItemCount(), num1 - 1);
    }

}
