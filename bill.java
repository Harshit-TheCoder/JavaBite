// import java.awt.BorderLayout;
// import java.awt.Color;
// import java.awt.Font;
// import java.awt.FontFormatException;
// import java.awt.GraphicsEnvironment;
// import java.awt.Insets;
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import javax.swing.*;

// class bill {
//     Font notoFont;
//     Font pizzaFont;
//     Font burgerFont;
//     Font juiceFont;
//     String p, b, j;

//     bill() throws IOException {
//         String globalfont = "Fonts\\NotoSansDevanagari-VariableFont_wdth,wght.ttf";
//         String filePath = "OrderFood.txt";
//         String pizzaPath = "OrderPizza.txt";
//         String burgerPath = "OrderBurger.txt";
//         String juicePath = "OrderJuice.txt";

//         StringBuilder receipt = new StringBuilder("\t\tJavaBite Bill\nYour Order:\n");
//         StringBuilder preceipt = new StringBuilder("");
//         StringBuilder breceipt = new StringBuilder("");
//         StringBuilder jreceipt = new StringBuilder("");

//         readFile(filePath, receipt);
//         readFile(pizzaPath, preceipt);
//         readFile(burgerPath, breceipt);
//         readFile(juicePath, jreceipt);

//         clearFile(filePath);
//         clearFile(pizzaPath);
//         clearFile(burgerPath);
//         clearFile(juicePath);

//         // Set font paths before loading

//         notoFont = loadFont(globalfont);
//         pizzaFont = loadFont(p);
//         burgerFont = loadFont(b);
//         juiceFont = loadFont(j);

//         JFrame receiptFrame = new JFrame("Receipt");
//         receiptFrame.setSize(700, 800);
//         receiptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         receiptFrame.setLocationRelativeTo(null);

//         JPanel panel = new JPanel();
//         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

//         JTextArea receiptArea = createTextArea(receipt.toString(), notoFont);
//         JTextArea pReceiptArea = createTextArea(preceipt.toString(), pizzaFont);
//         JTextArea bReceiptArea = createTextArea(breceipt.toString(), burgerFont);
//         JTextArea jReceiptArea = createTextArea(jreceipt.toString(), juiceFont);

//         panel.add(new JScrollPane(receiptArea));
//         panel.add(new JScrollPane(pReceiptArea));
//         panel.add(new JScrollPane(bReceiptArea));
//         panel.add(new JScrollPane(jReceiptArea));

//         receiptFrame.add(panel, BorderLayout.CENTER);
//         receiptFrame.setVisible(true);
//     }

//     void readFile(String filePath, StringBuilder receipt) {
//         try (FileReader fileReader = new FileReader(filePath);
//              BufferedReader bufferedReader = new BufferedReader(fileReader)) {
//             String line;
//             while ((line = bufferedReader.readLine()) != null) {
//                 receipt.append(line).append("\n");
//                 System.out.println(line);
//             }
//         } catch (IOException e) {
//             System.err.println(e);
//         }
//     }

//     void clearFile(String filePath) {
//         try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//             writer.write("\n");
//         } catch (IOException ex) {
//             System.err.println(ex);
//         }
//     }

//     Font loadFont(String fontPath) {
//         try {
//             Font font = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(16f);
//             GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//             ge.registerFont(font);
//             return font;
//         } catch (FontFormatException | IOException e) {
//             return new Font("Sanserif", Font.PLAIN, 15);
//         }
//     }

//     JTextArea createTextArea(String text, Font font) {
//         JTextArea textArea = new JTextArea();
//         textArea.setText(text);
//         textArea.setFont(font);
//         textArea.setForeground(new Color(128, 0, 128));
//         textArea.setMargin(new Insets(10, 10, 10, 10));
//         textArea.setEditable(false);
//         return textArea;
//     }

//     void setPizzaFont(String font) {
//         p = font;
//     }

//     void setBurgerFont(String font) {
//         b = font;
//     }

//     void setJuiceFont(String font) {
//         j = font;
//     }

//     public static void main(String[] args) throws IOException {
//         bill b = new bill();
//     }
// }

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

class bill {
    Font notoFont;
    Font pizzaFont;
    Font burgerFont;
    Font juiceFont;

