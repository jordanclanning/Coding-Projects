import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        int boardWidth = 360;
        int boardHeight = 640;

        JFrame frame = new JFrame("2028 Olympic Dreams");
        // frame.setVisible(true);
		frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlappyBird flappyBird = new FlappyBird();
        frame.add(flappyBird);
        frame.pack();
        flappyBird.requestFocus();
        frame.setVisible(true);

        String filepath = "C:\\Users\\jorda\\OneDrive\\Documents\\JS-BASICS\\Flappy Bird\\Tyler, the Creator Vice Staples Stuntman remake.wav";
        PlayMusic(filepath);
       // JOptionPane.showMessageDialog(null, "press okay to stop");



    }
    public static void PlayMusic(String location) {
        try {
            File musicPath = new File(location);
            if(musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } 
            else {System.out.println("file doenst exist");}

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}