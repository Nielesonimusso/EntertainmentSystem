/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad;

import java.io.File;
import javax.sound.sampled.Clip;

/**
 *
 * @author s132054
 */
public interface FrameProducer {
    
    public void configStreamSource(String filePath);
    
    public Clip getStreamSource();
    
}
