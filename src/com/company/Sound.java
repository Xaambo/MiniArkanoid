package com.company;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
    public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("audios/ball.wav"));
    public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("audios/gameover.wav"));
    public static final AudioClip BACK = Applet.newAudioClip(Sound.class.getResource("audios/back.wav"));
}