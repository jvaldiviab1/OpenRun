package com.finalproject.openrun.module.music.data.model;

public class UtilMusic {
    public String timeMillisTimes(Long duration){
        Long minutes = duration / 60000;
        Long seconds = duration % 60000 / 1000;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
