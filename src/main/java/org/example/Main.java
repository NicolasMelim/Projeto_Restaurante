package org.example;

import Entites.Client;
import Entites.Order;
import Entites.OrderItem;
import Entites.Product;
import Entites.enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Insira os dados do cliente:");
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("E-mail: ");
        String email = sc.next();
        System.out.print("Data de nascimento (DD/MM/YYYY): ");
        Date birthDate = sfd.parse(sc.next());

        Client client = new Client(name, email, birthDate);
        System.out.println("Insira os dados do pedido:");
        System.out.print("Status: ");
        sc.nextLine(); // Limpa o buffer após sc.next()
        OrderStatus status = OrderStatus.valueOf(sc.next().toUpperCase());

        Order order = new Order(new Date(), status, client);

        System.out.print("Quantos itens para o pedido? ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Dados do produto #" + i + ":");
            sc.nextLine(); // Limpa o buffer após sc.nextInt()
            System.out.print("Nome: ");
            String nameProduct = sc.nextLine();
            System.out.print("Preço: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantidade: ");
            int quantity = sc.nextInt();

            Product product = new Product(nameProduct, productPrice);
            OrderItem oti = new OrderItem(quantity, productPrice, product);
            order.addItem(oti);
        }

        System.out.println();
        System.out.println(order); // Exibe os detalhes do pedido formatados
        sc.close();
    }
}
