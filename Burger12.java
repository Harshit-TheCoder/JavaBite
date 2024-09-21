import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.*;

class Burger12 extends JFrame implements ActionListener {
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
            g.drawImage(backgroundImage, 0, 0, 1200, 2000, this);
        }
    }


    String itemsPath = "OrderFood.txt";
    String[] languages = {"English", "Hindi", "Marathi", "Tamizh", "Telugu", "Kannada", "Malayalam"};
    String[] burgerNames = {"VEG MAKHANI BURST", "CRISPY VEG BURGER", "VEG WHOPPER", 
                            "HOT 'N' CHEESY BURGER", "BK VEGGIE BURGER", "CRISPY VEG TACO", 
                            "BK CHICKEN DOUBLE PATTY BURGER", "BK CHICKEN BURGER WITH CHEESE"};
    // String[] burgerDescriptions = {"Veg patty, fresh onion and signature makhani sauce.",
    //                                "Bk veg patty, green lettuce, tomato, cheese slice, signature sauce.",
    //                                "Chilli Cheese patty, spicy sauce, soft square masala buns. It's cheesy and spicy.",
    //                                "Delightful veg taco.",
    //                                "Bk chicken double patty, green lettuce, tomato, signature sauce.",
    //                                "Bk chicken patty, green lettuce, tomato, cheese slice, signature sauce.",
    //                                "Veg patty, fresh onion and signature sauce.",
    //                                "Bk chicken burger with cheese."};
    String[] burgerPrices = {"69", "89", "89", "79", "199", "259", "89", "159"};

    String [] burgerDescriptions;
    String[] imagePaths = {"Images\\makhaniburst.jpg", "Images\\crispy veg.jpg", "Images\\veg whopper.jpg", 
                           "Images\\hotncheesy.jpg", "Images\\bkveggie.jpg", "Images\\taco.jpg", 
                           "Images\\doublechickenpatty.jpg", "Images\\chickencheese.jpg"};
    
    JRadioButton[] burgerButtons;
    JLabel[] burgerDescriptionsLabels;
    JLabel[] burgerPricesLabels;
    JTextField[] burgerQuantityFields;
    JLabel[] burgerImages;
    JLabel backgroundImageLabel;
    JComboBox<String> JLanguage = new JComboBox<>(languages);
    JButton pizza, drinks, bill, BILL;
    
    Burger12() {
        this.setTitle("BURGERS!!!");
        this.setSize(1200, 2000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Create the panel with background image
        JPanel panel = new BackgroundPanel("burger.png"); // Set your background image path here
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(1200, 2000));

        Locale defaultLocale = Locale.of("en", "US");
        this.bundle = ResourceBundle.getBundle("Messages", defaultLocale);
        burgerDescriptions = this.bundle.getString("burgerDescriptions").split(",");

        burgerButtons = new JRadioButton[burgerNames.length];
        burgerDescriptionsLabels = new JLabel[burgerNames.length];
        burgerPricesLabels = new JLabel[burgerNames.length];
        burgerQuantityFields = new JTextField[burgerNames.length];
        burgerImages = new JLabel[burgerNames.length];

        // Set up the components
        int yPosition = 50;
        for (int i = 0; i < burgerNames.length; i++) {
            burgerButtons[i] = new JRadioButton(burgerNames[i]);
            burgerButtons[i].setBounds(20, yPosition, 300, 50);
            burgerButtons[i].setForeground(Color.red);
            burgerButtons[i].setFont(new Font("Algerian", Font.PLAIN, 15));
            burgerButtons[i].setFocusable(false);
            burgerButtons[i].addActionListener(this);
            panel.add(burgerButtons[i]);

            burgerDescriptionsLabels[i] = new JLabel(burgerDescriptions[i]);
            burgerDescriptionsLabels[i].setBounds(30, yPosition + 50, 500, 50);
            burgerDescriptionsLabels[i].setForeground(new Color(25, 25, 112));
            burgerDescriptionsLabels[i].setFont(new Font("Arial", Font.BOLD, 12));
            panel.add(burgerDescriptionsLabels[i]);

            ImageIcon imageIcon = new ImageIcon(imagePaths[i]);
            Image img = imageIcon.getImage().getScaledInstance(100, 75, Image.SCALE_SMOOTH);
            burgerImages[i] = new JLabel(new ImageIcon(img));
            burgerImages[i].setBounds(600, yPosition, 100, 75);
            panel.add(burgerImages[i]);

            burgerPricesLabels[i] = new JLabel(burgerPrices[i]);
            burgerPricesLabels[i].setBounds(600, yPosition + 100, 100, 50);
            burgerPricesLabels[i].setForeground(new Color(25, 25, 112));
            burgerPricesLabels[i].setFont(new Font("Arial", Font.BOLD, 12));
            panel.add(burgerPricesLabels[i]);

            burgerQuantityFields[i] = new JTextField();
            burgerQuantityFields[i].setBounds(900, yPosition, 150, 50);
            burgerQuantityFields[i].addActionListener(this);
            burgerQuantityFields[i].setForeground(new Color(128, 0, 128));
            burgerQuantityFields[i].setFont(new Font("Arial", Font.BOLD, 16));
            burgerQuantityFields[i].setHorizontalAlignment(JTextField.CENTER);
            panel.add(burgerQuantityFields[i]);

            yPosition += 150;
        }

        // Labels for sections
        System.out.println(yPosition);
        JLabel burgersLabel = new JLabel("BURGERS");
        burgersLabel.setBounds(50, 0, 150, 30);
        burgersLabel.setFont(new Font("Algerian", Font.PLAIN, 25));
        burgersLabel.setForeground(new Color(25, 25, 112));
        panel.add(burgersLabel);

        JLabel pricesLabel = new JLabel("PRICES");
        pricesLabel.setBounds(600, 0, 100, 30);
        pricesLabel.setFont(new Font("Algerian", Font.PLAIN, 25));
        pricesLabel.setForeground(new Color(25, 25, 112));
        panel.add(pricesLabel);

        JLabel quantityLabel = new JLabel("NUMBER OF BURGERS");
        quantityLabel.setBounds(850, 0, 350, 30);
        quantityLabel.setFont(new Font("Algerian", Font.PLAIN, 25));
        quantityLabel.setForeground(new Color(25, 25, 112));
        panel.add(quantityLabel);

        // Navigation and action buttons
        JLabel direct = new JLabel("Please click the buttons to navigate accordingly: ");
        direct.setBounds(20, 1300, 800, 50);
        direct.setForeground(new Color(75, 0, 130));
        direct.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(direct);

        JLabel billGuide = new JLabel("Please click to generate the bill: ");
        billGuide.setBounds(20, 1600, 800, 50);
        billGuide.setForeground(new Color(75, 0, 130));
        billGuide.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(billGuide);

        pizza = new JButton("PIZZA");
        drinks = new JButton("DRINKS");
        bill = new JButton("ADD TO ORDER");
        BILL = new JButton("BILL");
        pizza.setBounds(20, 1400, 150, 50);
        drinks.setBounds(20, 1500, 150, 50);
        bill.setBounds(20, 1700, 300, 50);
        BILL.setBounds(400, 1700, 150, 50);
        JLanguage.setBounds(20, 1800, 300, 50);
        pizza.addActionListener(this);
        drinks.addActionListener(this);
        bill.addActionListener(this);
        BILL.addActionListener(this);
        JLanguage.addActionListener(this);
        panel.add(pizza);
        panel.add(drinks);
        panel.add(bill);
        panel.add(BILL);
        panel.add(JLanguage);

        // Add the panel with JScrollPane
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        this.add(scrollPane);
        this.setVisible(true);
    }

    private void updateLanguageContent() {
        // if (pizzaButtons == null) {
        //     // This block ensures pizzaButtons is not null before attempting to update content
        //     pizzaNames = this.bundle.getString("pizzaNames").split(",");
        //     pizzaDescriptions = this.bundle.getString("pizzaDescriptions").split(",");
        //     pizzaButtons = new JRadioButton[pizzaNames.length];
        //     pizzaDescriptionsLabels = new JLabel[pizzaNames.length];
        //     pizzaPricesLabels = new JLabel[pizzaNames.length];
        //     pizzaQuantityFields = new JTextField[pizzaNames.length];
        //     pizzaImages = new JLabel[pizzaNames.length];
        //     return; // Early exit to prevent NullPointerException
        // }// Ensure that the length of arrays matches
        
        burgerDescriptions = this.bundle.getString("burgerDescriptions").split(",");
        if (burgerNames.length != burgerDescriptions.length) {
            JOptionPane.showMessageDialog(this, "Mismatch between burger names and descriptions.");
            return;
        }
        // Update UI components with new language content
        for (int i = 0; i < burgerNames.length; i++) {
            burgerDescriptionsLabels[i].setText(burgerDescriptions[i]);
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
        if (e.getSource() == drinks) {
            this.dispose();
            new Drinks12(); // Assuming Drinks12 is the class for drinks
        }
        if(e.getSource() == BILL){
            bill b = new bill();
        }
        if (e.getSource() == bill) {
            // Code for generating the bill can be added here
            StringBuilder selectedItems = new StringBuilder();
            double totalPrice = 0.0;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(itemsPath, true))) {
                // writer.write("Order Summary:");
                writer.newLine();
    
                for (int i = 0; i < burgerButtons.length; i++) {
                    if (burgerButtons[i].isSelected()) {
                        String quantityText = burgerQuantityFields[i].getText();
                        if (quantityText.isEmpty()) {
                            quantityText = "1"; // Default to 1 if no quantity is provided
                        }
                        int quantity = Integer.parseInt(quantityText);
                        double price = Double.parseDouble(burgerPrices[i]);
                        double itemTotal = price * quantity;
                        totalPrice += itemTotal;
    
                        String line = burgerNames[i] + " - Price: $" + price + " - Quantity: " + quantity + " - Total: $" + itemTotal;
                        selectedItems.append(line).append("\n");
                        writer.write(line);
                        writer.newLine();
                    }
                }
    
                if (selectedItems.length() == 0) {
                    selectedItems.append("No burgers selected.");
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
        Burger12 b = new Burger12();
    }
}
