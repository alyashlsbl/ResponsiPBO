
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


public class Dataa extends JFrame{
    
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
    
    JLabel Footer = new JLabel("APLIKASI PERHITUNGAN GAJI PT. VETERAN JAYA");
    
    JButton btnShow = new JButton("Show");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    
    JTable tabel;
    DefaultTableModel tabelModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID","Nama","Alamat","No Hp","Posisi","Gaji"};
    
    public Dataa(){
        
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
        
        tabelModel = new DefaultTableModel (namaKolom,0);
        tabel = new JTable(tabelModel);
        scrollPane = new JScrollPane(tabel);
        
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
       
        add(btnUpdate);
        btnUpdate.setBounds(200,400,120,70);
        add(btnShow);
        btnShow.setBounds(350,400,120,70);
        add(btnDelete);
        btnDelete.setBounds(500,400,120,70);
        
        add(Footer);
        Footer.setBounds(250, 500, 600, 50);
        Footer.setFont(new Font("Arial",Font.CENTER_BASELINE, 15));
        
        add(scrollPane);
        scrollPane.setBounds(150,100,600,200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
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
    
    int getBanyakData() {
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * from `admin`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            return jmlData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL error");
            return 0;
        }
    }

String[][] readAdmin() {
        try{
            int jmlData = 0;
            String data[][]=new String[getBanyakData()][6];
            String query = "Select * from `admin` ";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                data[jmlData][0] = resultSet.getString("idd");
                data[jmlData][1] = resultSet.getString("namaa");
                data[jmlData][2] = resultSet.getString("alamatt");
                data[jmlData][3] = resultSet.getString("no_hpp");
                data[jmlData][4] = resultSet.getString("posisii");
                data[jmlData][5] = resultSet.getString("gajii");
                
                jmlData++;
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL error");
            return null;
        }
    }
    
void deleteKaryawan(String id) {
        try{
            String query = "DELETE FROM `admin` WHERE `idd = '"+id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "berhasil dihapus" );
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
}
