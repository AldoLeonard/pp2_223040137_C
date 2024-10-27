/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materi4;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author user
 */
public class WindowListenerExample {
    public static void main(String[] args) {
        //Membuat Frame
        JFrame frame = new JFrame("WindowListener Example");
        
        //Membuat label untuk menampilkan pesan
        JLabel label = new JLabel("Lakukan operasi pada jendela.");
        label.setBounds(50, 50, 300, 30);
        
        //Menambahkan WindowListener ke frame
        frame.addWindowListener(new WindowListener() {
            //Dijalankan ketika jendela dibuka
            public void windowOpened(WindowEvent e) {
                label.setText("Window Opened.");
            }
            //Dijalankan ketika jendela sedang dalam proses penutupan
            public void windowClosing(WindowEvent e) {
                label.setText("Window Closing.");
                //Bisa menambhakn System.exit(0) jika  ingin menghentikan program
            }
            //Dijalankan ketika jendela benar benar ditutup
            public void windowClosed(WindowEvent e) {
                System.out.println("Window Closed.");                      
            }
            //Dijalankan ketika jendela diminimalkan
            public void windowIconified(WindowEvent e) {
                label.setText("Window Minimized");
            }
            //Dijalankan ketika jendela dipulihkan dari minimalkan
            public void windowDeiconified(WindowEvent e) {
                label.setText("Window Restored");
            }
            //Dijalankan ketika jendela menjadi aktif(berfokus)
            public void windowActivated(WindowEvent e) {
                label.setText("Window Activated");
            }
            //Dijalankan ketika jendela kehilangna fokus
            public void windowDeactivated(WindowEvent e) {
                label.setText("Window Deactivated.");
            }
    });
        
        //Menambahkan label ke frame
        frame.add(label);
        
        //setting frame
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //agar jendela benar benar tertutup
}
}