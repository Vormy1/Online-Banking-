package com.example.onlinebank;

import java.sql.*;

/**
 * DAO класс для работы с таблицей customers
 */
public class CustomerDAO {

    // CREATE
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO customers (name, email, phone) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPhone());

            ps.executeUpdate();
            System.out.println("Customer added to DB");

        } catch (SQLException e) {
            System.out.println("Add failed: " + e.getMessage());
        }
    }

    // READ
    public void printAllCustomers() {
        String sql = "SELECT * FROM customers";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("email") + " | " +
                                rs.getString("phone")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updatePhone(String email, String newPhone) {
        String sql = "UPDATE customers SET phone = ? WHERE email = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newPhone);
            ps.setString(2, email);

            ps.executeUpdate();
            System.out.println("Phone updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteByEmail(String email) {
        String sql = "DELETE FROM customers WHERE email = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.executeUpdate();
            System.out.println("Customer deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
