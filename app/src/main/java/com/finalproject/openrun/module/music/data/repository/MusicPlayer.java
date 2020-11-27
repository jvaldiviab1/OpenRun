package com.finalproject.openrun.module.music.data.repository;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;

import androidx.lifecycle.MutableLiveData;

import com.finalproject.openrun.module.music.data.Constants;
import com.finalproject.openrun.module.music.data.model.Song;
import com.finalproject.openrun.module.music.services.MusicService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {

    public static final String CONTENT_MEDIA_EXTERNAL_AUDIO_ALBUMART = "content://media/external/audio/albumart";
    private static MusicPlayer instance;

    public static MusicPlayer getInstance(){
        if (instance == null)
            instance = new MusicPlayer();
        return instance;
    }

    private final MutableLiveData<MediaPlayer> mediaPlayer = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isPlaying = new MutableLiveData<>();
    private final MutableLiveData<Song> playingSong = new MutableLiveData<>();
    private final MutableLiveData<List<Song>> playingList = new MutableLiveData<>();

    private Context playingContext;

    private MusicPlayer(){
        this.mediaPlayer.setValue(new MediaPlayer());
        this.isPlaying.setValue(mediaPlayer.getValue().isPlaying());
    }

    public void loadMusics(ContentResolver contentResolver){
        Cursor cursor = contentResolver.query(Constants.externalMusicUri,null, null, null, null);
        List<Song> songs = new ArrayList<>();

        while(cursor.moveToNext()){
            String songId = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
            String songTitle = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
            String songAlbum = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
            String songArtist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            String songLength = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));

            Uri songCoverUri = null;

            if (songLength == null)
                continue;
            if (cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)) != null && !cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)).equals(""))
                songCoverUri = ContentUris.withAppendedId(Uri.parse(CONTENT_MEDIA_EXTERNAL_AUDIO_ALBUMART), Long.parseLong(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID))));

            Song thisLoopSong = new Song(Long.parseLong(songId), songTitle, songAlbum, songArtist, songCoverUri, Integer.parseInt(songLength), null);
            songs.add(thisLoopSong);
        }

        cursor.close();
        SongRepository.getInstance().setAllSongs(songs);
    }

    public void playMusic(Song song, final Context context) throws IOException {
        playingContext = context;

        mediaPlayer.getValue().stop();

        playingSong.setValue(song);

        Uri contentUri = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, playingSong.getValue().getSongId());

        mediaPlayer.setValue(new MediaPlayer());
        mediaPlayer.getValue().setAudioAttributes(new AudioAttributes.Builder()
                .setLegacyStreamType(AudioManager.STREAM_MUSIC)
                .build());
        mediaPlayer.getValue().setDataSource(context.getApplicationContext(), contentUri);
        mediaPlayer.getValue().setOnCompletionListener(mediaPlayer -> {
            try {
                if (song.getIndex() + 1 < playingList.getValue().size())
                    playMusic(playingList.getValue().get(song.getIndex() + 1), context);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        mediaPlayer.getValue().prepare();
        mediaPlayer.getValue().start();

        bindService();

        isPlaying.setValue(true);
    }

    public MutableLiveData<Song> getPlayingSong() {
        return playingSong;
    }

    public void resume() {
        mediaPlayer.getValue().start();
        isPlaying.setValue(true);
        bindService();
    }

    public void pause() {
        mediaPlayer.getValue().pause();
        isPlaying.setValue(false);
        bindService();
    }

        private void bindService() {
        // Run Service
        Intent intent = new Intent(playingContext, MusicService.class);
        playingContext.startForegroundService(intent);
    }

    public MutableLiveData<Boolean> isPlaying() {
        return isPlaying;
    }

    public MutableLiveData<List<Song>> getPlayingList() {
        return playingList;
    }

    public MutableLiveData<MediaPlayer> getMediaPlayer() {
        return mediaPlayer;
    }


}
