import javax.swing.*;
import java.awt.*;

public class PongGameGui extends JFrame {

    private JPanel jPanel1;
    private JButton startButton;
    private JTextField textField1;
    private JTextField textField2;

    public PongGameGui() {
        initComponents();
    }

    private void initComponents() {
        startButton.addActionListener(e -> {
            try {
                String player1Name = textField1.getText();
                String player2Name = textField2.getText();

                // Check if names contain only letters
                if (!isValidName(player1Name) || !isValidName(player2Name)) {
                    throw new IllegalArgumentException("Invalid name. Please use only letters.");
                }

                this.dispose();
                new GameFrame();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setContentPane(jPanel1);
        pack();
        setTitle("Pong Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(GamePanel.GAME_WIDTH + 150, GamePanel.GAME_HEIGHT + 150));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PongGameGui());
    }
}
