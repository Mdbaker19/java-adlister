import Models.Employee;
import Models.Product;
import daos.DaoFactory;

import java.util.Date;
import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee matt = new Employee();

        matt.setEmpNo(1L);
        matt.setFirstName("Matt");
        matt.setLastName("B");
        matt.setBirthDate(new Date());
        matt.setHireDate(new Date());
        matt.setGender('M');

        System.out.println("Name : " + matt.getFirstName() + " " + matt.getLastName());

        Employee second = new Employee();
        Employee third = new Employee();

        Product item1 = new Product();
        item1.setName("personal Item");
        item1.setPrice(77.99);
        List<Product> cart = DaoFactory.getProductsDao().all();
        DaoFactory.getProductsDao().insert(item1);
        System.out.println(DaoFactory.getProductsDao().all().size());

        for(Product c : cart){
            System.out.println(c.getName());
        }

    }
}
