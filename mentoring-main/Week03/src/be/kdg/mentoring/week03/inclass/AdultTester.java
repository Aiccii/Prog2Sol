package be.kdg.mentoring.week03.inclass;

import java.util.function.Predicate;

public class AdultTester implements Predicate<Person> {
    @Override
    public boolean test(Person person) {
        return person.getAge() > 18;
    }
}
