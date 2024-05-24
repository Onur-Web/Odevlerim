package week5.patikaStore;

public class Notebook extends Product {

    public Notebook(Integer productId, Double productPrice, Integer productStock, String productName, Integer brandId, String brandName, Integer ram, Integer memory, Double screenSize) {
        super(productId, productPrice, productStock, productName, brandId, brandName,ram,memory,screenSize);

    }

    public String toString(){
        return "|" + this.getProductId() + " | " + this.getProductName() + "                      | " + this.getProductPrice() + "     | " + this.getName() + "     | " + this.getMemory() + "  | " + this.getScreenSize() + "     | " + this.getRam() + " |         ";
    }


}
