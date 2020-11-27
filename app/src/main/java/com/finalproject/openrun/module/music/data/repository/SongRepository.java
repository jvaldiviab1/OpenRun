package com.finalproject.openrun.module.music.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.finalproject.openrun.module.music.data.model.Song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SongRepository {

    private static SongRepository instance;

    public static SongRepository getInstance(){
        if(instance == null)
            instance = new SongRepository();
        return instance;
    }

    private SongRepository(){
        isShuffleMode.setValue(false);
        isRepeatingMode.setValue(false);
    }

    private List<Song> allSongs = new ArrayList<>();

    private List<Song> shuffleSongs;

    private final MutableLiveData<Boolean> isShuffleMode = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isRepeatingMode = new MutableLiveData<>();

    public void setAllSongs(List<Song> allSongs){
        this.allSongs = allSongs;
    }

    public List<Song> getAllSongs(){
        return allSongs;
    }

    public List<Song> getShuffleTracks(){
        return shuffleSongs;
    }

    public List<Song> getTracks(String search){
        if(allSongs != null)
            return allSongs.stream().filter(song -> song.getSongTitle().toLowerCase().contains(search) || song.getAlbumName().toLowerCase().contains(search) || song.getArtistName().toLowerCase().contains(search)).collect(Collectors.toList());
        return new ArrayList<>();
    }

    public void makeShuffle() {
        shuffleSongs = new ArrayList<>(allSongs);
        Collections.shuffle(shuffleSongs);
    }


    public void switchShuffle() {
        isShuffleMode.setValue(!isShuffleMode.getValue());
        if (isShuffleMode.getValue()) makeShuffle();
    }
    public void switchRepeating() {
        this.isRepeatingMode.setValue(!isRepeatingMode.getValue());
    }

    public MutableLiveData<Boolean> isRepeating() {
        return isRepeatingMode;
    }

    public MutableLiveData<Boolean> isShuffle() {
        return isShuffleMode;
    }

    public Song goPreviousTrack() {
        return null;
    }

    public Song goNextTrack() {
        return null;
    }
}
