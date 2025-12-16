import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("===== TEST 1: seller findById =====");
        Seller seller = sellerDao.findById(1);
        System.out.println(seller);

        System.out.println();
        System.out.println("===== TEST 2: seller findByDepartment =====");
        Department department = new Department(2, null);
        List<Seller> sellersByDepartment = sellerDao.findByDepartment(department);
        for (Seller s : sellersByDepartment) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("===== TEST 3: seller findAll =====");
        List<Seller> sellersAll = sellerDao.findAll();
        for (Seller s : sellersAll) {
            System.out.println(s);
        }
    }
}