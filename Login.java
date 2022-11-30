import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Login implements ActionListener{
    //Initialized class
    JLabel label = new JLabel();
    JLabel username = new JLabel();
    JLabel password= new JLabel();
    JFrame frame = new JFrame();
    JTextField userText = new JTextField();
    JTextField passText = new JTextField();
    JButton submit = new JButton("Log In");
    ImageIcon img = new ImageIcon("grocery.png");

    //data types
    String userDefault = "admin";
    String passDefault = "2022jj2022";
    String user, pass;


    //default font
    Font myFont = new Font("Arial",Font.BOLD,30);
    Font loginFont = new Font ("Arial", Font.PLAIN,16);

    Login(){
        //frame settings
        frame.setTitle("Login");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480,300);
        frame.getContentPane().setBackground(Color.decode("#3297a8"));
        frame.setIconImage(img.getImage());
        frame.setResizable(false);

        //label: GROCERY SHOPPING
        label.setText("GROCERY SHOPPING");
        label.setFont(myFont);
        label.setBounds(80,30,400,50);
        label.setOpaque(true);
        label.setBackground(Color.decode("#3297a8"));
        label.setForeground(Color.WHITE);

        //label: USERNAME
        username.setText("Username: ");
        username.setFont(loginFont);
        username.setBounds(55,90,80,40);
        username.setOpaque(true);
        username.setBackground(Color.decode("#3297a8"));
        username.setForeground(Color.WHITE);

        //text field: USERNAME
        userText.setBounds(138,100,220,20);
        userText.setFont(loginFont);

        //label: PASSWORD
        password.setText("Password: ");
        password.setFont(loginFont);
        password.setBounds(55,120,80,40);
        password.setOpaque(true);
        password.setBackground(Color.decode("#3297a8"));
        password.setForeground(Color.WHITE);

        //text field: PASSWORD
        passText.setBounds(138,130,220,20);
        passText.setFont(loginFont);

        //submit button
        submit.addActionListener(this);
        submit.setFont(loginFont);
        submit.setFocusable(false);
        submit.setBounds(180, 170, 120,30);

        //add contents to FRAME
        frame.add(label);
        frame.add(username);
        frame.add(userText);
        frame.add(password);
        frame.add(passText);
        frame.add(submit);

        frame.setVisible(true);
    }

    public static void main(String args[]){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == submit){
            user = userText.getText();
            pass = passText.getText();
            if(userDefault.equals(user) && passDefault.equals(pass)){
                System.out.println("LOGIN SUCCESSFUL!");
                System.out.println(user);
                System.out.println(pass);
                //POSMenu menu = new POSMenu();
                POSMenu menu = new POSMenu();
                frame.dispose();
            }
            else{
                System.out.println("LOGIN FAILED!");
                System.out.println(user);
                System.out.println(pass);
                JOptionPane.showMessageDialog(null,"Incorrect password, please re-type! ", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
