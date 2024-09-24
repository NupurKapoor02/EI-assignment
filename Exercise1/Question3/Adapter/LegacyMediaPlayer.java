package Question3.Adapter;

public class LegacyMediaPlayer {
    public void playMp3(String fileName) {
        System.out.println("Playing mp3 file: " + fileName);
    }

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }
}
