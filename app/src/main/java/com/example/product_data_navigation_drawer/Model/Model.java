package com.example.product_data_navigation_drawer.Model;

public class Model {
    int connection;
    int productaddd;

    public int getConnection() {
        return connection;
    }

    public void setConnection(int connection) {
        this.connection = connection;
    }

    public int getProductaddd() {
        return productaddd;
    }

    public void setProductaddd(int result) {
        this.productaddd = result;
    }

    @Override
    public String toString() {
        return "RegisterUser{" +
                "connection=" + connection +
                ", productadd=" + productaddd +
                '}';
    }



}
