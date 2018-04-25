package com.example.anthonyeisenback.musicplayer.Utilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anthonyeisenback.musicplayer.R;
import com.example.anthonyeisenback.musicplayer.Song;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private List<Song> songList;
    private Song songCreator;
    private AdapterCallback adapterCallback;

    public SongAdapter(List<Song> songList, AdapterCallback adapterCallback) {
        this.songList = songList;
        this.adapterCallback = adapterCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(songList.get(position));


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.artist_name_textview)
        protected TextView artistName;
        @BindView(R.id.song_time_textview)
        protected TextView songTime;
        @BindView(R.id.song_name_textview)
        protected TextView songName;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Song songCreator) {
            songName.setText(adapterCallback.getContext().getString(R.string.song_name, songCreator.getSongTitle()));
            artistName.setText(adapterCallback.getContext().getString(R.string.artist_name, songCreator.getSongArtist()));
            songTime.setText(adapterCallback.getContext().getString(R.string.song_time, songCreator.getSongTime()));



        }

    }


    public interface AdapterCallback {
        Context getContext();
        void rowClicked(Song songCreator);
        void rowLongClicked(Song songCreator);

    }
}
