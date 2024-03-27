package fileio;

import java.io.*;
import java.util.Objects;

public class FileIOMain {

    public static void fileIOStart() {

        writeFile();
        readFile();


        inputAndOutputStreams_Bytes();

        inputAndOutputStreams_Characters();
    }

    private static void writeFile() {
        String[] names = {"John", "Carl", "Jerry"};
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("file-io-output.xml"));
            writer.write("Names");

            for (String name : names) {
                writer.write("\n" + name);
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("file-io-output.xml"));

            String result = "";
            String line;

            while ((line = reader.readLine()) != null) {
                // System.out.println(line);
                result += line + "\n";
            }
            System.out.println(result);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // bytestream for whenever you don't know what it contains, reads byte per byte. Otherwise use character stream
    // input en outputstream zijn gewoon de bytes die doorgestuurd worden
    private static void inputAndOutputStreams_Bytes() {
        // characterstream for characters, reads char per char
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream("file-io-stream-input.xml");
            fileOutputStream = new FileOutputStream("file-io-stream-output.xml");

            // reads one byte at a time until end of file (-1).
            int content;
            while ((content = fileInputStream.read()) != -1) {
                fileOutputStream.write((byte) content);
            }


        } catch (IOException ignored) {
        } finally {
            if (!Objects.isNull(fileInputStream)) {
                try {
                    fileInputStream.close();
                } catch (IOException ignored) {
                }
            }
            if (!Objects.isNull(fileOutputStream)) {
                try {
                    fileOutputStream.close();
                } catch (IOException ignored) {
                }
            }
        }
    }


    private static void inputAndOutputStreams_Characters() {

        // using try-with-resources to auto-closel the streams, which you could also use for the byte stream stuff.
        try (
                FileReader readerStream = new FileReader("file-io-character-stream-input.txt");
                FileWriter writerStream = new FileWriter("file-io-character-stream-output.txt")
        ) {
            int content;
            while ((content = readerStream.read()) != -1) {
                writerStream.append((char) content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
