/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas03;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author user
 */


public class FormDataProduk extends JFrame {
    private JTextField textNamaProduk;
    private JComboBox<String> comboKategori;
    private JSpinner spinnerStok;
    private JTable tableProduk;
    private DefaultTableModel tableModel;

    public FormDataProduk() {
        setTitle("Form Input Data Produk");
        setSize(600, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        // Nama Produk
        JLabel labelNamaProduk = new JLabel("Nama Produk:");
        textNamaProduk = new JTextField();
        labelNamaProduk.setBounds(20, 20, 100, 25);
        textNamaProduk.setBounds(120, 20, 200, 25);
        add(labelNamaProduk);
        add(textNamaProduk);

        // Kategori Produk
        JLabel labelKategori = new JLabel("Kategori:");
        comboKategori = new JComboBox<>(new String[]{"Elektronik", "Pakaian", "Makanan", "Minuman"});
        labelKategori.setBounds(20, 60, 100, 25);
        comboKategori.setBounds(120, 60, 200, 25);
        add(labelKategori);
        add(comboKategori);

        // Stok
        JLabel labelStok = new JLabel("Jumlah Stok:");
        spinnerStok = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        labelStok.setBounds(20, 100, 100, 25);
        spinnerStok.setBounds(120, 100, 100, 25);
        add(labelStok);
        add(spinnerStok);

        // Tabel untuk menampilkan data produk
        String[] columnNames = {"Nama Produk", "Kategori", "Stok"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tableProduk = new JTable(tableModel);
        JScrollPane scrollTable = new JScrollPane(tableProduk);
        scrollTable.setBounds(20, 200, 540, 200);
        add(scrollTable);

        // Tombol Submit
        JButton btnSubmit = new JButton("Tambah Produk");
        btnSubmit.setBounds(120, 150, 150, 30);
        add(btnSubmit);

        // Event handling untuk tombol submit
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String namaProduk = textNamaProduk.getText();
                String kategori = (String) comboKategori.getSelectedItem();
                int stok = (int) spinnerStok.getValue();

                // Menambahkan data ke dalam JTable
                tableModel.addRow(new Object[]{namaProduk, kategori, stok});

                // Membersihkan form setelah submit
                textNamaProduk.setText("");
                comboKategori.setSelectedIndex(0);
                spinnerStok.setValue(1);
            }
        });
    }
}

