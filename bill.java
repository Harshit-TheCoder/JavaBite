import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

class bill{
    // JLabel l;
    // JLabel name,address,phone,numOfPeople,time;
    // JLabel namep,addressp,phonep,numOfPeoplep,timep;
    // JButton dishes;

    bill(){

    // this.setTitle("Customer's profile");
    // this.setSize(800,700);
    // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    // this.setLocationRelativeTo(null);

    String filePath = "OrderFood.txt";
    String line;

    StringBuilder receipt = new StringBuilder("Your Order:\n");
        // Initialize FileReader and BufferedReader
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                receipt.append(line).append("\n");
                System.out.println(line);
            }
        } catch (IOException e) {
            // e.printStackTrace();
            System.err.println(e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OrderFood.txt"))) {

            writer.write("\n");
            } catch (IOException ex) {
            System.err.println(ex);
        }

        JFrame receiptFrame = new JFrame("Receipt");
        receiptFrame.setSize(600, 600);
        JTextArea receiptArea = new JTextArea();
        receiptArea.setText(receipt.toString());
        receiptArea.setEditable(false);
        receiptFrame.add(new JScrollPane(receiptArea), BorderLayout.CENTER);
        receiptFrame.setLocationRelativeTo(null);
        receiptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        receiptFrame.setVisible(true);

        

    // name = new JLabel("NAME:");
    // name.setBounds(20,50,500,50);
    // namep = new JLabel(a.get(0));
    // namep.setBounds(20, 100, 500, 50);
    // address = new JLabel("ADDRESS:");
    // address.setBounds(20,150,500,50);
    // addressp = new JLabel(a.get(1));
    // addressp.setBounds(20, 200, 500, 50);
    // phone = new JLabel("PHONE NUMBER:");
    // phone.setBounds(20,250,500,50);
    // phonep = new JLabel(a.get(2));
    // phonep.setBounds(20, 300, 500, 50);
    // numOfPeople = new JLabel("NUMBER OF PEOPLE:");
    // numOfPeople.setBounds(20,350,500,50);
    // numOfPeoplep = new JLabel(a.get(3));
    // numOfPeoplep.setBounds(20, 400, 500, 50);
    // time = new JLabel("TIME FOR TABLE BOOKING:");
    // time.setBounds(20,450,300,50);
    // timep = new JLabel(a.get(4));
    // timep.setBounds(20, 500, 500, 50);

    // name.setForeground(Color.red);
    // name.setFont(new Font("Algerian",Font.PLAIN,15));
    // address.setForeground(Color.red);
    // address.setFont(new Font("Algerian",Font.PLAIN,15));
    // phone.setForeground(Color.red);
    // phone.setFont(new Font("Algerian",Font.PLAIN,15));
    // time.setForeground(Color.red);
    // time.setFont(new Font("Algerian",Font.PLAIN,15));
    // numOfPeople.setForeground(Color.red);
    // numOfPeople.setFont(new Font("Algerian",Font.PLAIN,15));


    // dishes = new JButton("MENU");
    // dishes.setBounds(20, 580 , 150 , 75);
    // dishes.addActionListener(this);

    // l = new JLabel();
    // l.setSize(800,700);
    // l.setBackground(Color.PINK);
    // l.setOpaque(true);
   
    // l.add(name);
    // l.add(address);
    // l.add(numOfPeople);
    // l.add(phone);
    // l.add(time);
    // l.add(namep);
    // l.add(addressp);
    // l.add(numOfPeoplep);
    // l.add(phonep);
    // l.add(timep);

    
    // this.add(l);
   



    }
    public static void main(String[] args) {
        bill b = new bill();
    }
}
