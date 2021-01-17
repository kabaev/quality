package lab_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Создать класс Person с полями: name, surname, age.
    Имплементировать интерфейс Comparable, используя поля surname, name
    Добавить несколько объектов Person в List
    Вывести
    1) неотсортированный список,
    2) список, отсортированный по name,
    3) список, отсортированный по surname,
    4) список, отсортированный по age
 */
public class RunnerLab11 {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<Person>();

        Person person1 = new Person("Ivanov", "Andrey", 24);
        Person person2 = new Person("Nikitin", "Nikolay", 34);
        Person person3 = new Person("Omelchenko", "Svetlana", 18);
        Person person4 = new Person("Antonova", "Olga", 55);
        Person person5 = new Person("Nikitin", "Maxim", 45);

        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);

        System.out.println("List unsorted:\n" + list + "\n");

        Collections.sort(list, new PersonNameComparator());
        System.out.println("List sorted by name:\n" + list + "\n");

        Collections.sort(list);
        System.out.println("List sorted by surname (naturally):\n" + list + "\n");

        Collections.sort(list, new PersonAgeComparator());
        System.out.println("List sorted by age:\n" + list + "\n");
    }
}

