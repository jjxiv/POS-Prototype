import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class textfieldTest implements ActionListener{
    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JButton button = new JButton();
    JTextArea text = new JTextArea();

    textfieldTest(){
        //JFRAME: frame settings
        frame.setVisible(true);
        frame.setSize(1080,1920);
//        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //JTEXTAREA
        text.setText("HI WORLD!\n");
        text.setText(text.getText()+"JERICHO JOHN ALMORO" + "\nOK BYE!");
        text.setBounds(10,0,400,600);
        text.setEditable(false);

        frame.add(text);
    }

    public static void main(String [] args){
        textfieldTest text = new textfieldTest();
    }

    @Override
    public void actionPerformed(ActionEvent e){
//        if(e.getSource() = ){
//
//        }
    }


}
