/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysinhvien;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User 28820
 */
public class JFrame_DiemsoSV extends javax.swing.JFrame {

    /**
     * Creates new form JFrame_DiemsoSV
     */
    public JFrame_DiemsoSV() {
        initComponents();
    }
    
    private DefaultTableModel tableModel = new DefaultTableModel();
    boolean chua_co_diem=false;    
    private String diem_chu(float diem)
    {
        if(diem>=4 && diem<5) return "D";
        else 
            if(diem>=5 && diem<5.5) return "D+";
            else 
                if(diem>=5.5 && diem<6.5) return "C";
                else 
                    if(diem>=6.5 && diem<7) return "C+";
                    else 
                        if(diem>=7 && diem<8) return "B";
                        else 
                            if(diem>=8 && diem<9) return "B+";
                            else 
                                if(diem>=9) return "A";
                                else
                                    if(diem<4 && diem>=0) return "F";
        return "";
    }
    
    private double Diem_chu_sang_so(String s)
    {
        if(s.compareTo("A")==0) return 4.0;
        else 
            if(s.compareTo("B+")==0) return 3.5;
            else 
                if(s.compareTo("B")==0) return 3.0;
                else 
                    if(s.compareTo("C+")==0) return 2.5;
                    else 
                        if(s.compareTo("C")==0) return 2.0;
                        else 
                            if(s.compareTo("D+")==0) return 1.5;
                            else 
                                if(s.compareTo("D")==0) return 1.0;
        return  0;
    }
    private float diem_trung_binh()
    {
        float diemTB=0;
        int n=tblDiem.getRowCount();
        for(int i=0;i<n;i++)
        {
            if(tblDiem.getValueAt(i,4).toString().equals(""))
            {
                chua_co_diem=true;
                break;
            }
            diemTB += Diem_chu_sang_so(tblDiem.getValueAt(i,4).toString());
            chua_co_diem = false;
        }
        diemTB=diemTB/n;
        return diemTB;
    }
    
    private String xep_Loai()
    {
        String loai="";
        float diemTB = diem_trung_binh();
        if(diemTB>=3.6) loai="Xuất sắc";
        else 
            if(diemTB>=3.2 && diemTB<3.6) loai="Giỏi";
            else 
                if(diemTB>=2.5 && diemTB<3.2) loai="Khá";
                else 
                    if(diemTB>=2 && diemTB<2.5) loai="trung bình";
                    else 
                        if(diemTB>=1 && diemTB<2) loai="trunh bình yếu";
                        else 
                            if(diemTB<1 && diemTB>=0) loai="Kém";
                            else loai = "";
        return loai;
    }
    
    private void UpdateTable(){
        try
        {
            
            DefaultTableModel model = (DefaultTableModel) tblDiem.getModel();
            model.setRowCount(0);
            Statement s = clsConnection.con.createStatement();
            ResultSet rs = s.executeQuery("SELECT Mamon,Tenmon,Sotinchi,Diemso "
                    + "FROM Diem WHERE MSSV='"+cbbSV.getSelectedItem().toString()+"' AND Namhoc='"
                    +cbbNamhoc.getSelectedItem().toString()+"' AND Hocki='"
                    +cbbHocki.getSelectedItem().toString()+ "'");
            String []colsName = {"Mã môn", "Tên môn", "Số tín chỉ", "Điểm số", "Điểm chữ"};
            tableModel.setColumnIdentifiers(colsName);
            tblDiem.setModel(tableModel);
            while(rs.next())
            {
                    Object rows[] = new Object[5];
                    rows[0] = rs.getString(1);
                    rows[1] = rs.getString(2);
                    rows[2] = rs.getInt(3);
                    if( rs.getFloat(4) == -1 ) rows[3] ="";
                           else rows[3] = rs.getFloat(4);
                    rows[4] = diem_chu(rs.getFloat(4));                    
                    tableModel.addRow(rows);
            }
            Float diem=diem_trung_binh();                  
            if(diem.toString().equals("")||chua_co_diem)
            {
                txtDiemTB.setText("");
                txtXepLoai.setText("");
            }
            else
            {
                txtDiemTB.setText(diem.toString());
                txtXepLoai.setText(xep_Loai());
            }

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDiem = new javax.swing.JTable();
        cbbSV = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbbNamhoc = new javax.swing.JComboBox<>();
        cbbHocki = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnNhap = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnQuaylai = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDiemTB = new javax.swing.JTextField();
        txtXepLoai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMonhoc = new javax.swing.JTextField();
        txtDiemso = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tblDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDiemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDiem);

        cbbSV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSVActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Chọn sinh viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Năm học");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Học kì");

        cbbNamhoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbNamhoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNamhocActionPerformed(evt);
            }
        });

        cbbHocki.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbHocki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbHockiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setText("KẾT QUẢ HỌC TẬP");

        btnNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNhap.setText("Nhập/Sửa điểm");
        btnNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLuu.setText("Lưu kết quả");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnQuaylai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnQuaylai.setText("Quay lại");
        btnQuaylai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuaylaiActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Điểm trung bình học kì");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Xếp loại");

        txtDiemTB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtXepLoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Môn học");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Điểm số");

        txtMonhoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtDiemso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbbHocki, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbbSV, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbNamhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(352, 352, 352))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMonhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiemso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNhap)
                        .addGap(93, 93, 93)
                        .addComponent(btnLuu)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtXepLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(26, 26, 26)
                                .addComponent(txtDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(421, 421, 421))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnQuaylai)
                        .addGap(160, 160, 160))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbNamhoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbHocki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtXepLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtMonhoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtDiemso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuaylai)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try
        {
            tblDiem.setEnabled(false);
            btnLuu.setEnabled(false);
            txtMonhoc.setEnabled(false);
            txtDiemso.setEnabled(false);
            String query1="SELECT MSSV FROM SinhVien";
            String query2="SELECT distinct Namhoc FROM Namhoc_Hocki";
            String query3="SELECT distinct Hocki FROM Namhoc_Hocki";
            PreparedStatement ps=clsConnection.con.prepareStatement(query1);
            Statement s2=clsConnection.con.createStatement();
            Statement s3=clsConnection.con.createStatement();
            ResultSet rs1=ps.executeQuery();
            ResultSet rs2=s2.executeQuery(query2);
            ResultSet rs3=s3.executeQuery(query3);
            DefaultComboBoxModel cbbMSSV=new DefaultComboBoxModel();
            DefaultComboBoxModel cbbNamHoc=new DefaultComboBoxModel();
            DefaultComboBoxModel cbbHK=new DefaultComboBoxModel();
            while(rs1.next())
            {
                cbbMSSV.addElement(rs1.getObject(1));
            }
            while(rs2.next())
            {
                cbbNamHoc.addElement(rs2.getObject(1));
            }
            while(rs3.next())
            {
                cbbHK.addElement(rs3.getObject(1));
            }
            cbbSV.setModel(cbbMSSV);
            cbbNamhoc.setModel(cbbNamHoc);
            cbbHocki.setModel(cbbHK);
            UpdateTable();            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
     
    }//GEN-LAST:event_formWindowOpened

    private void cbbSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSVActionPerformed
        // TODO add your handling code here:
        UpdateTable();
    }//GEN-LAST:event_cbbSVActionPerformed

    private void cbbNamhocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNamhocActionPerformed
        // TODO add your handling code here:
        UpdateTable();
    }//GEN-LAST:event_cbbNamhocActionPerformed

    private void cbbHockiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbHockiActionPerformed
        // TODO add your handling code here:
        UpdateTable();
    }//GEN-LAST:event_cbbHockiActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
         try
        {
            Statement s = clsConnection.con.createStatement();
            int a = tblDiem.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) tblDiem.getModel();
            if (a>=0)
            {
                 model.setValueAt(txtDiemso.getText(),a,2);
            }
            for (int i = 0; i < tblDiem.getRowCount(); i++) {  
                String up = "UPDATE Diem SET Diemso=" + txtDiemso.getText() + "WHERE Tenmon='" + txtMonhoc.getText() + "' AND MSSV ='" + cbbSV.getSelectedItem().toString() + "'";
                s.execute(up);
            }
            JOptionPane.showMessageDialog(this, "Lưu dữ liệu thành công !!!");  
        
    	} 
         catch (Exception ex) 
        { 
            ex.printStackTrace();
 
    	}
        UpdateTable();          
        tblDiem.setEnabled(false);
        btnNhap.setEnabled(true);
        btnLuu.setEnabled(false);
        txtMonhoc.setEnabled(false);
        txtDiemso.setEnabled(false);
        
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapActionPerformed
        // TODO add your handling code here:
        txtMonhoc.setEnabled(true);
        txtDiemso.setEnabled(true);
        tblDiem.setEnabled(true);
        btnLuu.setEnabled(true);
        btnNhap.setEnabled(false);       
    }//GEN-LAST:event_btnNhapActionPerformed

    private void tblDiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDiemMouseClicked
        // TODO add your handling code here:
        int a = tblDiem.getSelectedRow();
        if(a>=0){
        DefaultTableModel model = (DefaultTableModel) tblDiem.getModel();
        txtMonhoc.setText(model.getValueAt(a, 1).toString());
        txtDiemso.setText(model.getValueAt(a, 3).toString());
        }
      
    }//GEN-LAST:event_tblDiemMouseClicked

    private void btnQuaylaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuaylaiActionPerformed
        // TODO add your handling code here:
        new JFrame_MainMenu().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnQuaylaiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame_DiemsoSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_DiemsoSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_DiemsoSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_DiemsoSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_DiemsoSV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNhap;
    private javax.swing.JButton btnQuaylai;
    private javax.swing.JComboBox<String> cbbHocki;
    private javax.swing.JComboBox<String> cbbNamhoc;
    private javax.swing.JComboBox<String> cbbSV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDiem;
    private javax.swing.JTextField txtDiemTB;
    private javax.swing.JTextField txtDiemso;
    private javax.swing.JTextField txtMonhoc;
    private javax.swing.JTextField txtXepLoai;
    // End of variables declaration//GEN-END:variables
}
