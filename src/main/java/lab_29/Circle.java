package lab_29;

/**
 * The {@code Circle} class describes an object representing a shape.
 *
 * @author Timur Kabaev
 */
public class Circle implements Shape {

    private final double radius;

    private Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException();
        }
        this.radius = radius;
    }

    /**
     * It's a factory method which calls private constructor of the class.
     *
     * @param radius
     *        The value of the {@code Circle} radius.
     * @return  newly created {@code Circle} object.
     */
    public static Circle getInstance(double radius) {
        return new Circle(radius);
    }

    /**
     *
     * @return perimeter of the {@code Circle} object.
     */
    @Override
    public double getPerimeter() {
        return 2.0 * Math.PI * radius;
    }

    /**
     *
     * @return  a string representation of the {@code Circle} object.
     */
    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
