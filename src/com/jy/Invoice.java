package com.jy;


import java.math.RoundingMode;
import java.text.NumberFormat;

public class Invoice {
    private String name;
    private double price;
    private int quantity;
    private boolean taxable;
    private String state;


//    public Invoice(String n, double p, int q, boolean t)
//    {
//        name = n;
//        price = p;
//        quantity = q;
//        taxable = t;
//    }

    @Override
    public String toString() {

        String temp = String.valueOf(taxable);
        String temp2 = String.valueOf(quantity);
        String temp3 = String.valueOf(getPrice());
        return(formatlength(11,name)+"           "+formatlength(11,temp2)+"          "+formatlength(11,getFormattedPrice(price))+"       "+formatlength(11,temp3)+"      "+formatlength(11,temp));
    }

    public String formatlength(int x, String s)
    {
        if(s.length() > x)
        {
            return s.substring(0,x);
        }
        else
        {
            return(s+spaces(x-s.length()));
        }
    }

    public String spaces(int x)
    {
        String s = "";

        for(int i = 0; i<x;i++)
        {
            s+= " ";
        }
        return s;
    }



    private String getFormattedPrice(double price) {
        // Use the NumberFormat class to format the price to 2 decimal places
        NumberFormat number = NumberFormat.getInstance();
        number.setMaximumFractionDigits(2);
        number.setMinimumFractionDigits(2);
        number.setRoundingMode(RoundingMode.HALF_UP);
        return number.format(price);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price*getQuantity();
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
