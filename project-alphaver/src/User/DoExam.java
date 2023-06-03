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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Soal : ");

        btnPilihanGanda.add(A);
        A.setText("A");

        btnPilihanGanda.add(B);
        B.setText("B");

        btnPilihanGanda.add(C);
        C.setText("C");

        btnNext.setText("Next ");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        TxtSoal.setEditable(false);
        TxtSoal.setColumns(20);
        TxtSoal.setRows(5);
        jScrollPane2.setViewportView(TxtSoal);

        btnPrev.setText("Prev");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel1.setText("A.");

        jLabel3.setText("B.");

        jLabel4.setText("C.");

        jLabel5.setText("D.");

        btnPilihanGanda.add(D);
        D.setText("D");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 157, Short.MAX_VALUE)
                                .addComponent(btnPrev)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNext)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSubmit)))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NoSoal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(A))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(B))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(C))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(D)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(NoSoal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(A))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(B))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(C))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNext)
                            .addComponent(btnPrev)
                            .addComponent(btnSubmit)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(D))))
                .addGap(17, 17, 17))
        );

        pack();
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
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
