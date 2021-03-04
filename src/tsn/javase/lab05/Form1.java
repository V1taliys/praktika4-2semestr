package tsn.javase.lab05;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

public class Form1 extends javax.swing.JFrame {

    public Form1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Fam = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton_Pazdr = new javax.swing.JButton();
        jButton_Fam_Clear = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jEditorPane_Pozdr = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Работа со строками в Java");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png")));
        setResizable(false);
        getContentPane().setLayout(null);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTextArea_Fam.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea_Fam.setColumns(20);
        jTextArea_Fam.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextArea_Fam.setLineWrap(true);
        jTextArea_Fam.setRows(5);
        jTextArea_Fam.setWrapStyleWord(true);
        jTextArea_Fam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(jTextArea_Fam);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 30, 316, 180);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 240, 0);

        jButton_Pazdr.setText("ok");
        jButton_Pazdr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PazdrActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Pazdr);
        jButton_Pazdr.setBounds(160, 430, 170, 23);

        jButton_Fam_Clear.setText("Очистка");
        jButton_Fam_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Fam_ClearActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Fam_Clear);
        jButton_Fam_Clear.setBounds(191, 220, 140, 23);

        jEditorPane_Pozdr.setEditable(false);
        jEditorPane_Pozdr.setBackground(new java.awt.Color(255, 255, 153));
        jEditorPane_Pozdr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jEditorPane_Pozdr.setContentType("text/html"); // NOI18N
        jEditorPane_Pozdr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane4.setViewportView(jEditorPane_Pozdr);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(10, 260, 320, 150);

        setSize(new java.awt.Dimension(366, 512));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_PazdrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PazdrActionPerformed
           // Нажатие кнопки поздравить
        ArrayList<String> fam = new ArrayList<>();   // Массив фамилий
        jEditorPane_Pozdr.setText(null); // Очищаем область поздравлений
        // Заполнение массива персон
        try { // Проверка введенных пользователем фамилий
            for (int i = 0; i < jTextArea_Fam.getLineCount(); i++) {
                int start = jTextArea_Fam.getLineStartOffset(i);
                int end = jTextArea_Fam.getLineEndOffset(i);
                // Проверяем является ли строка пустой (== - не работает)
                String line = jTextArea_Fam.getText(start, end - start).trim();
                if (line.equals("")) {
                    continue;
                }
                fam.add(line); // добавление фамилии в массив
            }
        } catch (BadLocationException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ошибка чтения фамилий",
                    "Ошибка данных", JOptionPane.ERROR_MESSAGE);
            return; // Выход
        }
   

        int vMin = fam.get(0).length();
        int vMax = fam.get(0).length();


        for (int i = 0; i < fam.size(); i++) {
            if (fam.get(i).length() < vMin) {
                vMin = fam.get(i).length();

            } else {
                if (fam.get(i).length() > vMax) {
                    vMax = fam.get(i).length();

                }
            }
        }
         StringBuilder s = new StringBuilder("<p align=\"center\"><cite><b><font size=\"5\">");
                      s.append("Букв в самом длином слове:" + vMax + "<br>" + "Букв в самом коротком слове:" + vMin );

        jEditorPane_Pozdr.setText(s.toString());
    }//GEN-LAST:event_jButton_PazdrActionPerformed

    private void jButton_Fam_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Fam_ClearActionPerformed
        // Очистка списка фамилий
        jTextArea_Fam.setText(null);
    }//GEN-LAST:event_jButton_Fam_ClearActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Fam_Clear;
    private javax.swing.JButton jButton_Pazdr;
    private javax.swing.JEditorPane jEditorPane_Pozdr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea_Fam;
    // End of variables declaration//GEN-END:variables
}
