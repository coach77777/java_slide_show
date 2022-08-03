import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();		
		textPane.setBackground(Color.BLUE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		
		//**************************************************
		//CHANGED TO UPDATE--detox//wellness
		//**************************************************
		setTitle("Top 5 DETOX/WELNESS Destinations in the USA SlideShow");
		
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	
	/*****************************************************************************************
	 * TO MEET THE LATEST REQUESTS OF PRODUCT OWNER.
	 * PRESENTED ARE THE TOP 5 DESTINATIONS PHOTOS
	 * IN THE UNITED STATES
	 * https://www.zochagroup.com/the-10-best-detox-wellness-spa-retreats-in-america/
	 /*****************************************************************************************/

	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Amangiri.jpg") + "'</body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/miiamosedona.jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/we-care-detox-spa.jpg") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Red-Mountain-Spa.jpg") + "'</body></html>";
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/The-Ranch.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	/*****************************************************************************************
	 * TO MEET THE LATEST REQUESTS OF PRODUCT OWNER.
	 * PRESENTED ARE THE TOP 5 DESTINATIONS DESCRIPTION
	 * IN THE UNITED STATES
	 * https://www.zochagroup.com/the-10-best-detox-wellness-spa-retreats-in-america/
	 * 
	 * (not a change from P.O.)
	 * CHANGED FONT COLOR SO WE COULD READ DESCRIPTIONS
	 /*****************************************************************************************/
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body><font color='white' size='5'>#1 Amangiri – Canyon Point, Utah</font> <br><<font color='white' size='2'>The Amangiri Resort is a detox retreat oasis surrounded by Utah’s beautiful red rock terrain. Its luxurious treatments utilize the landscape and culture with traditional Navajo healing techniques and Sedona clay to revitalize your body.</font></body></html>";
		} else if (i==2){
			text = "<html><body><font color='white' size='5'>#2 Mii Amo Spa</font> <br><<font color='white' size='2'>Simplicity is key at the Mii Amo Spa located in the spiritual city of Sedona. A clay wrap will draw out all your toxins while psychic massages and even hypnosis tap into the subconscious of open-minded guests.</font></body></html>";
		} else if (i==3){
			text = "<html><body><font color='white' size='5'>#3 We Care Spa – Desert Hot Springs, California</font> <br><<font color='white' size='2'>Spend as many as eight days at this desert oasis detox vacation where lymphatic massages, an infrared sauna and specialized beverages are made to help you sustain your serenity. Mud wraps complement your liquid diet along with yoga, dance classes and meditation to round out your stay.</font></body></html>";
		} else if (i==4){
			text = "<html><body><font color='white' size='5'>#4 Red Mountain Resort – Ivans, Utah</font> <br><<font color='white' size='2'>A more adventurous detox vacation at Red Mountain might be for you if activities like hiking and kayaking sound like a peaceful escape. Their trained outdoor guides will deliver their expertise in nature while the resort itself is a picture of Southwestern beauty.</font></body></html>";
		} else if (i==5){
			text = "<html><body><font color='white' size='5'>#5 The Ranch – Malibu, California</font> <br><<font color='white' size='2'>Well-known for its celebrity clientele, The Ranch is the perfect place to detox and clear your mind of bad habits during an up to ten-day stay. Fitness classes and hikes keep you active while a specialized meal plan and medical testing ensure that the rejuvenation process is unfolding.</font></body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}