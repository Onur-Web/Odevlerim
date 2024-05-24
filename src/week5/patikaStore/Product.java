package week5.patikaStore;

public class Product extends Brand {

    private Integer productId;
    private Double productPrice;
    private Integer productStock;
    private String productName;

    private Integer ram;
    private Integer memory;
    private Double screenSize;

    public Product(Integer productId, Double productPrice, Integer productStock, String productName, Integer brandId, String brandName, Integer ram, Integer memory, Double screenSize) {
        super(brandId, brandName);
        this.productId = productId;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productName = productName;
        this.ram = ram;
        this.memory = memory;
        this.screenSize = screenSize;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
    }
}
