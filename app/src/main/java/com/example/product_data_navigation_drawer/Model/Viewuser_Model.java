package com.example.product_data_navigation_drawer.Model;

import java.util.List;

public class Viewuser_Model {
    int connection;
    int result;
    List<Productdata_Model>productdata;
    public Viewuser_Model(int connection, int result) {
        this.connection = connection;
        this.result = result;
    }

    public int getConnection() {
        return connection;
    }

    public void setConnection(int connection) {
        this.connection = connection;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Viewuser_Model{" +
                "connection=" + connection +
                ", result=" + result +
                '}';
    }
}
