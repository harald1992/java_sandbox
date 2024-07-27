package object;

import lombok.Data;

@Data
public class Vector2D {
    private float x;
    private float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void normalize() {
        final float magnitude = (float) Math.sqrt(x * x + y * y);
        if (magnitude != 0) {
            x /= magnitude;
            y /= magnitude;
        }
    }

    public Vector2D normalized() {
        final float magnitude = (float) Math.sqrt(x * x + y * y);
        if (magnitude != 0) {
            return new Vector2D(x / magnitude, y / magnitude);
        }
        return new Vector2D(0, 0);

    }

    public int getX() {
        return (int) x;
    }

    public float getXFloat() {
        return  x;
    }

    public int getY() {
        return (int) y;
    }

    public float getYFloat() {
        return  y;
    }

    @Override
    public String toString() {
        return "Vector2D{" + "x=" + x + ", y=" + y + '}';
    }

    public Vector2D multiply(int i) {
        return new Vector2D(x * i, y * i);
    }
}
