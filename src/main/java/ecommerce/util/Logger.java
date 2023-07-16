package ecommerce.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public static final String FILE_PATH ="C:\\Users\\Twellv\\IdeaProjects\\ecommerceX-backend\\loggerftw.txt";

    private static boolean creatingLogger() {
     boolean b = false;

        try{
            File myMainLogger = new File(FILE_PATH);
            if(!myMainLogger.exists()) {
                myMainLogger.createNewFile(); // true if the named file does not exist
                System.out.println("File created: "+myMainLogger.getName());
            }
        } catch(IOException exception) {
            exception.getMessage();
            exception.printStackTrace();
        }
     return b;
    }

    private static void saveWhatIWrote(String string){
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH, true);
            BufferedWriter myWriter = new BufferedWriter(fileWriter);

            myWriter.write(string);
            myWriter.newLine();

            myWriter.close();
            fileWriter.close();
        } catch(IOException exception){
            exception.printStackTrace();
            exception.getMessage();
        }
    }

    private static String criandoTimeStamp() {
        LocalDateTime localDateTime =  LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeStamp = localDateTime.format(formatter);
        return timeStamp;
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
