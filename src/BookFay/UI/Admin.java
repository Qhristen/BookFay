/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookFay.UI;
import BookFay.Controller.*;
import BookFay.DBconnection.BookFayConnection;
import com.mysql.jdbc.exceptions.DeadlockTimeoutRollbackMarker;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.commons.dbutils.DbUtils;


/**
 *
 * @author Qhristen
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
    }

    public void SwitchPanel(JPanel panel){
        MainTab.removeAll();
        MainTab.add(panel);
        MainTab.repaint();
        MainTab.revalidate();
        
    }

    String data[][]=null;
    String column[]=null;
    public void filter(String querry){
        
        try{

         Connection con = BookFayConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from student where student.stdmatric=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, querry);
            ResultSet rs = ps.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
                        
                        TableModel model = new DefaultTableModel(data, column);
                        jTable1.setModel(model);
//            jTable1.setModel(DbUtils.resultSetTableModel(rs)); 
   
            
//        querry = rs.getString("stdname");
//        tr.setRowFilter(RowFilter.regexFilter(querry));
        }catch(Exception e){
            
        }

    }
    
    
     public void filter1(String querry){
        
        try{

         Connection con = BookFayConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from librarian where name=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, querry);
            ResultSet rs = ps.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
                        
                        TableModel model = new DefaultTableModel(data, column);
                        jTable2.setModel(model);
//            jTable1.setModel(DbUtils.resultSetTableModel(rs)); 
   
            
//        querry = rs.getString("stdname");
//        tr.setRowFilter(RowFilter.regexFilter(querry));
        }catch(Exception e){
            
        }

    }
    

    
    
  public void Refresh() {

		String data[][]=null;
		String column[]=null;
		try{
			Connection con=BookFayConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from student",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                        
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		TableModel model = new DefaultTableModel(data, column);
		jTable1.setModel(model);
		
	}
    
  
  public void RefreshLib() {

		String data[][]=null;
		String column[]=null;
		try{
			Connection con=BookFayConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from librarian",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                        
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		TableModel model = new DefaultTableModel(data, column);
		jTable2.setModel(model);
		
	}
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("book_fay?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        studentQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT s FROM Student s");
        studentList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : studentQuery.getResultList();
        librarian_1Query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT l FROM Librarian_1 l");
        librarian_1List = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : librarian_1Query.getResultList();
        librarian_1Query1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT l FROM Librarian_1 l");
        librarian_1List1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : librarian_1Query1.getResultList();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        kButton2 = new keeptoo.KButton();
        kButton6 = new keeptoo.KButton();
        kButton7 = new keeptoo.KButton();
        kButton3 = new keeptoo.KButton();
        kButton10 = new keeptoo.KButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        MainTab = new javax.swing.JTabbedPane();
        selectt = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        addlib = new javax.swing.JPanel();
        LibName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        LibPass = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        LibEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        LibNum = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        LibCity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LibAddr = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        kButton9 = new keeptoo.KButton();
        typeLib = new javax.swing.JTextField();
        addSstudent = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pass = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ph = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        matric = new javax.swing.JTextField();
        kButton8 = new keeptoo.KButton();
        typeStu = new javax.swing.JTextField();
        viewStudent = new javax.swing.JPanel();
        kButton11 = new keeptoo.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        SearchField = new javax.swing.JTextField();
        viewlib = new javax.swing.JPanel();
        kButton4 = new keeptoo.KButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        SearchField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1265, 786));
        setUndecorated(true);

        kGradientPanel1.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setForeground(new java.awt.Color(102, 0, 102));
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(153, 153, 0));
        kGradientPanel1.setkFillBackground(false);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 204, 204));
        kGradientPanel1.setkTransparentControls(false);
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 204, 204));

        kButton2.setText("View Librarian");
        kButton2.setBorderPainted(false);
        kButton2.setFont(new java.awt.Font("Kristen ITC", 1, 12)); // NOI18N
        kButton2.setkAllowTab(false);
        kButton2.setkEndColor(new java.awt.Color(0, 51, 102));
        kButton2.setkFillButton(false);
        kButton2.setkHoverEndColor(new java.awt.Color(153, 0, 153));
        kButton2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        kButton2.setkIndicatorColor(new java.awt.Color(204, 204, 204));
        kButton2.setkIndicatorThickness(3);
        kButton2.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton2.setkSelectedColor(new java.awt.Color(0, 51, 204));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        kButton6.setText("Add Librarian");
        kButton6.setBorderPainted(false);
        kButton6.setFont(new java.awt.Font("Kristen ITC", 1, 12)); // NOI18N
        kButton6.setkAllowTab(false);
        kButton6.setkEndColor(new java.awt.Color(0, 51, 102));
        kButton6.setkFillButton(false);
        kButton6.setkHoverEndColor(new java.awt.Color(153, 0, 153));
        kButton6.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton6.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        kButton6.setkIndicatorColor(new java.awt.Color(204, 204, 204));
        kButton6.setkIndicatorThickness(3);
        kButton6.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton6.setkSelectedColor(new java.awt.Color(0, 51, 204));
        kButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton6ActionPerformed(evt);
            }
        });

        kButton7.setText("Add Student");
        kButton7.setBorderPainted(false);
        kButton7.setFont(new java.awt.Font("Kristen ITC", 1, 12)); // NOI18N
        kButton7.setkAllowTab(false);
        kButton7.setkEndColor(new java.awt.Color(0, 51, 102));
        kButton7.setkFillButton(false);
        kButton7.setkHoverEndColor(new java.awt.Color(153, 0, 153));
        kButton7.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton7.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        kButton7.setkIndicatorColor(new java.awt.Color(204, 204, 204));
        kButton7.setkIndicatorThickness(3);
        kButton7.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton7.setkSelectedColor(new java.awt.Color(0, 51, 204));
        kButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton7ActionPerformed(evt);
            }
        });

        kButton3.setText("View Student");
        kButton3.setBorderPainted(false);
        kButton3.setFont(new java.awt.Font("Kristen ITC", 1, 12)); // NOI18N
        kButton3.setkAllowTab(false);
        kButton3.setkEndColor(new java.awt.Color(0, 51, 102));
        kButton3.setkFillButton(false);
        kButton3.setkHoverEndColor(new java.awt.Color(153, 0, 153));
        kButton3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton3.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        kButton3.setkIndicatorColor(new java.awt.Color(204, 204, 204));
        kButton3.setkIndicatorThickness(3);
        kButton3.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton3.setkSelectedColor(new java.awt.Color(0, 51, 204));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        kButton10.setText("Logout");
        kButton10.setBorderPainted(false);
        kButton10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        kButton10.setkAllowTab(false);
        kButton10.setkEndColor(new java.awt.Color(0, 51, 102));
        kButton10.setkFillButton(false);
        kButton10.setkHoverEndColor(new java.awt.Color(153, 0, 153));
        kButton10.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton10.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        kButton10.setkIndicatorColor(new java.awt.Color(204, 204, 204));
        kButton10.setkIndicatorThickness(3);
        kButton10.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton10.setkSelectedColor(new java.awt.Color(0, 51, 204));
        kButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton10ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Admin Portal");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("BOOKFAY- Library Book Management System");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addGap(0, 53, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(43, 43, 43)
                        .addComponent(kButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(kButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addContainerGap())
        );

        kGradientPanel1.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 650));

        MainTab.setBackground(new java.awt.Color(255, 255, 255));
        MainTab.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MainTab.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        MainTab.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        MainTab.setAutoscrolls(true);

        selectt.setBackground(new java.awt.Color(0, 51, 102));

        jLabel15.setBackground(new java.awt.Color(204, 204, 204));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Welcome to the Admin Panel");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 153, 153));
        jLabel17.setText("Select option");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookFay/Image/icons8_Long_Arrow_Left_32px.png"))); // NOI18N

        javax.swing.GroupLayout selecttLayout = new javax.swing.GroupLayout(selectt);
        selectt.setLayout(selecttLayout);
        selecttLayout.setHorizontalGroup(
            selecttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selecttLayout.createSequentialGroup()
                .addContainerGap(221, Short.MAX_VALUE)
                .addGroup(selecttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(selecttLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)))
                .addGap(199, 199, 199))
        );
        selecttLayout.setVerticalGroup(
            selecttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selecttLayout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(selecttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(324, Short.MAX_VALUE))
        );

        MainTab.addTab("", selectt);

        addlib.setBackground(new java.awt.Color(255, 255, 255));
        addlib.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LibName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LibNameActionPerformed(evt);
            }
        });
        addlib.add(LibName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 371, 41));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("User Name");
        addlib.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 100, 20));

        LibPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LibPassActionPerformed(evt);
            }
        });
        addlib.add(LibPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 371, 41));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Password");
        addlib.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 60, 20));

        LibEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LibEmailActionPerformed(evt);
            }
        });
        addlib.add(LibEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 371, 41));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Email");
        addlib.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 60, 20));

        LibNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LibNumActionPerformed(evt);
            }
        });
        addlib.add(LibNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 371, 41));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Phone Number");
        addlib.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 100, 20));

        LibCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LibCityActionPerformed(evt);
            }
        });
        addlib.add(LibCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 371, 41));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("City");
        addlib.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 100, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookFay/Image/icons8_Add_User_Male_32px_1.png"))); // NOI18N
        jLabel7.setText("Add Librarian");
        jLabel7.setIconTextGap(10);
        addlib.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 150, 30));

        LibAddr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LibAddrActionPerformed(evt);
            }
        });
        addlib.add(LibAddr, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 371, 41));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Address");
        addlib.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 100, 20));

        kButton9.setForeground(new java.awt.Color(0, 102, 153));
        kButton9.setText("Save");
        kButton9.setBorderPainted(false);
        kButton9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        kButton9.setkAllowTab(false);
        kButton9.setkBackGroundColor(new java.awt.Color(0, 0, 102));
        kButton9.setkEndColor(new java.awt.Color(0, 51, 102));
        kButton9.setkHoverEndColor(new java.awt.Color(0, 51, 102));
        kButton9.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton9.setkHoverStartColor(new java.awt.Color(51, 204, 255));
        kButton9.setkIndicatorColor(new java.awt.Color(204, 204, 204));
        kButton9.setkIndicatorThickness(3);
        kButton9.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton9.setkSelectedColor(new java.awt.Color(0, 51, 204));
        kButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton9ActionPerformed(evt);
            }
        });
        addlib.add(kButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, 370, -1));

        typeLib.setEditable(false);
        typeLib.setBackground(new java.awt.Color(255, 255, 255));
        typeLib.setForeground(new java.awt.Color(255, 255, 255));
        typeLib.setText("librarian");
        typeLib.setBorder(null);
        typeLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeLibActionPerformed(evt);
            }
        });
        addlib.add(typeLib, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 60, 50, -1));

        MainTab.addTab("", addlib);

        addSstudent.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 153, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookFay/Image/icons8_Add_User_Male_32px_1.png"))); // NOI18N
        jLabel8.setText("Add Student");
        jLabel8.setIconTextGap(10);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("User Name");

        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Password");

        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Email");

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Phone Number");

        ph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Matric Number");

        matric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matricActionPerformed(evt);
            }
        });

        kButton8.setForeground(new java.awt.Color(0, 102, 153));
        kButton8.setText("Save");
        kButton8.setBorderPainted(false);
        kButton8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        kButton8.setkAllowTab(false);
        kButton8.setkBackGroundColor(new java.awt.Color(0, 0, 102));
        kButton8.setkEndColor(new java.awt.Color(0, 51, 102));
        kButton8.setkHoverEndColor(new java.awt.Color(0, 51, 102));
        kButton8.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton8.setkHoverStartColor(new java.awt.Color(51, 204, 255));
        kButton8.setkIndicatorColor(new java.awt.Color(204, 204, 204));
        kButton8.setkIndicatorThickness(3);
        kButton8.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton8.setkSelectedColor(new java.awt.Color(0, 51, 204));
        kButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton8ActionPerformed(evt);
            }
        });

        typeStu.setEditable(false);
        typeStu.setBackground(new java.awt.Color(255, 255, 255));
        typeStu.setForeground(new java.awt.Color(255, 255, 255));
        typeStu.setText("student");
        typeStu.setBorder(null);
        typeStu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeStuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addSstudentLayout = new javax.swing.GroupLayout(addSstudent);
        addSstudent.setLayout(addSstudentLayout);
        addSstudentLayout.setHorizontalGroup(
            addSstudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSstudentLayout.createSequentialGroup()
                .addGap(594, 594, 594)
                .addComponent(typeStu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(245, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addSstudentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257))
            .addGroup(addSstudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addSstudentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(addSstudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addSstudentLayout.createSequentialGroup()
                            .addGap(110, 110, 110)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ph, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(matric, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        addSstudentLayout.setVerticalGroup(
            addSstudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addSstudentLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(typeStu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(addSstudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addSstudentLayout.createSequentialGroup()
                    .addGap(0, 38, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(9, 9, 9)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(9, 9, 9)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(9, 9, 9)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(ph, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(9, 9, 9)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(matric, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 154, Short.MAX_VALUE)))
        );

        MainTab.addTab("", addSstudent);

        viewStudent.setBackground(new java.awt.Color(255, 255, 255));
        viewStudent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton11.setForeground(new java.awt.Color(0, 102, 153));
        kButton11.setText("Refresh");
        kButton11.setBorderPainted(false);
        kButton11.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        kButton11.setkAllowTab(false);
        kButton11.setkBackGroundColor(new java.awt.Color(0, 0, 102));
        kButton11.setkEndColor(new java.awt.Color(0, 51, 102));
        kButton11.setkHoverEndColor(new java.awt.Color(0, 51, 102));
        kButton11.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton11.setkHoverStartColor(new java.awt.Color(51, 204, 255));
        kButton11.setkIndicatorColor(new java.awt.Color(204, 204, 204));
        kButton11.setkIndicatorThickness(3);
        kButton11.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton11.setkSelectedColor(new java.awt.Color(0, 51, 204));
        kButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton11ActionPerformed(evt);
            }
        });
        viewStudent.add(kButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 550, 130, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setAutoscrolls(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Matric", "Student Email", "Student phone", "Student passord", "Stuudent Name", "Student Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, studentList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${stdmatric}"));
        columnBinding.setColumnName("Stdmatric");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${stdemail}"));
        columnBinding.setColumnName("Stdemail");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${stdphone}"));
        columnBinding.setColumnName("Stdphone");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${stdpass}"));
        columnBinding.setColumnName("Stdpass");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${stdname}"));
        columnBinding.setColumnName("Stdname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${stdId}"));
        columnBinding.setColumnName("Std Id");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        viewStudent.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 780, 410));

        SearchField.setText("Search here");
        SearchField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 204))); // NOI18N
        SearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFieldActionPerformed(evt);
            }
        });
        SearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchFieldKeyReleased(evt);
            }
        });
        viewStudent.add(SearchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 780, 50));

        MainTab.addTab("", viewStudent);

        viewlib.setBackground(new java.awt.Color(255, 255, 255));
        viewlib.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton4.setForeground(new java.awt.Color(0, 102, 153));
        kButton4.setText("Refresh");
        kButton4.setBorderPainted(false);
        kButton4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        kButton4.setkAllowTab(false);
        kButton4.setkBackGroundColor(new java.awt.Color(0, 0, 102));
        kButton4.setkEndColor(new java.awt.Color(0, 51, 102));
        kButton4.setkHoverEndColor(new java.awt.Color(0, 51, 102));
        kButton4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton4.setkHoverStartColor(new java.awt.Color(51, 204, 255));
        kButton4.setkIndicatorColor(new java.awt.Color(204, 204, 204));
        kButton4.setkIndicatorThickness(3);
        kButton4.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton4.setkSelectedColor(new java.awt.Color(0, 51, 204));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });
        viewlib.add(kButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 570, 140, -1));

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, librarian_1List1, jTable2);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("Email");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${password}"));
        columnBinding.setColumnName("Password");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${address}"));
        columnBinding.setColumnName("Address");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contact}"));
        columnBinding.setColumnName("Contact");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${city}"));
        columnBinding.setColumnName("City");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);

        viewlib.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 790, 440));

        SearchField1.setText("Search here");
        SearchField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 204))); // NOI18N
        SearchField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchField1ActionPerformed(evt);
            }
        });
        SearchField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchField1KeyReleased(evt);
            }
        });
        viewlib.add(SearchField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 780, 50));

        MainTab.addTab("", viewlib);

        kGradientPanel1.add(MainTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 910, 660));

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        close.setBackground(new java.awt.Color(0, 0, 102));
        close.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        close.setForeground(new java.awt.Color(0, 0, 51));
        close.setText("x");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        minimize.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        minimize.setForeground(new java.awt.Color(0, 0, 51));
        minimize.setText("-");
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("BOOKFAY- Library Book Management System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 995, Short.MAX_VALUE)
                .addComponent(minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(minimize)
                        .addComponent(jLabel4))
                    .addComponent(close))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        kGradientPanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        setSize(new java.awt.Dimension(1265, 680));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
this.setState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
      int x=JOptionPane.showConfirmDialog(null,"Are you sure to quit","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(x==0) System.exit(0);
        else return;
    }//GEN-LAST:event_closeMouseClicked

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        // TODO add your handling code here:
        SwitchPanel(viewlib);
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
        // TODO add your handling code here:
        SwitchPanel(addlib);
    }//GEN-LAST:event_kButton6ActionPerformed

    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed
        // TODO add your handling code here:
        SwitchPanel(addSstudent);
    }//GEN-LAST:event_kButton7ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        // TODO add your handling code here:
        SwitchPanel(viewStudent);
    }//GEN-LAST:event_kButton3ActionPerformed
        int xx, yy;
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        int y = evt.getYOnScreen();
        int x = evt.getXOnScreen();
        this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        // TODO add your handling code here:
        RefreshLib();
    }//GEN-LAST:event_kButton4ActionPerformed

    private void kButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton8ActionPerformed

        StudentDBController stCon = new StudentDBController();
        String name = fname.getText();
        String password = String.valueOf(pass.getText());
        String Email = email.getText();
        String PhoneMunber = ph.getText();
        String Matric = matric.getText();
        String type = typeStu.getText();
        //                        ResultSet rs = ps.executeQuery();
        if(name.equals("")&& password.equals("")&& Email.equals("") && PhoneMunber.equals("") && Matric.equals("")){
            JOptionPane.showMessageDialog(Admin.this,"Sorry, Form is Empty");

        }else{
            stCon.save(name, password, Email, Matric, PhoneMunber, type);
            JOptionPane.showMessageDialog(Admin.this, fname.getText() + " added successfully!");
            fname.setText("");
            pass.setText("");
            email.setText("");
            ph.setText("");
            matric.setText("");

        }

    }//GEN-LAST:event_kButton8ActionPerformed

    private void matricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matricActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matricActionPerformed

    private void phActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void kButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton9ActionPerformed
        // TODO add your handling code here:
        LibrarianDBController LibCon = new LibrarianDBController();
        String name = LibName.getText();
        String password = String.valueOf(LibPass.getText());
        String email = LibEmail.getText();
        String PhoneMunber = LibNum.getText();
        String city = LibCity.getText();
        String address = LibAddr.getText();
        String type = typeLib.getText();

        //                        ResultSet rs = ps.executeQuery();
        if(name.equals("")&& password.equals("")&& email.equals("") && PhoneMunber.equals("") && city.equals("") && address.equals("")){
            JOptionPane.showMessageDialog(Admin.this,"Sorry, Form is Empty");

        }else{
            LibCon.save(name, password, email, address, city, PhoneMunber, type);
            JOptionPane.showMessageDialog(Admin.this, LibName.getText()+ " added successfully!");
            LibName.setText("");
            LibAddr.setText("");
            LibPass.setText("");
            LibEmail.setText("");
            LibNum.setText("");
            LibCity.setText("");
            LibAddr.setText("");

        }

    }//GEN-LAST:event_kButton9ActionPerformed

    private void LibAddrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LibAddrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LibAddrActionPerformed

    private void LibCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LibCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LibCityActionPerformed

    private void LibNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LibNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LibNumActionPerformed

    private void LibEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LibEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LibEmailActionPerformed

    private void LibPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LibPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LibPassActionPerformed

    private void LibNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LibNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LibNameActionPerformed

    private void kButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton10ActionPerformed
        // TODO add your handling code here:
      
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_kButton10ActionPerformed

    private void kButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton11ActionPerformed
        // TODO add your handling code here:
        Refresh();
    }//GEN-LAST:event_kButton11ActionPerformed

    private void typeStuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeStuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeStuActionPerformed

    private void typeLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeLibActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeLibActionPerformed

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchFieldActionPerformed

    private void SearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFieldKeyReleased
        String query = SearchField.getText();
        filter(query);

    }//GEN-LAST:event_SearchFieldKeyReleased

    private void SearchField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchField1ActionPerformed
        // TODO add your handling code here:
        String query = SearchField1.getText();
        filter1(query);
    }//GEN-LAST:event_SearchField1ActionPerformed

    private void SearchField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchField1KeyReleased
        // TODO add your handling code here:
        String query = SearchField1.getText();
        filter1(query);
    }//GEN-LAST:event_SearchField1KeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField LibAddr;
    private javax.swing.JTextField LibCity;
    private javax.swing.JTextField LibEmail;
    private javax.swing.JTextField LibName;
    private javax.swing.JTextField LibNum;
    private javax.swing.JTextField LibPass;
    private javax.swing.JTabbedPane MainTab;
    private javax.swing.JTextField SearchField;
    private javax.swing.JTextField SearchField1;
    private javax.swing.JPanel addSstudent;
    private javax.swing.JPanel addlib;
    private javax.swing.JLabel close;
    private javax.swing.JTextField email;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private keeptoo.KButton kButton10;
    private keeptoo.KButton kButton11;
    private keeptoo.KButton kButton2;
    private keeptoo.KButton kButton3;
    private keeptoo.KButton kButton4;
    private keeptoo.KButton kButton6;
    private keeptoo.KButton kButton7;
    private keeptoo.KButton kButton8;
    private keeptoo.KButton kButton9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private java.util.List<BookFay.UI.Librarian_1> librarian_1List;
    private java.util.List<BookFay.UI.Librarian_1> librarian_1List1;
    private javax.persistence.Query librarian_1Query;
    private javax.persistence.Query librarian_1Query1;
    private javax.swing.JTextField matric;
    private javax.swing.JLabel minimize;
    private javax.swing.JTextField pass;
    private javax.swing.JTextField ph;
    private javax.swing.JPanel selectt;
    private java.util.List<BookFay.UI.Student> studentList;
    private javax.persistence.Query studentQuery;
    private javax.swing.JTextField typeLib;
    private javax.swing.JTextField typeStu;
    private javax.swing.JPanel viewStudent;
    private javax.swing.JPanel viewlib;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
