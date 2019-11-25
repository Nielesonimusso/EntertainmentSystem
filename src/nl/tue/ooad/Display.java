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
public class Display implements FrameConsumer {

    JPanel displayPanel;
    
    public Display(JPanel displayPanel) {
        this.displayPanel = displayPanel;
    }
    
    void turnOff() {
        
    }
    
    void turnOn() {
        
    }
    
    void playFrame() {
        
    }

    void pauseFrame() {
        
    }
    
    @Override
    public void consumeStream(StreamFrame stream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
