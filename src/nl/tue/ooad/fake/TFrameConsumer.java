/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad.fake;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import nl.tue.ooad.FrameProducer;
import nl.tue.ooad.StreamFrame;

/**
 *
 * @author s157106
 */
public class TFrameConsumer implements Runnable {
    
    private TFrameProducer producer;
    //private BlockingQueue<StreamFrame> blockingQueue;
    private AudioFormat audioFormat;
    
    public TFrameConsumer(TFrameProducer producer){
        this.producer = producer;
    }
    
    public void setProducer(TFrameProducer producer){
        this.producer = producer;
    }
    
    @Override
    public void run(){
        
        try {
            
            boolean config = false;
            while(!config){
                if (producer.getAudioFormat() != null){
                    audioFormat = producer.getAudioFormat();
                    config = true;
                }
                Thread.sleep(100);
            }
            
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine soundLine = (SourceDataLine) AudioSystem.getLine(info);
            soundLine.open(audioFormat);
            soundLine.start();
            
            while(true){
                System.out.println("Consuming ***");
                StreamFrame sf = producer.getStreamFrameQueue().take();
                soundLine.write(sf.getFrame(), 0, sf.getFrame().length);
            }
        } catch (LineUnavailableException ex) {
            Logger.getLogger(TFrameConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(TFrameConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
