import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Time;
import java.util.ArrayList;

public class List extends JFrame {
    JFrame frame;
    JButton bookTicketButton;
    JTextField textNumber;
    JLabel NumberOfChairLabel;
    ArrayList<Film1> movies = new ArrayList<>();

    List(String userName) {
        frame = new JFrame("Cinema Ticket System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        movies = createMovieList();

        JPanel moviePanel = createMoviePanel2();

        JPanel bookingPanel = createBookingPanel(userName);

        JPanel cancelBookingPanel = createCancelBookingPanel(userName);

        JPanel userDetails = createUserDetails(userName);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Movies", moviePanel);
        tabbedPane.addTab("Book Tickets", bookingPanel);
        tabbedPane.addTab("Cancel Booking", cancelBookingPanel);
        tabbedPane.addTab("User Details ",userDetails);

        frame.setResizable(false);
        frame.getContentPane().add(tabbedPane);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

     public JPanel createUserDetails(String userName){

        JPanel panel =new JPanel();
         JTextArea textArea =new JTextArea();
         textArea.setEnabled(false);
         JLabel userlabel =new JLabel();
         //userlabel.setText("User : "+userName+"                 Your Tickets ");
         panel.setLayout(new BorderLayout());
         JScrollPane scrollPane = new JScrollPane(textArea);
         textArea.setForeground(Color.black);
         ArrayList<String> tickets =new ArrayList<>();

         Timer timer =new Timer(0, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try{
                     int balance=0;
                     BufferedReader reader2 =new BufferedReader(new FileReader("C:\\Users\\Hasan\\IdeaProjects\\Swing\\src\\User.txt"));
                     String line2;
                     while((line2=reader2.readLine())!=null){
                         String []names=line2.split(",");
                         if(userName.equals(names[0])){
                             balance =Integer.parseInt(names[2]);
                             break;
                         }
                     }
                     userlabel.setText("User : "+userName+"                 Your Tickets         |              balance = "+ balance +"S.P");
                     textArea.replaceRange("",0,textArea.getText().length());
                     tickets.clear();
                     BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Hasan\\IdeaProjects\\Swing\\src\\Tickets.txt"));
                     String line;
                     while((line = reader.readLine())!=null){
                         String []parts=line.split(",");
                         if(parts[0].equals(userName))
                             tickets.add(parts[0]+"  ,  "+parts[1]+"  ,  "+parts[2]+"  Number of seats : "+Integer.parseInt(parts[3])+"  Number of Ticket : "+Integer.parseInt(parts[4]));
                     }
                     for(String t:tickets){
                         textArea.append(t+"\n");
                     }
                 }catch (IOException ex){
                     ex.printStackTrace();
                 }
             }
         });
         timer.start();

         panel.add(userlabel,BorderLayout.NORTH);
         panel.add(textArea,BorderLayout.CENTER);
         return panel;
     }

