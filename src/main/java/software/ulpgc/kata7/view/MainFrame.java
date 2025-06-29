package software.ulpgc.kata7.view;

import software.ulpgc.kata7.control.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private JTextField textField;
    private JLabel nameLabel;
    private JLabel imageLabel;

    public MainFrame() {
        this.setTitle("Pokedex");
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(searchPokemon(), BorderLayout.NORTH);
        add(pokemonInformation(), BorderLayout.CENTER);
        this.commands = new HashMap<>();
    }

    public void put(String commandName, Command command) {
        this.commands.put(commandName, command);
    }

    private JButton searchButton(){
        JButton sendButton = new JButton("Enviar");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (commands.containsKey("send")) {
                    commands.get("send").execute();
                }
            }
        });
        return sendButton;
    }

    private JPanel searchPokemon(){
        JPanel topPanel = new JPanel(new FlowLayout());
        textField = new JTextField(20);
        topPanel.add(textField);
        topPanel.add(searchButton());
        return topPanel;
    }

    private JPanel pokemonInformation(){
        JPanel bottomPanel = new JPanel(new BorderLayout());

        bottomPanel.add(pokemonNamePanel(), BorderLayout.NORTH);
        bottomPanel.add(pokemonImagePanel(), BorderLayout.CENTER);

        return bottomPanel;
    }

    private JPanel pokemonImagePanel() {
        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(200, 200));
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        imagePanel.add(imageLabel);
        return imagePanel;
    }

    private JPanel pokemonNamePanel() {
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nameLabel = new JLabel("Selecciona un pokemon");
        namePanel.add(nameLabel);
        return namePanel;
    }

    public String getTextInput() {
        return textField.getText();
    }

    private void setNameText(String name) {
        nameLabel.setText(name);
    }

    private void setImage(ImageIcon image) {
        imageLabel.setIcon(image);
    }

    public void updatePokemonInfo(String name, ImageIcon image) {
        setNameText(name);
        setImage(image);
        revalidate();
        repaint();
    }
}
