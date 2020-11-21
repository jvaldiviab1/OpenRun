package com.finalproject.openrun.module.music.data.repository;

public class SongRepository {

    private static SongRepository instance;

    public static SongRepository getInstance(){
        if(instance == null)
            instance = new SongRepository();
        return instance;
    }



}
