
package salestaxes;

import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CartTest {
    
    public CartTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        CartItems item1 = new CartItems("1 music CD at 14.99"); 
        List<CartItems> allItems = new ArrayList<>();
        allItems.add(item1);
        Cart cart = new Cart(allItems);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetAllItems() {
        CartItems item1 = new CartItems("1 imported bottle of perfume at 27.99"); 
        CartItems item2 = new CartItems("1 music CD at 14.99"); 
        List<CartItems> allItems = new ArrayList<>();
        allItems.add(item1);
        allItems.add(item2); 
        Cart cart = new Cart(allItems);
        double expResult = 2; 
        int result = cart.getAllItems().size();
        
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSetSalesTaxes() {
        CartItems item = new CartItems("1 music CD at 14.99"); 
        List<CartItems> allItems = new ArrayList<>();
        allItems.add(item);
        Cart cart = new Cart(allItems);
        double itemTax = 1.50f; 
        cart.setSalesTaxes(itemTax);
        double expResult = 1.50f; 
        double result    = cart.getSalesTaxes(); 
        
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSetCartTotal() {
        CartItems item = new CartItems("1 music CD at 14.99"); 
        List<CartItems> allItems = new ArrayList<>();
        allItems.add(item);
        Cart cart = new Cart(allItems);
        double itemTotal = 16.49f;
        cart.setCartTotal(itemTotal); 
        double expResult = 16.49f;
        double result    = cart.getTotal(); 
        
        assertEquals(expResult, result, 0.0);  
    }    
}
