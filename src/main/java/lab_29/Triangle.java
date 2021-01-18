package lab_29;

/**
 * The {@code Triangle} class describes an object representing a shape.
 *
 * @author Timur Kabaev
 */
public class Triangle implements Shape {

    private final double sideA;
    private final double sideB;
    private final double sideC;


    private Triangle(double sideA, double sideB, double sideC) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException("Sides of the triangle can't be less or equal to 0");
        }
        if ((sideA >= sideB + sideC) || (sideB >= sideA + sideC) ||(sideC >= sideA + sideB)) {
            sideA = sideB = sideC = 1.0;
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /**
     * It's a factory method which calls private constructor of the class.
     *
     * @param sideA
     *        The value of the {@code Triangle} side A.
     * @param sideB
     *        The value of the {@code Triangle} side B.
     * @param sideC
     *        The value of the {@code Triangle} side C.
     * @return  newly created {@code Triangle} object.
     */
    public static Triangle getInstance(double sideA, double sideB, double sideC) {
        return new Triangle(sideA, sideB, sideC);
    }

    /**
     *
     * @return perimeter of the {@code Triangle} object.
     */
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    /**
     *
     * @return  a string representation of the {@code Triangle} object.
     */
    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }
}
