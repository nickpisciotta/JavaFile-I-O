package salestaxes;

public class Parser {
    
    private static final String[] EXEMPT_ITEMS = {"chocolate", "book", "pills" };
   
    public static double parseQuantity(String data) {
        float totalQuantity = Float.parseFloat(data.split("")[0]); 
        return totalQuantity; 
    };
    
    public static double parsePrice(String data) {
        String[] dataArray; 
        dataArray   = data.split(" at "); 
        double price = Double.parseDouble(dataArray[1]);
        return price; 
    }; 
    
    public static String parseName(String data) {
        String quantityName = data.split(" at ")[0];
        String name         = quantityName.split("", 2)[1]; 
        return name.trim(); 
    };
    
    public static boolean imported(String data) {
        boolean result = data.contains("imported"); 
        return result; 
    }; 
    
    public static boolean exempt(String data) {
        boolean result = false; 
        for(String item : EXEMPT_ITEMS) {
           if (data.contains(item)) {
               result = true;
               break; 
           } 
        } 
        return result; 
    }     
}