    public ArrayList<Film1> createMovieList() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Hasan\\IdeaProjects\\Swing\\src\\Films.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                movies.add(new Film1(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4]));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return movies;
    }

    public JPanel createMoviePanel2() {

        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(2, 3, 5, 5); // 2 rows, 3 columns
        panel.setLayout(gridLayout);

        // Row 1
        ImageIcon image1 = createImageIcon("C:\\Users\\Hasan\\Desktop\\image\\Home Alone.JPG");
        JLabel label1 = new JLabel(image1);
        JButton button1 = new JButton("show Information");
        JPanel rowPanel1 = new JPanel(new BorderLayout());
        rowPanel1.add(label1, BorderLayout.NORTH);
        rowPanel1.add(button1, BorderLayout.SOUTH);
        panel.add(rowPanel1);

        // Row 2
        ImageIcon image2 = createImageIcon("C:\\Users\\Hasan\\Desktop\\image\\The walking dead.JPG");
        JLabel label2 = new JLabel(image2);
        JButton button2 = new JButton("show Information");
        JPanel rowPanel2 = new JPanel(new BorderLayout());
        rowPanel2.add(label2, BorderLayout.NORTH);
        rowPanel2.add(button2, BorderLayout.SOUTH);
        panel.add(rowPanel2);

        // Row 3
        ImageIcon image3 = createImageIcon("C:\\Users\\Hasan\\Desktop\\image\\Doctor Who.JPG");
        JLabel label3 = new JLabel(image3);
        JButton button3 = new JButton("show Information");
        JPanel rowPanel3 = new JPanel(new BorderLayout());
        rowPanel3.add(label3, BorderLayout.NORTH);
        rowPanel3.add(button3, BorderLayout.SOUTH);
        panel.add(rowPanel3);

        // Row 4
        ImageIcon image4 = createImageIcon("C:\\Users\\Hasan\\Desktop\\image\\SpiderMan.JPG");
        JLabel label4 = new JLabel(image4);
        JButton button4 = new JButton("show Information");
        JPanel rowPanel4 = new JPanel(new BorderLayout());
        rowPanel4.add(label4, BorderLayout.NORTH);
        rowPanel4.add(button4, BorderLayout.SOUTH);
        panel.add(rowPanel4);

        // Row 5

        ImageIcon image5 = createImageIcon("C:\\Users\\Hasan\\Desktop\\image\\The Office.JPG");
        JLabel label5 = new JLabel(image5);
        JButton button5 = new JButton("show Information");
        JPanel rowPanel5 = new JPanel(new BorderLayout());
        rowPanel5.add(label5, BorderLayout.NORTH);
        rowPanel5.add(button5, BorderLayout.SOUTH);
        panel.add(rowPanel5);

        // Row 6
        ImageIcon image6 = createImageIcon("C:\\Users\\Hasan\\Desktop\\image\\Finestkind.JPG");
        JLabel label6 = new JLabel(image6);
        JButton button6 = new JButton("show Information");
        JPanel rowPanel6 = new JPanel(new BorderLayout());
        rowPanel6.add(label6, BorderLayout.NORTH);
        rowPanel6.add(button6, BorderLayout.SOUTH);
        panel.add(rowPanel6);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String letter = "An eight-year-old troublemaker, mistakenly left home alone, must defend his home against a pair of burglars on Christmas Eve.";
                String massge = "Movie name : Home Alone \n" + "Movie Kind : Comedy" + "\nshow Time First : 01:00 am to 02:45 pm \n" + "show Time Repaly :07:00 pm to 8:45 pm\n" + "Overview :\n" + letter + "\nits shown in Cinema Hall 1";
                JOptionPane.showMessageDialog(null, massge, "Movie Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String letter = "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. " +
                        "\nHe sets out to find his family and encounters many other survivors along the way.";
                String massge = "Movie name : The Walking Dead \n" + "Movie Kind : Action " + "\nshow Time First : 11:00 am to 12:45 pm \n" + "show Time Repaly : 05:00 pm to 06:45 pm\n" + "Overview :\n" + letter + "\nits shown in Cinema Hall 1";
                JOptionPane.showMessageDialog(null, massge, "Movie Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String letter = "The Doctor is a Time Lord: a 900 year old alien with 2 hearts, part of a gifted civilization who mastered time travel." +
                        " \nThe Doctor saves planets for a living—more of a hobby actually, and the Doctor's very, very good at it.";
                String massge = "Movie name : Doctor Who \n" + "Movie Kind : Drama " + "\nshow Time First : 03:00 am to 04:45 pm \n" + "show Time Repaly : 09:00 pm to 10:45 am\n" + "Overview :\n " + letter + "\nits shown in Cinema Hall 1";
                JOptionPane.showMessageDialog(null, massge, "Movie Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String letter = "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero." +
                        " \nWhen he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.";
                String massge = "Movie name : Spider Man \n" + "Movie Kind : Action" + "\nshow Time First : 11:00 am to 12:45 pm \n" + "show Time Repaly : 05:00 pm to 06:45 pm\n" + "Overview :\n" + letter + "\nits shown in Cinema Hall 2";
                JOptionPane.showMessageDialog(null, massge, "Movie Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String letter = "The everyday lives of office employees in the Scranton, Pennsylvania branch of the fictional Dunder Mifflin Paper Company.";
                String massge = "Movie name : The Office \n" + "Movie Kind : Comedy" + "\nshow Time First : 01:00 am to 02:45 pm \n" + "show Time Repaly :07:00 pm to 8:45 pm\n" + "Overview :\n" + letter + "\nits shown in Cinema Hall 2";
                JOptionPane.showMessageDialog(null, massge, "Movie Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String letter = "Two brothers are pulled into a deal with an organized crime syndicate in Boston.";
                String massge = "Movie name : Finestkind \n" + "Movie Kind : Drama " + "\nshow Time First : 03:00 am to 04:45 pm \n" + "show Time Repaly : 09:00 pm to 10:45 am\n" + "Overview :\n " + letter + "\nits shown in Cinema Hall 2";
                JOptionPane.showMessageDialog(null, massge, "Movie Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return panel;
    }

    private static ImageIcon createImageIcon(String fileName) {
        try {
            Image image = new ImageIcon(fileName).getImage();
            // You can scale the image if needed
            Image scaledImage = image.getScaledInstance(180, 250, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JPanel createBookingPanel(String userName) {
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        JLabel Movielabel = new JLabel("Choose Movie ");
        JComboBox<String> movieComboBox = new JComboBox<>();
        JLabel TimeLabel = new JLabel("Choose Time ");
        JComboBox<String> timeComboBox = new JComboBox<>();
        NumberOfChairLabel = new JLabel("Enter number of chairs ");
        textNumber = new JTextField(5);
        bookTicketButton = new JButton("Book Ticket");
        bookTicketButton.setEnabled(false);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(Movielabel)
                .addComponent(TimeLabel)
                .addComponent(NumberOfChairLabel)
                .addComponent(bookTicketButton)
        );
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(movieComboBox)
                .addComponent(timeComboBox)
                .addComponent(textNumber)
        );
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(Movielabel)
                .addComponent(movieComboBox)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(TimeLabel)
                .addComponent(timeComboBox)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(NumberOfChairLabel)
                .addComponent(textNumber)
        );
        vGroup.addComponent(bookTicketButton);
        layout.setVerticalGroup(vGroup);

        panel.add(Movielabel);
        panel.add(movieComboBox);
        panel.add(TimeLabel);
        panel.add(timeComboBox);
        panel.add(NumberOfChairLabel);
        panel.add(textNumber);
        panel.add(bookTicketButton);

        for (Film1 movie : movies) {
            movieComboBox.addItem(movie.getMoveName());
        }

        movieComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMovie = (String) movieComboBox.getSelectedItem();
                for (Film1 movie : movies) {
                    if (movie.getMoveName().equals(selectedMovie)) {
                        timeComboBox.removeAllItems();
                        timeComboBox.addItem(movie.getShowTimesFirst().time);
                        timeComboBox.addItem(movie.getShowTimesReplay().time);
                        break;
                    }
                }
            }
        });
        textNumber.getDocument().addDocumentListener(
                new DocumentListener() {
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
                }
        );
        bookTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMovie="";
                String selectedTime="";
                boolean integer = true;
                int selectedNumberOfChair = 0,balance=0;
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Hasan\\IdeaProjects\\Swing\\src\\User.txt"));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if(userName.equals(parts[0])){
                            balance=Integer.parseInt(parts[2]);
                           break;
                        }
                    }
                }catch (IOException ex){
                    ex.printStackTrace();
                }
                try {
                     selectedMovie = (String) movieComboBox.getSelectedItem();
                     selectedTime = (String) timeComboBox.getSelectedItem();
                    selectedNumberOfChair = Integer.parseInt(textNumber.getText());
                    if(selectedNumberOfChair <= 0) {
                        integer = false;
                        JOptionPane.showMessageDialog(null, "Please Enter Positive Number ", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException exception) {
                    integer = false;
                    JOptionPane.showMessageDialog(null, "Please enter number not string", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                if (integer)
                    new Ticketing().TicketBooking(userName,balance, selectedMovie, selectedTime, selectedNumberOfChair, movies);
            }
        });
        return panel;
    }


    private JPanel createCancelBookingPanel(String userName) {
        JPanel panel = new JPanel();

        JLabel TicketLabel = new JLabel("Enter TicketNumber :");
        JTextField TicketNumber = new JTextField(5);
        JButton cancelTicket = new JButton("Cancel Ticket");

        panel.add(TicketLabel);
        panel.add(TicketNumber);
        panel.add(cancelTicket);

        cancelTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ticket = 0;
                try {
                    ticket = Integer.parseInt(TicketNumber.getText());
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Please Enter Positive number ");
                }
                if (Ticketing.CancelTicket(ticket, movies, userName)) {
                    Ticketing.WriteInFileTickets();
                    JOptionPane.showMessageDialog(null, "The ticket has been cancelled", "Cancel Ticket", JOptionPane.INFORMATION_MESSAGE);
                } else
                    JOptionPane.showMessageDialog(null, "There is no ticket with this number on your account", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
        return panel;

    }

    public void updateStateButton() {
        String text = textNumber.getText();
        if (!text.isEmpty())
            bookTicketButton.setEnabled(true);
    }

}
