package lab_29;

/**
 * The {@code Rectangle} class describes an object representing a shape.
 *
 * @author Timur Kabaev
 */
public class Rectangle implements Shape {

    private final double sideA;
    private final double sideB;

    private Rectangle(double sideA, double sideB) {
        if (sideA <= 0 || sideB <= 0) {
            throw new IllegalArgumentException();
        }
        this.sideA = sideA;
        this.sideB = sideB;
    }

    /**
     * It's a factory method which calls private constructor of the class.
     *
     * @param sideA
     *        The value of the {@code Rectangle} side A.
     * @param sideB
     *        The value of the {@code Rectangle} side B.
     * @return  newly created {@code Rectangle} object.
     */
    public static Rectangle getInstance(double sideA, double sideB) {
        return new Rectangle(sideA, sideB);
    }

    /**
     *
     * @return perimeter of the {@code Rectangle} object.
     */
    @Override
    public double getPerimeter() {
        return 2.0 * (sideA + sideB);
    }

    /**
     *
     * @return  a string representation of the {@code Rectangle} object.
     */
    @Override
    public String toString() {
        return "Rectangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                '}';
    }
}
