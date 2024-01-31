package com.example.appcyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FilesAdapter filesAdapter;
    private List<FileModel> fileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate");

        recyclerView = findViewById(R.id.recyclerView);
        fileList = new ArrayList<>();
        filesAdapter = new FilesAdapter(fileList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(filesAdapter);

        File privateDir = getFilesDir();
        Log.d("MainActivity", "Private directory path: " + privateDir.getAbsolutePath());
        displayFiles(privateDir);

        Log.d("MainActivity", "onCreate completed");
    }


    private void displayFiles(File directory) {
        Log.d("MainActivity", "displayFiles called for directory: " + directory.getAbsolutePath());

        if (!directory.isDirectory()) {
            Log.d("MainActivity", "Not a directory: " + directory.getAbsolutePath());
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            List<FileModel> newFileList = new ArrayList<>();

            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    String filePath = file.getAbsolutePath();
                    newFileList.add(new FileModel(fileName, filePath));
                    Log.d("MainActivity", "Added file: " + fileName + " at path: " + filePath);
                }
            }

            
            Log.d("MainActivity", "New FileList size: " + newFileList.size());


            if (!newFileList.isEmpty()) {
                Collections.sort(newFileList, (file1, file2) ->
                        Long.compare(new File(file2.getFilePath()).lastModified(),
                                new File(file1.getFilePath()).lastModified()));

                fileList.clear();
                fileList.addAll(newFileList);


                Log.d("MainActivity", "Updated FileList size: " + fileList.size());

                filesAdapter.notifyDataSetChanged();
            } else {
                Log.d("MainActivity", "No new files to add.");
            }
        } else {
            Log.d("MainActivity", "Files array is null");
        }
    }



}

