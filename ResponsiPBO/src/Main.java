
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Main {
    
    public static void main(String[] args) {
        // TODO code application logic here
        MainKaryawan a = new MainKaryawan();
    }
    
}

class Admin extends JFrame {
    
   String pass="admin";
   final JTextField tfuser = new JTextField(10);
   final JPasswordField tfpass = new JPasswordField(10);

   JLabel luser = new JLabel("Username");
   JLabel lpass = new JLabel("Password");
   JButton btnLogin = new JButton("Login");
   JButton btnBack = new JButton("Cancel");

public Admin() {
    
setTitle("LOGIN");
setDefaultCloseOperation(3);
setSize(350,200);
setLocation(500,275);
setLayout(null);
add(luser);
add(tfuser);
add(lpass);
add(tfpass);
add(btnLogin);
add(btnBack);
luser.setBounds(10,15,120,20);
tfuser.setBounds(140,10,150,30);
lpass.setBounds(10,55,120,20);
tfpass.setBounds(140,50,150,30);
btnLogin.setBounds(130,100,100,30);
btnBack.setBounds(235,100,100,30);

btnBack.addActionListener((ActionEvent e) -> {
          MainKaryawan a = new MainKaryawan();
           dispose();
        });
        
btnLogin.addActionListener((ActionEvent e) -> {
    if(tfuser.getText().equalsIgnoreCase("admin") && pass.equalsIgnoreCase(tfpass.getText()))
    {   JOptionPane.showMessageDialog(null, "Berhasil Login");
        MainAdmin g = new MainAdmin();
        
        dispose();}
    else 
    {
        JOptionPane.showMessageDialog(null, "username atau password salah");
    }
    
});
        setVisible(true);
}
}
