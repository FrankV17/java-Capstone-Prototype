import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogManager {
    private static final String LOG_FILE = "energy_log.txt";

    // Write a log entry to the file
    public static void log(String message) {
        try {
            File logFile = new File(LOG_FILE);
            FileWriter fileWriter = new FileWriter(logFile, true); // true to append to file
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Get the current date and time
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            printWriter.printf("[%s] %s%n", timestamp, message);

            printWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }
}
