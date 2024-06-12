package carRental.business;

import carRental.core.Helper;
import carRental.dao.BrandDao;
import carRental.entity.Brand;
import carRental.entity.Model;

import java.util.ArrayList;

public class BrandManager {
    private final BrandDao brandDao;
    private final ModelManager modelManager;

    //USERDAO CLASSINI ÇAĞIRDIĞIMIZ METOD
    public BrandManager() {
        this.brandDao = new BrandDao();
        this.modelManager = new ModelManager();
    }

    //VİEW DAN BU METODA GELECEĞİZ BURADAN DAO YA GİDECEĞİZ
    public ArrayList<Brand> findAll() {
        return this.brandDao.findAll();
    }

    //VIEW DAN BU METODA GELECEGIZ BURADAN DAO YA GIDECEGIZ
    public ArrayList<Object[]> getForTable(int size) {
        ArrayList<Object[]> brandRowList = new ArrayList<>();
        for (Brand brand : this.findAll()) {
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = brand.getId();
            rowObject[i++] = brand.getName();
            brandRowList.add(rowObject);
        }
        return brandRowList;
    }

    //VİEW DAN BU METODA GELECEĞİZ BURADAN DAO YA GİDECEĞİZ
    public boolean save(Brand brand) {
        if (brand.getId() != 0) {
            Helper.showMessage("error");
        }
        return this.brandDao.save(brand);
    }

    //VİEW DAN BU METODA GELECEĞİZ BURADAN DAO YA GİDECEĞİZ
    public Brand getById(int id) {
        return this.brandDao.getById(id);
    }

    //VİEW DAN BU METODA GELECEĞİZ BURADAN DAO YA GİDECEĞİZ
    public boolean update(Brand brand) {
        if (this.getById(brand.getId()) == null) {
            Helper.showMessage("notFound");
        }
        return this.brandDao.update(brand);
    }

    //VİEW DAN BU METODA GELECEĞİZ BURADAN DAO YA GİDECEĞİZ
    public boolean delete(int id) {
        if (this.getById(id) == null) {
            Helper.showMessage(id + " ID Kayıtlı Marka Bulunamadı");
            return false;
        }
        for (Model model : this.modelManager.getByListBrandId(id)){
            this.modelManager.delete(model.getId());
        }
        return this.brandDao.delete(id);
    }
}
