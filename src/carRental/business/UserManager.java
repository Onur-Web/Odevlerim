package carRental.business;

import carRental.dao.UserDao;
import carRental.entity.User;

public class UserManager {
    private final UserDao userDao;

    //USERDAO CLASSINI ÇAĞIRDIĞIMIZ METOD
    public UserManager() {
        this.userDao = new UserDao();
    }
    //VİEW DAN BU METODA GELECEĞİZ BURADAN DAO YA GİDECEĞİZ
    public User findByLogin(String username, String password){
        //BU METOD İÇERİSİNDE FARKLI İŞLEMLER YAPABİLİRİZ
        return this.userDao.findByLogin(username,password);
    }
}
