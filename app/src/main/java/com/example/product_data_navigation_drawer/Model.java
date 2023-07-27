package com.example.product_data_navigation_drawer;

public class Model {
    int connection;
    int productadd;

    public int getConnection() {
        return connection;
    }

    public void setConnection(int connection) {
        this.connection = connection;
    }

    public int getProductadd() {
        return productadd;
    }

    public void setProductadd(int result) {
        this.productadd = result;
    }

    @Override
    public String toString() {
        return "RegisterUser{" +
                "connection=" + connection +
                ", productadd=" + productadd +
                '}';
    }



}
