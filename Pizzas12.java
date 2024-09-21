import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.*;


class Pizzas12 extends JFrame implements ActionListener {

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
    
    // String[] pizzaNames = {"ONION PIZZA MANIA", "CAPSICUM PIZZA MANIA", "PANEER PIZZA MANIA", 
    //                        "CORN PIZZA MANIA", "CHICKEN PIZZA MANIA", "FARMHOUSE PIZZA MANIA", 
    //                        "CLASSIC PIZZA MANIA", "MARGHERITA PIZZA MANIA"};

    // String[] pizzaDescriptions = {"Crunchy onion on a cheesy base", 
    //                               "Caters your spice cravings loaded with juicy paneer and crisp capsicum",
    //                               "Flavourful trio of juicy paneer crisp capsicum with red spicy paprika", 
    //                               "Sweet and juicy golden corn for that lipsmacking taste", 
    //                               "Chicken Sausage pepper and barbeque chicken and periperi chicken in fresh pan crust", 
    //                               "Delightful combination of onion capsicum tomato and grilled mushroom.", 
    //                               "A classic pizza topped with sprinkle of basil and parsley herbs", 
    //                               "Classic delight with 100% real mozzarella cheese"};
    String[] pizzaNames;
    String[] pizzaDescriptions;
    String[] pizzaPrices = {"69", "89", "89", "79", "199", "259", "89", "159"};
    
    String[] imagePaths = {"onion.jpg", "caps.jpg", "paneer.jpg", 
                           "corn.jpg", "chick.jpg", "farm.jpg", 
                           "clp.jpg", "mar.jpg"};
    String[] languages = {"English", "Hindi", "Marathi", "Tamizh", "Telugu", "Kannada", "Malayalam"};
    JRadioButton[] pizzaButtons;
    JLabel[] pizzaDescriptionsLabels;
    JLabel[] pizzaPricesLabels;
    JTextField[] pizzaQuantityFields;
    JLabel[] pizzaImages;

    JComboBox<String> JLanguage = new JComboBox<>(languages);

    JButton burger, drinks, bill, BILL;
    
    Pizzas12() {
        this.setTitle("PIZZAAAA!!!");
        this.setSize(1200, 2000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        // Create the panel with background image
        JPanel panel = new BackgroundPanel("pizza.png"); // Set your background image path here
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(1200, 2000));

        Locale defaultLocale = Locale.of("en", "US");
        this.bundle = ResourceBundle.getBundle("Messages", defaultLocale);
        pizzaNames = this.bundle.getString("pizzaNames").split(",");
        pizzaDescriptions = this.bundle.getString("pizzaDescriptions").split(",");

        pizzaButtons = new JRadioButton[pizzaNames.length];
        pizzaDescriptionsLabels = new JLabel[pizzaNames.length];
        pizzaPricesLabels = new JLabel[pizzaNames.length];
        pizzaQuantityFields = new JTextField[pizzaNames.length];
        pizzaImages = new JLabel[pizzaNames.length];

        // Set up the components
        int yPosition = 50;
        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaButtons[i] = new JRadioButton(pizzaNames[i]);
            pizzaButtons[i].setBounds(20, yPosition, 250, 50);
            pizzaButtons[i].setForeground(Color.red);
            pizzaButtons[i].setFont(new Font("Algerian", Font.PLAIN, 15));
            pizzaButtons[i].setFocusable(false);
            pizzaButtons[i].addActionListener(this);
            panel.add(pizzaButtons[i]);

            pizzaDescriptionsLabels[i] = new JLabel(pizzaDescriptions[i]);
            pizzaDescriptionsLabels[i].setBounds(30, yPosition + 50, 500, 50);
            pizzaDescriptionsLabels[i].setForeground(new Color(75, 0, 130));
            pizzaDescriptionsLabels[i].setFont(new Font("Noto Sans", Font.BOLD, 12));
            panel.add(pizzaDescriptionsLabels[i]);

            ImageIcon imageIcon = new ImageIcon(imagePaths[i]);
            Image img = imageIcon.getImage().getScaledInstance(100, 75, Image.SCALE_SMOOTH);
            pizzaImages[i] = new JLabel(new ImageIcon(img));
            pizzaImages[i].setBounds(600, yPosition, 100, 75);
            panel.add(pizzaImages[i]);

            pizzaPricesLabels[i] = new JLabel(pizzaPrices[i]);
            pizzaPricesLabels[i].setBounds(600, yPosition + 100, 100, 50);
            pizzaPricesLabels[i].setForeground(new Color(75, 0, 130));
            pizzaPricesLabels[i].setFont(new Font("Noto Sans", Font.BOLD, 12));
            panel.add(pizzaPricesLabels[i]);

            pizzaQuantityFields[i] = new JTextField();
            pizzaQuantityFields[i].setBounds(900, yPosition, 150, 50);
            pizzaQuantityFields[i].addActionListener(this);
            pizzaQuantityFields[i].setForeground(new Color(128, 0, 128));
            pizzaQuantityFields[i].setFont(new Font("Noto Sans", Font.BOLD, 16));
            pizzaQuantityFields[i].setHorizontalAlignment(JTextField.CENTER);
            panel.add(pizzaQuantityFields[i]);

            yPosition += 150;
        }

