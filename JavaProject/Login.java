import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Login extends JFrame implements ActionListener {
        JButton buttonLogin,buttonCreateAccount;
        JLabel labelUser,labelPassword;
        final JTextField userName;
        final JPasswordField password;
       Login(){
        //ImageIcon image=new ImageIcon("C:\\Login.JPG");

        Container container = this.getContentPane();
        GroupLayout groupLayout = new GroupLayout(container);
        container.setLayout(groupLayout);


        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        groupLayout.preferredLayoutSize(container);


        labelUser= new JLabel("UserName");
        labelPassword =new JLabel("Password");
        userName =new JTextField();

        password =new JPasswordField();
        buttonCreateAccount = new JButton("CreateAccount");
        buttonLogin = new JButton("Login");
        //buttonLogin.setIcon(image);
        //buttonLogin.setSize(200,200);

        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()

                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(labelUser)
                                .addComponent(labelPassword)
                        )
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(userName)
                                .addComponent(password)


                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(buttonLogin)
                                        .addComponent(buttonCreateAccount)
                                )
                        )
        );


        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()

                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelUser)
                                .addComponent(userName)
                        )

                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelPassword)
                                .addComponent(password)
                        )

                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonLogin)
                                .addComponent(buttonCreateAccount)
                        )
        );
        userName.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateStateButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateStateButton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateStateButton();
            }
        });
        password.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateStateButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateStateButton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateStateButton();
            }
        });
        buttonCreateAccount.addActionListener(this);
        buttonLogin.setEnabled(false);
        buttonLogin.addActionListener(this);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setVisible(true);
        this.setResizable(false);
    }
    private void updateStateButton(){
        String name=userName.getText();
        String PassWord=password.getText();
        buttonLogin.setEnabled(!name.isEmpty() && !PassWord.isEmpty());
    }
    @Override
    public void actionPerformed(ActionEvent e) {

           if(e.getSource()==buttonCreateAccount){
               new CreateAccount();
           }
           if(e.getSource()==buttonLogin) {
               String Password=password.getText();
               String UserName=userName.getText();
               if(!found(UserName,Password)){
                   JOptionPane.showMessageDialog(null,"Wrong UserName or PassWord ","ERROR",JOptionPane.ERROR_MESSAGE);
               }
               else{
                   dispose();
                   new List(UserName);
               }
           }
    }
    public boolean found(String name,String password){
        try {
            BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\Hasan\\IdeaProjects\\Swing\\src\\User.txt"));
            String line;
            while((line=reader.readLine())!=null){
                String []parts=line.split(",");
                if(name.equals(parts[0]) && password.equals(parts[1]))
                    return true;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}