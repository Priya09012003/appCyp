package com.example.appcyp;

public class FileModel {




        private String fileName;
        private String filePath;

        public FileModel(String fileName, String filePath) {
            this.fileName = fileName;
            this.filePath = filePath;
        }

        public String getFileName() {
            return fileName;
        }

        public String getFilePath() {
            return filePath;
        }
    }


