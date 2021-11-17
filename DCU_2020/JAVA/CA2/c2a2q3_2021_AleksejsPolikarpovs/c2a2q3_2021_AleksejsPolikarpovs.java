
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
	In this task I decided to implement GUI to this solution.
	At the moment I am taking Oracle Java Foundation certification course and GUI is a bit covered there.
	That's my first GUI so I guess it might look a bit messy ...
	In future i will be very glad if you give me some extra tasks that we need to implement in to solution.
*/


class Gui implements ActionListener{                                                                  // implement event handler

    JFrame frame;
    JButton button1;
    JButton button2;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;

    Gui() {

        label1 = new JLabel("EVENT CUSTOMER COUNTER V1.0");                                  	       // label in our graphical interface
        label1.setFont(new Font("Serif", Font.BOLD, 34));                                              // set font , font style and font size
        label1.setBounds(40, 10, 600, 60);                                           			   	   // location and size of label
        label1.setVisible(true);                                                                       // visibility set to true

        label2 = new JLabel("All Rights Reserved by Aleksejs Polikarpovs 2021");
        label2.setFont(new Font("Serif", Font.PLAIN, 14));
        label2.setBounds(20, 220, 300, 60);
        label2.setVisible(true);

        label3 = new JLabel();
        label3.setText(CustomerCounter.getCurrentCustomerAmount());                                    // prints amount of current customers in the venue
        label3.setFont(new Font("Serif", Font.BOLD, 110));
        label3.setBounds(340, 80, 300, 250);
        label3.setVisible(true);
        label3.setForeground(new Color(0, 205, 102));                                                  // font colour
        label3.setBorder(BorderFactory.createEtchedBorder());                                          // border around
        label3.setSize(new Dimension(300, 120));                                                       // size of border

        label4 = new JLabel("! ALARM !");
        label4.setFont(new Font("Serif", Font.BOLD, 34));
        label4.setBounds(100, 140, 500, 60);
        label4.setVisible(false);                                                                      // alarm is hidden till max capacity reached
        label4.setForeground(Color.red);

        label5 = new JLabel();
        label5.setText(CustomerCounter.messegeGui());                                                  // message about capacity situation
        label5.setFont(new Font("Serif", Font.BOLD, 18));
        label5.setBounds(20, 190, 660, 60);
        label5.setVisible(true);

        label6 = new JLabel("CUSTOMERS IN");
        label6.setFont(new Font("Serif", Font.BOLD, 12));
        label6.setBounds(440, 60, 120, 60);
        label6.setVisible(true);

        button1 = new JButton("Let IN Person");
        button1.setBounds(20, 80, 140, 60);
        button1.addActionListener(this);
        button1.setBackground(Color.gray);
        button1.setForeground(Color.blue);
        button1.setBorder(BorderFactory.createEtchedBorder());
        button1.setFocusable(false);                                                                   // removes border around active button text

        button2 = new JButton("Let OUT Person");
        button2.setBounds(180, 80, 140, 60);
        button2.addActionListener(this);
        button2.setBackground(Color.gray);
        button2.setForeground(Color.blue);
        button2.setBorder(BorderFactory.createEtchedBorder());
        button2.setFocusable(false);

        frame = new JFrame("Event Customer Counter");                                                  // create pop up window
        frame.setSize(new Dimension(700, 300));                                             		   // dimensions
        frame.getContentPane().setBackground(new Color(110, 123, 139));
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                          // operation on close
        frame.add(label1);                                                                             // adds labels  or buttons in to the frame
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(label6);
        frame.add(button1);
        frame.add(button2);
        frame.setVisible(true);                                                                        // frame visibility is set to true
    }

    public void actionPerformed(ActionEvent e){                                                        // method for actions performed in GUI
        if(e.getSource() == button1){                                                                  // action on button "Let in person" clicked
            CustomerCounter.customerEnters();                                                          // increase customer count
            label5.setText(CustomerCounter.messegeGui());                                              // updates message
            label3.setText(CustomerCounter.getCurrentCustomerAmount());                                // updates current amount of customers
            if(CustomerCounter.getCurrentCustomerAmount().equals(CustomerCounter.getMaxCapacity())){   // if max capacity reached
                label4.setVisible(true);                                                               // alarm label visibility set to true
            }
        }

        if(e.getSource() == button2){                                                                  // action on button "Let out person"
            CustomerCounter.customerLeaves();                                                          // decrease customer count
            label5.setText(CustomerCounter.messegeGui());                                              // updates message
            label3.setText(CustomerCounter.getCurrentCustomerAmount());                                // updates message
            label4.setVisible(false);                                                                  // current customer amount is lower than max capacity, so alarm label is hidden
        }
    }
}

public class c2a2q3_2021_AleksejsPolikarpovs {

    public static void main(String[] args){

        CustomerCounter.setMaxCapacity(5);                                                             // set max capacity. Every venue might have different capacity
        new Gui();                                                                                     // calls Gui

    }
}