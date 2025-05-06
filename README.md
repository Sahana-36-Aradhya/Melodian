# 🎶 Melodian - Java Music Player

Melodian is a simple Java console-based `.wav` player that selects songs based on your mood.

## 🚀 Features
- Mood-based song menu
- Play, Stop, Reset, Quit options
- Clean audio control via Java Sound API
- Robust exception handling

## 🧱 Classes
- **Main.java** – Displays moods, handles input
- **WhichSongToPlay.java** – Maps mood → songs, builds file path
- **DataRetrivalToPlaySong.java** – Handles audio playback using `Clip`

## 🎧 Moods
Calm, Angry, Romantic, Sad, Devotion, Study, Meditation, Dark

## ⚙️ Requirements
- Java 11+
- `.wav` files under: `src/Music_Player/<mood>/`

## ▶️ Run

```bash
javac -d bin src/Music_Player/*.java
java -cp bin Music_Player.Main
