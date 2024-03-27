package abstractClasses;

public class NotAbstractCat extends AbstractAnimal implements AnimalInterface {

    public NotAbstractCat(int age, String name) {
        super(age, name);
    }

    @Override
    public void makeAbstractNoise() {
        System.out.println("purr");
    }

    @Override
    public void poopFromInterface() {
        System.out.println("dump");
    }

}
