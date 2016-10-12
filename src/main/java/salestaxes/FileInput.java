package salestaxes;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileInput {
    static List<CartItems> allItems = new ArrayList<>(); 
   
    public static void main(String[] args) throws IOException { 
        BufferedReader textIn = null; 
        FileReader inputFile = new FileReader(args[0]); 
        FileInput fileInput = new FileInput(); 
        
        try { 
            textIn = new BufferedReader(inputFile);
            String currentLine; 
            while ((currentLine = textIn.readLine()) != null) { 
                fileInput.createItems(currentLine);       
            } 
            createCartAndReceipt(allItems); 
        } finally  {
            if (textIn != null) {
                textIn.close(); 
            } 
        } 
    }

    private void createItems(String item) {  
        CartItems cartItem = new CartItems(item);
        allItems.add(cartItem);        
    }
    
    private static void createCartAndReceipt(List<CartItems> items) throws IOException {  
        Cart totalItems = new Cart(items); 
        System.out.println("Items now being added to cart");
        calculateTaxAndTotal(totalItems); 
        generateReceipt(totalItems);     
    }
    
    private static void calculateTaxAndTotal(Cart items) {
       Calculator.main(items); 
       System.out.println("Calculating Taxes");
    }
    
    private static void generateReceipt(Cart items) throws IOException {
        ReceiptWriter example = new ReceiptWriter(); 
        example.writeReceipt(items); 
    }
}
