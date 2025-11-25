import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame {

    // Komponen GUI
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, resetButton;

    public LoginForm() {

        // Judul window
        setTitle("Login Form");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // window di tengah layar

        // Panel utama
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        // Label dan field
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        // Tombol login dan reset
        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");

        // Tambahkan ke panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(resetButton);

        // Tambah panel ke frame
        add(panel);

        // Event tombol login
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Validasi sederhana
                if (username.equals("admin") && password.equals("12345")) {
                    JOptionPane.showMessageDialog(null,
                            "Login Berhasil!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Username atau Password salah!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Event tombol reset
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        // Tampilkan GUI
        setVisible(true);
    }

    public static void main(String[] args) {
        // Jalankan GUI di event dispatch thread
        SwingUtilities.invokeLater(() -> new LoginForm());
    }
}