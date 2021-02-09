import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Main {

    public static void main(String[] args) {
        LoginSignupFrame lsf=new LoginSignupFrame();
    }
}

class LoginSignupFrame extends JFrame implements ActionListener {
    private JLabel userLabel, passwordLabel, success;
    private JTextField userText;
    private JPasswordField passwordText;
    private JButton button;

    LoginSignupFrame() {
        JFrame frame = new JFrame();
        setSize(275, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(this);
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText();

        if (user.equals("Venkatesh") && password.equals("Venkatesh"))
            success.setText("Login successful");
        else
            success.setText("Credentials didn't match");
    }
}