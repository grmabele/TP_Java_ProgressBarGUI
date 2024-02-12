import javax.swing.*;
import java.awt.*;

public class ProgressBarDemo  {

    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar();

    ProgressBarDemo() {

        bar.setValue(0);
        //bar.setSize(100,100);
        bar.setBounds(0,0,420,400);
        bar.setStringPainted(true);
        bar.setFont(new Font("MV Boli",Font.BOLD,30));
        bar.setForeground(Color.red);
        bar.setBackground(Color.BLACK);

        frame.add(bar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);

        frame.setVisible(true);

        fill();
    }

    public void fill() {
        Thread thread = new Thread(() -> {
            int counter = 0;
            while (counter <= 100) {
                bar.setValue(counter);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter += 1;
            }
            SwingUtilities.invokeLater(() -> bar.setString("Done!"));
        });
        thread.start();
    }
}
