package com.mycompany.do_an;

import com.mycompany.do_an.DatabaseHelper;
import com.mycompany.do_an.SanPham;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QL_banhang_Form extends javax.swing.JFrame {

    private final List<SanPham> danhSachSP = new ArrayList<>();
    private DefaultTableModel modelMenu;
    private DefaultTableModel modelGioHang;
    private final DecimalFormat df = new DecimalFormat("#,###");
    private double tongTien = 0;
    private int tongSoLy = 0;

    public QL_banhang_Form() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("PHẦN MỀM GỌI MÓN ĐỒ UỐNG (KÉO THẢ DESIGN)");

        modelMenu = (DefaultTableModel) tblMenu.getModel();
        modelGioHang = (DefaultTableModel) tblGioHang.getModel();

        napDuLieuMau();
        capNhatBangMenu();
    }

    private void napDuLieuMau() {
        danhSachSP.clear();
        danhSachSP.add(new SanPham("DU01", "Cà Phê Đen Đá", 25000, 100));
        danhSachSP.add(new SanPham("DU02", "Cà Phê Sữa Sài Gòn", 30000, 80));
        danhSachSP.add(new SanPham("DU03", "Trà Sữa Trân Châu", 45000, 50));
        danhSachSP.add(new SanPham("DU04", "Trà Đào Cam Sả", 35000, 40));
        danhSachSP.add(new SanPham("DU05", "Sữa Tươi Trân Châu Đường Đen", 50000, 60));
    }

    private void capNhatBangMenu() {
        modelMenu.setRowCount(0);
        for (SanPham sp : danhSachSP) {
            modelMenu.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), df.format(sp.getDonGia()), sp.getSoLuong()});
        }
    }

    private void tinhTongGioHang() {
        tongSoLy = 0;
        tongTien = 0;
        for (int i = 0; i < modelGioHang.getRowCount(); i++) {
            int sl = Integer.parseInt(modelGioHang.getValueAt(i, 4).toString());
            double tt = Double.parseDouble(modelGioHang.getValueAt(i, 5).toString().replace(",", ""));
            tongSoLy += sl;
            tongTien += tt;
        }
        lblSoLuongMon.setText("SỐ LƯỢNG MÓN: " + tongSoLy);
        lblTongTien.setText("TỔNG TIỀN: " + df.format(tongTien) + " VNĐ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitleMenu = new javax.swing.JLabel();
        lblTitleGioHang = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMenu = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnChonMua = new javax.swing.JButton();
        btnTaiSQL = new javax.swing.JButton();
        pnlThanhToan = new javax.swing.JPanel();
        lblSoLuongMon = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        btnXoaMon = new javax.swing.JButton();
        btnLamMoiGio = new javax.swing.JButton();
        btnDatHang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitleMenu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTitleMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleMenu.setText("MÓN ĐỒ UỐNG CHỌN MUA");

        lblTitleGioHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTitleGioHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleGioHang.setText("GIỎ HÀNG CỦA BẠN");

        tblMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã món", "Tên đồ uống", "Đơn giá (VNĐ)", "Số lượng tồn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMenu.setRowHeight(26);
        jScrollPane1.setViewportView(tblMenu);

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên đồ uống", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.setRowHeight(26);
        jScrollPane2.setViewportView(tblGioHang);

        btnChonMua.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnChonMua.setText("Thêm Món Vào Giỏ");
        btnChonMua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonMuaActionPerformed(evt);
            }
        });

        btnTaiSQL.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnTaiSQL.setText("Tải Menu");
        btnTaiSQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiSQLActionPerformed(evt);
            }
        });

        pnlThanhToan.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin thanh toán"));

        lblSoLuongMon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSoLuongMon.setText("SỐ LƯỢNG MÓN: 0");

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(204, 0, 0));
        lblTongTien.setText("TỔNG TIỀN: 0 VNĐ");

        btnXoaMon.setText("Xóa món chọn");
        btnXoaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMonActionPerformed(evt);
            }
        });

        btnLamMoiGio.setText("Làm mới giỏ");
        btnLamMoiGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiGioActionPerformed(evt);
            }
        });

        btnDatHang.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDatHang.setText("Đặt hàng & Thanh toán");
        btnDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlThanhToanLayout = new javax.swing.GroupLayout(pnlThanhToan);
        pnlThanhToan.setLayout(pnlThanhToanLayout);
        pnlThanhToanLayout.setHorizontalGroup(
            pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThanhToanLayout.createSequentialGroup()
                        .addComponent(lblSoLuongMon, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlThanhToanLayout.createSequentialGroup()
                        .addComponent(btnXoaMon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLamMoiGio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDatHang)))
                .addContainerGap())
        );
        pnlThanhToanLayout.setVerticalGroup(
            pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoLuongMon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoiGio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTitleMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnChonMua, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTaiSQL, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTitleGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                    .addComponent(pnlThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitleMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitleGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnChonMua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTaiSQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChonMuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonMuaActionPerformed
        int row = tblMenu.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng bấm chọn 1 món ở bảng bên trái trước!");
            return;
        }
        String ma = modelMenu.getValueAt(row, 0).toString();
        String ten = modelMenu.getValueAt(row, 1).toString();
        double gia = Double.parseDouble(modelMenu.getValueAt(row, 2).toString().replace(",", ""));
        int tonKho = Integer.parseInt(modelMenu.getValueAt(row, 3).toString());

        String slStr = JOptionPane.showInputDialog(this, "Nhập số lượng ly cho món: " + ten, "1");
        if (slStr != null && !slStr.trim().isEmpty()) {
            try {
                int sl = Integer.parseInt(slStr.trim());
                if (sl <= 0 || sl > tonKho) {
                    JOptionPane.showMessageDialog(this, "Số lượng phải từ 1 đến " + tonKho);
                    return;
                }
                int stt = modelGioHang.getRowCount() + 1;
                modelGioHang.addRow(new Object[]{stt, ma, ten, df.format(gia), sl, df.format(gia * sl)});
                tinhTongGioHang();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên!");
            }
        }
    }//GEN-LAST:event_btnChonMuaActionPerformed

    private void btnTaiSQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiSQLActionPerformed
        try (Connection conn = DatabaseHelper.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT MaSP, TenSP, DonGia, SoLuong FROM SanPham")) {
            danhSachSP.clear();
            while (rs.next()) {
                danhSachSP.add(new SanPham(
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getDouble("DonGia"),
                        rs.getInt("SoLuong")
                ));
            }
            capNhatBangMenu();
            JOptionPane.showMessageDialog(this, "Tải dữ liệu từ SQL Server thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi kết nối SQL Server: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTaiSQLActionPerformed

    private void btnXoaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMonActionPerformed
        int row = tblGioHang.getSelectedRow();
        if (row >= 0) {
            modelGioHang.removeRow(row);
            for (int i = 0; i < modelGioHang.getRowCount(); i++) {
                modelGioHang.setValueAt(i + 1, i, 0);
            }
            tinhTongGioHang();
        } else {
            JOptionPane.showMessageDialog(this, "Chọn món trong giỏ hàng để xóa!");
        }
    }//GEN-LAST:event_btnXoaMonActionPerformed

    private void btnLamMoiGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiGioActionPerformed
        modelGioHang.setRowCount(0);
        tinhTongGioHang();
    }//GEN-LAST:event_btnLamMoiGioActionPerformed

    private void btnDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHangActionPerformed
        if (modelGioHang.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Giỏ hàng đang trống!");
            return;
        }
        JOptionPane.showMessageDialog(this, "Đặt hàng thành công!Tổng tiền thanh toán: " + df.format(tongTien) + " VNĐ");
        modelGioHang.setRowCount(0);
        tinhTongGioHang();
    }//GEN-LAST:event_btnDatHangActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> {
            new QL_banhang_Form().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonMua;
    private javax.swing.JButton btnDatHang;
    private javax.swing.JButton btnLamMoiGio;
    private javax.swing.JButton btnTaiSQL;
    private javax.swing.JButton btnXoaMon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSoLuongMon;
    private javax.swing.JLabel lblTitleGioHang;
    private javax.swing.JLabel lblTitleMenu;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel pnlThanhToan;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblMenu;
    // End of variables declaration//GEN-END:variables
}
