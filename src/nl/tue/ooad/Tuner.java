/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad;

import javax.swing.JPanel;

/**
 *
 * @author s132054
 */
public class Tuner implements FrameProducer {
    
    int channel;
    ProgramGuide guide;
    JPanel tunerPanel;

    public Tuner(JPanel tunerPanel, JPanel programGuidePanel) {
        this.tunerPanel = tunerPanel;
        guide = new ProgramGuide(programGuidePanel);
    }
    
    
    
    ProgramGuide getProgramGuide() {
        return guide;
    }
    
    void setChannel(int channel) {
        
    }

    @Override
    public StreamFrame produceStream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
