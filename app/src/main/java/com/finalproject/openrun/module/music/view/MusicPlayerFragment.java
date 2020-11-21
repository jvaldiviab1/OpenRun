package com.finalproject.openrun.module.music.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.finalproject.openrun.R;
import com.finalproject.openrun.module.music.data.model.Song;
import com.finalproject.openrun.module.music.viewmodel.MusicPlayerViewModel;

public class MusicPlayerFragment extends Fragment {

    public static final String TAG_FRAGMENT_MUSIC_BAR = "tag_fragment_music_bar";
    public static final String TAG_MUSIC_PLAYER_VIEW_PAGER = "tag_music_player_view_pager";
    public static final String STORAGE_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
    private static final int REQUEST_READ_STORAGE = 10002;

    private MusicPlayerViewModel viewModel;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_music, container, false);
        final TextView textView = root.findViewById(R.id.text_home);

        return root;
    }

}