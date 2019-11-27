/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

/**
 *
 * @author s132054
 */
public class Tuner implements FrameProducer, Runnable{
    
    int channel;
    ProgramGuide guide;
    JPanel tunerPanel;
    
    BlockingQueue<StreamFrame> buffer;
    
    Map<Integer, File[]> channels;
    ChannelIterator currentChannelIterator;
    
    AudioInputStream fileInput;

    public Tuner(JPanel tunerPanel, JPanel programGuidePanel) {
        this.tunerPanel = tunerPanel;
        guide = new ProgramGuide(programGuidePanel);
        buffer = new LinkedBlockingDeque<>();
        
        // build list of channel source files based on directory structure
        channels = new HashMap<>();
        File[] channelDirectories = new File("./channels/").listFiles(File::isDirectory);
        for (File f : channelDirectories) {
            int channelNumber = Integer.parseInt(f.getName());
            File[] sourceFiles = f.listFiles();
            Arrays.sort(sourceFiles, (File o1, File o2) -> o1.getName().compareTo(o2.getName()));
            channels.put(channelNumber, sourceFiles);
            System.out.println("Channel " + channelNumber + " found");
            for (File sf: sourceFiles) {
                System.out.println("Program " + sf.getName() + " found");
            }
        }
    }

    @Override
    public BlockingQueue<StreamFrame> getStreamQueue() {
        return buffer;
    }

    @Override
    public void run() {
        // set channel at the start (lowest channel)?
        int lowestChannel = channels.keySet().stream().reduce(Integer.MAX_VALUE, (t, u) -> Math.min(t, u));
        setChannel(lowestChannel);
        
        // continuously fill buffer with stream frames from fileInput
        
        while (!Thread.interrupted()) {
            int lastChannel = channel;
            
            try {
                try {
                    File nextInputFile = currentChannelIterator.next();
                    System.out.println("Opening program " + nextInputFile.getName() + " on channel " + channel);
                    System.out.println("Buffer size: " + buffer.size());
                    fileInput = AudioSystem.getAudioInputStream(nextInputFile);
                } catch (UnsupportedAudioFileException ex) {
                    System.err.println("Invalid audio file at channel " + channel);
                    ex.printStackTrace();
                }

                int frameLength = fileInput.getFormat().getFrameSize();
                byte[] fileBuffer = new byte[frameLength];
                while (channel == lastChannel && fileInput.available() > frameLength) {
                    fileInput.read(fileBuffer);
                    StreamFrame sf = new StreamFrame(Arrays.copyOf(fileBuffer, frameLength));
                    buffer.add(sf);
                }
                // do not care about left-over bytes? 
                // (either less than one frame, or switching to other channel)
                fileInput.close();
                
            } catch (IOException ex) {
                System.err.println("IO error while reading file from channel " + channel);
                ex.printStackTrace();
            }
        }
    }
    
    
    ProgramGuide getProgramGuide() {
        return guide;
    }
    
    void setChannel(int channel) {
        this.channel = channel;
        currentChannelIterator = new ChannelIterator(channels.get(channel));
    }

    @Override
    public StreamFrame produceStream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    class ChannelIterator implements Iterator<File> {
        
        int next = 0;
        File[] channelFiles;

        public ChannelIterator(File[] channelFiles) {
            this.channelFiles = channelFiles;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public File next() {
            File nextFile = channelFiles[next];
            next++;
            next %= channelFiles.length;
            return nextFile;
        }
        
    }
}
