
package salestaxes;
import java.util.List;

public class Calculator {
    private static final double SALESTAX = 0.1; 
    private static final double IMPORTDUTY = 0.05; 
    
    public static void main(Cart cart) {
        calculations(cart);
    }
    
    public static void calculations(Cart cart) { 
        for (CartItems item : cart.getAllItems()) {
           sumItemTaxesAndTotal(item);
           sumCartTotal(cart, item.getSalesTax(), item.getTotalCost()); 
        }
    }
    
    public static void sumItemTaxesAndTotal(CartItems item) {
        checkSalesTax(item); 
        checkImportDuty(item);
        sumTotalItemCost(item); 
    }
    
    public static void sumCartTotal(Cart cart, double itemSalesTax, double itemTotalCost) {
        addToCartSalesTaxes(cart, itemSalesTax);
        addToCartTotal(cart, itemTotalCost); 
    }
    
    public static void addToCartSalesTaxes(Cart cart, double salesTax) {
        cart.setSalesTaxes(salesTax);
    }
    
    public static void addToCartTotal(Cart cart, double itemTotalCost) {
        cart.setCartTotal(itemTotalCost);
    }

    public static double checkSalesTax(CartItems item) {
        double roundedTax = 0; 
        if (!item.isExempt()) { 
           double salesTax = (SALESTAX * item.getPrice());
           roundedTax = roundSalesTax(salesTax);
           item.setSalesTax(roundedTax);  
        }
    return roundedTax; 
    }
    
    public static double checkImportDuty(CartItems item) {
        double roundedTax = 0; 
        if (item.isImported()) {
            double importDuty = (IMPORTDUTY * item.getPrice());
            roundedTax = roundSalesTax(importDuty); 
            item.setSalesTax(roundedTax); 
        }
        return roundedTax; 
    }
    
    public static void sumTotalItemCost(CartItems item) {
        item.setTotalCost(item.getSalesTax());
    }
    
    private static double roundSalesTax(double itemTax) {
        return Math.ceil(itemTax * 20) / 20.0;
    }      
}
