package model;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class Order {
    private String OrderID;
    private String OrderData;
    private String CustID;
    public String getOrderID() {
        return OrderID;
    }
    public void setOrderID(String orderID) {
        OrderID = orderID;
    }
    public String getOrderData() {
        return OrderData;
    }
    public void setOrderData(String orderData) {
        OrderData = orderData;
    }
    public String getCustID() {
        return CustID;
    }
    public void setCustID(String custID) {
        CustID = custID;
    }
    public Order(String orderID, String orderData, String custID) {
        OrderID = orderID;
        OrderData = orderData;
        CustID = custID;
    }
    public Order() {
    }
    @Override
    public java.lang.String toString() {
        return "Order [OrderID=" + OrderID + ", OrderData=" + OrderData + ", CustID=" + CustID + "]";
    }

    
}
