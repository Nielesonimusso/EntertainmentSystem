/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author s132054
 */
public interface FrameProducer {
    
    StreamFrame produceStream();
    
    BlockingQueue<StreamFrame> getStreamQueue();
    
}
