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
        clipPosition = 0;
    }

    
    @Override
    public void setProducer(FrameProducer producer){
        this.producer = producer;
    }
    
    public void configStreamSource(){
        if (producer != null){
            // Stop sound before changing audio to play
            if (streamSource != null){
                streamSource.stop();
                streamSource.drain();
                streamSource.close();              
            }
            streamSource = producer.getStreamSource();
            streamSource.addLineListener(this);
            mediaDuration = streamSource.getMicrosecondLength();
            clipPosition = 0;
        }
    }
    
    public boolean containsStreamSource(){
        return streamSource != null;
    }
    

    public void playStream() {
        if (streamSource != null){
            streamSource.setMicrosecondPosition(clipPosition);
            streamSource.start();
            isPlaying = true;
        }
    }

    public void pauseStream() {
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
            System.out.println("Playback paused.");
            System.out.println(streamSource.getMicrosecondPosition());
            System.out.println(mediaDuration);
            if (Math.abs(streamSource.getMicrosecondPosition() - mediaDuration) < 1000){
                System.out.println("Playback stopped.");
                streamSource.drain();
                streamSource.close();
                streamSource = null;
                configStreamSource();
                playStream();
            } 
        } 
    }
}
