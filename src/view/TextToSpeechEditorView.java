/*
 * 
 * This is the class that is responsible for the text to speech transormations and audio tuning.
 * This window opens when the user has opened a file and chooses to transform it into audio. 
 * 
 */

package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.text.Caret;

import commands.DocumentToSpeech;
import commands.PlayDocument_TuneAudio;
import commands.PlaySelectedDocument;
import model.TTSFacade;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class TextToSpeechEditorView {

	private JFrame frame;
	private static String s;
	public static JTextArea editorTextArea;
	public static JButton play_Button;
	public static JButton playSelected_Button;
	public static JSlider slider;
	public static JSlider slider_1;
	public static JSlider slider_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	
	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void textToSpeechEditorView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextToSpeechEditorView window = new TextToSpeechEditorView();
					window.initialize();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public TextToSpeechEditorView() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		slider = new JSlider();
		slider.setBounds(39, 6, 29, 119);
		slider.setMinimum(0);
		slider.setMaximum(10);
		slider.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(slider);
		
		JLabel lblNewLabel = new JLabel("Volume");
		lblNewLabel.setBounds(33, 132, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		slider_1 = new JSlider();
		slider_1.setValue(80);
		slider_1.setBounds(137, 6, 20, 119);
		slider_1.setMinimum(40);
		slider_1.setMaximum(160);
		slider_1.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(slider_1);
		
		JLabel lblNewLabel_1 = new JLabel("Pitch");
		lblNewLabel_1.setBounds(131, 132, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		slider_2 = new JSlider();
		slider_2.setBounds(228, 6, 36, 119);
		slider_2.setMinimum(1);
		slider_2.setMaximum(160);
		slider_2.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(slider_2);
		
		JLabel lblNewLabel_2 = new JLabel("Rate");
		lblNewLabel_2.setBounds(229, 132, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 160, 788, 406);
		frame.getContentPane().add(scrollPane);
		
		editorTextArea = new JTextArea();
		editorTextArea.setText(MainApp.textArea.getText());		
		scrollPane.setViewportView(editorTextArea);
		TextToSpeechEditorView.editorTextArea.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseReleased(MouseEvent e) {
						if (TextToSpeechEditorView.editorTextArea.getSelectedText() != null) {
							s = TextToSpeechEditorView.editorTextArea.getSelectedText();
						}
					}
				});
		
		playSelected_Button = new JButton("Play selected");
		playSelected_Button.setBounds(315, 47, 117, 29);
		playSelected_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PlaySelectedDocument psd = new PlaySelectedDocument();
				psd.actionPerformed(e);
			}
		});
		frame.getContentPane().add(playSelected_Button);
	
		
		play_Button = new JButton("Play");
		play_Button.setBounds(315, 6, 117, 29);
		play_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayDocument_TuneAudio pd = new PlayDocument_TuneAudio();
				pd.actionPerformed(e);
			}
		});
		frame.getContentPane().add(play_Button);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Start Recording");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(653, 6, 141, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("End Recording");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(653, 34, 141, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(315, 88, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
	}
	
	public static String getSelectedText() {
		return s;
	}
}