
package salestaxes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CartItemsTest {
    
    public CartItemsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @org.junit.Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        CartItems instance = new CartItems("1 box of wine at 12");
        double expResult = 1.0; 
        double result = instance.getQuantity();
        double delta = 0.0; 
        assertEquals(expResult, result, delta);
    }
    
    @org.junit.Test
    public void testGetPrice() {
        System.out.println("getPrice");
        CartItems instance = new CartItems("1 box of wine at 12");
        double expResult = 12.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
    }
    
    @org.junit.Test
    public void testGetImported() {
        System.out.println("getImported");
        CartItems instance = new CartItems("1 imported box of wine at 12");
        boolean expResult = true;
        boolean result = instance.isImported();
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testGetName() {
        System.out.println("getName");
        CartItems instance = new CartItems("1 box of wine at 12");
        String expResult = "box of wine";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testGetExemption() {
        System.out.println("getExemption");
        CartItems instance = new CartItems("1 imported bar of chocolate at 12");
        boolean expResult = true;
        boolean result = instance.isExempt();
        assertEquals(expResult, result);
    }
}
