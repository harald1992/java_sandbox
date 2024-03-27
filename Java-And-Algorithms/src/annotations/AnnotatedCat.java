package annotations;

@VeryImportantAnnotation
public class AnnotatedCat {

    String name;

    public AnnotatedCat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // @RunImmediately("New Name")
    public void setName(String name) {
        this.name = name;
    }

    @RunImmediately(parameter = "hmmm")
    public void purr(String inputvalue) {
        System.out.println(this.name + " purrs, extra value from annotation is " + inputvalue);
    }

    public void meow() {
        System.out.println(this.name + " meows");
    }



}
