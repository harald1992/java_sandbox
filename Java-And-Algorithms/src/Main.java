import static optionals.OptionalsMain.optionalsStart;
import static records.RecordsMain.recordsStart;
import static reflection.ReflectionMain.reflectionStart;
import static streams.StreamsMain.startStreams;

public class Main {

    public static void main(String[] args) {
        // startGraphs();
        // startStreams();
        // optionalsStart();
        // recordsStart();

        try {
            reflectionStart();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}