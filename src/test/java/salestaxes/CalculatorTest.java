
package salestaxes;

import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    
    public CalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testCalculator() {
        CartItems item1 = new CartItems("1 imported bottle of perfume at 27.99"); 
        CartItems item2 = new CartItems("1 music CD at 14.99"); 
        List<CartItems> allItems = new ArrayList<>();
        allItems.add(item1);
        allItems.add(item2); 
        Cart cart = new Cart(allItems); 
        Double item1SalesTax = 4.2; 
        Double item1Total    = 32.19; 
        Double item2SalesTax = 1.50; 
        Double item2Total    = 16.490000000000002; 
        Double totalCartTaxes = 5.70;
        Double totalCartTotal = 48.68;
       
        Calculator.main(cart); 
        assertEquals(item1SalesTax, item1.getSalesTax(), 0); 
        assertEquals(item1Total, item1.getTotalCost(), 0); 
        assertEquals(item2SalesTax, item2.getSalesTax(), 0);
        assertEquals(item2Total, item2.getTotalCost(), 0);
        assertEquals(totalCartTaxes, cart.getSalesTaxes(), 0);
        assertEquals(totalCartTotal, cart.getTotal(), 0);
    }

    @Test
    public void testSumItemTaxesAndTotal() {
        CartItems item = new CartItems("1 imported bottle of perfume at 27.99"); ;
        Calculator.sumItemTaxesAndTotal(item);
        Double  itemSalesTax  = 4.2;
        Double itemTotalCost = 32.19; 
        
        assertEquals(itemSalesTax, item.getSalesTax(), 0);
        assertEquals(itemTotalCost, item.getTotalCost(), 0);
    }
      
    @Test
    public void testSumCartTotal() {
        CartItems item = new CartItems("1 imported bottle of perfume at 27.99"); 
        List<CartItems> allItems = new ArrayList<>();
        allItems.add(item);
        Cart cart = new Cart(allItems);
        Double itemSalesTax = 4.2; 
        Double itemTotal    = 32.19; 
        Calculator.sumCartTotal(cart, itemSalesTax, itemTotal); 
        double expResult    = 32.19; 
        double result       = cart.getTotal(); 
        
        assertEquals(expResult, result, 0.0);      
    }

    @Test
    public void testCheckSalesTax() {
        CartItems item1 = new CartItems("1 imported bottle of perfume at 27.99");
        double expResult = 2.80;
        double result    = Calculator.checkSalesTax(item1);
        assertEquals(expResult, result, 0.0);
        
        CartItems item2  = new CartItems("1 chocolate bar at 0.85"); 
        double expResult2 = 0.0; 
        double result2    = Calculator.checkSalesTax(item2);
        assertEquals(expResult2, result2, 0.0);
    }
    
    @Test
    public void testCheckImportDuty() {
        CartItems item1 = new CartItems("1 imported bottle of perfume at 27.99");
        double expResult = 1.40;
        double result    = Calculator.checkImportDuty(item1); 
        assertEquals(expResult, result, 0.0);
        
        CartItems item2  = new CartItems("1 chocolate bar at 0.85"); 
        double expResult2 = 0.0; 
        double result2    = Calculator.checkImportDuty(item2);
        assertEquals(expResult2, result2, 0.0);
    }    
}
