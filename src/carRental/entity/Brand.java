package carRental.entity;

public class Brand {
    private int id;
    private String name;

    //BOŞ OLARAK BİR CONSTRUCKTOR OLUŞTURDUK (OBERLOADING)
    public Brand() {

    }
    //DOLU BİR CONSTRUCKTOR OLUŞTURDUK (OBERLOADING)
    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }
    //VAROLAN CONSTRUCKTOR DEGISTIRILDI (OVERLOADING)
    public Brand(String name) {
        this.id = id;
        this.name = name;
    }
    //GET VE SET LER OLUŞTURULDU
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
