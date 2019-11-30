/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad.fake;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import nl.tue.ooad.FrameProducer;
import nl.tue.ooad.StreamFrame;

/**
 *
 * @author s157106
 */
public class TFrameProducer implements Runnable, FrameProducer {
 
    int BUFFER_SIZE = 64*1024; // 64 kb
    String AUDIO_FILENAME = "./sounds/JungleAnimalSounds.wav";
    
    private final BlockingQueue<StreamFrame> blockingQueue;
    private AudioFormat audioFormat = null;
    
    
    public TFrameProducer(BlockingQueue<StreamFrame> blockingQueue){
        this.blockingQueue = blockingQueue;
    }
    
    @Override
    public BlockingQueue<StreamFrame> getStreamFrameQueue(){
        return blockingQueue;
    }
    
    @Override
    public AudioFormat getAudioFormat(){
        return audioFormat;
    }
    
    @Override
    public void run(){
        try {            
            File soundFile = new File(AUDIO_FILENAME);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            audioFormat = audioInputStream.getFormat();
            
            // Write data to the blocking queue
            int nBytesRead = 0;
            byte[] sampledData = new byte[BUFFER_SIZE];
            while (nBytesRead != -1) {
                System.out.println("Producing ***");
                nBytesRead = audioInputStream.read(sampledData, 0, sampledData.length);
                if (nBytesRead >= 0) {
                    StreamFrame sf = new StreamFrame(sampledData);
                    blockingQueue.put(sf);
                }
                
                // Pause the thread some miliseconds
                Thread.sleep(20);
            }
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(TFrameProducer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TFrameProducer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(TFrameProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
