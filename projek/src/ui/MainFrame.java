package ui;

import dao.TableUserDAO;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import models.TableUser;

public class MainFrame extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtName, txtAge, txtEmail, txtAddress;
    private TableUserDAO TableUserDAO;

    public MainFrame() {
        TableUserDAO = new TableUserDAO();
        setTitle("Table User Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Panel Utama
        JPanel panel = new JPanel(new BorderLayout());
        getContentPane().add(panel);

        // Tabel
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Age", "Email", "Address"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Form Input
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Manage Data"));

        inputPanel.add(new JLabel("Name:"));
        txtName = new JTextField();
        inputPanel.add(txtName);

        inputPanel.add(new JLabel("Age:"));
        txtAge = new JTextField();
        inputPanel.add(txtAge);

        inputPanel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        inputPanel.add(txtEmail);

        inputPanel.add(new JLabel("Address:"));
        txtAddress = new JTextField();
        inputPanel.add(txtAddress);

        panel.add(inputPanel, BorderLayout.NORTH);

        // Tombol
        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("Add");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Load data ke tabel
        loadTableData();

        // Event Handlers
        btnAdd.addActionListener(e -> addData());
        btnUpdate.addActionListener(e -> updateData());
        btnDelete.addActionListener(e -> deleteData());

        setVisible(true);
    }

    private void loadTableData() {
        tableModel.setRowCount(0);
        List<TableUser> data = TableUserDAO.getAll();
        for (TableUser row : data) {
            tableModel.addRow(new Object[]{
                row.getId(),
                row.getName(),
                row.getAge(),
                row.getEmail(),
                row.getAddress()
            });
        }
    }

    private void addData() {
        try {
            // Membuat objek baru untuk data pengguna
            TableUser newRow = new TableUser();
    
            // Mengambil data dari JTextField menggunakan getText()
            newRow.setName(txtName.getText());
            newRow.setAge(Integer.parseInt(txtAge.getText())); // Parsing string ke integer
            newRow.setEmail(txtEmail.getText());
            newRow.setAddress(txtAddress.getText());
    
            // Menyimpan data ke database melalui DAO
            TableUserDAO.insert(newRow);
    
            // Memuat ulang data ke tabel
            loadTableData();
    
            // Menampilkan pesan sukses
            JOptionPane.showMessageDialog(this, "Data added successfully!");
        } catch (NumberFormatException ex) {
            // Menangani jika input usia bukan angka
            JOptionPane.showMessageDialog(this, "Invalid age format. Please enter a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            // Menangani kesalahan lain
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    private void updateData() {
        try {
            // Memastikan ada baris yang dipilih
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to update.");
                return;
            }
    
            // Mendapatkan ID dari baris yang dipilih
            int id = (int) tableModel.getValueAt(selectedRow, 0);
    
            // Membuat objek baru untuk menyimpan data yang diperbarui
            TableUser updatedRow = new TableUser();
            updatedRow.setId(id);
    
            // Mengambil data dari JTextField menggunakan getText()
            updatedRow.setName(txtName.getText());
            updatedRow.setAge(Integer.parseInt(txtAge.getText())); // Parsing string ke integer
            updatedRow.setEmail(txtEmail.getText());
            updatedRow.setAddress(txtAddress.getText());
    
            // Memperbarui data di database melalui DAO
            TableUserDAO.update(updatedRow);
    
            // Memuat ulang data ke tabel
            loadTableData();
    
            // Menampilkan pesan sukses
            JOptionPane.showMessageDialog(this, "Data updated successfully!");
        } catch (NumberFormatException ex) {
            // Menangani jika input usia bukan angka
            JOptionPane.showMessageDialog(this, "Invalid age format. Please enter a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            // Menangani kesalahan lain
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    private void deleteData() {
        try {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to delete.");
                return;
            }

            int id = (int) tableModel.getValueAt(selectedRow, 0);
            TableUserDAO.delete(id);
            loadTableData();
            JOptionPane.showMessageDialog(this, "Data deleted successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
