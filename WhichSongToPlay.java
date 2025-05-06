package Music_Player;

import java.util.*;

public class WhichSongToPlay {
    private Scanner scanner;
    private DataRetrivalToPlaySong data = new DataRetrivalToPlaySong(" ");

    // Mood to song mapping
    private final Map<String, String[][]> moodToSongs = Map.of(
        "Calm", new String[][] {
            {"Gamanava", "calm/Gamanava.wav"},
            {"Hejjegondu Hejje", "calm/Hejjegondu Hejje.wav"},
            {"Maleyali Joteyali", "calm/Maleyali Joteyali.wav"},
            {"Summane Heege Ninnane", "calm/Summane Heege Ninnane.wav"}
        },
        "Angry", new String[][] {
            {"abcdefu", "anger/abcdefu.wav"},
            {"Brutal", "anger/brutal.wav"},
            {"Good 4 U", "anger/good 4 u.wav"},
            {"Power", "anger/Power.wav"}
        },
        "Romantic", new String[][] {
            {"Ishq Wala Love", "romantic/Ishq-Wala-Love.wav"},
            {"Kabhi Jo Badal", "romantic/Kabhi-Jo-Badal-Barse.wav"},
            {"Mast Magan", "romantic/Mast-Magan.wav"},
            {"Ale Ale", "romantic/Savari-Ale-Ale.wav"}
        },
        "Sad", new String[][] {
            {"Birugali Yondige", "sad/Birugali Yondige.wav"},
            {"Finding Her", "sad/Finding Her.wav"},
            {"Husn", "sad/HUSN.wav"},
            {"Sanam Teri Kasam", "sad/Sanam Teri Kasam.wav"}
        },
        "Devotion", new String[][] {
            {"Ashtalakshmi Stotram", "devotion/Ashtalakshmi stotram.wav"},
            {"Karpura Gauram", "devotion/Karpura Gauram.wav"},
            {"Narayanam Namaskritya", "devotion/Narayanam Namaskritya.wav"},
            {"Shree Hari Stotram", "devotion/Shree Hari Stotram.wav"}
        },
        "Study", new String[][] {
            {"30 Min Timer", "study/30 Min Timer.wav"},
            {"Ancient Saraswati Mantra", "study/ANCIENT SARASWATI MANTRA.wav"},
            {"Calm Piano", "study/Calm Piano.wav"},
            {"Krishna Flute", "study/Krishna_Flute.wav"}
        },
        "Meditation", new String[][] {
            {"Calm", "meditation/calm.wav"},
            {"Om 108 Times", "meditation/Om.wav"},
            {"Shri Krishna Govind", "meditation/Shri krishna govind.wav"},
            {"Soothing Music", "meditation/Soothing Music.wav"}
        },
        "Dark", new String[][] {
            {"Bitch Boss", "dark/Doja Cat - Boss Btch.wav"},
            {"I Wanna Be Your Slave", "dark/I WANNA BE YOUR SLAVE.wav"},
            {"Love and War", "dark/Love and War.wav"},
            {"WTF", "dark/WTF.wav"}
        }
    );

    public WhichSongToPlay(Scanner scanner) {
        this.scanner = scanner;  // Receive the scanner from the main method
    }

    public void playSongs(String mood) {
        if (!moodToSongs.containsKey(mood)) {
            System.out.println("Invalid mood selected.");
            return;
        }

        String[][] songs = moodToSongs.get(mood);
        boolean terminate = true;

        while (terminate) {
            System.out.println("\n---------- " + mood + " Playlist 🎵 ----------");
            for (int i = 0; i < songs.length; i++) {
                System.out.println((i + 1) + ". " + songs[i][0]);
            }
            System.out.println((songs.length + 1) + ". Exit");
            System.out.print("Enter the song number you want to play: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            if (choice >= 1 && choice <= songs.length) {
                String basePath = System.getProperty("user.dir"); // project root
                String path = basePath + "/src/Music_Player/" + songs[choice - 1][1];
                data.setFile(path);
                data.playMusic();
            } else if (choice == songs.length + 1) {
                terminate = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
