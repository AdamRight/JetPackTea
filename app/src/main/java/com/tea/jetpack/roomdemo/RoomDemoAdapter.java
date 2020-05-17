package com.tea.jetpack.roomdemo;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tea.jetpack.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangtea on 2020/5/17.
 */
public class RoomDemoAdapter extends RecyclerView.Adapter<RoomDemoAdapter.RoomDemoViewHolder> {

    List<Word> words = new ArrayList<>();

    public void setWords(List<Word> words) {
        this.words = words;
    }

    @NonNull
    @Override
    public RoomDemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.room_demo_cell_normal, parent, false);
        return new RoomDemoViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final RoomDemoViewHolder holder, int position) {
        Word word = words.get(position);
        holder.tvId.setText(String.valueOf(word.getId()));
        holder.tvChi.setText(word.getMeaning());
        holder.tvEng.setText(word.getWord());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://m.youdao.com/dict?le=eng&q=" + holder.tvEng.getText().toString());
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    static class RoomDemoViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvEng, tvChi;

        public RoomDemoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvEng = itemView.findViewById(R.id.tv_english);
            tvChi = itemView.findViewById(R.id.tv_chinese);
        }
    }
}
