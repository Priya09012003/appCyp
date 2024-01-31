package com.example.appcyp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


    public class FilesAdapter extends RecyclerView.Adapter<FilesAdapter.ViewHolder> {

        private List<FileModel> fileList;

        public FilesAdapter(List<FileModel> fileList) {
            this.fileList = fileList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            FileModel file = fileList.get(position);
            holder.fileNameTextView.setText(file.getFileName());
        }

        @Override
        public int getItemCount() {
            return fileList.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView fileNameTextView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                fileNameTextView = itemView.findViewById(R.id.fileNameTextView);
            }
        }
    }


