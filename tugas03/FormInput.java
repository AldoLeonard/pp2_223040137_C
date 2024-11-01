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


public class FormInput extends JFrame {
    private JTextField textNama;
    private JTextArea textAlamat;
    private JRadioButton rbLaki, rbPerempuan;
    private JCheckBox cbMembaca, cbOlahraga, cbMusik;
    private JComboBox<String> comboPendidikan;
    private JList<String> listBahasa;
    private JSlider sliderUsia;
    private JSpinner spinnerPengalaman;
    private JTable table;
    private DefaultTableModel tableModel;

    public FormInput() {
        setTitle("Form Input Data Karyawan");
        setSize(600, 700);
        setLayout(null);
        setLocationRelativeTo(null);

        // Nama
        JLabel labelNama = new JLabel("Nama:");
        textNama = new JTextField();
        labelNama.setBounds(20, 20, 100, 25);
        textNama.setBounds(120, 20, 200, 25);
        add(labelNama);
        add(textNama);

        // Alamat
        JLabel labelAlamat = new JLabel("Alamat:");
        textAlamat = new JTextArea();
        JScrollPane scrollAlamat = new JScrollPane(textAlamat);
        labelAlamat.setBounds(20, 60, 100, 25);
        scrollAlamat.setBounds(120, 60, 200, 60);
        add(labelAlamat);
        add(scrollAlamat);

        // Jenis Kelamin
        JLabel labelGender = new JLabel("Jenis Kelamin:");
        rbLaki = new JRadioButton("Laki-laki");
        rbPerempuan = new JRadioButton("Perempuan");
        ButtonGroup bgGender = new ButtonGroup();
        bgGender.add(rbLaki);
        bgGender.add(rbPerempuan);
        labelGender.setBounds(20, 140, 100, 25);
        rbLaki.setBounds(120, 140, 100, 25);
        rbPerempuan.setBounds(220, 140, 100, 25);
        add(labelGender);
        add(rbLaki);
        add(rbPerempuan);

        // Hobi
        JLabel labelHobi = new JLabel("Hobi:");
        cbMembaca = new JCheckBox("Membaca");
        cbOlahraga = new JCheckBox("Olahraga");
        cbMusik = new JCheckBox("Musik");
        labelHobi.setBounds(20, 180, 100, 25);
        cbMembaca.setBounds(120, 180, 100, 25);
        cbOlahraga.setBounds(220, 180, 100, 25);
        cbMusik.setBounds(320, 180, 100, 25);
        add(labelHobi);
        add(cbMembaca);
        add(cbOlahraga);
        add(cbMusik);

        // Pendidikan Terakhir
        JLabel labelPendidikan = new JLabel("Pendidikan Terakhir:");
        comboPendidikan = new JComboBox<>(new String[] {"SMA", "D3", "S1", "S2"});
        labelPendidikan.setBounds(20, 220, 150, 25);
        comboPendidikan.setBounds(170, 220, 150, 25);
        add(labelPendidikan);
        add(comboPendidikan);

        // Bahasa yang Dikuasai
        JLabel labelBahasa = new JLabel("Bahasa:");
        listBahasa = new JList<>(new String[] {"Inggris", "Mandarin", "Jepang", "Indonesia"});
        JScrollPane scrollBahasa = new JScrollPane(listBahasa);
        labelBahasa.setBounds(20, 260, 100, 25);
        scrollBahasa.setBounds(120, 260, 100, 60);
        add(labelBahasa);
        add(scrollBahasa);

        // Usia (JSlider)
        JLabel labelUsia = new JLabel("Usia:");
        sliderUsia = new JSlider(18, 60, 25);
        sliderUsia.setMajorTickSpacing(10);
        sliderUsia.setMinorTickSpacing(1);
        sliderUsia.setPaintTicks(true);
        sliderUsia.setPaintLabels(true);
        labelUsia.setBounds(20, 340, 100, 25);
        sliderUsia.setBounds(120, 340, 300, 50);
        add(labelUsia);
        add(sliderUsia);

        // Pengalaman Kerja (JSpinner)
        JLabel labelPengalaman = new JLabel("Pengalaman (tahun):");
        spinnerPengalaman = new JSpinner(new SpinnerNumberModel(0, 0, 40, 1));
        labelPengalaman.setBounds(20, 400, 150, 25);
        spinnerPengalaman.setBounds(170, 400, 50, 25);
        add(labelPengalaman);
        add(spinnerPengalaman);

        // Tabel untuk menampilkan data input
        String[] columnNames = {"Nama", "Alamat", "Jenis Kelamin", "Hobi", "Pendidikan", "Bahasa", "Usia", "Pengalaman"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollTable = new JScrollPane(table);
        scrollTable.setBounds(20, 500, 540, 150);
        add(scrollTable);

        // Tombol Submit
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(120, 450, 100, 30);
        add(btnSubmit);

        // Event handling untuk tombol submit
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = textNama.getText();
                String alamat = textAlamat.getText();
                String gender = rbLaki.isSelected() ? "Laki-laki" : rbPerempuan.isSelected() ? "Perempuan" : "";
                
                String hobi = "";
                if (cbMembaca.isSelected()) hobi += "Membaca ";
                if (cbOlahraga.isSelected()) hobi += "Olahraga ";
                if (cbMusik.isSelected()) hobi += "Musik ";
                
                String pendidikan = (String) comboPendidikan.getSelectedItem();
                
                String bahasa = String.join(", ", listBahasa.getSelectedValuesList());
                
                int usia = sliderUsia.getValue();
                int pengalaman = (int) spinnerPengalaman.getValue();

                // Menambahkan data ke dalam JTable
                tableModel.addRow(new Object[]{nama, alamat, gender, hobi, pendidikan, bahasa, usia, pengalaman});

                // Membersihkan form setelah submit
                textNama.setText("");
                textAlamat.setText("");
                bgGender.clearSelection();
                cbMembaca.setSelected(false);
                cbOlahraga.setSelected(false);
                cbMusik.setSelected(false);
                comboPendidikan.setSelectedIndex(0);
                listBahasa.clearSelection();
                sliderUsia.setValue(25);
                spinnerPengalaman.setValue(0);
            }
        });
    }
}
