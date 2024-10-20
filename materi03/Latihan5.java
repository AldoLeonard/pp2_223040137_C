/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materi3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author user
 */

public class Latihan5 extends JFrame {
    public Latihan5() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Form Biodata");
        this.setSize(100, 400); // Sesuaikan ukuran form
        this.setLayout(new BorderLayout());

        // Panel utama dengan GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(240, 240, 240)); // Warna latar belakang sesuai gambar
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label untuk judul form
        JLabel formTitle = new JLabel("Form Biodata", SwingConstants.CENTER);
        formTitle.setFont(new Font("Arial", Font.BOLD, 14)); // Ukuran font lebih kecil
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(formTitle, gbc);

        // Label dan TextField untuk Nama
        JLabel labelNama = new JLabel("Nama:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(labelNama, gbc);

        JTextField textNama = new JTextField(3); // Sesuaikan ukuran TextField
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(textNama, gbc);

        // Label dan TextField untuk Nomor HP
        JLabel labelNomorHP = new JLabel("Nomor HP:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(labelNomorHP, gbc);

        JTextField textNomorHP = new JTextField(3);
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(textNomorHP, gbc);

        // Label dan RadioButtons untuk Jenis Kelamin
        JLabel labelJenisKelamin = new JLabel("Jenis Kelamin:");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(labelJenisKelamin, gbc);

        JRadioButton radioLaki = new JRadioButton("Laki-Laki");
        JRadioButton radioPerempuan = new JRadioButton("Perempuan");
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioLaki);
        bg.add(radioPerempuan);

        JPanel genderPanel = new JPanel(new GridLayout(2, 1));
        genderPanel.setBackground(new Color(240, 240, 240)); // Warna latar belakang sesuai
        genderPanel.add(radioLaki);
        genderPanel.add(radioPerempuan);
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(genderPanel, gbc);

        // Checkbox untuk WNA
        JCheckBox checkWNA = new JCheckBox("Warga Negara Asing");
        checkWNA.setBackground(new Color(240, 240, 240));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(checkWNA, gbc);

        // Tombol untuk Simpan
        JButton buttonSimpan = new JButton("Simpan");
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(buttonSimpan, gbc);

        // Panel output di bagian bawah
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBackground(Color.WHITE); // Warna latar belakang putih
        JTextArea txtOutput = new JTextArea(5, 20);
        txtOutput.setEditable(false);
        txtOutput.setMargin(new Insets(10, 10, 10, 10)); // Padding dalam JTextArea
        JScrollPane scrollOutput = new JScrollPane(txtOutput);
        outputPanel.add(scrollOutput, BorderLayout.CENTER);

        // Menambahkan panel ke frame
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(outputPanel, BorderLayout.SOUTH);

        // Action Listener untuk tombol
        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textNama.getText();
                String nomorHP = textNomorHP.getText();
                String jenisKelamin = radioLaki.isSelected() ? "Laki-Laki" : "Perempuan";
                String wnaStatus = checkWNA.isSelected() ? "Ya" : "Tidak";

                txtOutput.setText("Nama           : " + nama + "\n" +
                                  "Nomor HP       : " + nomorHP + "\n" +
                                  "Jenis Kelamin  : " + jenisKelamin + "\n" +
                                  "WNA            : " + wnaStatus);

                // Kosongkan field input
                textNama.setText("");
                textNomorHP.setText("");
                bg.clearSelection();
                radioLaki.setSelected(true); // Set default kembali ke Laki-Laki
                checkWNA.setSelected(false);
            }
        });

        this.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Latihan5 app = new Latihan5();
                app.setVisible(true);
            }
        });
    }
}
