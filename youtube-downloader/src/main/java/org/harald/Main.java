package org.harald;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    private static final String downloadsFolder = System.getProperty("user.home") + "/Downloads/";

    private static final Scanner scanner = new Scanner(System.in);

    private static String youtubeVideoUrl;

    private static URL url;

    private static String videoName = "lala" + ".mp4";


    public static void main(String[] args) {

        // scanUrl();
        // downloadYoutubeVideo();
        // writeFile();
        YoutubeDLVideoDownloader downloader = new YoutubeDLVideoDownloader();
        downloader.download();
    }

    private static void scanUrl() {
        System.out.println("Youtube URL:");
        youtubeVideoUrl = scanner.nextLine();

        // DOWNLOAD
        try {
            url = new URL(youtubeVideoUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }


    private static void downloadYoutubeVideo() {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                System.out.println("connection OK");
                String filePath = downloadsFolder + videoName;

                try (
                        InputStream inputStream = connection.getInputStream();
                        FileOutputStream outputStream = new FileOutputStream(filePath)
                )
                {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    System.out.println("Video downloaded successfully!");

                } catch(FileNotFoundException fnfe){
                    fnfe.printStackTrace();
                }
            } else {
                System.out.println("Failed to download video. HTTP error code: " + connection.getResponseCode());
            }
    } catch(IOException e) {
        e.printStackTrace();
    }
}

private static void writeFile() {
    // TODO: Exctract video name from url.

    System.out.println("downloading from: " + youtubeVideoUrl);
    String filePath = downloadsFolder + videoName;
    File file = new File(filePath);
    System.out.println(file.toString());

    try (
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
    ) {
        writer.write("lala");

    } catch (IOException ioe) {
        ioe.printStackTrace();
    }

}


}