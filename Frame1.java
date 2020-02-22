

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; //for making UI by frames,Buttons etc.

class Main_Frame extends JFrame {
	JLabel label1,background;
	JTextField no_of_rows_input,no_of_cols_input,rows_tf,cols_tf;
	JButton genrate_ground,manual;
	JPanel p1;      //p1 is a panel on which all labels,buttons and textFields will be mounted 
	
	
	/*following function is the constructor of class.It set title to the frame and set size of the frame*/
	
	public Main_Frame() {
		setTitle("MAZE CREATOR");
		setSize(500,450);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/*fuction given below is for Creating objects of components,setting their sizes and mounting them on the frame */
	
	void setComponent(){
		
		/*Objects of all the classes are created according to the requirement
		  for example we want panel so we created JPanel object by "new JPanel()" */
		
		
		p1=new JPanel();
		rows_tf=new JTextField("Enter No. of rows:");  //This is just used as a label but I used non editable textfield for it
		rows_tf.setEditable(false);    
		no_of_rows_input=new JTextField();
		cols_tf=new JTextField("Enter No. of columns:");   //This is just used as a label but I used non editable textfield for it
		cols_tf.setEditable(false);
		no_of_cols_input=new JTextField();
		label1=new JLabel("Click Button to make grid");
		manual=new JButton("MANUAL");  
		genrate_ground=new JButton("MAKE");
		ImageIcon img=new ImageIcon("C:\\Users\\sanpa\\eclipse-workspace\\Maze\\src\\image5.jpg");
   	    background=new JLabel("",img,JLabel.CENTER);
        p1.setLayout(null);         //Layout is flow layout by default so it is set to null 
        
        /*Setting bounds for the created objects as per our requirement generally we are
          giving dimensions of length,width and coordinates of position */
        
        background.setBounds(0,0,490,440);
        p1.setBounds(0, 0, 500, 315);
		rows_tf.setBounds(90,40,150,20);
		no_of_rows_input.setBounds(280,40,50,20);
		cols_tf.setBounds(90,120,150,20);
		no_of_cols_input.setBounds(280,120,50,20);
		label1.setBounds(125,160,170,15);
		genrate_ground.setBounds(160,180,80,30);
		manual.setBounds(150, 250, 100, 30);
		
		/* finally adding all the components to the panel p1 */
		
		p1.add(rows_tf);
		p1.add(cols_tf);
		p1.add(no_of_rows_input);
		p1.add(no_of_cols_input);
		p1.add(label1);
		p1.add(genrate_ground);
		p1.add(manual);
		p1.add(background);
		/*providing some action after click of button*/
		
		genrate_ground.addActionListener(new Action());
		manual.addActionListener(new Action());
		
		/* now adding panel p1 to the Frame*/
		add(p1);
		
	}
	
	
   /* Main function where the frame is created */
	
   public static void main(String[] args) {
	  Main_Frame jf=new Main_Frame();
	  jf.setComponent();
   }
   
   /*Following class is implemention ActionListener interface*/
   class Action implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int no_of_rows,no_of_cols;
		
		//If user clicks on Make button following action takes place
		
		if(e.getSource()==genrate_ground) {
		       no_of_rows=Integer.parseInt(no_of_rows_input.getText());
		       no_of_cols=Integer.parseInt(no_of_cols_input.getText());
		       if(no_of_rows<=15 && no_of_cols<=25) {
		           Activity_Frame ob=new Activity_Frame(no_of_rows,no_of_cols);
		           ob.setComponents();
		       }
		       else {
			       JOptionPane.showMessageDialog(new JFrame(),"Rows greater than 15 OR\n columns greater than 25 are not allowed ","Dialog",JOptionPane.ERROR_MESSAGE);
		       }
	   }
		
		//If user clicks on Manual button following action takes place

		if(e.getSource()==manual) {
			new Manual();
		}
	   
    }
   }
}

class Manual extends JFrame{
	JTextArea a;
	public Manual() {
		setVisible(true);
		setSize(300,400);
		setResizable(false);
		setTitle("MANUAL");
		setComponents();
	}
	public void setComponents() {
		  a=new JTextArea();
		  a.setBounds(5, 5, 195, 395);
		  //setting manual information which will be displayed to user
		  a.setText("\n  No. of Rows should less Than 16\n  No. of columns should less than 26\n\n  BUTTONS :\n\n  ENTRY  :- add entry gate\n\n  Exit :-Add Exit Gate\n\n  WALL :- Add Walls\n\n  RE.PATH  :- Remove Existing Path\n\n  REMOVE  :-Removing Unwanted Walls Doors\n\n  SOLVE  :-Make Path from Entry To Exit\n\n  RANDOM  :-Add Walls Randomly");
		  add(a);
		  a.setEditable(false);
	}
}