
package com.capgemini.cartservice;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.cartservice.cartresource.CartResource;
import com.capgemini.cartservice.entity.Cart;
import com.capgemini.cartservice.entity.Items;
import com.capgemini.cartservice.service.CartService;

@RunWith(SpringRunner.class)

@SpringBootTest
public class CartServiceTest {

	@Autowired
	private CartService cartService;

	private Items item;
	private List<Items> items;

	@Before
	public void setUp() {
		item = new Items("Samsung", 1000, 2);
		items = new ArrayList<Items>();
		items.add(item);
		items.add(new Items("Nokia",1000,2));
		items.add(new Items("Redmi",1000,2));
	}

	@Test
	public void testGetCart() throws Exception {
		Cart actual = cartService.getcartById(101);
		Cart expected = new Cart(101, items);
		assertEquals(expected.getItems(), actual.getItems());

	}

	@Test(expected = NoSuchElementException.class)
	public void testCartNotFound() throws Exception {
		Cart cart = cartService.getcartById(120);
	}

	@Test
	public void testUpdateCart() throws Exception {
		
		Items item = new Items("Nokia", 1000, 2);
		List<Items> itemsSet = new ArrayList<Items>();
		itemsSet.add(item);
		CartResource cartResource = new CartResource();
		Cart actual = cartService.getcartById(103);
		Cart expected = new Cart(103, itemsSet);
		assertEquals(expected.getItems(), actual.getItems());
	}

}
