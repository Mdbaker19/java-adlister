import Models.Employee;

import java.util.Date;

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
    }
}
