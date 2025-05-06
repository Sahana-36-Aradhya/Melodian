package Music_Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class DataRetrivalToPlaySong {

    private String filename;

    public DataRetrivalToPlaySong(String file) {
        this.filename = file;
    }

    public String getFile() {
        return filename;
    }

    public void setFile(String file) {
        this.filename = file;
    }

    public void playMusic() {
        try {
            File file = new File(filename); 
            Scanner scanner = new Scanner(System.in);  // Scanner for input
            AudioInputStream audio = AudioSystem.getAudioInputStream(file); // we are saying to get that audio at that location
            Clip clip = AudioSystem.getClip(); // This is mainly used for control
            clip.open(audio);

            String response = "";

            while (!response.equals("Q")) {
                System.out.println("P - Play");
                System.out.println("S - Stop");
                System.out.println("R - Reset");
                System.out.println("Q - Quit");
                System.out.print("Enter your choice: ");
                response = scanner.next().toUpperCase();

                switch (response) {
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("Sorry, no such operation.");
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("Hmm, sorry, I couldn't find the file.");
        } catch (LineUnavailableException l) {
            System.out.println("Hmm, audio line is unavailable.");
        } catch (UnsupportedAudioFileException a) {
            System.out.println("Sorry, the audio file is not supported.");
        } catch (IOException w) {
            System.out.println("Oops...! Something went wrong.");
        }
    }
}
