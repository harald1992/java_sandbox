package org.harald;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class YoutubeDLVideoDownloader {

    private final String downloadsFolder = System.getProperty("user.home") + "/Downloads";

    public void download() {
        // String videoUrl =
        //         "https://www.youtube.com/watch?v=V374Nre2aVA&list=PLGWM-WydG5jJeW7pu2RDkLvd-_-zDkqw3&index=8&ab_channel=JavaDevelopmentJournal";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Paste your youtube url here:");
        String videoUrl = scanner.nextLine();
// String outputUrl = -o ~/YouTube/%(title)s.%(ext)s


        ProcessBuilder processBuilder = new ProcessBuilder(
                downloadsFolder + "/yt-dlp_macos",
                "--progress",
                "--output", downloadsFolder + "/%(title)s.%(ext)s",  // Specify the full path to the output file
                videoUrl);

        try {
            Process process = processBuilder.start();
            System.out.println("Starting the download (will do all videos of the playlist?");
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Video downloaded successfully!");
            } else {
                // Print any error message from yt-dlp
                InputStream errorStream = process.getErrorStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(errorStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
