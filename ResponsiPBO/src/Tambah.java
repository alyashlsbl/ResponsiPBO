
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Tambah extends JFrame{
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbresponsi";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    JButton karyawan = new JButton("Karyawan");
    JButton home = new JButton("Home");
    JButton tambah = new JButton("Tambah");
    JButton data = new JButton("Data");
    JButton petunjuk = new JButton("Petunjuk");
    
    JButton btnSimpan = new JButton("Simpan");
    
    JLabel Footer = new JLabel("APLIKASI PERHITUNGAN GAJI PT. VETERAN JAYA");
    
    JLabel lID = new JLabel("ID Pegawai");
    JTextField tfID = new JTextField();
    JLabel lNama = new JLabel("Nama");
    JTextField tfNama = new JTextField();
    JLabel lAlamat = new JLabel("Alamat");
    JTextField tfAlamat = new JTextField();
    JLabel lNo_hp = new JLabel("No Hp");
    JTextField tfNo_hp = new JTextField();
    JLabel lGaji = new JLabel("Gaji Pokok");
    JTextField tfGaji = new JTextField();
    JLabel lPosisi = new JLabel("Posisi");
    JTextField tfPosisi = new JTextField();
    
    public Tambah(){
        
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Koneksi Berhasil");
        }catch(ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setSize(850,580);
        setLocation(225,75);
        
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
        
        add(btnSimpan);
        btnSimpan.setBounds(700,450,120,70);
        
        add(Footer);
        Footer.setBounds(250, 500, 600, 50);
        Footer.setFont(new Font("Arial",Font.CENTER_BASELINE, 15));
        add(lID);
        lID.setBounds(150,50,90,20);
        add(tfID);
        tfID.setBounds(250,50,200,20);
        add(lNama);
        lNama.setBounds(150,80,90,20);
        add(tfNama);
        tfNama.setBounds(250,80,200,20);
        add(lAlamat);
        lAlamat.setBounds(150,110,90,20);
        add(tfAlamat);
        tfAlamat.setBounds(250,110,200,20);
        add(lNo_hp);
        lNo_hp.setBounds(150,140,90,20);
        add(tfNo_hp);
        tfNo_hp.setBounds(250,140,200,20);
        add(lPosisi);
        lPosisi.setBounds(150,170,90,20);
        add(tfPosisi);
        tfPosisi.setBounds(250,170,200,20);
        add(lGaji);
        lGaji.setBounds(150,200,90,20);
        add(tfGaji);
        tfGaji.setBounds(250,200,200,20);
        
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
        
        tfID.addActionListener((ActionEvent e) -> {
    String id = tfID.getText();
    try {
        String query = "SELECT * FROM `karyawan` WHERE `ID` = '" + id + "'";
        statement = koneksi.createStatement();
        ResultSet resultSet = statement.executeQuery(query); 
        while (resultSet.next()) { 
            tfNama.setText(resultSet.getString("Nama")); 
            tfAlamat.setText(resultSet.getString("Alamat")); 
            tfNo_hp.setText(resultSet.getString("No_hp")); 
            tfPosisi.setText(resultSet.getString("Posisi"));
            tfGaji.setText(resultSet.getString("Total_gaji")); 
            
            
        }
    } catch (SQLException sql) {
        System.out.println(sql.getMessage());
    }
       });
        btnSimpan.addActionListener((ActionEvent e) -> {
            if (tfID.getText().equals("") ) {
                JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
            } else {
                String id = tfID.getText();
                String nama = tfNama.getText();
                String posisi = tfPosisi.getText();
                String alamat = tfAlamat.getText();
                String no_hp = tfNo_hp.getText();
                long gaji = Long.parseLong(tfGaji.getText());
                
                
                
                this.insertAdmin(id,nama,alamat,no_hp,posisi,gaji);
                
            }
        });
        
    }
    public void insertAdmin(String id ,String nama, String alamat, String no_hp ,String posisi, long gaji) {
        try{
            String query = "INSERT INTO `admin`(`idd`,`namaa`,`alamatt`,`no_hpp`,`posisii`,`gajii`) VALUES ('"+id+"','"+nama+"','"+alamat+"','"+no_hp+"','"+posisi+"','"+gaji+"')";
        statement = (Statement) koneksi.createStatement();
        statement.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"Data berhasil ditambahkan");
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
        
    }
    
}
