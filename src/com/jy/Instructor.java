package com.jy;


public class Instructor {
    private String name;
    private String address;
    private String date;
    private int accountnumber;


//    public Instructor(String n, String a, String d, int an)
//    {
//        name = n;
//        address = a;
//        date = d;
//        accountnumber = an;
//    }

    @Override
    public String toString() {
        return  "------------------------------------------------------\n"+
                "Customer Name:      " + name + "\n" +
                "Address:            " + address + "\n" +
                "Date:               " + date + "\n" +
                "Account Number:     " + accountnumber + "\n"+
                "------------------------------------------------------\n";
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(int accountnumber) {
        this.accountnumber = accountnumber;
    }
}
