package be.kdg.mentoring.week03.javafx.screenreader.model;

public class ScreenReaderTest {
    public static void main(String[] args) {
        ScreenReader sr = new ScreenReader();
        sr.setText("Hello there, how are you doing today? I am fine. Thank you very much!");
        sr.readAloud();
    }
}
