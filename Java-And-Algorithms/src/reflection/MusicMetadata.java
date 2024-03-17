package reflection;

import java.util.Date;

public class MusicMetadata {

    private String name;
    private final String author;
    private final byte[] audio;
    private final Date lastModified;

    public MusicMetadata(String name, String author, byte[] audio, Date lastModified) {
        this.name = name;
        this.author = author;
        this.audio = audio;
        this.lastModified = lastModified;
    }

    private void myMethod() {
        System.out.println("My Method Called");
    }

}
