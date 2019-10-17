
public class Rectangle {
    private int height;
    private int width;

    public Rectangle (int h, int w) {
        System.out.println("Rectangle created.");
        setWidth(w);
        setHeight(h);
    }

    void printArea() {
        System.out.println(getHeight() * getWidth());
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
