/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materi4;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class KeyListenerExample {
	public static void main(String[] args) {
		JFrame frame = new JFrame("KeyListenerExample");
		
		//Membuat label untuk menampilkan pesan
		JLabel label = new JLabel("Tekan tombol pada keyboard.");
		label.setBounds(50, 50, 300, 30);
		
		//Membuat text field untuk fokus keybiard
		JTextField textField = new JTextField();
		textField.setBounds(50, 100, 200, 30);
		
		//Menambahkan KeyListener ke text field
		textField.addKeyListener(new KeyListener() {
			//Dijalankan ketika tombol ditekan 
			public void keyPressed(KeyEvent e) {
				label.setText("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
			}
			//Dijalankan ketika tombol dilepaskan
			public void keyReleased(KeyEvent e) {
				label.setText("Key Released " + KeyEvent.getKeyText(e.getKeyCode()));
			}
			//Dijalankan ketika tombol ditekan dan dilepaskan (sama dengan mengetik karakter
			public void keyTyped(KeyEvent e) {
				label.setText("Key Typed: " + e.getKeyChar());
			}
		});
		
		//Menambahkan komponen ke frame
		frame.add(label);
		frame.add(textField);
		
		//Setting frame
		frame.setSize(400, 200);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
