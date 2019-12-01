/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.JPanel;

/**
 *
 * @author s132054
 */
public class Display implements FrameConsumer, LineListener {

    private boolean isPlaying;
    private long clipPosition;
    private long mediaDuration;
    private JPanel displayPanel;
    private Clip streamSource;
    private FrameProducer producer;
    
    
    public Display(JPanel displayPanel) {
        this.displayPanel = displayPanel;
        streamSource = null;
        mediaDuration = 0;
    }

    
    public void setProducer(FrameProducer producer){
        this.producer = producer;
    }
    
    @Override
    public void setStreamSource(Clip streamSource) {
        this.streamSource = streamSource;
        mediaDuration = streamSource.getMicrosecondLength();
    }

    public boolean containsStreamSource(){
        return streamSource != null;
    }
    
    public void play(){
        streamSource.setFramePosition(0);
        streamSource.start();
    }
         
    void playStream() {
        if (streamSource != null){
            streamSource.setMicrosecondPosition(clipPosition);
            streamSource.start();
            isPlaying = true;
        }
    }

    void pauseStream() {
        if (streamSource != null) {
            clipPosition = streamSource.getMicrosecondPosition();
            streamSource.stop();
            isPlaying = false;            
        }
    }

    @Override
    public void update(LineEvent event) {
         LineEvent.Type type = event.getType();
         
        if (type == LineEvent.Type.START) {
            System.out.println("Playback started.");
             
        } else if (type == LineEvent.Type.STOP) {
            System.out.println("Playback completed.");
        }
    }
}
