/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas03;

import javax.swing.*;

/**
 *
 * @author user
 */


public class MainApp extends JFrame {
    public MainApp() {
        setTitle("Aplikasi Data Karyawan dan Produk");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Setup JMenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        
        // Menu item untuk membuka Form Data Karyawan
        JMenuItem menuItemFormKaryawan = new JMenuItem("Form Data Karyawan");
        menuFile.add(menuItemFormKaryawan);
        
        // Menu item untuk membuka Form Data Produk
        JMenuItem menuItemFormProduk = new JMenuItem("Form Data Produk");
        menuFile.add(menuItemFormProduk);

        menuBar.add(menuFile);
        setJMenuBar(menuBar);

        // Event untuk membuka form input karyawan
        menuItemFormKaryawan.addActionListener(e -> new FormInput().setVisible(true));

        // Event untuk membuka form input produk
        menuItemFormProduk.addActionListener(e -> new FormDataProduk().setVisible(true));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainApp().setVisible(true);
        });
    }
}
