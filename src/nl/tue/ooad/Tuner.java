/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad;

import java.util.concurrent.BlockingQueue;
import javax.sound.sampled.AudioFormat;
import javax.swing.JPanel;

/**
 *
 * @author s132054
 */
public class Tuner{
    
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


}
