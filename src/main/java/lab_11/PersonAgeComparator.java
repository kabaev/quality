package lab_11;

import java.util.Comparator;

/**
 * The {@code PersonAgeComparator} class is used for comparing {@code Person} objects by age.
 *
 * @author Timur Kabaev
 */
public class PersonAgeComparator implements Comparator<Person> {

    /**
     *
     * @param person1 the {@code Person} to be compared.
     * @param person2 the {@code Person} to be compared.
     * @return the value {@code 0} if the {@code Person} objects
     *         are the same age; a value less than {@code 0} if
     *         {@code person1} is younger than {@code person2};
     *         and a value greater than {@code 0} if the
     *         {@code person1} is older than {@code person2}.
     */
    public int compare(Person person1, Person person2) {
        return person1.getAge().compareTo(person2.getAge());
    }
}
