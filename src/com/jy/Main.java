package com.jy;
import java.util.Scanner;
import java.util.ArrayList;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class Main {

    public static String format(double price)
    {
        NumberFormat number = NumberFormat.getInstance();
        number.setMaximumFractionDigits(2);
        number.setMinimumFractionDigits(2);
        number.setRoundingMode(RoundingMode.HALF_UP);
        return number.format(price);
    }

    public static void main(String[] args) {

        System.out.println("Hello, Welcome to Behind-The-Door Break Room Cafe");

        Scanner in = new Scanner(System.in);

        Instructor person = new Instructor();

        ArrayList<Invoice> invoices = new ArrayList<>();

        String input = "";
        double subtotal = 0.00;
        double tax = 0.00;

        System.out.println("Enter your name: ");
        person.setName(in.nextLine());

        System.out.println("Enter your address: ");
        person.setAddress(in.nextLine());

        System.out.println("Enter the date: ");
        person.setDate(in.nextLine());

        System.out.println("Enter your account number: ");
        person.setAccountnumber(in.nextInt());
        in.nextLine();


        while(!input.equals("n"))
        {
            Invoice receipt = new Invoice();

            System.out.println("Enter item name: ");
            receipt.setName(in.nextLine());

            System.out.println("Price: ");
            receipt.setPrice(in.nextDouble());
            in.nextLine();

            System.out.println("Quantity: ");
            receipt.setQuantity(in.nextInt());
            in.nextLine();

            System.out.println("Taxable (true or false): ");
            receipt.setTaxable(in.nextBoolean());
            in.nextLine();

            System.out.println("Enter your state: ");
            receipt.setState(in.nextLine().toLowerCase());

            invoices.add(receipt);

            System.out.println("Add another item (y) or (n): ");
            input = in.nextLine().toLowerCase();
        }

        for(int i = 0; i<invoices.size();i++)
        {
            subtotal += invoices.get(i).getPrice();
        }

        for(int i = 0; i<invoices.size();i++)
        {
            if(invoices.get(i).isTaxable())
            {
                if(invoices.get(i).getState().equals("MD"))
                {
                    tax = tax + (invoices.get(i).getPrice() * 0.06);
                }
                else if (invoices.get(i).getState().equals("DC"))
                {
                    tax = tax + (invoices.get(i).getPrice() * 0.053);
                }
                else if (invoices.get(i).getState().equals("VA"))
                {
                    tax = tax + (invoices.get(i).getPrice() * 0.0575);
                }
                else
                {
                    tax = tax + (invoices.get(i).getPrice() * 0.05);
                }
            }
        }

        System.out.println(person.toString());
        System.out.println("Item Name             Quantity             Price             Cost             Taxable        \n" +
                           "=============================================================================================\n");

        for(int i = 0; i<invoices.size();i++)
        {
            System.out.println(invoices.get(i).toString());
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Subtotal: $"+format(subtotal));
        System.out.println("Sales Tax: $"+format(tax));
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Total: $"+format(subtotal+tax));



    }
}
