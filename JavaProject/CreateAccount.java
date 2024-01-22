import javax.security.auth.login.AccountNotFoundException;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.NumberFormat;

public class CreateAccount extends JFrame implements ActionListener{
    JLabel UserAccount,AccountPassword,Balance;
    final JTextField userAccountText,BalanceText;
    final JPasswordField AccountPasswordText;
    JButton button;
    CreateAccount(){
        Container container =this.getContentPane();
        GroupLayout grouplayout=new GroupLayout(container);
        container.setLayout(grouplayout);

        grouplayout.setAutoCreateContainerGaps(true);
        grouplayout.preferredLayoutSize(container);

        UserAccount =new JLabel("UserAccount");
        AccountPassword =new JLabel("AccountPassword");
        Balance = new JLabel("Balance");

        userAccountText=new JTextField();
        AccountPasswordText=new JPasswordField();
        BalanceText = new JTextField();
        button=new JButton("Ok");


        grouplayout.setHorizontalGroup(
                grouplayout.createSequentialGroup()
                        .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(UserAccount)
                                .addComponent(AccountPassword)
                                .addComponent(Balance)
                        )
                        .addGap(20)
                        .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(userAccountText)
                                .addComponent(AccountPasswordText)
                                .addComponent(BalanceText)
                                .addComponent(button)
                        )
        );
        grouplayout.setVerticalGroup(
                grouplayout.createSequentialGroup()
                        .addGap(15)
                        .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(UserAccount)
                                .addComponent(userAccountText)
                        )
                        .addGap(15)
                        .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(AccountPassword)
                                .addComponent(AccountPasswordText)
                        )
                        .addGap(15)
                        .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(Balance)
                                .addComponent(BalanceText)
                        )
                        .addGroup(grouplayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button)
                        )
                        .addGap(15)


        );
        button.setEnabled(false);
        BalanceText.getDocument().addDocumentListener(new DocumentListener() {
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
        userAccountText.getDocument().addDocumentListener(new DocumentListener() {
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
        AccountPasswordText.getDocument().addDocumentListener(new DocumentListener() {
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

        this.setResizable(false);
        button.addActionListener(this);
        this.setSize(400,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void updateStateButton(){
        String Account=userAccountText.getText();
        String AccountPassword=AccountPasswordText.getText();
        String Balance=BalanceText.getText();
        button.setEnabled( !Account.isEmpty() && !AccountPassword.isEmpty() && !Balance.isEmpty());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
          int balance=0;
           if(e.getSource()==button)
          {
              try{
                  balance=Integer.parseInt(BalanceText.getText());
                  if(balance<=0)
                      throw new NumberFormatException();
              }catch (NumberFormatException ex){
                  JOptionPane.showMessageDialog(null,"Enter positive number");
              }
              User user= new User(userAccountText.getText(),AccountPasswordText.getText(),balance);
              if(!found(userAccountText.getText()))
              {
                  try{
                      BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\Hasan\\IdeaProjects\\Swing\\src\\User.txt",true));
                      writer.write(user.UserAccount+","+user.AccountPassWord+","+user.balance );
                      writer.flush();
                      writer.newLine();
                      writer.close();
                      this.dispose();
                  }catch(FileNotFoundException ex){
                      ex.printStackTrace();
                  }
                  catch (IOException ee){
                      ee.printStackTrace();
                  }
              }else{
                  JOptionPane.showMessageDialog(null,"UserName is Used ,Please Enter Another UserName","ERROR",JOptionPane.ERROR_MESSAGE);
              }
          }
    }

    public boolean found(String name){
        try {
            BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\Hasan\\IdeaProjects\\Swing\\src\\User.txt"));
            String line;
            while((line=reader.readLine())!=null){
                String []parts=line.split(",");
                if(name.equals(parts[0]))
                    return true;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
