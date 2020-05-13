
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class Data extends JFrame{
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbresponsi";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    JButton admin = new JButton("Admin");
    JButton home = new JButton("Home");
    JButton gaji = new JButton("Gaji");
    JButton data = new JButton("Data");
    JButton petunjuk= new JButton("Petunjuk");
    
    JButton btnShow = new JButton("Show");
    
    JTable tabel;
    DefaultTableModel tabelModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID Pegawai","Nama","Posisi","Gaji Pokok","Jam Lembur","Tunjangan","Total Gaji"};
    
    JLabel Footer = new JLabel("APLIKASI PERHITUNGAN GAJI PT. VETERAN JAYA");
    
    public Data(){
        
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
        add(gaji);
        gaji.setBounds(10,100,120,70);
        add(data);
        data.setBounds(10,180,120,70);
        add(petunjuk);
        petunjuk.setBounds(10,260,120,70);
        add(admin);
        admin.setBounds(700,20,120,70);
        add(Footer);
        Footer.setBounds(250, 500, 600, 50);
        Footer.setFont(new Font("Arial",Font.CENTER_BASELINE, 15));
        
        add(btnShow);
        btnShow.setBounds(350,400,120,70);
        add(scrollPane);
        scrollPane.setBounds(150,100,600,200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
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
        
         btnShow.addActionListener((ActionEvent e) -> {
          String[][] dataKaryawan = this.readKaryawan();
          tabel.setModel(new JTable(dataKaryawan,namaKolom).getModel());
        });
        
    }
    
    int getBanyakData() {
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * from `data_gaji`";
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

String[][] readKaryawan() {
        try{
            int jmlData = 0;
            String data[][]=new String[getBanyakData()][7];
            String query = "Select `idp`,`nama`,`posisi`,`gajipokok`,`lembur`,`tunjangan`,`totalgaji` from `data_gaji` ";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                data[jmlData][0] = resultSet.getString("idp");
                data[jmlData][1] = resultSet.getString("nama");
                data[jmlData][2] = resultSet.getString("posisi");
                data[jmlData][3] = resultSet.getString("gajipokok");
                data[jmlData][4] = resultSet.getString("lembur");
                data[jmlData][5] = resultSet.getString("tunjangan");
                data[jmlData][6] = resultSet.getString("totalgaji");
                jmlData++;
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL error");
            return null;
        }
    }
}
