package abstractClasses;

public class AbstractClassesMain {

    public static void abstractClassesStart() {
        // AbstractAnimal animal = new AbstractAnimal();   // cannot instantiate abstract class, only extend it
        NotAbstractCat cat = new NotAbstractCat(5, "Scooby");
        cat.makeAbstractNoise();

        // diference abstract method with interface:
        // every method in interface is abstract by default
        // can implement more interfaces but only extend one class
        // fields in interface are static final so have to be instantiated once
        cat.poopFromInterface();

        System.out.println(cat instanceof NotAbstractCat); // check what class it is. Might be useful before typecasting
    }

}