    bill() throws IOException {
        String globalfont = "Fonts\\NotoSansDevanagari-VariableFont_wdth,wght.ttf";
        String filePath = "OrderFood.txt";
        String pizzaPath = "OrderPizza.txt";
        String burgerPath = "OrderBurger.txt";
        String juicePath = "OrderJuice.txt";

        StringBuilder receipt = new StringBuilder("\t\tJavaBite Bill\nYour Order:\n");
        StringBuilder preceipt = new StringBuilder("\t\tPizzas Ordered\n");
        StringBuilder breceipt = new StringBuilder("\t\tBurgers Ordered\n");
        StringBuilder jreceipt = new StringBuilder("\t\tJuices Ordered\n");

        notoFont = loadFont(globalfont);

        // Read font paths and order details
        pizzaFont = readAndLoadFont(pizzaPath, preceipt);
        burgerFont = readAndLoadFont(burgerPath, breceipt);
        juiceFont = readAndLoadFont(juicePath, jreceipt);

        // Reading the general order file
        readFile(filePath, receipt);

        clearFile(filePath);
        clearFile(pizzaPath);
        clearFile(burgerPath);
        clearFile(juicePath);

        JFrame receiptFrame = new JFrame("Receipt");
        receiptFrame.setSize(700, 800);
        receiptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        receiptFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextArea receiptArea = createTextArea(receipt.toString(), notoFont);
        JTextArea pReceiptArea = createTextArea(preceipt.toString(), pizzaFont);
        JTextArea bReceiptArea = createTextArea(breceipt.toString(), burgerFont);
        JTextArea jReceiptArea = createTextArea(jreceipt.toString(), juiceFont);

        panel.add(new JScrollPane(receiptArea));
        panel.add(new JScrollPane(pReceiptArea));
        panel.add(new JScrollPane(bReceiptArea));
        panel.add(new JScrollPane(jReceiptArea));

        receiptFrame.add(panel, BorderLayout.CENTER);
        receiptFrame.setVisible(true);
    }

