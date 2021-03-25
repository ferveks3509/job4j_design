package Generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericsAnimals {
    public void printObject(List<?> list) {
        for (Iterator<?> it = list.iterator(); it.hasNext(); ) {
            Object next = it.next();
            System.out.println(next);
        }
    }
    public void printBouncedWildCard(List<? extends Predator> list) {
        for (Iterator<? extends Predator> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println(next);
        }
    }
    public void printLowerBouncedWildCard(List<? super Predator> list) {
        for (Iterator<? super Predator> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println(next);
        }
    }

    public static void main(String[] args) {
        GenericsAnimals generics = new GenericsAnimals();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();
        first.add(new Animal("hunter"));
        second.add(new Predator("hunter", "cats"));
        third.add(new Tiger("hunter", "cats", "200"));

        generics.printObject(first);
        generics.printObject(second);
        generics.printObject(third);
        System.out.println();

        //generics.printBouncedWildCard(first);
        generics.printBouncedWildCard(second);
        generics.printBouncedWildCard(third);
        System.out.println();

        generics.printLowerBouncedWildCard(first);
        generics.printLowerBouncedWildCard(second);
        //generics.printLowerBouncedWildCard(third);
    }
}
