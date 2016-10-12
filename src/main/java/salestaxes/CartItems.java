
package salestaxes;

public class CartItems {
    private String data;
    private double quantity;
    private double price;
    private String name;
    private double salesTax; 
    private double totalCost; 
    private boolean imported;
    private boolean exemption; 
    private final Parser parser = new Parser();  

    public CartItems(String data) {
        this.data      = data; 
        this.quantity  = Parser.parseQuantity(data);
        this.price     = Parser.parsePrice(data); 
        this.salesTax  = 0;
        this.totalCost = price; 
        this.name      = Parser.parseName(data); 
        this.imported  = Parser.imported(data); 
        this.exemption = Parser.exempt(data);
    }
    
    public double getQuantity() {return quantity;} 
    public double getPrice() {return price;}
    public void  setSalesTax(double tax) {this.salesTax += tax;
                                          this.salesTax = Math.ceil(this.salesTax * 20) / 20.0;}
    public void  setTotalCost(double totalTaxes) {this.totalCost += totalTaxes;}  
    public boolean isImported() {return imported;} 
    public String getName() {return name;}
    public double getSalesTax() { return salesTax; } 
    public double getTotalCost() {return totalCost;}
    public boolean isExempt() {return exemption;}
    
}; 
    

