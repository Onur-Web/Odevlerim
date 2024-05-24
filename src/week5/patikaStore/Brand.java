package week5.patikaStore;

public class Brand {
    private Integer id;
    private String name;


    public Brand(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getProductId() {
        return id;
    }

    public void setProductId(Integer productId) {
        this.id = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
