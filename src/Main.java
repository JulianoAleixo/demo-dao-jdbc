import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Department department = new Department(1, "Books");
        System.out.println(department);

        Seller seller = new Seller(1, "Juliano", "juliano@email.com", new Date(), 2500.0, department);
        System.out.println(seller);

        SellerDao sellerDao = DaoFactory.createSellerDao();
    }
}