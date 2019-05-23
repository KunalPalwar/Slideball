package com.example.java;

import javax.sound.midi.*;

public class Sound {
    Sequencer sequencer;
    Sequence sequence;
    Track track;



    public void setupMidi(int instrument,int key){
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();


            MidiEvent event =null;
            ShortMessage first =new ShortMessage();
            first.setMessage(192,1,instrument,50);
            MidiEvent changeInst = new MidiEvent(first,1);
            track.add(changeInst);


            ShortMessage a =new ShortMessage();
            a.setMessage(144,1,key,120);
            MidiEvent noteOn = new MidiEvent(a,1);
            track.add(noteOn);

            ShortMessage b =new ShortMessage();
            b.setMessage(128,1,key,120);
            MidiEvent noteOff = new MidiEvent(b,6);
            track.add(noteOff);

            sequencer.setSequence(sequence);
            sequencer.start();
            sequencer.setTempoInBPM(120);


        }catch(Exception e){
            e.printStackTrace();

        }}
//    public MidiEvent makeEvent(int one,int two,int three,int four,int tick ){
//        MidiEvent event=null;
//        try{
//
//            ShortMessage a= new ShortMessage();
//            a.setMessage(one,two,three,four);
//            event = new MidiEvent(a,tick);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return event;
//    }

}
