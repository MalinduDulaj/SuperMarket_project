package tm;

import javafx.scene.control.Button;

public class CustomerTM {
    private int customerid;
    private String name;
    private String address;
    private double salary;
    private Button btnDelete;
    public int getCustomerid() {
        return customerid;
    }
    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Button getBtnDelete() {
        return btnDelete;
    }
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }
    public CustomerTM(int customerid, String name, String address, double salary, Button btnDelete) {
        this.customerid = customerid;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.btnDelete = btnDelete;
    }
    
    public CustomerTM() {

    }


    @Override
    public String toString() {
        return "CustomerTM [customerid=" + customerid + ", name=" + name + ", address=" + address + ", salary=" + salary
                + ", btnDelete=" + btnDelete + "]";
    }

    
}
