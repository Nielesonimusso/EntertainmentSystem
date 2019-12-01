/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;
/**
 *
 * @author s132054
 */
public class Display implements FrameConsumer {


    private boolean isPlaying;
    private long clipPosition;
    private JPanel displayPanel;
    private Clip streamSource;
    
    public Display(JPanel displayPanel) {
        this.displayPanel = displayPanel;
    }

    @Override
    public void setStreamSource(Clip streamSource) {
        this.streamSource = streamSource;
    }

    public void play(){
        streamSource.setFramePosition(0);
        streamSource.start();
    }
         
    void playStream() {
        streamSource.setMicrosecondPosition(clipPosition);
        streamSource.start();
        isPlaying = true;
    }

    void pauseStream() {
        clipPosition = streamSource.getMicrosecondPosition();
        streamSource.stop();
        isPlaying = false;
    }
}
