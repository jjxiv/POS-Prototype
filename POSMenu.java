import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class POSMenu implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JTextField statusText;
    JTextArea totalText;
    JTextArea totalPrice;
    JLabel orderTitle = new JLabel();
    JLabel itemList = new JLabel();
    JLabel status = new JLabel();
    JLabel quantity = new JLabel();
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[2];
    JButton delButton, clrButton, addItem, delItem, printReceipt, restart;
    JPanel panel;
    ImageIcon img = new ImageIcon("grocery.png");

    Font myFont = new Font("Arial",Font.PLAIN,16);
    Font title = new Font("Arial",Font.BOLD,20);
    Font textFont = new Font("Arial",Font.BOLD,18);
    Font total = new Font("Arial",Font.BOLD,30);
    String previous = null;
    double result=0;
    int count = 0;
    char operator;

    POSMenu(){
        frame = new JFrame("GROCERY SYSTEM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 550);
        frame.getContentPane().setBackground(Color.decode("#3297a8"));
        frame.setLayout(null);
        frame.setIconImage(img.getImage());
        frame.setResizable(false);

        textfield = new JTextField();
        textfield.setBounds(10, 40, 300, 40);
        textfield.setFont(myFont);
        textfield.setBackground(Color.decode("#f0f0f0"));
        textfield.setEditable(false);

        statusText = new JTextField();
        statusText.setBounds(70, 90, 240,20);
        statusText.setFont(myFont);
        statusText.setBackground(Color.decode("#474646"));
        statusText.setForeground(Color.GREEN);
        statusText.setEditable(false);

        totalText = new JTextArea();
        totalText.setBounds(330,40,340,335);
        totalText.setFont(textFont);
        totalText.setBackground(Color.decode("#f0f0f0"));
        totalText.setEditable(false);
        totalText.setText("======================================\n");
        totalText.setText(totalText.getText() + "ORDER ID      PRODUCT        PRICE\n");

        totalPrice = new JTextArea();
        totalPrice.setBounds(330,385,340,38);
        totalPrice.setFont(total);
        totalPrice.setBackground(Color.decode("#f0f0f0"));
        totalPrice.setEditable(false);
        totalPrice.setText("TOTAL:                "+"0.0");



        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        addItem = new JButton("Add Item");
        delItem = new JButton("Delete Item");
        restart = new JButton("Restart");
        printReceipt = new JButton ("End");
        functionButtons[0] = delButton;
        functionButtons[1] = clrButton;

        for(int i =0;i<2;i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(textFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i =0;i<10;i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(textFont);
            numberButtons[i].setFocusable(false);
        }

        //delButton.setBounds(100,430,100,50);
        //clrButton.setBounds(200,430,100,50);

        panel = new JPanel();
        panel.setBounds(10, 120, 300, 300);
        panel.setLayout(new GridLayout(4,3,10,10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(numberButtons[0]);
        panel.add(delButton);
        panel.add(clrButton);


        //JLabel: TITLE
        orderTitle.setText("ITEM SERIAL NUMBER");
        orderTitle.setBounds(10,0,400,50);
        orderTitle.setFont(title);
        orderTitle.setForeground(Color.WHITE);

        //JLabel: STATUS
        status.setText("STATUS: ");
        status.setBounds(10,75,400,50);
        status.setForeground(Color.WHITE);

        //JLABEL: ITEMLIST
        itemList.setText("ITEM LIST");
        itemList.setBounds(330,0,400,50);
        itemList.setFont(title);
        itemList.setForeground(Color.WHITE);


        //JBUTTON: add item
        addItem.setBounds(10,430,145,70);
        addItem.addActionListener(this);
        addItem.setFocusable(false);
        addItem.setFont(title);

        //JBUTTON: restart

        restart.setBounds(165,430,145,70);
        restart.addActionListener(this);
        restart.setFocusable(false);
        restart.setFont(title);


        //JBUTTON: delItem
        delItem.setBounds(330,430,200,70);
        delItem.addActionListener(this);
        delItem.setFocusable(false);
        delItem.setFont(title);

        //JBUTTON: printReceipt
        printReceipt.setBounds(540,430,130,70);
        printReceipt.addActionListener(this);
        printReceipt.setFocusable(false);
        printReceipt.setFont(title);

        frame.add(printReceipt);
        frame.add(delItem);
        frame.add(restart);
        frame.add(itemList);
        frame.add(totalText);
        frame.add(totalPrice);
        frame.add(status);
        frame.add(addItem);
        frame.add(statusText);
        frame.add(orderTitle);
        frame.add(panel);
        //frame.add(delButton);
        //frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        POSMenu menu = new POSMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++) {
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==clrButton) {
            textfield.setText("");
        }
        if(e.getSource()==delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++) {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
        if(e.getSource() == addItem){
            String id = textfield.getText();
            previous = totalText.getText();
            System.out.println("previous is:" + previous);
            if (count > 15){
                System.out.println("Cart is full!");
            }
            else if(id.equals("12345") && count < 10){
                count++;
                totalText.setText(totalText.getText() + id + " " + "            Apple " + "                 100\n");
                System.out.println("Current count is: " + count);
                statusText.setText("ID added to item list!");
                result+=100;
                totalPrice.setText("TOTAL:                "+result);
            }
            else if(id.equals("45678") && count < 10){
                count++;
                totalText.setText(totalText.getText() + id + " " + "            Orange" + "                 90\n");
                System.out.println("Current count is: " + count);
                statusText.setText("ID added to item list!");
                result+=90;
                totalPrice.setText("TOTAL:                "+result);
            }
            else if(id.equals("98765") && count < 10){
                count++;
                totalText.setText(totalText.getText() + id + " " + "            Banana" + "                 60\n");
                System.out.println("Current count is: " + count);
                statusText.setText("ID added to item list!");
                result+=60;
                totalPrice.setText("TOTAL:                "+result);
            }
            else{
                statusText.setText("ID not found!");
            }
            textfield.setText("");
        }
        if (e.getSource() == delItem){
            if (count == 0){
                ;
            }
            else{
                totalText.setText(previous);
                count--;
                System.out.println("Current count is: " + count);
            }

        }
        if(e.getSource() == restart){
            totalText.setText("======================================\n");
            totalText.setText(totalText.getText() + "ORDER ID      PRODUCT        PRICE\n");
            result=0;
            totalPrice.setText("TOTAL:                "+result);
            count=0;
        }
        if(e.getSource() == printReceipt){
            frame.dispose();
        }
    }
}
