package Question3.Adapter;

import Question3.Adapter.Logs.Logger;

import java.util.Scanner;

public class AdapterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger.log("MediaPlayerApp started.");
        
        String continuePlaying;

        do {
            try {
                LegacyMediaPlayer legacyPlayer = new LegacyMediaPlayer();
                MediaPlayerAdapter adapter = new MediaPlayerAdapter(legacyPlayer);

                System.out.println("Enter the file format you want to play (mp3/mp4/flac/wav): ");
                String format = scanner.nextLine().trim().toLowerCase();

                System.out.println("Enter the file name: ");
                String fileName = scanner.nextLine();

                adapter.play(format, fileName);

                System.out.print("Would you like to play another file? (yes/no): ");
                continuePlaying = scanner.nextLine().trim().toLowerCase();

            } catch (Exception e) {
                Logger.log("An error occurred: " + e.getMessage());
                System.err.println("An error occurred: " + e.getMessage());
                continuePlaying = "no";
            }
        } while (continuePlaying.equals("yes"));

        scanner.close();
        Logger.log("MediaPlayerApp ended.");
        System.out.println("Thank you for using the Media Player!");
    }
}
