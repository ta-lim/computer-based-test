package User;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoExam extends javax.swing.JFrame {

    private java.sql.Connection connectionDB;
    private int userId;
    private String examID;
    private String username;
    private int noQuestion = 1;
    private int questionId;
    private int totalQuestions = 0;
    private int[] userAnswers;
    private int[] ListQuestion;

    public DoExam(java.sql.Connection connectionDB, int userId, String examID) {
        this.connectionDB = connectionDB;
        this.userId = userId;
        this.examID = examID;
        System.out.println(examID);
        initComponents();
        this.initAlgos();
    }

    private void initAlgos() {
        this.btnPilihanGanda.clearSelection();
        if (totalQuestions == 0) {
            try {
                String sql = "SELECT * FROM questions where exam_id = ?";
                PreparedStatement statement = this.connectionDB.prepareStatement(sql);
                statement.setString(1, this.examID);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    this.totalQuestions++;
                }

                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }

            this.userAnswers = new int[this.totalQuestions];
            this.ListQuestion = new int[this.totalQuestions];
        }

        if (this.noQuestion == this.totalQuestions) {
            this.btnSubmit.setVisible(true);
            this.btnNext.setVisible(false);
        } else {
            this.btnSubmit.setVisible(false);
            this.btnNext.setVisible(true);
        }

        if (this.noQuestion == 1) {
            this.btnPrev.setVisible(false);
        } else {
            this.btnPrev.setVisible(true);
        }

        this.DbSoal();
    }

    private void DbSoal() {
        int counter = 1;
        
        try {
            String sql = "SELECT * FROM questions where exam_id = ?";
            PreparedStatement statement = this.connectionDB.prepareStatement(sql);
            statement.setString(1, this.examID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                if (counter == this.noQuestion) {
                    this.TxtSoal.setText(resultSet.getString("question"));
                    this.NoSoal.setText("" + this.noQuestion);
                    this.questionId = resultSet.getInt("id");
                    this.ListQuestion[this.noQuestion - 1] = resultSet.getInt("id");
                    break;
                }

                counter++;
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        try {
            String sql = "SELECT * FROM answers where questions_id = ? ORDER BY choice";
            PreparedStatement statement = this.connectionDB.prepareStatement(sql);
            statement.setInt(1, this.questionId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                switch (resultSet.getString("choice")) {
                    case "A":
                        this.A.setText(resultSet.getString("answer"));
                        if (resultSet.getInt("id") == this.userAnswers[this.noQuestion - 1]) {
                            this.A.setSelected(true);
                        }
                        break;

                    case "B":
                        this.B.setText(resultSet.getString("answer"));
                        if (resultSet.getInt("id") == this.userAnswers[this.noQuestion - 1]) {
                            this.B.setSelected(true);
                        }
                        break;

                    case "C":
                        this.C.setText(resultSet.getString("answer"));
                        if (resultSet.getInt("id") == this.userAnswers[this.noQuestion - 1]) {
                            this.C.setSelected(true);
                        }
                        break;

                    case "D":
                        this.D.setText(resultSet.getString("answer"));
                        if (resultSet.getInt("id") == this.userAnswers[this.noQuestion - 1]) {
                            this.D.setSelected(true);
                        }
                        break;
                }
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    public void UpdateJawaban() {
        String jwbSiswa = "";
        if (A.isSelected()) {
            jwbSiswa = "A";
        } else if (B.isSelected()) {
            jwbSiswa = "B";
        } else if (C.isSelected()) {
            jwbSiswa = "C";
        } else if (D.isSelected()) {
            jwbSiswa = "D";
        }

        try {
            String sql = "SELECT * FROM answers where questions_id = ? AND choice = ?";
            PreparedStatement statement = this.connectionDB.prepareStatement(sql);
            statement.setInt(1, this.questionId);
            statement.setString(2, jwbSiswa);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                this.userAnswers[this.noQuestion - 1] = resultSet.getInt("id");
//              
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
    
    public void SubmitJawaban (){
      
         for (int i = 0; i < this.totalQuestions; i++) {
            try {
                String sql = "INSERT INTO user_answers (user_id, exam_id, questions_id, answer_id) VALUES (" + this.userId + ","+this.examID+","+this.ListQuestion[i]+","+this.userAnswers[i]+");";
                 java.sql.PreparedStatement statement = this.connectionDB.prepareStatement(sql);
                statement.execute();

                System.out.println("ArrayList data successfully inserted into the database.");
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
        }
    }
    
     public void DeleteExamAcces (){
        
            try {
                String sql = "DELETE FROM  exam_access WHERE user_id = "+this.userId+" AND exam_id = "+this.examID+";";
                 java.sql.PreparedStatement statement = this.connectionDB.prepareStatement(sql);
                statement.execute();

                System.out.println("Data successfully delete from the database.");
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return;
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

        btnPilihanGanda = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        A = new javax.swing.JRadioButton();
        B = new javax.swing.JRadioButton();
        C = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtSoal = new javax.swing.JTextArea();
        NoSoal = new javax.swing.JLabel();
        btnPrev = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        D = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(100, 116, 139));
        jLabel2.setText("Soal: ");

        A.setBackground(new java.awt.Color(255, 255, 255));
        btnPilihanGanda.add(A);
        A.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        A.setForeground(new java.awt.Color(100, 116, 139));
        A.setText("A");
        A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AActionPerformed(evt);
            }
        });

        B.setBackground(new java.awt.Color(255, 255, 255));
        btnPilihanGanda.add(B);
        B.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        B.setForeground(new java.awt.Color(100, 116, 139));
        B.setText("B");

        C.setBackground(new java.awt.Color(255, 255, 255));
        btnPilihanGanda.add(C);
        C.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        C.setForeground(new java.awt.Color(100, 116, 139));
        C.setText("C");

        btnNext.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNext.setForeground(new java.awt.Color(59, 130, 246));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/FaChevronRight.png"))); // NOI18N
        btnNext.setText("Next ");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        TxtSoal.setEditable(false);
        TxtSoal.setColumns(20);
        TxtSoal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TxtSoal.setRows(5);
        jScrollPane2.setViewportView(TxtSoal);

        btnPrev.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnPrev.setForeground(new java.awt.Color(59, 130, 246));
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/FaChevronLeft.png"))); // NOI18N
        btnPrev.setText("Prev");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnSubmit.setBackground(new java.awt.Color(59, 130, 246));
        btnSubmit.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(100, 116, 139));
        jLabel1.setText("A.");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(100, 116, 139));
        jLabel3.setText("B.");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(100, 116, 139));
        jLabel4.setText("C.");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(100, 116, 139));
        jLabel5.setText("D.");

        D.setBackground(new java.awt.Color(255, 255, 255));
        btnPilihanGanda.add(D);
        D.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        D.setForeground(new java.awt.Color(100, 116, 139));
        D.setText("D");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(100, 116, 139));
        jLabel6.setText("Jawaban:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addGap(24, 24, 24)
                        .addComponent(btnSubmit))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(NoSoal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(D, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(C, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(A, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(182, 182, 182)))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(NoSoal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(A))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(B))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(C))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(D))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        this.UpdateJawaban();
        this.noQuestion++;
        this.initAlgos();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        this.UpdateJawaban();
        this.noQuestion--;
        this.initAlgos();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        UpdateJawaban();
        SubmitJawaban();
        DeleteExamAcces ();
        
        new DashboardUser(this.connectionDB,Integer.toString( this.userId)).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DoExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DoExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DoExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DoExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DoExam().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton A;
    private javax.swing.JRadioButton B;
    private javax.swing.JRadioButton C;
    private javax.swing.JRadioButton D;
    private javax.swing.JLabel NoSoal;
    private javax.swing.JTextArea TxtSoal;
    private javax.swing.JButton btnNext;
    private javax.swing.ButtonGroup btnPilihanGanda;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
