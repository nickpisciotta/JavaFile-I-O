
package salestaxes;
import java.util.ArrayList;
import java.util.List;


public class Cart {
    private List<CartItems> allItems; 
    private double total; 
    private double salesTaxes; 
    
    public Cart(List<CartItems> allItems) {
        this.allItems   = allItems;
        this.total      = 0.0; 
        this.salesTaxes = 0.0; 
    }
    
    public List<CartItems> getAllItems() {return allItems;}
    public double getTotal() {return total;} 
    public double getSalesTaxes() {return salesTaxes;} 
    public void  setSalesTaxes(double tax) {this.salesTaxes += tax;}
    public void  setCartTotal(double itemTotal) {this.total += itemTotal;}     
}
