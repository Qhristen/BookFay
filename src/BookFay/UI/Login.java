/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookFay.UI;
import BookFay.DBconnection.BookFayConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Qhris
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login1
     */
    public Login() {
        initComponents();
    }
    int cnt=3;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        close = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        LoginBut = new keeptoo.KButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        UserName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        kGradientPanel1.setBackground(new java.awt.Color(0, 102, 255));
        kGradientPanel1.setForeground(new java.awt.Color(102, 0, 102));
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(153, 153, 0));
        kGradientPanel1.setkFillBackground(false);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 204, 204));
        kGradientPanel1.setkTransparentControls(false);
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setText("x");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        kGradientPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 16, -1));

        minimize.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        minimize.setForeground(new java.awt.Color(255, 255, 255));
        minimize.setText("-");
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        kGradientPanel1.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 10, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Name");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 77, 21));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 77, 21));

        Password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kGradientPanel1.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 280, 34));

        LoginBut.setText("Login");
        LoginBut.setkBackGroundColor(new java.awt.Color(51, 0, 153));
        LoginBut.setkEndColor(new java.awt.Color(0, 102, 153));
        LoginBut.setkFillButton(false);
        LoginBut.setkHoverEndColor(new java.awt.Color(51, 255, 255));
        LoginBut.setkHoverForeGround(new java.awt.Color(153, 153, 255));
        LoginBut.setkHoverStartColor(new java.awt.Color(51, 0, 255));
        LoginBut.setkSelectedColor(new java.awt.Color(153, 153, 255));
        LoginBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButActionPerformed(evt);
            }
        });
        kGradientPanel1.add(LoginBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 244, 280, 50));

        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("BOOKFAY- Library Books  Management System");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 345, 240, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookFay/Image/ln.png"))); // NOI18N
        kGradientPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 320, 300));
        kGradientPanel1.add(UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 280, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked

    }//GEN-LAST:event_minimizeMouseClicked

 
    
    private void LoginButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButActionPerformed

        try{
            
            Connection con = BookFayConnection.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement ("SELECT * FROM login WHERE name=? and password=?");
            ps.setString(1, UserName.getText());
            ps.setString(2, Password.getText());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String UserType = rs.getString("user_type");
                    if(UserType.equals("librarian")){
                        new Librarian().setVisible(true);
                            dispose();
                    }else if(UserType.equals("admin")){
                        new Admin().setVisible(true);
                             dispose();
             
                    }
//                    else if(UserType.equals("student")){
//                         new StudentUI().setVisible(true);
//                                 dispose();
//                        
//                        
//                    }
                         
                     
                     
//                     if("librarian".equals(rs.getString("user"))){
//                         new Librarian().setVisible(true);
//                            dispose();
//                     }else if("student".equals(rs.getString("user"))){
//                              new StudentUI().setVisible(true);
//                                 dispose();
//                     }else if("admin".equals(rs.getString("user"))){
//                         new Admin().setVisible(true);
//                    dispose();
//                     }
//                    
                    
//               
//            }else if(rs.equals("student")){
//            ps = con.prepareStatement("select stdmatric,stdpass from student where stdmatric=? and stdpass=?");
//            ps.setString(1, UserName.getText());
//            ps.setString(2, Password.getText());
//             rs = ps.executeQuery();
//
//                              new StudentUI().setVisible(true);
//                                 dispose();
//                     }else if(UserName.getText().equals("admin")){
//                        ps = con.prepareStatement("select name,password from login where name=? and password=?");
//                        ps.setString(1, UserName.getText());
//                        ps.setString(2, Password.getText());
//                        System.out.println(ps);
//                        rs = ps.executeQuery();
//                         new Admin().setVisible(true);
//                             dispose();
                     }
            
        else {
                cnt--;
                if(cnt>0)
                JOptionPane.showMessageDialog(null, "		Error...! in Login Try Again No of Trys left "+ cnt);
                else {
                    JOptionPane.showMessageDialog(null, "		Error...! in Login.... Software is Quitting..!");
                    System.exit(0);
                }

            }
            

        }catch(SQLException e){

        }

        //        String name = UserName.getText();
        //        String password = String.valueOf(Password.getPassword());
        //        if(name.equals("admin")&&password.equals("123")){
            //				Admin admin = new Admin();
            //                                admin.setVisible(true);
            //                                setVisible(false);
            //                                select.remove(select);
            //                                select.setVisible(false);
            //                                select.dispose();
            //
            //			}else{
            //                        JOptionPane.showMessageDialog(Login.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
            //			UserName.setText("");
            //                        Password.setText("");
            //			}
    }//GEN-LAST:event_LoginButActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton LoginBut;
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField UserName;
    private javax.swing.JLabel close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel minimize;
    // End of variables declaration//GEN-END:variables
}
