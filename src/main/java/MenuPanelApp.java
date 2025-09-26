import javax.swing.*;
import java.awt.*;

public class MenuPanelApp {

    public JFrame frame;

    public JPanel main;
    public CardLayout card;

    public MenuPanelApp() {

        frame = new JFrame("Swing Application with Panels & Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuNavigate = new JMenu("Navigate");

        JMenuItem home = new JMenuItem("Home");
        JMenuItem profile = new JMenuItem("Profile");
        JMenuItem settings = new JMenuItem("Settings");

        menuNavigate.add(home);
        menuNavigate.add(profile);
        menuNavigate.add(settings);

        menuBar.add(menuNavigate);


        JMenu menuFile = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        menuFile.add(exitItem);
        menuBar.add(menuFile);

        frame.setJMenuBar(menuBar);

        card = new CardLayout();
        main = new JPanel(card);

        JPanel homePanel = createPanel("Welcome to Home Page", Color.BLUE);
        JPanel profilePanel = createPanel("This is the Profile Page", Color.CYAN);
        JPanel settingsPanel = createPanel("Adjust your Settings here", Color.ORANGE);

        main.add(homePanel, "Home");
        main.add(profilePanel, "Profile");
        main.add(settingsPanel, "Settings");


        home.addActionListener(e -> card.show(main, "Home"));
        profile.addActionListener(e -> card.show(main, "Profile"));
        settings.addActionListener(e -> card.show(main, "Settings"));
        exitItem.addActionListener(e -> System.exit(0));


        frame.add(main);
        frame.setVisible(true);


    }


    private JPanel createPanel(String text, Color bgColor) {
        JPanel Group2 = new JPanel();
        Group2.setBackground(bgColor);
        Group2.setLayout(new BorderLayout());

        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        Group2.add(label, BorderLayout.CENTER);
        return Group2;
    }



}
