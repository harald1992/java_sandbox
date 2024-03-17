package optionals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalsMain {

    public static void optionalsStart() {
        /* find normal*/
        Cat cat = findCatByName("booboo").orElseThrow();
        System.out.println("Cat 1 found, name is " + cat.getName());

        /* isPresent check */
        Optional<Cat> optionalCat = findCatByName("optional cat");
        if (optionalCat.isPresent()) {
            System.out.println("Optional cat found");
        } else {
            System.out.println("optional cat not found");
        }

        /* find or else create different Cat */
        Cat orElseCat = findCatByName("Not a cat").orElse(new Cat("Unknown"));
        System.out.println("OrElseCat found, name is " + orElseCat.getName());

        /* find and map Cat to String name */
        String catMap = findCatByName("booboo").map(Cat::getName).orElse("Not found cat");
        System.out.println("catMap found and mapped the name, name is " + catMap);

        /* find and throw if not found */
        Cat catThrow = findCatByName("NOT_CAT").orElseThrow();
        System.out.println("catThrow found, name is " + catThrow.getName());
    }

    private static Optional<Cat> findCatByName(String name) {
        List<Cat> cats = Arrays.asList(new Cat("booboo"), new Cat("lala"));
        return cats.stream().filter(cat -> cat.getName().equals(name)).findFirst();
    }

}
