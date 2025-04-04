package Entites;

import Entites.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus orderStatus;
    private Client client;
    List<OrderItem> orderItems = new ArrayList<>();

    public Order(){}


    public Order(Date moment, OrderStatus orderStatus, Client client) {
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    public void addItem(OrderItem ord){
        orderItems.add(ord);

    }
    public void removeItem(OrderItem ord){
        orderItems.remove(ord);

    }
    public double total(){
        double sum = 0  ;
        for (OrderItem item : orderItems){
            return  sum += item.subTotal();
        }
        return  sum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "moment=" + moment +
                ", orderStatus=" + orderStatus +
                ", orderItems=" + orderItems +
                '}';
    }
}
