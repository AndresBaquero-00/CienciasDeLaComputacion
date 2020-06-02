/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cambiomonedas;

/**
 *
 * @author leeyn
 */
public class Resultado extends javax.swing.JFrame {

    /**
     * Creates new form Resultado
     */
    String[][] imprimir;
    int[] livalores;
    int iC;
    int n;
    String[][] all;

    public Resultado(String[][] imprimir, int[] livalores, int iC, int n) {
        this.imprimir = imprimir;
        this.livalores = livalores;
        this.iC = iC;
        this.n = n;
        initComponents();
    }

    public Resultado() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        taResul = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        taResumido = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        taResul.setColumns(20);
        taResul.setRows(5);
        jScrollPane1.setViewportView(taResul);

        taResumido.setColumns(20);
        taResumido.setRows(5);
        jScrollPane2.setViewportView(taResumido);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        all = new String[n + 2][iC + 2];

        all[0][0] = "Valores";
        for (int j = 1; j < iC + 2; j++) {
            all[0][j] = String.valueOf(j - 1);
        }
        for (int i = 2; i < n + 2; i++) {
            all[i][0] = "val: " + livalores[i - 2];
        }
        for (int i = 1; i < n + 2; i++) {
            for (int j = 1; j < iC + 2; j++) {
                all[i][j] = imprimir[i - 1][j - 1];
            }
        }
        String s;
        for (int i = 0; i < n + 2; i++) {
            s = "";
            for (int j = 0; j < iC + 2; j++) {
                s += "" + all[i][j];
                s += "\t|\t";
            }
            taResul.append("\n" + s + "\n");
        }
        String c = "";
        String[] div = all[all.length - 1][all[0].length - 1].split("~");
        String[] rela = div[0].split(" ");

        for (int br = 1; br < div.length; br++) {

            String[] data = div[br].split(":");
            for(int g=0;g<data.length;g++){
                System.out.println(data[g]+"-");
            }
            c += "\t"+data[0] + " moneda de: " + data[1] + "\t";
        }
        taResumido.append("\n" + c + "\n");
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Resultado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taResul;
    private javax.swing.JTextArea taResumido;
    // End of variables declaration//GEN-END:variables
}
