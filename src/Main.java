import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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

        System.out.println();
        System.out.println("===== TEST 4: seller insert =====");
        Seller newSeller = new Seller(null, "Greg Martini", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println();
        System.out.println("===== TEST 5: seller update =====");
        Seller sellerToUpdate = sellerDao.findById(newSeller.getId());
        sellerToUpdate.setName("Bruce Wayne");
        sellerDao.update(sellerToUpdate);
        System.out.println("Updated Completed!");

        System.out.println();
        System.out.println("===== TEST 6: seller delete =====");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();
    }
}