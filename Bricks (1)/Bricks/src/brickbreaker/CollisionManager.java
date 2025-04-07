package brickbreaker;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

public class CollisionManager {
    private long lastCollisionTime = 0;
    private final long COLLISION_COOLDOWN = 100;

    public void checkBaseCollision(Base base, Ball ball) {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - lastCollisionTime) > COLLISION_COOLDOWN) {
            if (ball.x >= base.x && ball.x <= base.x + base.getBASE_WIDTH()
                    && ball.y + ball.getBALL_HEIGHT() >= base.y
                    && ball.y + ball.getBALL_HEIGHT() <= base.y + base.getBASE_HEIGHT()) {
                ball.yVelocity *= -1;
                if (ball.x > 400) ball.xVelocity *= -1;
                lastCollisionTime = currentTime;
            } else if (ball.x + ball.getBALL_WIDTH() >= base.x
                    && ball.x + ball.getBALL_WIDTH() <= base.x + base.getBASE_WIDTH() / 4
                    && ball.y >= base.y && ball.y <= base.y + base.getBASE_HEIGHT()) {
                ball.xVelocity *= -1;
                ball.yVelocity *= -1;
                lastCollisionTime = currentTime;
            } else if (ball.x <= base.x + base.getBASE_WIDTH()
                    && ball.x >= base.x + base.getBASE_WIDTH() - base.getBASE_WIDTH() / 4
                    && ball.y + ball.getBALL_HEIGHT() >= base.y
                    && ball.y + ball.getBALL_HEIGHT() <= base.y + base.getBASE_HEIGHT()) {
                ball.xVelocity *= -1;
                ball.yVelocity *= -1;
                lastCollisionTime = currentTime;
            }
        }
    }

    public Brick checkBrickCollisions(ArrayList<Brick> bricks, Ball ball) {
        Iterator<Brick> iterator = bricks.iterator();
        while (iterator.hasNext()) {
            Brick brick = iterator.next();
            Rectangle bounds = brick.getBounds();

            if (ball.x >= bounds.x && ball.x <= bounds.x + bounds.width
                    && ball.y <= bounds.y + bounds.height && ball.y >= bounds.y) {
                iterator.remove();
                ball.yVelocity *= -1;
                return brick;
            } else if (ball.x + ball.getBALL_WIDTH() >= bounds.x && ball.x + ball.getBALL_WIDTH() <= bounds.x + 5
                    && ball.y > bounds.y && ball.y < bounds.y + bounds.height) {
                iterator.remove();
                ball.xVelocity *= -1;
                return brick;
            } else if (ball.x <= bounds.x + bounds.width && ball.y >= bounds.y
                    && ball.x >= bounds.x && ball.y < bounds.y + bounds.height) {
                iterator.remove();
                ball.xVelocity *= -1;
                return brick;
            } else if (ball.x >= bounds.x && ball.x <= bounds.x + bounds.width
                    && ball.y + ball.getHeight() >= bounds.y && ball.y + ball.getHeight() <= bounds.y + bounds.height) {
                iterator.remove();
                ball.yVelocity *= -1;
                return brick;
            }
        }
        return null;
    }
}
