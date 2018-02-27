package com.wqw.java;


import java.io.File;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;

/**
 * Decription:
 *
 * @author WangQiuWei
 * @since 2017/3/8
 */
public class AmrToMp3 {

    public static void main(String[] args) throws Exception {
        change("/Users/didi/Desktop/a.mar");
    }

    public static void change(String path) {
        File source = new File(path);
        File target = new File("/Users/didi/Desktop/a.mp3");
        AudioAttributes audio = new AudioAttributes();
        Encoder encoder = new Encoder();
        audio.setCodec("libmp3lame");
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");
        attrs.setAudioAttributes(audio);

        try {
            encoder.encode(source, target, attrs);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InputFormatException e) {
            e.printStackTrace();
        } catch (EncoderException e) {
            e.printStackTrace();
        }
    }
}
