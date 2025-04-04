package Entites;

public class OrderItem {
    Integer quantity;
    Double price;
    public OrderItem(){

    }
    public OrderItem(Integer quantity, Double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItem(int quantity, double productPrice, Product product) {

    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }
    public Double subTotal(){
        return quantity * price;
    }
}
