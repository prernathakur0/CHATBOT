import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Chatbot extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextArea ca = new JTextArea(); // Chat area
	private JTextField cf = new JTextField(); // Chat field
	private JButton b = new JButton(); // Send button
	private JLabel l = new JLabel(); // Button label
	
	Chatbot() {
		// Frame properties
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		f.setLayout(null);
		f.setSize(400,400);
		f.getContentPane().setBackground(Color.cyan);
		f.setTitle("ChatBot");

		// Add components to frame
		f.add(ca);
		f.add(cf);
		f.add(b);

		// Chat area properties
		ca.setSize(300, 310);
		ca.setLocation(1, 1);
		ca.setBackground(Color.BLACK);
		ca.setForeground(Color.GREEN);
		ca.setEditable(false);

		// Chat field properties
		cf.setSize(300, 20);
		cf.setLocation(1, 320);

		// Send button properties
		l.setText("SEND");
		b.add(l);
		b.setSize(80, 20);
		b.setLocation(300, 320);

		// Add action listener to the button
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == b) { // Message sent on button click
					String text = cf.getText().toLowerCase();
					ca.append("You --> " + text + "\n");
					cf.setText("");
					
					// Check for specific inputs and respond
					if (text.contains("hi")) {
						replyMeth("Hi there");
					} else if (text.contains("how are you")) {
						replyMeth("I'm Good :). Thank you for asking");
					} else if (text.contains("what is your name")) {
						replyMeth("I'm the Trending CHATBOT");
					} else if (text.contains("You are from which country")) {
						replyMeth("INDIA");
					} else if (text.contains("any suggestions")) {
						replyMeth("NO got to chatgpt");
					} else if (text.contains("bye")) {
						replyMeth("Too Soon :( Anyways\nSTAY HOME STAY SAFE");
					} else {
						replyMeth("I Can't Understand");
					}
				}
			}
		});
	}
	
	// Reply method
	public void replyMeth(String s) {
		ca.append("ChatBot --> " + s + "\n");
	}
}

public class ChatBotDemo {
	public static void main(String[] args) {
		new Chatbot(); // Instantiate chatbot
	}
}
