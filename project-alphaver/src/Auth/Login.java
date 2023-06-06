package Auth;

import User.DashboardUser;
import Admin.DashboardAdmin;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Aditya Syawal, Muhamad Talim, Mikail Asada, Rafi Fajrul
 */
public class Login extends javax.swing.JFrame {
    private java.sql.Connection connectionDB;
    public Login(java.sql.Connection connectionDB) {
        this.connectionDB = connectionDB;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        titleLogin = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        textField_Username = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        labelPassword = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CBTAuthentication ");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(59, 130, 246));
        jPanel2.setToolTipText("");

        title1.setBackground(new java.awt.Color(255, 255, 255));
        title1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 255, 255));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/FaDesktop.png"))); // NOI18N
        title1.setMaximumSize(new java.awt.Dimension(72, 32));
        title1.setMinimumSize(new java.awt.Dimension(72, 32));

        title2.setBackground(new java.awt.Color(255, 255, 255));
        title2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        title2.setForeground(new java.awt.Color(255, 255, 255));
        title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title2.setText("CBT");
        title2.setMaximumSize(new java.awt.Dimension(72, 32));
        title2.setMinimumSize(new java.awt.Dimension(72, 32));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        titleLogin.setBackground(new java.awt.Color(255, 255, 255));
        titleLogin.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        titleLogin.setForeground(new java.awt.Color(30, 41, 59));
        titleLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLogin.setText("Authentication");
        titleLogin.setAlignmentY(0.0F);
        titleLogin.setOpaque(true);
        titleLogin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        labelUsername.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelUsername.setForeground(new java.awt.Color(100, 116, 139));
        labelUsername.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelUsername.setText("Username");
        labelUsername.setPreferredSize(new java.awt.Dimension(280, 0));

        textField_Username.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textField_Username.setForeground(new java.awt.Color(100, 116, 139));
        textField_Username.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textField_Username.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textField_Username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(71, 85, 105)));
        textField_Username.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textField_Username.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        textField_Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_UsernameActionPerformed(evt);
            }
        });
        textField_Username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textField_UsernameKeyPressed(evt);
            }
        });

        jPasswordField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(100, 116, 139));
        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPasswordField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(71, 85, 105)));
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        labelPassword.setBackground(java.awt.Color.white);
        labelPassword.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelPassword.setForeground(new java.awt.Color(100, 116, 139));
        labelPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelPassword.setText("Password");

        buttonLogin.setBackground(new java.awt.Color(59, 130, 246));
        buttonLogin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonLogin.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogin.setText("Log In");
        buttonLogin.setBorder(null);
        buttonLogin.setBorderPainted(false);
        buttonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonLogin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLoginMouseClicked(evt);
            }
        });
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        buttonLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buttonLoginKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(225, 29, 72));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleLogin)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPassword))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(titleLogin)
                .addGap(26, 26, 26)
                .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textField_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void login() {
        String username = textField_Username.getText();
        String password = jPasswordField1.getText();

        if (username.length() < 1) {
            jLabel1.setText("Username tidak boleh kosong");
            return;
        } else if (password.length() < 1) {
            jLabel1.setText("Password tidak boleh kosong");
            return;
        }

        try {
            String query = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
            java.sql.Statement statement = this.connectionDB.createStatement();
            java.sql.ResultSet res = statement.executeQuery(query);

            if (res.next()) {
                if (res.getBoolean("isAdmin") == true) {
                    DashboardAdmin dashboard = new DashboardAdmin(this.connectionDB);
                    dashboard.setVisible(true);
                    this.setVisible(false);
                    return;
                }
                DashboardUser dashboard = new DashboardUser(this.connectionDB, res.getString("id"));
                dashboard.setVisible(true);
                this.setVisible(false);
                return;
            }

            jLabel1.setText("Username atau Password tidak ditemukan");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void buttonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLoginMouseClicked
        login();
    }//GEN-LAST:event_buttonLoginMouseClicked

    private void textField_UsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_UsernameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jPasswordField1.requestFocusInWindow();
        }
    }//GEN-LAST:event_textField_UsernameKeyPressed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buttonLogin.requestFocusInWindow();
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void buttonLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_buttonLoginKeyPressed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void textField_UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_UsernameActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JTextField textField_Username;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel titleLogin;
    // End of variables declaration//GEN-END:variables

}

