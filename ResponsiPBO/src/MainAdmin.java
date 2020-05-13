
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class MainAdmin extends JFrame{
    
    JButton karyawan = new JButton("Karyawan");
    JButton home = new JButton("Home");
    JButton tambah = new JButton("Tambah");
    JButton data = new JButton("Data");
    JButton petunjuk = new JButton("Petunjuk");
    
    JLabel Footer = new JLabel("APLIKASI PERHITUNGAN GAJI PT. VETERAN JAYA");
    
    JTextArea teks = new JTextArea(" Selamat Datang ADMIN,\n Silahkan masuk ke menu tambah untuk memasukan data baru.\n Jika mengalami kesulitan klik menu petunjuk");
    
    public MainAdmin(){
        
        add(home);
        home.setBounds(10,20,120,70);
        add(tambah);
        tambah.setBounds(10,100,120,70);
        add(data);
        data.setBounds(10,180,120,70);
        add(petunjuk);
        petunjuk.setBounds(10,260,120,70);
        add(karyawan);
        karyawan.setBounds(700,20,120,70);
        add(teks);
        teks.setBounds(150, 100, 600, 300);
        
        add(Footer);
        Footer.setBounds(250, 500, 600, 50);
        Footer.setFont(new Font("Arial",Font.CENTER_BASELINE, 15));
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setSize(850,580);
        setLocation(225,75);
        
        home.addActionListener((ActionEvent e) -> {
          MainAdmin a = new MainAdmin();
           dispose();
        });
        tambah.addActionListener((ActionEvent e) -> {
          Tambah b = new Tambah();
           dispose();
        });
        data.addActionListener((ActionEvent e) -> {
          Dataa c = new Dataa();
           dispose();
        });
        petunjuk.addActionListener((ActionEvent e) -> {
          Petunjukk d = new Petunjukk();
           dispose();
        });
        karyawan.addActionListener((ActionEvent e) -> {
          MainKaryawan d = new MainKaryawan();
           dispose();
        });
    }
}
