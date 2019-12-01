/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad;

import javax.swing.JList;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

/**
 *
 * @author s132054
 */
public class Tuner implements FrameProducer, Runnable {

    int channel;
    boolean nextProgramLoaded = true;
    ProgramGuide guide;
    JPanel tunerPanel;

    Map<Integer, File[]> channels;
    ChannelIterator currentChannelIterator;

    AudioInputStream fileInput;
    Clip streamSource;

    public Tuner(JPanel tunerPanel, JList programJList) {
        this.tunerPanel = tunerPanel;
        guide = new ProgramGuide(programJList);

        // build list of channel source files based on directory structure
        channels = new HashMap<>();
        File[] channelDirectories = new File("./channels/").listFiles(File::isDirectory);
        for (File f : channelDirectories) {
            int channelNumber = Integer.parseInt(f.getName());
            File[] sourceFiles = f.listFiles();
            Arrays.sort(sourceFiles, (File o1, File o2) -> o1.getName().compareTo(o2.getName()));
            channels.put(channelNumber, sourceFiles);
            System.out.println("Channel " + channelNumber + " found");
            for (File sf : sourceFiles) {
                System.out.println("Program " + sf.getName() + " found");
            }
        }
    }

    @Override
    public void run() {
        // set channel at the start (lowest channel)?
        int lowestChannel = channels.keySet().stream().reduce(Integer.MAX_VALUE, (t, u) -> Math.min(t, u));
        setChannel(lowestChannel);

        // continuously fill buffer with stream frames from fileInput
        while (!Thread.interrupted()) {
            int lastChannel = channel;

            if (!nextProgramLoaded) {
                File nextInputFile = currentChannelIterator.next();
                System.out.println("Opening program " + nextInputFile.getName() + " on channel " + channel);
                String filePath = "" + "./" + channel + "/" + nextInputFile.getName();
                System.out.println(filePath);
                configStreamSource(filePath);
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
    public void configStreamSource(String filePath) {
        AudioInputStream audioIn = null;
        try {
            URL url;
            url = this.getClass().getClassLoader().getResource(filePath);
            audioIn = AudioSystem.getAudioInputStream(url);
            streamSource = AudioSystem.getClip();
            streamSource.open(audioIn);
            nextProgramLoaded = true;
            System.out.println(audioIn.getFormat());
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(FrameProducer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                audioIn.close();
            } catch (IOException ex) {
                Logger.getLogger(FrameProducer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Clip getStreamSource() {
        nextProgramLoaded = false;
        while(!nextProgramLoaded){
            try {
                Thread.sleep(20);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        //
        return streamSource;
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
