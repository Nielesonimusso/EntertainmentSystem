/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad.fake;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author s157106
 */
public class TFrameProducer implements Runnable {
 
    private final BlockingQueue<TStreamFrame> blockingQueue;
    
    public TFrameProducer(BlockingQueue<TStreamFrame> blockingQueue){
        this.blockingQueue = blockingQueue;
    }
    
    @Override
    public void run(){
        Random rnd = new Random();
        for (int i = 0; i <= 100; i++){
            try {
                TStreamFrame sf = new TStreamFrame(rnd.nextInt(256));
                System.out.println("Produced StreamFrame: " + sf.toString());
                blockingQueue.put(sf);                
            } catch (InterruptedException ie){
                System.out.println("Producer was interrupted!");
            }
        }
        System.out.println("Elements contained in blocking queue: " + blockingQueue.size());
    }
}
