import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class LanguageTranslator extends JFrame implements ActionListener {
    private JComboBox<String> fromLanguage, toLanguage;
    private JTextArea inputText, outputText;
    private JButton translateButton;
    Font notoFont;
    public LanguageTranslator() {
        try {
            notoFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts\\NotoSansDevanagari-VariableFont_wdth,wght.ttf")).deriveFont(18f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(notoFont);
        } catch (IOException | FontFormatException e) {
            notoFont = new Font("Sanserif", Font.PLAIN, 18);
        }
        // Initialize JFrame
        setTitle("Language Translator");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize components
        String[] languages = {"English", "Hindi", "Marathi", "Tamil", "Telugu", "Kannada", "Malayalam"};
        fromLanguage = new JComboBox<>(languages);
        toLanguage = new JComboBox<>(languages);
        inputText = new JTextArea(8, 30);
        inputText.setFont(notoFont);
        outputText = new JTextArea(8, 30);
        outputText.setFont(notoFont);
        outputText.setText("नमस्ते");
        outputText.setEditable(false);
        translateButton = new JButton("Translate");

        // Add ActionListener to the button
        translateButton.addActionListener(this);

        // Panel for language selection
        JPanel languagePanel = new JPanel(new GridLayout(2, 2));
        languagePanel.add(new JLabel("From:"));
        languagePanel.add(fromLanguage);
        languagePanel.add(new JLabel("To:"));
        languagePanel.add(toLanguage);

        // Panel for input text area
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input Text"));
        inputPanel.add(new JScrollPane(inputText), BorderLayout.CENTER);

        // Panel for output text area
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBorder(BorderFactory.createTitledBorder("Translated Text"));
        outputPanel.add(new JScrollPane(outputText), BorderLayout.CENTER);

        // Panel for the translate button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(translateButton);

        // Add panels to the JFrame
        add(languagePanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.WEST);
        add(outputPanel, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Simulate the translation
        String fromLang = (String) fromLanguage.getSelectedItem();
        String toLang = (String) toLanguage.getSelectedItem();
        String input = inputText.getText();

        if (input.trim().isEmpty()) {
            outputText.setText("नमस्ते.");
            return;
        }

        // Simulated translation result
        String translatedText = "नमस्ते from " + fromLang + " to " + toLang + ": " + input;

        // Display the translated text in the output text area
        outputText.setText(translatedText);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LanguageTranslator::new);
    }
}
