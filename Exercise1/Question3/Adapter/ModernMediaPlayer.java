package Question3.Adapter;

public class ModernMediaPlayer {
    public void playFlac(String fileName) {
        System.out.println("Playing FLAC file: " + fileName);
    }

    public void playWav(String fileName) {
        System.out.println("Playing WAV file: " + fileName);
    }
}
