package lab_29;

import java.util.Arrays;
import java.util.Comparator;

/*
    Создать 10 случайных фигур Circle, Triangle, Rectangle со случайными параметрами
    – радиусом, длиной стороны.
    Все фигуры имплементируют интерфейс Shape с одним методом getPerimeter():
    double, возвращающим периметр (или длину окружности)
    Найти и вывести информацию о фигуре с максимальным/минимальным периметром
 */
public class RunnerLab29 {

    public static void main(String[] args) {

        Shape[] randomShapesArray = ShapeFabric.getRandomShapes(10);

        System.out.println("Random shapes array:");
        Arrays.stream(randomShapesArray).forEach(obj -> System.out.printf(obj + ", perimeter - " + "%5.2f\n", obj.getPerimeter()));

        Shape max = Arrays.stream(randomShapesArray)
                .max(Comparator.comparingDouble(Shape::getPerimeter))
                .get();

        Shape min = Arrays.stream(randomShapesArray)
                .min(Comparator.comparingDouble(Shape::getPerimeter))
                .get();

        System.out.printf("The shape that has max value of the perimeter " + max + ", perimeter - " + "%5.2f\n" , max.getPerimeter());
        System.out.printf("The shape that has min value of the perimeter " + min + ", perimeter - " + "%5.2f\n" , min.getPerimeter());
    }
}