    Font readAndLoadFont(String filePath, StringBuilder receipt) {
        String fontPath = null;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            // Read the first line as font path
            fontPath = bufferedReader.readLine();
            String line;
            // Append the rest as receipt details
            while ((line = bufferedReader.readLine()) != null) {
                receipt.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return loadFont(fontPath);
    }

    void readFile(String filePath, StringBuilder receipt) {
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                receipt.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    void clearFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    Font loadFont(String fontPath) {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(16f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
            return font;
        } catch (FontFormatException | IOException e) {
            return new Font("Sanserif", Font.PLAIN, 15);
        }
    }

    JTextArea createTextArea(String text, Font font) {
        JTextArea textArea = new JTextArea();
        textArea.setText(text);
        textArea.setFont(font);
        textArea.setForeground(new Color(128, 0, 128));
        textArea.setMargin(new Insets(10, 10, 10, 10));
        textArea.setEditable(false);
        return textArea;
    }

    public static void main(String[] args) throws IOException {
        new bill();
    }
}













// import java.awt.BorderLayout;
// import java.awt.Color;
// import java.awt.Font;
// import java.awt.FontFormatException;
// import java.awt.GraphicsEnvironment;
// import java.awt.Insets;
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import javax.swing.*;

// class bill{
//     // JLabel l;
//     // JLabel name,address,phone,numOfPeople,time;
//     // JLabel namep,addressp,phonep,numOfPeoplep,timep;
//     // JButton dishes;
//     Font notoFont;
//     Font pizzaFont;
//     Font burgerFont;
//     Font juiceFont;
//     String p, b, j;
//     bill() throws IOException{

//     // this.setTitle("Customer's profile");
//     // this.setSize(800,700);
//     // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
//     // this.setLocationRelativeTo(null);
//     String globalfont="Fonts\\NotoSansDevanagari-VariableFont_wdth,wght.ttf";
//     String filePath = "OrderFood.txt";
//     String pizzaPath = "OrderPizza.txt";
//     String burgerPath = "OrderBurger.txt";
//     String juicePath = "OrderJuice.txt";

//     String line;
    
//     StringBuilder receipt = new StringBuilder("\t\tJavaBite Bill\nYour Order:\n");
//     StringBuilder preceipt = new StringBuilder("");
//     StringBuilder breceipt = new StringBuilder("");
//     StringBuilder jreceipt = new StringBuilder("");

//         // Initialize FileReader and BufferedReader
//         try (FileReader fileReader = new FileReader(filePath);
//              BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
//             // Read the file line by line
//             while ((line = bufferedReader.readLine()) != null) {
//                 receipt.append(line).append("\n");
//                 System.out.println(line);
//             }
//         } catch (IOException e) {
//             // e.printStackTrace();
//             System.err.println(e);
//         }

//         try (FileReader fileReader = new FileReader(pizzaPath);
//              BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
//             // Read the file line by line
//             while ((line = bufferedReader.readLine()) != null) {
//                 preceipt.append(line).append("\n");
//                 System.out.println(line);
//             }
//         } catch (IOException e) {
//             // e.printStackTrace();
//             System.err.println(e);
//         }

//         try (FileReader fileReader = new FileReader(burgerPath);
//              BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
//             // Read the file line by line
//             while ((line = bufferedReader.readLine()) != null) {
//                 breceipt.append(line).append("\n");
//                 System.out.println(line);
//             }
//         } catch (IOException e) {
//             // e.printStackTrace();
//             System.err.println(e);
//         }

//         try (FileReader fileReader = new FileReader(juicePath);
//              BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
//             // Read the file line by line
//             while ((line = bufferedReader.readLine()) != null) {
//                 jreceipt.append(line).append("\n");
//                 System.out.println(line);
//             }
//         } catch (IOException e) {
//             // e.printStackTrace();
//             System.err.println(e);
//         }


//         try (BufferedWriter writer = new BufferedWriter(new FileWriter("OrderFood.txt"))) {

//             writer.write("\n");
//             } catch (IOException ex) {
//             System.err.println(ex);
//         }
//         try (BufferedWriter writer = new BufferedWriter(new FileWriter("OrderPizza.txt"))) {

//             writer.write("\n");
//             } catch (IOException ex) {
//             System.err.println(ex);
//         }
//         try (BufferedWriter writer = new BufferedWriter(new FileWriter("OrderBurger.txt"))) {

//             writer.write("\n");
//             } catch (IOException ex) {
//             System.err.println(ex);
//         }
//         try (BufferedWriter writer = new BufferedWriter(new FileWriter("OrderJuice.txt"))) {

//             writer.write("\n");
//             } catch (IOException ex) {
//             System.err.println(ex);
//         }

//         receipt.append("\tThank You! Visit Again!!").append("\n");
        
//         try {
            
//             notoFont = Font.createFont(Font.TRUETYPE_FONT, new File(globalfont)).deriveFont(16f);
//             GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//             ge.registerFont(notoFont);
//         } catch (FontFormatException e) {
//             notoFont = new Font("Sanserif", Font.PLAIN, 15);
//         }

//         try {
            
//             pizzaFont = Font.createFont(Font.TRUETYPE_FONT, new File(p)).deriveFont(16f);
//             GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//             ge.registerFont(notoFont);
//         } catch (FontFormatException e) {
//             notoFont = new Font("Sanserif", Font.PLAIN, 15);
//         }

//         try {
            
//             burgerFont = Font.createFont(Font.TRUETYPE_FONT, new File(b)).deriveFont(16f);
//             GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//             ge.registerFont(notoFont);
//         } catch (FontFormatException e) {
//             notoFont = new Font("Sanserif", Font.PLAIN, 15);
//         }

//         try {
            
//             juiceFont = Font.createFont(Font.TRUETYPE_FONT, new File(j)).deriveFont(16f);
//             GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//             ge.registerFont(notoFont);
//         } catch (FontFormatException e) {
//             notoFont = new Font("Sanserif", Font.PLAIN, 15);
//         }


//         JFrame receiptFrame = new JFrame("Receipt");
//         receiptFrame.setSize(900, 900);
//         JTextArea receiptArea = new JTextArea();
//         receiptArea.setText(receipt.toString());
//         receiptArea.setFont(notoFont);
//         receiptArea.setForeground(new Color(128, 0, 128));
//         receiptArea.setMargin(new Insets(10,10,10,10));
//         receiptArea.setEditable(false);

//         JTextArea pReceiptArea = new JTextArea();
//         pReceiptArea.setText(preceipt.toString());
//         pReceiptArea.setFont(pizzaFont);
//         pReceiptArea.setForeground(new Color(128, 0, 128));
//         pReceiptArea.setMargin(new Insets(10,10,10,10));
//         pReceiptArea.setEditable(false);

//         JTextArea bReceiptArea = new JTextArea();
//         bReceiptArea.setText(breceipt.toString());
//         bReceiptArea.setFont(burgerFont);
//         bReceiptArea.setForeground(new Color(128, 0, 128));
//         bReceiptArea.setMargin(new Insets(10,10,10,10));
//         bReceiptArea.setEditable(false);

//         JTextArea jReceiptArea = new JTextArea();
//         jReceiptArea.setText(jreceipt.toString());
//         jReceiptArea.setFont(juiceFont);
//         jReceiptArea.setForeground(new Color(128, 0, 128));
//         jReceiptArea.setMargin(new Insets(10,10,10,10));
//         jReceiptArea.setEditable(false);

//         receiptFrame.add(new JScrollPane(receiptArea), BorderLayout.CENTER);
//         receiptFrame.add(new JScrollPane(pReceiptArea), BorderLayout.CENTER);
//         receiptFrame.add(new JScrollPane(bReceiptArea), BorderLayout.CENTER);
//         receiptFrame.add(new JScrollPane(jReceiptArea), BorderLayout.CENTER);
//         receiptFrame.setLocationRelativeTo(null);
//         receiptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         receiptFrame.setVisible(true);

        
//     }
//     void setPizzaFont(String font){
//         p = font;
//     }
//     void setBurgerFont(String font){
//         b = font;
//     }
//     void setJuiceFont(String font){
//         j = font;
//     }
//     public static void main(String[] args) throws IOException {
//         bill b = new bill();
//         b.setPizzaFont("Fonts\\NotoSansDevanagari-VariableFont_wdth,wght.ttf");
//         b.setBurgerFont("Fonts\\NotoSansDevanagari-VariableFont_wdth,wght.ttf");
//         b.setJuiceFont("Fonts\\NotoSansDevanagari-VariableFont_wdth,wght.ttf");
//     }
// }


// // name = new JLabel("NAME:");
//     // name.setBounds(20,50,500,50);
//     // namep = new JLabel(a.get(0));
//     // namep.setBounds(20, 100, 500, 50);
//     // address = new JLabel("ADDRESS:");
//     // address.setBounds(20,150,500,50);
//     // addressp = new JLabel(a.get(1));
//     // addressp.setBounds(20, 200, 500, 50);
//     // phone = new JLabel("PHONE NUMBER:");
//     // phone.setBounds(20,250,500,50);
//     // phonep = new JLabel(a.get(2));
//     // phonep.setBounds(20, 300, 500, 50);
//     // numOfPeople = new JLabel("NUMBER OF PEOPLE:");
//     // numOfPeople.setBounds(20,350,500,50);
//     // numOfPeoplep = new JLabel(a.get(3));
//     // numOfPeoplep.setBounds(20, 400, 500, 50);
//     // time = new JLabel("TIME FOR TABLE BOOKING:");
//     // time.setBounds(20,450,300,50);
//     // timep = new JLabel(a.get(4));
//     // timep.setBounds(20, 500, 500, 50);

//     // name.setForeground(Color.red);
//     // name.setFont(new Font("Algerian",Font.PLAIN,15));
//     // address.setForeground(Color.red);
//     // address.setFont(new Font("Algerian",Font.PLAIN,15));
//     // phone.setForeground(Color.red);
//     // phone.setFont(new Font("Algerian",Font.PLAIN,15));
//     // time.setForeground(Color.red);
//     // time.setFont(new Font("Algerian",Font.PLAIN,15));
//     // numOfPeople.setForeground(Color.red);
//     // numOfPeople.setFont(new Font("Algerian",Font.PLAIN,15));


//     // dishes = new JButton("MENU");
//     // dishes.setBounds(20, 580 , 150 , 75);
//     // dishes.addActionListener(this);

//     // l = new JLabel();
//     // l.setSize(800,700);
//     // l.setBackground(Color.PINK);
//     // l.setOpaque(true);
   
//     // l.add(name);
//     // l.add(address);
//     // l.add(numOfPeople);
//     // l.add(phone);
//     // l.add(time);
//     // l.add(namep);
//     // l.add(addressp);
//     // l.add(numOfPeoplep);
//     // l.add(phonep);
//     // l.add(timep);

    
//     // this.add(l);
   