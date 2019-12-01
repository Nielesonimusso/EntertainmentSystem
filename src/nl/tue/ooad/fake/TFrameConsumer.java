/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad.fake;


import javax.sound.sampled.AudioFormat;

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
        System.out.println("Hi there!");
    }
}
