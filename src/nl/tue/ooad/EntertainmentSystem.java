/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad;

/**
 *
 * @author s132054
 */
public class EntertainmentSystem extends javax.swing.JFrame {

    Recorder recorder;
    Tuner tuner;
    Display display;
    
    /**
     * Creates new form EntertainmentSystem
     */
    public EntertainmentSystem() {
        initComponents();
        
        //initialization of main component classes, passing on reference to their
        // respective JPanel
        recorder = new Recorder(recorderPanel, recordingJList);
        tuner = new Tuner(tunerPanel, programJList);
        display = new Display(displayPanel);
        
        new Thread(tuner).start();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayPanel = new javax.swing.JPanel();
        playButton = new javax.swing.JButton();
        tunerPanel = new javax.swing.JPanel();
        channelSelection = new javax.swing.JComboBox<>();
        channelSelectLabel = new javax.swing.JLabel();
        programGuidePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        programJList = new javax.swing.JList<>();
        programGuideToggleBtn = new javax.swing.JToggleButton();
        recorderPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        recordingJList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        displayPanel.setBackground(new java.awt.Color(255, 102, 102));

        playButton.setText("Play");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout displayPanelLayout = new javax.swing.GroupLayout(displayPanel);
        displayPanel.setLayout(displayPanelLayout);
        displayPanelLayout.setHorizontalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(playButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        displayPanelLayout.setVerticalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playButton)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        tunerPanel.setBackground(new java.awt.Color(153, 255, 153));

        channelSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        channelSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                channelSelectionActionPerformed(evt);
            }
        });

        channelSelectLabel.setText("Select Channel");

        programGuidePanel.setBackground(new java.awt.Color(255, 255, 153));

        jScrollPane1.setViewportView(programJList);

        javax.swing.GroupLayout programGuidePanelLayout = new javax.swing.GroupLayout(programGuidePanel);
        programGuidePanel.setLayout(programGuidePanelLayout);
        programGuidePanelLayout.setHorizontalGroup(
            programGuidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );
        programGuidePanelLayout.setVerticalGroup(
            programGuidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        programGuideToggleBtn.setText("Program Guide");
        programGuideToggleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programGuideToggleBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tunerPanelLayout = new javax.swing.GroupLayout(tunerPanel);
        tunerPanel.setLayout(tunerPanelLayout);
        tunerPanelLayout.setHorizontalGroup(
            tunerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tunerPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(channelSelectLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(channelSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(programGuideToggleBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(tunerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(programGuidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        tunerPanelLayout.setVerticalGroup(
            tunerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tunerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tunerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(channelSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(channelSelectLabel)
                    .addComponent(programGuideToggleBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(programGuidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        programGuideToggleBtn.getAccessibleContext().setAccessibleName("");

        recorderPanel.setBackground(new java.awt.Color(102, 204, 255));

        jScrollPane2.setViewportView(recordingJList);

        javax.swing.GroupLayout recorderPanelLayout = new javax.swing.GroupLayout(recorderPanel);
        recorderPanel.setLayout(recorderPanelLayout);
        recorderPanelLayout.setHorizontalGroup(
            recorderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recorderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        recorderPanelLayout.setVerticalGroup(
            recorderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recorderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tunerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(recorderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(displayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tunerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recorderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        
        if (playButton.getText().equals("Play")){
            play();
            playButton.setText("Pause");
        } else {
            pause();
            playButton.setText("Play");
        }       
    }//GEN-LAST:event_playButtonActionPerformed

    private void programGuideToggleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programGuideToggleBtnActionPerformed
        if(programGuideToggleBtn.isSelected()) {
            jScrollPane1.setVisible(true);
            ProgramGuide programGuide = new ProgramGuide(programJList);    
            programGuide.update();
        } else{
            jScrollPane1.setVisible(false);
        }
              
    }//GEN-LAST:event_programGuideToggleBtnActionPerformed

    private void channelSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_channelSelectionActionPerformed
        // TODO add your handling code here:  
    }//GEN-LAST:event_channelSelectionActionPerformed

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
            java.util.logging.Logger.getLogger(EntertainmentSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntertainmentSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntertainmentSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntertainmentSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntertainmentSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel channelSelectLabel;
    private javax.swing.JComboBox<String> channelSelection;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton playButton;
    private javax.swing.JPanel programGuidePanel;
    private javax.swing.JToggleButton programGuideToggleBtn;
    private javax.swing.JList<String> programJList;
    private javax.swing.JPanel recorderPanel;
    private javax.swing.JList<String> recordingJList;
    private javax.swing.JPanel tunerPanel;
    // End of variables declaration//GEN-END:variables

    void play() {
        if (!display.containsStreamSource()){
            display.setStreamSource(tuner.getStreamSource());
            display.playStream();
        } else {
            display.playStream();        
        }
    }
    
    void pause() {
        display.pauseStream();
    }
    
    void stop() {
        
    }
    
    void forward() {
        
    }
    
    void backward() {
        
    }
}

