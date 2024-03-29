package lambda.function;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> phKey = person -> person.getPhone().equals(key);
        Predicate<Person> nameKey = person -> person.getName().equals(key);
        Predicate<Person> surKey = person -> person.getSurname().equals(key);
        Predicate<Person> addrKey = person -> person.getAddress().equals(key);
        Predicate<Person> combine = phKey.or(nameKey).or(surKey).or(addrKey);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
