package salestaxes;
import java.io.*;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReceiptWriter {
   String receiptFilePath; 
   ArrayList<String> receiptContent; 
   private File receipt; 
   private FileWriter writeReceipt; 
   private BufferedWriter bufferedWriter; 
   
   public ReceiptWriter() throws IOException {
      this.receiptContent = new ArrayList<>();  
      setUpFileWriter(); 
   }
  
   public void writeReceipt(Cart cart) throws IOException {
      addContentToReceipt(cart); 
      checkForReceipt(); 
      
      try {
          writeToFile();
          closeFile();
      } catch (IOException e) {
           System.out.println("Error writing to file '" + receiptFilePath + "'");
      }
   }
   
    public void addContentToReceipt(Cart cart) {
     formatCartItems(cart.getAllItems());  
     formatSummaryLines(cart); 
   }
   
   public void formatCartItems(List<CartItems> cartItems) {
     for (CartItems item : cartItems) {
        receiptContent.add(String.format("%.1f %s: %.2f", item.getQuantity(), item.getName(), item.getTotalCost()));
     }  
   }
   
   public void formatSummaryLines(Cart cart) {
     receiptContent.add(String.format("Sales Taxes: %.2f", cart.getSalesTaxes())); 
     receiptContent.add(String.format("Total: %.2f", cart.getTotal())); 
   }
   
   private void writeToFile() throws IOException {
       for(String line : receiptContent) {
           bufferedWriter.write(line); 
           bufferedWriter.newLine(); 
       }
   }
   
   private void closeFile() throws IOException {
       bufferedWriter.close(); 
       writeReceipt.close(); 
       System.out.println("Receipt has now been printed");
   }
   
   private void setUpFileWriter() throws IOException {
     receiptFilePath = "receipts/receipt_" + dateTime() + ".txt";   
     receipt         = new File(receiptFilePath);
     writeReceipt    = new FileWriter(receipt, true);
     bufferedWriter  = new BufferedWriter(writeReceipt); 
   } 
   
   private void checkForReceipt() throws IOException {
     if (!receipt.exists()) {
         receipt.createNewFile(); 
     }  
   }
   
   private static String dateTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss");
        return df.format(new Date());
   }  
}
