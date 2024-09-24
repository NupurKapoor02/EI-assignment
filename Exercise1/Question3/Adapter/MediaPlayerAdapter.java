package Question3.Adapter;
import Question3.Adapter.Logs.Logger;

public class MediaPlayerAdapter extends ModernMediaPlayer {
    private LegacyMediaPlayer legacyPlayer;

    public MediaPlayerAdapter(LegacyMediaPlayer legacyPlayer) {
        this.legacyPlayer = legacyPlayer;
        Logger.log("Adapter created to use LegacyMediaPlayer with ModernMediaPlayer.");
    }

    public void play(String format, String fileName) {
        try {
            if (format.equalsIgnoreCase("mp3")) {
                legacyPlayer.playMp3(fileName);
                Logger.log("Playing mp3 file using LegacyMediaPlayer: " + fileName);
            } else if (format.equalsIgnoreCase("mp4")) {
                legacyPlayer.playMp4(fileName);
                Logger.log("Playing mp4 file using LegacyMediaPlayer: " + fileName);
            } else if (format.equalsIgnoreCase("flac")) {
                playFlac(fileName);
                Logger.log("Playing flac file using ModernMediaPlayer: " + fileName);
            } else if (format.equalsIgnoreCase("wav")) {
                playWav(fileName);
                Logger.log("Playing wav file using ModernMediaPlayer: " + fileName);
            } else {
                throw new IllegalArgumentException("Unsupported format: " + format);
            }
        } catch (IllegalArgumentException e) {
            Logger.log("Error: " + e.getMessage());
            System.err.println("Error: " + e.getMessage());
        }
    }
}
