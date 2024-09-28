import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

class profile extends JFrame implements ActionListener{
    String itemsPath = "OrderFood.txt";
    JLabel l;
    JLabel name,address,phone,numOfPeople,time;
    JTextField namet,addresst,phonet,numOfPeoplet,timet;
    JButton burger , drinks, pizzazzzz, addDetails;
    // JComboBox<String> dishes;
    profile(){
        
    this.setTitle("Customer's profile");
    this.setSize(800,700);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    this.setLocationRelativeTo(null);

    name = new JLabel("ENTER YOUR NAME");
    name.setBounds(20,50,500,50);
    namet = new JTextField();
    namet.setBounds(20,100,300,50);
    namet.setForeground(new Color(128, 0, 128));
    namet.setFont(new Font("Arial", Font.BOLD, 16));
    // namet.addActionListener(this);

    address = new JLabel("ENTER YOUR ADDRESS");
    address.setBounds(20,150,500,50);
    addresst = new JTextField();
    addresst.setBounds(20,200,300,50);
    addresst.setForeground(new Color(128, 0, 128));
    addresst.setFont(new Font("Arial", Font.BOLD, 16));
    // addresst.addActionListener(this);

    phone = new JLabel("ENTER YOUR PHONE NUMBER");
    phone.setBounds(20,250,500,50);
    phonet = new JTextField();
    phonet.setBounds(20,300,300,50);
    phonet.setForeground(new Color(128, 0, 128));
    phonet.setFont(new Font("Arial", Font.BOLD, 16));
    // phonet.addActionListener(this);

    numOfPeople = new JLabel("ENTER NUMBER OF PEOPLE");
    numOfPeople.setBounds(20,350,500,50);
    numOfPeoplet = new JTextField();
    numOfPeoplet.setBounds(20,400,300,50);
    numOfPeoplet.setForeground(new Color(128, 0, 128));
    numOfPeoplet.setFont(new Font("Arial", Font.BOLD, 16));
    // numOfPeoplet.addActionListener(this);

    time = new JLabel("ENTER THE TIME FOR TABLE BOOKING");
    time.setBounds(20,450,300,50);
    timet = new JTextField();
    timet.setBounds(20,500,300,50);
    timet.setForeground(new Color(128, 0, 128));
    timet.setFont(new Font("Arial", Font.BOLD, 16));
    // timet.addActionListener(this);

    name.setForeground(Color.red);
    name.setFont(new Font("Algerian",Font.PLAIN,15));
    address.setForeground(Color.red);
    address.setFont(new Font("Algerian",Font.PLAIN,15));
    phone.setForeground(Color.red);
    phone.setFont(new Font("Algerian",Font.PLAIN,15));
    time.setForeground(Color.red);
    time.setFont(new Font("Algerian",Font.PLAIN,15));
    numOfPeople.setForeground(Color.red);
    numOfPeople.setFont(new Font("Algerian",Font.PLAIN,15));

    burger = new JButton("Burger");
    pizzazzzz = new JButton("Pizza");
    drinks = new JButton("Drinks");
    addDetails = new JButton("Add Details");

    burger.setBounds(20, 580 , 100 , 75);
    pizzazzzz.setBounds(140, 580 , 100 , 75);
    drinks.setBounds(260, 580 , 100 , 75);
    addDetails.setBounds(380, 580, 100, 75);

    burger.addActionListener(this);
    pizzazzzz.addActionListener(this);
    drinks.addActionListener(this);
    addDetails.addActionListener(this);

    l = new JLabel();
    l.setSize(800,700);
    
   
    l.add(name);
    l.add(address);
    l.add(numOfPeople);
    l.add(phone);
    l.add(time);

    l.add(namet);
    l.add(addresst);
    l.add(numOfPeoplet);
    l.add(phonet);
    l.add(timet);
    l.add(burger);
    l.add(pizzazzzz);
    l.add(drinks);
    l.add(addDetails);
       
    this.add(l);
   
   

    this.setVisible(true);
    


}
public void actionPerformed(ActionEvent e) {

    if(e.getSource() == addDetails){
        String details="";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(itemsPath, true))) {
            writer.write("Name:"+namet.getText());
            writer.newLine();
            writer.write("Phone:"+phonet.getText());
            writer.newLine();
            writer.write("Address:"+addresst.getText());
            writer.newLine();
            writer.write("Number of People:"+numOfPeoplet.getText());
            writer.newLine();
            writer.write("Time:"+timet.getText());
            writer.newLine();
            details = "Name:"+namet.getText() + "\n"+ "Phone:"+phonet.getText()+ "\n" + "Address:"+addresst.getText()+ "\n" + "Number of People:"+numOfPeoplet.getText()+ "\n" + "Time:"+timet.getText();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        JOptionPane.showMessageDialog(this, "Details Added:\n" + details, "Details", JOptionPane.INFORMATION_MESSAGE);
    }
    
    

    if(e.getSource()==burger){
        this.dispose();
        try {
            Burger12 b = new Burger12();
        } catch (FontFormatException ex) {
        }
    }
    if(e.getSource()==pizzazzzz){
        this.dispose();
        try {
            Pizzas12 p = new Pizzas12();
        } catch (IOException ex) {
        }
    }
    if(e.getSource()==drinks){
        try {
            this.dispose();
            Drinks12 d = new Drinks12();
        } catch (IOException ex) {
        }
    }
    
   
 }
  
 public static void main(String[] args) {
    profile pro = new profile();
 }
 
}