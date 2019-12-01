/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author s132054
 */
public class Recorder implements FrameConsumer, FrameProducer {
    
    PlayList playList;
    List<Program> plannedRecordings;
    JPanel recorderPanel;
    JList recordingJList;

    public Recorder(JPanel recorderPanel, JList jList) {
        plannedRecordings = new ArrayList<>();
        playList = new PlayList();
        this.recorderPanel = recorderPanel;
        this.recordingJList = jList;
          recordingJList.setModel(new javax.swing.AbstractListModel<String>() {           
            public int getSize() { return playList.recordings.size(); }
            public String getElementAt(int i) { return playList.recordings.get(i).name; }
        });
    }
    
    void cancelPlannedRecording(Program program) {
        
    }

    void continuePlayingRecording() {
        
    }
    
    PlayList getRecordingPlayList() {
       
        return playList;
    }
    
    void pausePlayingRecording() {
        
    }
    
    void planRecording(Program program) {
        
    }
    
    void playRecording(Recording recording) {
        
    }
    
    void startRecording() {
        
    }
    
    void stopPlayingRecording() {
        
    }
    
    void stopRecording() {
        
    }

    @Override
    public void consumeStream(StreamFrame stream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StreamFrame produceStream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BlockingQueue<StreamFrame> getStreamQueue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}
}
