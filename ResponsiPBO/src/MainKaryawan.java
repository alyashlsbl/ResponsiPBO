
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class MainKaryawan extends JFrame{
    
    JTextArea welcome = new JTextArea("Selamat Datang! \n Silakan masuk ke menu Gaji untuk melakukan perhitungan gaji. \n Jika mengalami kesulitan klik menu Petunjuk");
    
    JButton admin = new JButton("Admin");
    JButton home = new JButton("Home");
    JButton gaji = new JButton("Gaji");
    JButton data = new JButton("Data");
    JButton petunjuk= new JButton("Petunjuk");
    
    JLabel Footer = new JLabel("APLIKASI PERHITUNGAN GAJI PT. VETERAN JAYA");
    
    public MainKaryawan(){
        
        add(home);
        home.setBounds(10,20,120,70);
        add(gaji);
        gaji.setBounds(10,100,120,70);
        add(data);
        data.setBounds(10,180,120,70);
        add(petunjuk);
        petunjuk.setBounds(10,260,120,70);
        add(admin);
        admin.setBounds(700,20,120,70);
        add(welcome);
        welcome.setBounds(150, 100, 600, 300);
        
        add(Footer);
        Footer.setBounds(250, 500, 600, 50);
        Footer.setFont(new Font("Arial",Font.CENTER_BASELINE, 15));
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setSize(850,580);
        setLocation(225,75);
       
        home.addActionListener((ActionEvent e) -> {
          MainKaryawan a = new MainKaryawan();
           dispose();
        });
        gaji.addActionListener((ActionEvent e) -> {
          Gaji b = new Gaji();
           dispose();
        });
        data.addActionListener((ActionEvent e) -> {
          Data c = new Data();
           dispose();
        });
        petunjuk.addActionListener((ActionEvent e) -> {
          Petunjuk d = new Petunjuk();
           dispose();
        });
        admin.addActionListener((ActionEvent e) -> {
          MainAdmin d = new MainAdmin();
           dispose();
        });
    }
    
}
