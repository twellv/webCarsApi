package ecommerce.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public static final String FILE_PATH ="C:\\Users\\Twellv\\IdeaProjects\\webCarsApi\\loggerftw.txt";

    private static boolean creatingLogger() {
     boolean verify = false;

        try{
            File myMainLogger = new File(FILE_PATH);
            verify = myMainLogger.createNewFile();
        } catch(IOException ex) {
            System.err.println(ex.getMessage());
        }
     return verify;
    }

    private static void saveWhatIWrote(String string){
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true);
                BufferedWriter myWriter = new BufferedWriter(fileWriter)){

            myWriter.write(string);
            myWriter.newLine();
        } catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }

    private static String criandoTimeStamp() {
        LocalDateTime localDateTime =  LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }

    public static void sendInfo(String string) {
        String timeStamp = "["+criandoTimeStamp()+"] [INFO] ";
        saveWhatIWrote(timeStamp + string);
    }

    public static void sendError(String string) {
        String timeStamp = "["+criandoTimeStamp()+"] [ERROR] ";
        saveWhatIWrote(timeStamp + string);
    }


}
