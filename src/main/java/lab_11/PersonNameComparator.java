package lab_11;

import java.util.Comparator;

/**
 * The {@code PersonNameComparator} class is used for comparing {@code Person} objects by name.
 *
 * @author Timur Kabaev
 */
public class PersonNameComparator implements Comparator<Person> {

    /**
     *
     * @param person1 the {@code Person} to be compared.
     * @param person2 the {@code Person} to be compared.
     * @return  the value {@code 0} if the {@code person1} and the
     *          {@code person2} have the same names; a value less
     *          than {@code 0} if the {@code person1} has a name
     *          placed before in alphabetical order than the
     *          {@code person2} name; and a value greater than
     *          {@code 0} if the {@code person1} has a name
     *          placed after in alphabetical order than the
     *          {@code person2} name.
     */
    public int compare(Person person1, Person person2) {
        return person1.getName().compareTo(person2.getName());
    }
}

