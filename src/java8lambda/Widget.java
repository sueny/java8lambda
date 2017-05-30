package java8lambda;

public class Widget {
    
    private Color color;
    private int weight;

    public Widget(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Widget{" + "color=" + color + ", weight=" + weight + '}';
    }
}
