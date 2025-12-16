import model.dao.DaoFactory;
import model.dao.DepartmentDao;
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
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

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

        System.out.println();
        System.out.println("===== TEST 7: department findById =====");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println();
        System.out.println("===== TEST 8: department findAll =====");
        List<Department> list = departmentDao.findAll();
        for (Department d : list) {
            System.out.println(d);
        }

        System.out.println();
        System.out.println("===== TEST 9: department insert =====");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println();
        System.out.println("===== TEST 10: department update =====");
        Department dep2 = departmentDao.findById(1);
        dep2.setName("Food");
        departmentDao.update(dep2);
        System.out.println("Update completed");

        System.out.println("===== TEST 11: department delete =====");
        System.out.print("Enter id for delete test: ");
        int id2 = sc.nextInt();
        departmentDao.deleteById(id2);
        System.out.println("Delete completed");

        sc.close();
    }
}