package abstractClasses;


public abstract class AbstractAnimal {

    int age;

    String name;

    public AbstractAnimal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public abstract void makeAbstractNoise();

}
