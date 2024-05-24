package week5.patikaStore;

public class Phone extends Product {

    private Integer camera;
    private Double battery;
    private String color;

    public Phone(Integer productId, Double productPrice, Integer productStock, String productName, Integer brandId, String brandName, Integer ram, Integer memory, Double screenSize, Integer camera, Double battery, String color) {
        super(productId, productPrice, productStock, productName, brandId, brandName, ram, memory, screenSize);
        this.camera = camera;
        this.battery = battery;
        this.color = color;
    }

    public Integer getCamera() {
        return camera;
    }

    public void setCamera(Integer camera) {
        this.camera = camera;
    }

    public Double getBattery() {
        return battery;
    }

    public void setBattery(Double battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        return "|" + this.getProductId() + " | " + this.getProductName() + "                      | " + this.getProductPrice() + "     | " + this.getName() + "     | " + this.getMemory() + "  | " + this.getScreenSize() + "  | " + this.getCamera() + "  | " + this.getBattery() + "  | " + this.getRam() + "  | " + this.getColor();
    }
}
