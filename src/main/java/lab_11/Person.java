package lab_11;

/**
 * The {@code Person} class describes an object representing a human.
 *
 * @author Timur Kabaev
 */
public class Person implements Comparable<Person> {

    private final String surname;
    private final String name;
    private final Integer age;

    /**
     * Initializes a newly created {@code Person} object.
     *
     * @param surname
     *        The value of the {@code Person} surname.
     * @param name
     *        The value of the {@code Person} name.
     * @param age
     *        The value of the {@code Person} age.
     */
    public Person(String surname, String name, Integer age) {
        this.surname = surname;
        this.name = name;
        this.age = age;
    }

    /**
     *
     * @return age of the {@code Person} object.
     */
    public Integer getAge() {
        return age;
    }

    /**
     *
     * @return name of the {@code Person} object.
     */
    public String getName() {
        return name;
    }

    /**
     * Compares two {@code Person} objects by surname and name.
     *
     * @param   anotherPerson the {@code Person} to be compared.
     * @return  the value {@code 0} if this {@code Person} and the
     *          argument {@code Person} have the same surnames and names;
     *          a value less than {@code 0} if this {@code Person} has
     *          a surname (or a name in the case of equality of surnames)
     *          placed before in alphabetical order than the argument
     *          {@code Person} surname (or name); and a value greater
     *          than {@code 0} if this {@code Person} has a surname
     *          (or a name in the case of equality of surnames) placed after
     *          in alphabetical order than the argument {@code Person}
     *          surname (or name).
     */
    public int compareTo(Person anotherPerson) {
        int comparingBySurname = surname.compareTo(anotherPerson.surname);
        if (comparingBySurname != 0) {
            return comparingBySurname;
        }
        return name.compareTo(anotherPerson.name);
    }

    /**
     *
     * @return  a string representation of the {@code Person} object.
     */
    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
