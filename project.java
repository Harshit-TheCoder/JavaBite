
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class project extends JFrame implements ActionListener{
     
     
     JLabel  intro1 , intro2 , intro3;
     JButton manager,customer;
    project(){
       //  p = new project1();
        this.setTitle("Restuarent Management System");
        this.setSize(500,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
      // this.setLayout(new FlowLayout());
        
         JLabel label = new JLabel();
         label.setSize(500,700);
         label.setOpaque(true);
   
         intro1 = new JLabel("JavaBite");
         intro2 = new JLabel("Come and enjoy with us a delightful ");
         intro3 = new JLabel("symphony of flavors in every bite");
         intro1.setBounds(115,50,300,100);
         intro1.setFont(new Font("Serif" , Font.BOLD , 35));
         intro1.setForeground(Color.red);
         intro2.setBounds(60,150,450,50);
         intro2.setFont(new Font("Sans-serif" , Font.BOLD , 20));
         intro2.setForeground(Color.red);
         intro3.setBounds(60,200,450,50);
         intro3.setFont(new Font("Sans-serif" , Font.BOLD , 20));
         intro3.setForeground(Color.red);
         
         this.add(label);
        

         // manager = new JButton("MANAGER");
         customer = new JButton("ORDER");
         //manager.setBounds(100,300,300,50);
         customer.setBounds(100,400,300,50);
         //manager.setFocusable(false);
         customer.setFocusable(false);
         //manager.addActionListener(this);
         customer.addActionListener(this);
         //label.add(manager);
         label.add(customer);
         label.add(intro1);
         label.add(intro2);
         label.add(intro3);
        this.setVisible(true);
     }
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==manager){
          this.dispose();
          new manage();
      }
      if(e.getSource()==customer){
         this.dispose();
         profile prof = new profile();
      }
     
   }

    
}