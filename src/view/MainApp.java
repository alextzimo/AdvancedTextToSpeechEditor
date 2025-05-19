/*
 * 
 * This is the main class that runs the application (main method).
 * If the user wants to open a file with Atbash or Rot13 encoding, he/she has to check the 
 * appropriate button on the up right side of the window. The same thing for the file saving (if
 * the user wants to save the file with encoding).
 * 
 */

package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

import commands.DocumentToSpeech;
import commands.EditDocument;
import commands.OpenDocument;
import commands.SaveDocument;

public class MainApp {

	private JFrame frame;
	public static JTextArea textArea;
	public static JScrollPane scrollPane;
	public static JTable table;
	public static JButton openButton;
	public static JButton editButton;
	public static JButton saveButton;
	public static JButton playButton;
	public static JButton replayButton;
	public static JRadioButton atbashButton;
	public static JRadioButton rot13Button;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		openButton = new JButton("Open");
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenDocument op = new OpenDocument();
				op.actionPerformed(e);
			}
		});
		openButton.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(openButton);
		
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditDocument ed = new EditDocument();
				ed.actionPerformed(e);
			}
		});
		editButton.setBounds(126, 6, 117, 29);
		frame.getContentPane().add(editButton);
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveDocument sa = new SaveDocument();
				sa.actionPerformed(e);
			}
		});
		saveButton.setBounds(246, 6, 117, 29);
		frame.getContentPane().add(saveButton);
		
		playButton = new JButton("DocToSpeech");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocumentToSpeech dts = new DocumentToSpeech();
				dts.actionPerformed(e);
			}
		});
		playButton.setBounds(366, 6, 117, 29);
		frame.getContentPane().add(playButton);
		
		replayButton = new JButton("Replay");
		replayButton.setBounds(486, 6, 117, 29);
		frame.getContentPane().add(replayButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 47, 1012, 687);
		frame.getContentPane().add(scrollPane);
		
		atbashButton = new JRadioButton("Atbash");
		atbashButton.setBounds(938, 0, 80, 23);
		frame.getContentPane().add(atbashButton);
		
		rot13Button = new JRadioButton("Rot13");
		rot13Button.setBounds(938, 26, 80, 23);
		frame.getContentPane().add(rot13Button);
	}
}