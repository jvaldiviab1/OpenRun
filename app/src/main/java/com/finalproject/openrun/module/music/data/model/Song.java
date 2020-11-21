package com.finalproject.openrun.module.music.data.model;

import android.net.Uri;

import java.util.Date;

public class Song {

    private long songId;
    private String songTitle;
    private String albumName;
    private String artistName;
    private Uri imagePath;

    private int songLength;
    private Date lastModified;
    private int songPlayCount;

    private int index;

    public Song(long songId, String songTitle, String albumName, String artistName, Uri imagePath, int songLength, Date lastModified, int songPlayCount) {
        this.songId = songId;
        this.songTitle = songTitle;
        this.albumName = albumName;
        this.artistName = artistName;
        this.imagePath = imagePath;
        this.songLength = songLength;
        this.lastModified = lastModified;
        this.songPlayCount = songPlayCount;
    }

    public Song(long songId, String songTitle, String albumName, String artistName, Uri imagePath, int songLength, Date lastModified) {
        this(songId, songTitle, albumName, artistName, imagePath, songLength, lastModified, 0);
    }

    public long getSongId() {
        return songId;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public Uri getImagePath() {
        return imagePath;
    }

    public int getSongLength() {
        return songLength;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public int getSongPlayCount() {
        return songPlayCount;
    }

    public int getIndex() {
        return index;
    }
}
