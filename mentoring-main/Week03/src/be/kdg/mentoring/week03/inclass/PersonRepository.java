package be.kdg.mentoring.week03.inclass;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PersonRepository {
    private final List<Person> data = new ArrayList<>();

    public List<Person> getBy(Predicate<Person> predicate) {
        List<Person> result = new ArrayList<>();
        for (Person person : data) {
            if (predicate.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    public void add(Person person) {
        data.add(person);
    }

}
