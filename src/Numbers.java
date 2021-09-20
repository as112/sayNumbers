import java.awt.*;
import java.util.Random;
import javax.swing.*;
public class Numbers extends JFrame {
    private JLabel countLabel;

    public Numbers() {
        super("Say numbers");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        countLabel = new JLabel("  ");
        countLabel.setFont(new Font("Serif", Font.PLAIN, 120));
        add(countLabel, BorderLayout.NORTH);
    }
    public void initListeners() throws InterruptedException {
        Random random = new Random();
        countLabel.setText("      " + random.nextInt(9999));
        Thread.sleep(5000);
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

class MyThread extends Thread {
    public void run() {
        Numbers app = new Numbers();
        app.setLocation(400, 250);
        app.setVisible(true);
        app.setSize(600, 200);
        while (true) {
            try {
                app.initListeners();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}