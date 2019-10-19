/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookFay.UI;

import BookFay.Controller.*;
import BookFay.DBconnection.BookFayConnection;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Qhris
 */
public class Librarian extends javax.swing.JFrame {

    /**
     * Creates new form Librarian
     */
    public Librarian() {
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
   
     public void filter1(String querry){
        
        try{

         Connection con = BookFayConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from books where name=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
     
     public void filter2(String querry){
        
        try{

         Connection con = BookFayConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from issuebooks where studentname=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
     
     
     
  JTable table ;
  JTable table1;
  public void ViewBooks() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		ViewBook.setLayout(new BorderLayout(0, 0));
		
		String data[][]=null;
		String column[]=null;
		try{
			Connection con=BookFayConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from books",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                        
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
		
		table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		
		ViewBook.add(sp, BorderLayout.CENTER);
	}
  
  public void ViewIssueBooks() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		ViewIssuedBook.setLayout(new BorderLayout(0, 0));
		
		String data[][]=null;
		String column[]=null;
		try{
			Connection con=BookFayConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from issuebooks",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
		
		 table1 = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table1);
		
		ViewIssuedBook.add(sp, BorderLayout.CENTER);
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
        issuebooksQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Issuebooks i");
        issuebooksList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : issuebooksQuery.getResultList();
        booksQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT b FROM Books b");
        booksList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : booksQuery.getResultList();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        kButton7 = new keeptoo.KButton();
        kButton3 = new keeptoo.KButton();
        kButton10 = new keeptoo.KButton();
        kButton8 = new keeptoo.KButton();
        kButton6 = new keeptoo.KButton();
        kButton9 = new keeptoo.KButton();
        jLabel16 = new javax.swing.JLabel();
        MainTab = new javax.swing.JTabbedPane();
        AddBook = new javax.swing.JPanel();
        isbn = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        kButton11 = new keeptoo.KButton();
        BookName = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        AuthorName = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        PublisherName = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        BookQty = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ViewBook = new javax.swing.JPanel();
        kButton13 = new keeptoo.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        SearchField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        IssueBooks = new javax.swing.JPanel();
        kButton12 = new keeptoo.KButton();
        StName = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        StCon = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        StId = new javax.swing.JTextField();
        BookCall = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        ReturnDate = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        ViewIssuedBook = new javax.swing.JPanel();
        kButton15 = new keeptoo.KButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        SearchField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        kButton17 = new keeptoo.KButton();
        ReturnBook = new javax.swing.JPanel();
        RBookCall = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        RStId = new javax.swing.JTextField();
        kButton5 = new keeptoo.KButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("BOOKFAY- Library Books Management System");

        kButton7.setText("Issue Book");
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

        kButton3.setText("View Issued Books");
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

        kButton10.setText("Return Book");
        kButton10.setBorderPainted(false);
        kButton10.setFont(new java.awt.Font("Kristen ITC", 1, 12)); // NOI18N
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

        kButton8.setText("Add Books");
        kButton8.setBorderPainted(false);
        kButton8.setFont(new java.awt.Font("Kristen ITC", 1, 12)); // NOI18N
        kButton8.setkAllowTab(false);
        kButton8.setkEndColor(new java.awt.Color(0, 51, 102));
        kButton8.setkFillButton(false);
        kButton8.setkHoverEndColor(new java.awt.Color(153, 0, 153));
        kButton8.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton8.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        kButton8.setkIndicatorColor(new java.awt.Color(204, 204, 204));
        kButton8.setkIndicatorThickness(3);
        kButton8.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton8.setkSelectedColor(new java.awt.Color(0, 51, 204));
        kButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton8ActionPerformed(evt);
            }
        });

        kButton6.setText("Logout");
        kButton6.setBorderPainted(false);
        kButton6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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

        kButton9.setText("View Books");
        kButton9.setBorderPainted(false);
        kButton9.setFont(new java.awt.Font("Kristen ITC", 1, 12)); // NOI18N
        kButton9.setkAllowTab(false);
        kButton9.setkEndColor(new java.awt.Color(0, 51, 102));
        kButton9.setkFillButton(false);
        kButton9.setkHoverEndColor(new java.awt.Color(153, 0, 153));
        kButton9.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton9.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        kButton9.setkIndicatorColor(new java.awt.Color(204, 204, 204));
        kButton9.setkIndicatorThickness(3);
        kButton9.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton9.setkSelectedColor(new java.awt.Color(0, 51, 204));
        kButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton9ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Librarian Portal");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(28, 28, 28)
                        .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(kButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addComponent(kButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGap(36, 36, 36))))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(kButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(kButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        kGradientPanel1.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 650));

        MainTab.setBackground(new java.awt.Color(255, 255, 255));
        MainTab.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MainTab.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        MainTab.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        MainTab.setAutoscrolls(true);

        AddBook.setBackground(new java.awt.Color(255, 255, 255));
        AddBook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        isbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isbnActionPerformed(evt);
            }
        });
        AddBook.add(isbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 371, 41));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("ISBN:");
        AddBook.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 100, 20));

        kButton11.setForeground(new java.awt.Color(0, 102, 153));
        kButton11.setText("Save");
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
        AddBook.add(kButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, 370, -1));

        BookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookNameActionPerformed(evt);
            }
        });
        AddBook.add(BookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 371, 41));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Name:");
        AddBook.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 100, 20));

        AuthorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuthorNameActionPerformed(evt);
            }
        });
        AddBook.add(AuthorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 371, 41));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Author:");
        AddBook.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 100, 20));

        PublisherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublisherNameActionPerformed(evt);
            }
        });
        AddBook.add(PublisherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 371, 41));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Publisher:");
        AddBook.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 100, 20));

        BookQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookQtyActionPerformed(evt);
            }
        });
        AddBook.add(BookQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 371, 41));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Quantity:");
        AddBook.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 100, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 153, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Add Book");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel14.setIconTextGap(1);
        AddBook.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 180, 90));

        MainTab.addTab("", AddBook);

        ViewBook.setBackground(new java.awt.Color(255, 255, 255));
        ViewBook.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ViewBookFocusGained(evt);
            }
        });
        ViewBook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton13.setForeground(new java.awt.Color(0, 102, 153));
        kButton13.setText("Refresh");
        kButton13.setBorderPainted(false);
        kButton13.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        kButton13.setkAllowTab(false);
        kButton13.setkBackGroundColor(new java.awt.Color(0, 0, 102));
        kButton13.setkEndColor(new java.awt.Color(0, 51, 102));
        kButton13.setkHoverEndColor(new java.awt.Color(0, 51, 102));
        kButton13.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton13.setkHoverStartColor(new java.awt.Color(51, 204, 255));
        kButton13.setkIndicatorColor(new java.awt.Color(204, 204, 204));
        kButton13.setkIndicatorThickness(3);
        kButton13.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton13.setkSelectedColor(new java.awt.Color(0, 51, 204));
        kButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton13ActionPerformed(evt);
            }
        });
        ViewBook.add(kButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 520, 120, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Added Date", "Quantity", "Publisher", "Author", "Name", "ISBN", "Book Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, booksList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${addedDate}"));
        columnBinding.setColumnName("Added Date");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${publisher}"));
        columnBinding.setColumnName("Publisher");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${author}"));
        columnBinding.setColumnName("Author");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${isbn}"));
        columnBinding.setColumnName("Isbn");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        ViewBook.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 780, 350));

        SearchField1.setText("Search books");
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
        ViewBook.add(SearchField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 780, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("List of Books");
        ViewBook.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 160, -1));

        MainTab.addTab("", ViewBook);

        IssueBooks.setBackground(new java.awt.Color(255, 255, 255));
        IssueBooks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton12.setForeground(new java.awt.Color(0, 102, 153));
        kButton12.setText("Issue");
        kButton12.setBorderPainted(false);
        kButton12.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        kButton12.setkAllowTab(false);
        kButton12.setkBackGroundColor(new java.awt.Color(0, 0, 102));
        kButton12.setkEndColor(new java.awt.Color(0, 51, 102));
        kButton12.setkHoverEndColor(new java.awt.Color(0, 51, 102));
        kButton12.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton12.setkHoverStartColor(new java.awt.Color(51, 204, 255));
        kButton12.setkIndicatorColor(new java.awt.Color(204, 204, 204));
        kButton12.setkIndicatorThickness(3);
        kButton12.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton12.setkSelectedColor(new java.awt.Color(0, 51, 204));
        kButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton12ActionPerformed(evt);
            }
        });
        IssueBooks.add(kButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, 370, -1));

        StName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StNameActionPerformed(evt);
            }
        });
        IssueBooks.add(StName, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 371, 41));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Student Name:");
        IssueBooks.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 100, 20));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Return Date:");
        IssueBooks.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 130, 20));

        StCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StConActionPerformed(evt);
            }
        });
        IssueBooks.add(StCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 371, 41));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Student Id:");
        IssueBooks.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 100, 20));

        StId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StIdActionPerformed(evt);
            }
        });
        IssueBooks.add(StId, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 371, 41));

        BookCall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookCallActionPerformed(evt);
            }
        });
        IssueBooks.add(BookCall, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 371, 41));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 255));
        jLabel26.setText("BOOKS");
        IssueBooks.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 190, 70));

        ReturnDate.setDateFormatString("dd-MM-yyyy");
        IssueBooks.add(ReturnDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 370, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Student Email:");
        IssueBooks.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 130, 20));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Book Id:");
        IssueBooks.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 100, 20));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 102, 255));
        jLabel31.setText("ISSUE ");
        IssueBooks.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 140, 70));

        MainTab.addTab("", IssueBooks);

        ViewIssuedBook.setBackground(new java.awt.Color(255, 255, 255));
        ViewIssuedBook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton15.setForeground(new java.awt.Color(0, 102, 153));
        kButton15.setText("Refresh");
        kButton15.setBorderPainted(false);
        kButton15.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        kButton15.setkAllowTab(false);
        kButton15.setkBackGroundColor(new java.awt.Color(0, 0, 102));
        kButton15.setkEndColor(new java.awt.Color(0, 51, 102));
        kButton15.setkHoverEndColor(new java.awt.Color(0, 51, 102));
        kButton15.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton15.setkHoverStartColor(new java.awt.Color(51, 204, 255));
        kButton15.setkIndicatorColor(new java.awt.Color(204, 204, 204));
        kButton15.setkIndicatorThickness(3);
        kButton15.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton15.setkSelectedColor(new java.awt.Color(0, 51, 204));
        kButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton15ActionPerformed(evt);
            }
        });
        ViewIssuedBook.add(kButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 180, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issued Date", "Return Date", "Student Email", "Student Nname", "Student Id", "Book Id", "S/N"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, issuebooksList, jTable2);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${issueddate}"));
        columnBinding.setColumnName("Issueddate");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${returnDate}"));
        columnBinding.setColumnName("Return Date");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${studentcontact}"));
        columnBinding.setColumnName("Studentcontact");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${studentname}"));
        columnBinding.setColumnName("Studentname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${studentid}"));
        columnBinding.setColumnName("Studentid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${bookId}"));
        columnBinding.setColumnName("Book Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);

        ViewIssuedBook.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 750, 350));

        SearchField2.setText("Search Issued Books");
        SearchField2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 204))); // NOI18N
        SearchField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchField2ActionPerformed(evt);
            }
        });
        SearchField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchField2KeyReleased(evt);
            }
        });
        ViewIssuedBook.add(SearchField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 750, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("List of Issued Books");
        ViewIssuedBook.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 260, -1));

        kButton17.setForeground(new java.awt.Color(0, 102, 153));
        kButton17.setText("Send Notification");
        kButton17.setBorderPainted(false);
        kButton17.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        kButton17.setkAllowTab(false);
        kButton17.setkBackGroundColor(new java.awt.Color(0, 0, 102));
        kButton17.setkEndColor(new java.awt.Color(0, 51, 102));
        kButton17.setkHoverEndColor(new java.awt.Color(0, 51, 102));
        kButton17.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton17.setkHoverStartColor(new java.awt.Color(51, 204, 255));
        kButton17.setkIndicatorColor(new java.awt.Color(204, 204, 204));
        kButton17.setkIndicatorThickness(3);
        kButton17.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton17.setkSelectedColor(new java.awt.Color(0, 51, 204));
        kButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton17ActionPerformed(evt);
            }
        });
        ViewIssuedBook.add(kButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 540, 210, -1));

        MainTab.addTab("", ViewIssuedBook);

        ReturnBook.setBackground(new java.awt.Color(255, 255, 255));
        ReturnBook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RBookCall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBookCallActionPerformed(evt);
            }
        });
        ReturnBook.add(RBookCall, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 371, 41));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Book Id:");
        ReturnBook.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 100, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Student Id:");
        ReturnBook.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 100, 20));

        RStId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RStIdActionPerformed(evt);
            }
        });
        ReturnBook.add(RStId, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 371, 41));

        kButton5.setForeground(new java.awt.Color(0, 102, 153));
        kButton5.setText("Return");
        kButton5.setBorderPainted(false);
        kButton5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        kButton5.setkAllowTab(false);
        kButton5.setkBackGroundColor(new java.awt.Color(0, 0, 102));
        kButton5.setkEndColor(new java.awt.Color(0, 51, 102));
        kButton5.setkHoverEndColor(new java.awt.Color(0, 51, 102));
        kButton5.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton5.setkHoverStartColor(new java.awt.Color(51, 204, 255));
        kButton5.setkIndicatorColor(new java.awt.Color(204, 204, 204));
        kButton5.setkIndicatorThickness(3);
        kButton5.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton5.setkSelectedColor(new java.awt.Color(0, 51, 204));
        kButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton5ActionPerformed(evt);
            }
        });
        ReturnBook.add(kButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 370, 50));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 153, 255));
        jLabel15.setText("Return Book");
        jLabel15.setIconTextGap(10);
        ReturnBook.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 240, 50));

        MainTab.addTab("", ReturnBook);

        kGradientPanel1.add(MainTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 890, 620));

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("BOOKFAY- Library Book Management System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jLabel5))
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
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_kButton6ActionPerformed

    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed
        // TODO add your handling code here:
        SwitchPanel(IssueBooks);
    }//GEN-LAST:event_kButton7ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        // TODO add your handling code here:
        SwitchPanel(ViewIssuedBook);

    }//GEN-LAST:event_kButton3ActionPerformed

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        int x=JOptionPane.showConfirmDialog(null,"Are you sure to quit","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(x==0) System.exit(0);
        else return;
    }//GEN-LAST:event_closeMouseClicked
    
    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked
        int xx, yy;
    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        int y = evt.getYOnScreen();
        int x = evt.getXOnScreen();
        this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void kButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton10ActionPerformed
        SwitchPanel(ReturnBook);        // TODO add your handling code here:
    }//GEN-LAST:event_kButton10ActionPerformed

    private void kButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton11ActionPerformed
        // TODO add your handling code here:
                        BookDBConection BookCon = new BookDBConection();
                        String ISBN = isbn.getText();
			String name = BookName.getText();
			String author = AuthorName.getText();
			String publisher = PublisherName.getText();
			String squantity = BookQty.getText();
			
			
			if(name.equals("")&& ISBN.equals("")&& author.equals("") && publisher.equals("") && squantity.equals("")){
            JOptionPane.showMessageDialog(Librarian.this,"Sorry, Form is Empty");

        }else{
            BookCon.save(ISBN, name, author, publisher, squantity);
            JOptionPane.showMessageDialog(Librarian.this,"Book added successfully!");
            isbn.setText("");
            BookName.setText("");
            AuthorName.setText("");
            PublisherName.setText("");
            BookQty.setText("");

        }
    }//GEN-LAST:event_kButton11ActionPerformed

    private void BookQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookQtyActionPerformed

    private void PublisherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublisherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PublisherNameActionPerformed

    private void AuthorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuthorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AuthorNameActionPerformed

    private void BookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookNameActionPerformed

    private void isbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isbnActionPerformed

    private void kButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton12ActionPerformed
        // TODO add your handling code here:
                        String BookId =BookCall.getText();
                        int BID = Integer.parseInt(BookId);
                        
			String studentid = StId.getText();
			String studentname= StName.getText();
			String studentcontact=StCon.getText();
			Date ReturnDate = this.ReturnDate.getDate();
                        String returnDate = String.format("%1$td-%1$tm-%1$tY", ReturnDate);

			if(BooksIssueDBController.checkBook(BID)){
                        if(BookId.equals("")&& studentid.equals("")&& studentname.equals("") && studentcontact.equals("")){
                        JOptionPane.showMessageDialog(Librarian.this,"Sorry, Form is Empty");

        }else{
            BooksIssueDBController.save(BID, studentid, studentname, studentcontact, returnDate);
            JOptionPane.showMessageDialog(Librarian.this,"Book Issued successfully!");
            BookCall.setText("");
            StCon.setText("");
            StId.setText("");
            StName.setText("");
           

        }
                        }		
			
    }//GEN-LAST:event_kButton12ActionPerformed

    private void StNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StNameActionPerformed

    private void StConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StConActionPerformed

    private void StIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StIdActionPerformed

    private void BookCallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookCallActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookCallActionPerformed

    private void kButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton8ActionPerformed
        // TODO add your handling code here:
        SwitchPanel(AddBook);
    }//GEN-LAST:event_kButton8ActionPerformed

    private void ViewBookFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ViewBookFocusGained
        // TODO add your handling code here:
         
    }//GEN-LAST:event_ViewBookFocusGained

    private void kButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton9ActionPerformed
        // TODO add your handling code here:
         SwitchPanel(ViewBook);
       
    }//GEN-LAST:event_kButton9ActionPerformed

    private void RBookCallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBookCallActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBookCallActionPerformed

    private void RStIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RStIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RStIdActionPerformed

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
        // TODO add your handling code here:
        String bookcallno=RBookCall.getText();
        int BookId = Integer.parseInt(bookcallno);
				int studentid=Integer.parseInt(RStId.getText());
				if(bookcallno.equals("")){
					
					JOptionPane.showMessageDialog(Librarian.this,"Sorry, unable to return book!");
				}else{
					
                                        BookReturnDBController.delete(BookId, studentid);
                                   JOptionPane.showMessageDialog(Librarian.this,"Book returned successfully!");     
				}
    }//GEN-LAST:event_kButton5ActionPerformed

    private void kButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton13ActionPerformed
       
        String data[][]=null;
		String column[]=null;
		try{
			Connection con=BookFayConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from books",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                        
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
		
    }//GEN-LAST:event_kButton13ActionPerformed

    private void kButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton15ActionPerformed
        // TODO add your handling code here:
        String data[][]=null;
		String column[]=null;
		try{
			Connection con=BookFayConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from issuebooks",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                        
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
		
    }//GEN-LAST:event_kButton15ActionPerformed

    private void SearchField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchField1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_SearchField1ActionPerformed

    private void SearchField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchField1KeyReleased
        // TODO add your handling code here:
        String query = SearchField1.getText();
        filter1(query);
    }//GEN-LAST:event_SearchField1KeyReleased

    private void SearchField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchField2ActionPerformed
        // TODO add your handling code here:
        String query = SearchField1.getText();
        filter1(query);
    }//GEN-LAST:event_SearchField2ActionPerformed

    private void SearchField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchField2KeyReleased
        // TODO add your handling code here:
        String query = SearchField2.getText();
        filter2(query);
    }//GEN-LAST:event_SearchField2KeyReleased

    private void kButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton17ActionPerformed
        // TODO add your handling code here:
        int eMail = jTable2.getSelectedRow();
        String email = jTable2.getModel().getValueAt(eMail, 4).toString();             
               String emailSubject = "Book Fay";
                String emailBody = "Please make endeavours to return the book issued to you; \n your time limit has elapsed";
      MailSender mailSender = new MailSender(email,emailSubject,emailBody);
    

        
    }//GEN-LAST:event_kButton17ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddBook;
    private javax.swing.JTextField AuthorName;
    private javax.swing.JTextField BookCall;
    private javax.swing.JTextField BookName;
    private javax.swing.JTextField BookQty;
    private javax.swing.JPanel IssueBooks;
    private javax.swing.JTabbedPane MainTab;
    private javax.swing.JTextField PublisherName;
    private javax.swing.JTextField RBookCall;
    private javax.swing.JTextField RStId;
    private javax.swing.JPanel ReturnBook;
    private com.toedter.calendar.JDateChooser ReturnDate;
    private javax.swing.JTextField SearchField1;
    private javax.swing.JTextField SearchField2;
    private javax.swing.JTextField StCon;
    private javax.swing.JTextField StId;
    private javax.swing.JTextField StName;
    private javax.swing.JPanel ViewBook;
    private javax.swing.JPanel ViewIssuedBook;
    private java.util.List<BookFay.UI.Books> booksList;
    private javax.persistence.Query booksQuery;
    private javax.swing.JLabel close;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTextField isbn;
    private java.util.List<BookFay.UI.Issuebooks> issuebooksList;
    private javax.persistence.Query issuebooksQuery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private keeptoo.KButton kButton10;
    private keeptoo.KButton kButton11;
    private keeptoo.KButton kButton12;
    private keeptoo.KButton kButton13;
    private keeptoo.KButton kButton15;
    private keeptoo.KButton kButton17;
    private keeptoo.KButton kButton3;
    private keeptoo.KButton kButton5;
    private keeptoo.KButton kButton6;
    private keeptoo.KButton kButton7;
    private keeptoo.KButton kButton8;
    private keeptoo.KButton kButton9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel minimize;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
