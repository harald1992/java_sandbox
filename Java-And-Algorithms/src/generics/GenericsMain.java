package generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

interface Animal {

    public void makeNoise();

}

class Dog implements Animal {

    @Override
    public void makeNoise() {
        System.out.println("Woof");
    }

}

class Cat implements Animal {

    @Override
    public void makeNoise() {
        System.out.println("Purr");
    }

}

public class GenericsMain {

    public static void genericsStart() {

        normalGenericClass();
        classExtendingInterface();

        genericMethod("lala", "lala");
        genericMethod(new Cat(), "lala");
        genericMethod(5.0f, new Dog());

        wildCardType(new ArrayList<>() {
            {
                add("Geeks");
                add("for");
                add("Geeks");
            }
        });

    }


    private static void normalGenericClass() {
        class GenericPrinter<T> {

            final T thingToPrint;

            public GenericPrinter(T thingToPrint) {
                this.thingToPrint = thingToPrint;
            }

            public void print() {
                System.out.println(thingToPrint);
            }

        }

        GenericPrinter<String> stringPrinter = new GenericPrinter<>("string");
        stringPrinter.print();


        GenericPrinter<Float> floatPrinter = new GenericPrinter<>(5.0f);
        floatPrinter.print();

        ArrayList<Integer> list = new ArrayList<>(); // also uses generics.
    }

    // bounded generic, so bound by the interface. And so ensuring it contains the right functions.
    private static void classExtendingInterface() {
        class GenericClassExtendingInterface<T extends Animal> {    // if extend two things -> extends Animal & Runnable
            // Serializable means that instances of the class can be turned into a byte-stream (for example, to be saved to a file) and then
            // converted back into classes again.

            public T animal;

            GenericClassExtendingInterface(T animal) {
                this.animal = animal;
            }

        }

        GenericClassExtendingInterface<Dog> genericClass = new GenericClassExtendingInterface<>(new Dog());
        genericClass.animal.makeNoise();


        GenericClassExtendingInterface<Cat> genericClass2 = new GenericClassExtendingInterface<>(new Cat());
        genericClass2.animal.makeNoise();
    }


    private static <T, V> void genericMethod(T thingToShout, V anotherThingToShout) {
        System.out.println(thingToShout);
        System.out.println(anotherThingToShout);
    }

    private static void wildCardType(List<?> myList) {
        for (var item : myList) {
            System.out.println(item);
        }
    }

}
