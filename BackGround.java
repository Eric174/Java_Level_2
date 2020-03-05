import java.awt.*;

public class BackGround {
    private final MainCanvas canvas;
    private final long TIME = 10_000_000_000L;
    private long lastTime;

    BackGround(MainCanvas canvas) {
        this.canvas = canvas;
        this.lastTime = System.nanoTime();
    }

    void checkTime() {
        long currentTime = System.nanoTime();
        if (currentTime - lastTime >= TIME) {
            setBackGround();
            lastTime = currentTime;
        }
    }

    void setBackGround() {
        canvas.setBackground(new Color(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255)
        ));
    }
}
