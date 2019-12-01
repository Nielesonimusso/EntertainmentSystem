/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad.fake;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import nl.tue.ooad.FrameProducer;
import nl.tue.ooad.StreamFrame;

/**
 *
 * @author s157106
 */
public class TFrameProducer implements FrameProducer {
 
    int BUFFER_SIZE = 64*1024; // 64 kb

    
    private Clip streamSource = null;
    
    @Override
    public void configStreamSource(String inputFilename){
        AudioInputStream audioIn = null;
        try {
            URL url = this.getClass().getClassLoader().getResource(inputFilename);
            audioIn = AudioSystem.getAudioInputStream(url);
            streamSource = AudioSystem.getClip();
            streamSource.open(audioIn);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(TFrameProducer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                audioIn.close();
            } catch (IOException ex) {
                Logger.getLogger(TFrameProducer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public Clip getStreamSource(){
        return streamSource;
    }
}
