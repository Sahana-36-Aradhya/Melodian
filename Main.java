package Music_Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in); // Object creation for input
        WhichSongToPlay which = new WhichSongToPlay(scanner); // Pass scanner to the method

        String userName = null;
        
        File file = new File("userName");
        if(file.exists()) {
        	try(BufferedReader reader = new BufferedReader(new FileReader(file))){
        		userName = reader.readLine();
        	}
        	catch(FileNotFoundException f) {
        		System.out.println("Sorry we couldn't find the file...");
        	}
        	catch(IOException e) {
        		System.out.println("Opps, Somthing went wrong.....");
        	}
        }
        else {
        	System.out.print("Please enter your name: ");
            userName = scanner.nextLine();
        	try(FileWriter writer = new FileWriter(file)){
        		writer.write(userName);
        	}
        	catch(FileNotFoundException f) {
        		System.out.println("Sorry we couldn't find the file...");
        	}
        	catch(IOException e) {
        		System.out.println("Opps, Somthing went wrong.....");
        	}
        }

        System.out.println("\n----------------------------------------");
        System.out.println("Hello " + userName.toUpperCase() + " 🎙 Welcome to Melodian 🎶🎧");
        System.out.println("----------------------------------------");

        String[] moods = { // we are using loop to print the moods so no repetition of sysout
            "Calm 🕊", "Angry 🔥", "Romantic 💗", "Sad 😭",
            "Devotion 🌱", "Study 👩‍🎓", "Meditation 🎵", "Dark 👻"
        };

        boolean chooseMood = true;
        while (chooseMood) {
            System.out.println("\n---------- Choose Your Mood ----------");// printing mood
            for (int i = 0; i < moods.length; i++) {
                System.out.println((i + 1) + ". " + moods[i]);
            }
            System.out.println((moods.length + 1) + ". Exit 👋"); // if we enter length+1 value it will exit
            System.out.print("Enter your mood choice: ");

            int moodChoice = scanner.nextInt(); // taking the actual mood
            if (moodChoice >= 1 && moodChoice <= moods.length) { 
                String moodName = moods[moodChoice - 1].split(" ")[0];  // Remove emoji means wt is after the space last symbol
                which.playSongs(moodName); // we are passing to the method where we set path and play music
            } else if (moodChoice == moods.length + 1) {
                chooseMood = false;
                System.out.println("\nThank you for using Melodian, " + userName + "! 🎧✨"); // if exit then we will print this msg
            } else {
                System.out.println("Invalid mood. Please try again.");
            }
        }
        scanner.close(); // Only close scanner here
    }
}