        // Labels for sections
        JLabel pizzasLabel = new JLabel("PIZZAS");
        pizzasLabel.setBounds(50, 0, 100, 30);
        pizzasLabel.setFont(new Font("Algerian", Font.PLAIN, 25));
        pizzasLabel.setForeground(new Color(128, 0, 128));
        panel.add(pizzasLabel);

        JLabel pricesLabel = new JLabel("PRICES");
        pricesLabel.setBounds(600, 0, 100, 30);
        pricesLabel.setFont(new Font("Algerian", Font.PLAIN, 25));
        pricesLabel.setForeground(new Color(128, 0, 128));
        panel.add(pricesLabel);

        JLabel quantityLabel = new JLabel("NUMBER OF PIZZAS");
        quantityLabel.setBounds(900, 0, 250, 30);
        quantityLabel.setFont(new Font("Algerian", Font.PLAIN, 25));
        quantityLabel.setForeground(new Color(128, 0, 128));
        panel.add(quantityLabel);

        // Navigation and action buttons
        JLabel direct = new JLabel("Please click the buttons to navigate accordingly: ");
        direct.setBounds(20, 1300, 800, 50);
        direct.setForeground(new Color(75, 0, 130));
        direct.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(direct);

        JLabel billGuide = new JLabel("Please click to generate the bill: ");
        billGuide.setBounds(20, 1500, 800, 50);
        billGuide.setForeground(new Color(75, 0, 130));
        billGuide.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(billGuide);

        burger = new JButton("BURGER");
        drinks = new JButton("DRINKS");
        bill = new JButton("ADD TO ORDER");
        BILL = new JButton("BILL");
        burger.setBounds(20, 1400, 150, 50);
        drinks.setBounds(200, 1400, 150, 50);
        bill.setBounds(20, 1600, 300, 50);
        BILL.setBounds(400, 1600, 150, 50);
        JLanguage.setBounds(20, 1700, 300, 50);
        burger.addActionListener(this);
        drinks.addActionListener(this);
        bill.addActionListener(this);
        BILL.addActionListener(this);
        JLanguage.addActionListener(this);
        panel.add(burger);
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
        pizzaNames = this.bundle.getString("pizzaNames").split(",");
        pizzaDescriptions = this.bundle.getString("pizzaDescriptions").split(",");
        if (pizzaNames.length != pizzaDescriptions.length) {
            JOptionPane.showMessageDialog(this, "Mismatch between pizza names and descriptions.");
            return;
        }
        // Update UI components with new language content
        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaButtons[i].setText(pizzaNames[i]);
            pizzaDescriptionsLabels[i].setText(pizzaDescriptions[i]);
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
        

        if (e.getSource() == burger) {
            this.dispose();
            Burger12 br = new Burger12(); // Assuming a Burger class exists
        }
        if (e.getSource() == drinks) {
            this.dispose();
            Drinks12 dr = new Drinks12(); // Assuming Drinks12 is the class for drinks
        }
        if(e.getSource() == BILL){
            bill bi = new bill();
        }
        if (e.getSource() == bill) {
            StringBuilder selectedItems = new StringBuilder();
            double totalPrice = 0.0;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(itemsPath, true))) {
                // writer.write("Order Summary:");
                writer.newLine();
    
                for (int i = 0; i < pizzaButtons.length; i++) {
                    if (pizzaButtons[i].isSelected()) {
                        String quantityText = pizzaQuantityFields[i].getText();
                        if (quantityText.isEmpty()) {
                            quantityText = "1"; // Default to 1 if no quantity is provided
                        }
                        int quantity = Integer.parseInt(quantityText);
                        double price = Double.parseDouble(pizzaPrices[i]);
                        double itemTotal = price * quantity;
                        totalPrice += itemTotal;
    
                        String line = pizzaNames[i] + " - Price: $" + price + " - Quantity: " + quantity + " - Total: $" + itemTotal;
                        selectedItems.append(line).append("\n");
                        writer.write(line);
                        writer.newLine();
                    }
                }
    
                if (selectedItems.length() == 0) {
                    selectedItems.append("No pizzas selected.");
                    writer.write(selectedItems.toString());
                    writer.newLine();
                }
    
                // Write the total price to the file
                writer.write("Total Price: $" + totalPrice);
                writer.newLine();
    
            } catch (IOException ex) {
                System.err.println(ex);
            }
    
            JOptionPane.showMessageDialog(this, selectedItems.toString() + "\nTotal Price: $" + totalPrice, "Bill Summary", JOptionPane.INFORMATION_MESSAGE);
        }
    
        
    }

    
    
    public static void main(String[] args) {
        Pizzas12 p = new Pizzas12();
        
    }

}
