public class Circle {
    private double radius;
    private double xCenter, yCenter;

    /**
     * 
     * @param radius
     * @param xCenter
     * @param yCenter
     */
    public Circle(double radius, double xCenter, double yCenter) {
        this.radius = radius;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    /**
     * 
     * @param radius
     */
    public Circle(double radius) {
        this.radius = radius;
        this.xCenter = 0;
        this.yCenter = 0;
    }
    /**
     * 
     */
    public Circle() {
        this.radius = 0;
        this.xCenter = 0;
        this.yCenter = 0;
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", xCenter=" + xCenter + ", yCenter=" + yCenter + "]";
    }

}