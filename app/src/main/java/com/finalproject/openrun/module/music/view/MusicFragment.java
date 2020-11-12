package com.finalproject.openrun.module.music.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.finalproject.openrun.R;
import com.finalproject.openrun.module.base.BaseFragment;
import com.finalproject.openrun.module.music.MusicContract;
import com.finalproject.openrun.module.music.model.Song;
import com.finalproject.openrun.module.music.presenter.MusicPresenter;

public class MusicFragment extends BaseFragment implements MusicContract.View {

    private MusicPresenter mMusicPresenter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_music, container, false);
        final TextView textView = root.findViewById(R.id.text_home);

        return root;
    }

    @Override
    public void showLoadding() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void updateSongState() {

    }

    @Override
    public void onSongClick(Song song, Boolean isPlaying) {

    }
}