package lab_29;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

/**
 * The {@code ShapeFabric} class contains static method for working with objects implementing the Shape interface.
 *
 * @author Timur Kabaev
 */
public class ShapeFabric {

    /**
     * Generates and returns an array of random objects implementing the Shape interface.
     *
     * @param count
     *        The quantity of generated random objects.
     * @return  the array of generated random objects. Constructors parameters of the
     *          created objects are set by random in the range from 0 to 100.
     */
    public static Shape[] getRandomShapes(int count) {
        Shape[] result = new Shape[count];

        ArrayList<Supplier<? extends Shape>> figures = new ArrayList<>();
        Random generator = new Random();

        figures.add(() -> (Circle.getInstance(generator.nextInt(100))));
        figures.add(() -> (Triangle.getInstance(generator.nextInt(100), generator.nextInt(100), generator.nextInt(100))));
        figures.add(() -> (Rectangle.getInstance(generator.nextInt(100), generator.nextInt(100))));

        for (int i = 0; i < count; i++) {
            result[i] = figures.get(generator.nextInt(figures.size())).get();
        }

        return result;
    }
}
