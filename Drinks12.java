import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.*;


class Drinks12 extends JFrame implements ActionListener {
    private ResourceBundle bundle;
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;
    
        public BackgroundPanel(String imagePath) {
            // Load the background image
            backgroundImage = new ImageIcon(imagePath).getImage();
        }
    
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image
            g.drawImage(backgroundImage, 0, 0, 1200, 2500, this);
        }
    }

    String itemsPath = "OrderFood.txt";

    String[] list = {"SMALL", "MEDIUM", "LARGE"};
    String[] languages = {"English", "Hindi", "Marathi", "Tamizh", "Telugu", "Kannada", "Malayalam"};
    String[] juices;
    JLabel[] juiceLabels;
    JRadioButton[] juiceButtons;
    JComboBox<String>[] sizeCombos;
    JTextField[] quantityFields;
    JLabel[] imageLabels;
    JComboBox<String> JLanguage = new JComboBox<>(languages);
    JButton pizza, burger, bill, BILL;
    Drinks12() {
        this.setTitle("JUICE CORNER");
        this.setSize(1200, 2500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // String[] juices = {"Orange Juice", "Mango Juice", "Watermelon Juice", "Lichi Juice", "Kiwi Juice",
        //         "Guava Juice", "Pineapple Juice", "Grape Juice", "Mixedfruit Juice", "Pomegranate Juice",
        //         "Lime", "Rose Lime", "Blue Lime", "Green Lime", "Masala Lime", "White Lime", "Soda Lime", "Cola Lime"};
        String[] prices = {"40            50             60", "40            50             60", "40            50             60", "40            50             60",
                "40            50             60", "40            50             60", "40            50             60", "40            50             60",
                "40            50             60", "40            50             60", "40            50             60", "40            50             60",
                "40            50             60", "40            50             60", "40            50             60", "40            50             60",
                "40            50             60", "40            50             60"};

        ImageIcon[] images = {
                new ImageIcon("Images/orangejuice.jpeg"), new ImageIcon("Images/mangojuice.jpg"), 
                new ImageIcon("Images/watermelonjuice.jpg"), new ImageIcon("Images/lichijuice.jpg"), 
                new ImageIcon("Images/guavajuice.jpg"), new ImageIcon("Images/kiwijuice.jpg"), 
                new ImageIcon("Images/grapejuice.jpeg"), new ImageIcon("Images/pineapplejuice.jpg"), 
                new ImageIcon("Images/mixedfruitjuice.jpg"), new ImageIcon("Images/pomegranatejuice.jpg"), 
                new ImageIcon("Images/lime.jpeg"), new ImageIcon("Images/roselime.jpg"), 
                new ImageIcon("Images/bluelime.jpg"), new ImageIcon("Images/greenlime.jpg"), 
                new ImageIcon("Images/masalalime.jpeg"), new ImageIcon("Images/whitelime.jpg"), 
                new ImageIcon("Images/limesoda.jpg"), new ImageIcon("Images/colalime.jpeg")
        };

        Locale defaultLocale = Locale.of("en", "US");
        this.bundle = ResourceBundle.getBundle("Messages", defaultLocale);
        list = this.bundle.getString("list").split(",");
        juices = this.bundle.getString("juices").split(",");

        juiceButtons = new JRadioButton[juices.length];
        juiceLabels = new JLabel[juices.length];
        sizeCombos = new JComboBox[juices.length];
        quantityFields = new JTextField[juices.length];
        imageLabels = new JLabel[juices.length];

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(1200, 2500));
        panel = new BackgroundPanel("juices.png"); // Set the background image
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(1200, 2500));
        int yPosition = 50;
        for (int i = 0; i < juices.length; i++) {
            juiceButtons[i] = new JRadioButton(juices[i]);
            juiceButtons[i].setBounds(20, yPosition, 200, 50);
            juiceButtons[i].setForeground(Color.red);
            juiceButtons[i].setFont(new Font("Algerian", Font.PLAIN, 15));
            juiceButtons[i].setFocusable(false);
            panel.add(juiceButtons[i]);

            Image img = images[i].getImage().getScaledInstance(100, 75, Image.SCALE_SMOOTH);
            imageLabels[i] = new JLabel(new ImageIcon(img));
            imageLabels[i].setBounds(250, yPosition, 100, 75);
            panel.add(imageLabels[i]);

            juiceLabels[i] = new JLabel(prices[i]);
            juiceLabels[i].setBounds(400, yPosition, 300, 50);
            panel.add(juiceLabels[i]);

            sizeCombos[i] = new JComboBox<>(list);
            sizeCombos[i].setBounds(750, yPosition, 100, 50);
            sizeCombos[i].addActionListener(this);
            panel.add(sizeCombos[i]);

            quantityFields[i] = new JTextField();
            quantityFields[i].setBounds(900, yPosition, 100, 50);
            quantityFields[i].setForeground(new Color(128, 0, 128));
            quantityFields[i].setFont(new Font("Arial", Font.BOLD, 16));
            quantityFields[i].setHorizontalAlignment(JTextField.CENTER);
            panel.add(quantityFields[i]);

            yPosition += 100;
        }

        System.out.println(yPosition);
        JLabel burgersLabel = new JLabel("DRINKS");
        burgersLabel.setBounds(50, 0, 150, 30);
        burgersLabel.setFont(new Font("Algerian", Font.PLAIN, 25));
        burgersLabel.setForeground(new Color(25, 25, 112));
        panel.add(burgersLabel);

        JLabel pricesLabel = new JLabel("PRICES");
        pricesLabel.setBounds(400, 0, 100, 30);
        pricesLabel.setFont(new Font("Algerian", Font.PLAIN, 25));
        pricesLabel.setForeground(new Color(25, 25, 112));
        panel.add(pricesLabel);

        JLabel quantityLabel = new JLabel("QUANTITY");
        quantityLabel.setBounds(850, 0, 350, 30);
        quantityLabel.setFont(new Font("Algerian", Font.PLAIN, 25));
        quantityLabel.setForeground(new Color(25, 25, 112));
        panel.add(quantityLabel);

        // Navigation and action buttons
        JLabel direct = new JLabel("Please click the buttons to navigate accordingly: ");
        direct.setBounds(20, 1900, 800, 50);
        direct.setForeground(new Color(75, 0, 130));
        direct.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(direct);

        JLabel billGuide = new JLabel("Please click to generate the bill: ");
        billGuide.setBounds(20, 2200, 800, 50);
        billGuide.setForeground(new Color(75, 0, 130));
        billGuide.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(billGuide);

        pizza = new JButton("PIZZA");
        burger = new JButton("BURGER");
        bill = new JButton("ADD TO ORDER");
        BILL = new JButton("BILL");
        pizza.setBounds(20, 2000, 150, 50);
        burger.setBounds(20, 2100, 150, 50);
        bill.setBounds(20, 2300, 300, 50);
        BILL.setBounds(400, 2300, 150, 50);
        JLanguage.setBounds(400, 2100, 300, 50);
        pizza.addActionListener(this);
        burger.addActionListener(this);
        bill.addActionListener(this);
        BILL.addActionListener(this);
        JLanguage.addActionListener(this);
        panel.add(pizza);
        panel.add(burger);
        panel.add(bill);
        panel.add(BILL);
        panel.add(JLanguage);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        this.add(scrollPane);
        this.setVisible(true);
    }
    private void updateLanguageContent() {
        list = this.bundle.getString("list").split(",");
        juices = this.bundle.getString("juices").split(",");
        // Update UI components with new language content
        for (int i = 0; i < juices.length; i++) {
            juiceButtons[i].setText(juices[i]);
            sizeCombos[i].setModel(new DefaultComboBoxModel<>(list));
        }
        
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == JLanguage){
            String selectedLanguage = (String)JLanguage.getSelectedItem();
            Locale locale;

            // Determine locale based on selected language
            locale = switch (selectedLanguage) {
                case "Hindi" -> Locale.of("hi", "IN");
                case "Marathi" -> Locale.of("mr", "IN");
                case "Tamizh" -> Locale.of("ta", "IN");
                case "Telugu" -> Locale.of("te", "IN");
                case "Kannada" -> Locale.of("kn", "IN");
                case "Malayalam" -> Locale.of("ml", "IN");
                default -> Locale.of("en", "US");
            };

        // Load the appropriate resource bundle
            this.bundle = ResourceBundle.getBundle("Messages", locale);
            updateLanguageContent();
        }

        if (e.getSource() == pizza) {
            this.dispose();
            new Pizzas12(); // Assuming a Pizza class exists
        }
        if (e.getSource() == burger) {
            this.dispose();
            new Burger12(); // Assuming Drinks12 is the class for drinks
        }
        if(e.getSource() == BILL){
            bill b = new bill();
        }
        if (e.getSource() == bill) {
            // Code for generating the bill
            StringBuilder selectedItems = new StringBuilder();
            double totalPrice = 0.0;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(itemsPath, true))) {
                writer.newLine();
                double price = 0.0;
                for (int i = 0; i < juiceButtons.length; i++) {
                    if (juiceButtons[i].isSelected()) {
                        // Get selected index
                        int selectedIndex = sizeCombos[i].getSelectedIndex();
                        
                        // Map index to price
                        switch (selectedIndex) {
                            case 0: // SMALL
                                price = 40.0;
                                break;
                            case 1: // MEDIUM
                                price = 50.0;
                                break;
                            case 2: // LARGE
                                price = 60.0;
                                break;
                            default:
                                price = 40.0; // Default if no valid index is found
                                break;
                        }
                        
                        // Calculate total price
                        double quantity = Double.parseDouble(quantityFields[i].getText());
                        totalPrice += price * quantity;
                        
                        // Write details to file
                        String line = juiceButtons[i].getText() + " - Price: $" + price + " - Glass Size: " + sizeCombos[i].getSelectedItem() + " - Quantity: " + quantity;
                        selectedItems.append(line).append("\n");
                        writer.write(line);
                        writer.newLine();
                    }
                }
        
                if (selectedItems.length() == 0) {
                    selectedItems.append("No drinks selected.");
                    writer.write(selectedItems.toString());
                    writer.newLine();
                }
        
                // Write the total price to the file
                writer.write("Total Price: $" + totalPrice);
                writer.newLine();
        
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        
            JOptionPane.showMessageDialog(this, selectedItems.toString() + "\nTotal Price: $" + totalPrice, "Bill Summary", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public static void main(String[] args) {
        Drinks12 d = new Drinks12();
    }
}
