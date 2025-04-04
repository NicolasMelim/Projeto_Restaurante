package org.example;

import Entites.Client;
import Entites.Order;
import Entites.OrderItem;
import Entites.Product;
import Entites.enums.OrderStatus;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws ParseException {

       Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Insira a data do cliente: ");
        System.out.println("Nome: ");
        String name = sc.nextLine();
        System.out.println("E-mail: ");
        String email = sc.next();
        System.out.println("Data de nascimento (DD/MM/YYYY): ");
        Date birthDate = sfd.parse(sc.next());

        Client client = new Client(name, email, birthDate);
        System.out.println("Insira os dados do pedido:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());

        Order order = new Order(new Date(), status, client);

        System.out.print("Quantos itens para o pedido: ");
        int n = sc.nextInt();
        for(int i = 0; i < n ; i++){
            System.out.print("Você irá pegar " + i + " produtos.");
            System.out.println("Nome: ");
            String nameProduct = sc.nextLine();
            System.out.println("Preço: ");
            double productPrice = sc.nextDouble();
            System.out.println("Quantidade: ");
            int quantity = sc.nextInt();

            Product product = new Product(nameProduct, productPrice);

            OrderItem oti   = new OrderItem(quantity, productPrice, product);

            order.addItem(oti);
        }
            System.out.println();

            System.out.println(order);
            sc.close();
        }
}