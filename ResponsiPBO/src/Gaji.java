
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Gaji extends JFrame {
    
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
    JButton btnHitung = new JButton("Hitung");
    JButton btnSimpan = new JButton("Simpan");
    
    JLabel id = new JLabel("ID Pegawai");
    JLabel nama = new JLabel("Nama");
    JLabel lposisi = new JLabel("Posisi");
    JLabel alamat = new JLabel("Alamat");
    JLabel no_hp = new JLabel("No HP");
    JLabel gajipokok = new JLabel("Gaji Pokok");
    JLabel lembur = new JLabel("Jam Lembur");
    JLabel tunjangan = new JLabel("Tunjangan");
    JLabel pajak = new JLabel("Pajak");
    JLabel totalgaji = new JLabel("Total Gaji");
    
    JTextField tfid = new JTextField("");
    JTextField tfnama = new JTextField("");
    JTextField tfalamat = new JTextField("");
    JTextField tfno_hp = new JTextField("");
    JTextField tfgajipokok = new JTextField("");
    JTextField tflembur = new JTextField("");
    JTextField tftunjangan = new JTextField("");
    JTextField tfpajak = new JTextField("");
    JTextField tftotalgaji = new JTextField("");
    
    
    String csposisi[] = {"Direktur","Manager","Programmer","Marketing","Surveyor"};
    JComboBox cbposisi = new JComboBox(csposisi);
    
    JLabel Footer = new JLabel("APLIKASI PERHITUNGAN GAJI PT. VETERAN JAYA");
 
    public Gaji(){
        
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
        
        add(btnHitung);
        btnHitung.setBounds(700,380,120,70);
        add(btnSimpan);
        btnSimpan.setBounds(700,450,120,70);
        
        add(id);
        id.setBounds(150,50,90,20);
        add(tfid);
        tfid.setBounds(250,50,200,20);
        add(nama);
        nama.setBounds(150,80,90,20);
        add(tfnama);
        tfnama.setBounds(250,80,200,20);
        add(lposisi);
        lposisi.setBounds(150,110,100,20);
        add(cbposisi);
        cbposisi.setBounds(250,110,100,20);
        add(alamat);
        alamat.setBounds(150,140,90,20);
        add(tfalamat);
        tfalamat.setBounds(250,140,200,20);
        add(no_hp);
        no_hp.setBounds(150,170,90,20);
        add(tfno_hp);
        tfno_hp.setBounds(250,170,200,20);
        add(gajipokok);
        gajipokok.setBounds(150,200,90,20);
        add(tfgajipokok);
        tfgajipokok.setBounds(250,200,200,20);
        add(lembur);
        lembur.setBounds(150,230,90,20);
        add(tflembur);
        tflembur.setBounds(250,230,200,20);
        add(tunjangan);
        tunjangan.setBounds(150,260,90,20);
        add(tftunjangan);
        tftunjangan.setBounds(250,260,200,20);
        add(pajak);
        pajak.setBounds(150,290,90,20);
        add(tfpajak);
        tfpajak.setBounds(250,290,200,20);
        add(totalgaji);
        totalgaji.setBounds(150,320,90,20);
        add(tftotalgaji);
        tftotalgaji.setBounds(250,320,200,20);
        
        
        
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
        
        btnSimpan.addActionListener((ActionEvent e) -> {
            if (tfid.getText().equals("") ) {
                JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
            } else {
                String id = tfid.getText();
                String nama = tfnama.getText();
                String posisi = (String) cbposisi.getSelectedItem();
                String alamat = tfalamat.getText();
                String no_hp = tfno_hp.getText();
                long gajipokok = Long.parseLong(tfgajipokok.getText());
                long lembur = Long.parseLong(tflembur.getText());
                long tunjangan = Long.parseLong(tftunjangan.getText());
                long pajak = Long.parseLong(tfpajak.getText());
                long totalgaji = Long.parseLong(tftotalgaji.getText());
                
                
                this.insertKaryawan(id,nama,posisi,alamat,no_hp,gajipokok,lembur,tunjangan,totalgaji);
                
            }
        });
        
        
        btnHitung.addActionListener((ActionEvent e) -> {
                long gajipokok = Long.parseLong(tfgajipokok.getText());
                long lembur = Long.parseLong(tflembur.getText());
                try {
                      long tunjangan = lembur*15000;
                      long pajak = gajipokok/100;
                      long totalgaji = gajipokok+tunjangan - pajak ;
                      
                      tftunjangan.setText(Long.toString(tunjangan));
                      tfpajak.setText(Long.toString(pajak));
                      tftotalgaji.setText(Long.toString(totalgaji));
                      
                } catch (Exception a) {
                    System.out.println(a.getMessage());
                }


                   });
        
    }

   public void insertKaryawan(String id ,String nama, String posisi,String alamat, String no_hp, long gajipokok, long lembur, long tunjangan, long totalgaji) {
        try{
            String query = "INSERT INTO `data_gaji`(`idp`,`nama`,`posisi`,`alamat`,`no_hp`,`gajipokok`,`lembur`,`tunjangan`,`totalgaji`) VALUES ('"+id+"','"+nama+"','"+posisi+"','"+alamat+"','"+no_hp+"','"+gajipokok+"','"+lembur+"','"+tunjangan+"','"+totalgaji+"')";
        statement = (Statement) koneksi.createStatement();
        statement.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"Data berhasil ditambahkan");
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
        
    }
}
