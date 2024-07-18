package object;

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
}
