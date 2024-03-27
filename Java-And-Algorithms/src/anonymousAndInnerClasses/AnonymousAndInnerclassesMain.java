package anonymousAndInnerClasses;

public class AnonymousAndInnerclassesMain {

    public class InnerClassAccessFromOutside {      // can access this one from another class by using something like this AnonymousAndInnerclassesMain.InnerClassAccessFromOutside instance = new AnonymousAndInnerclassesMain.InnerClassAccessFromOutsid();
        public void printStuff() {
            System.out.println("Inner class accessed from outside");
        }
    }

    public static void anonymousAndInnerclassesStart() {

        class Innerclass {
            public void printStuff() {
                System.out.println("inner class print");
            }
        }

        Innerclass innerclass = new Innerclass();
        innerclass.printStuff();

        Innerclass anonymousInnerclass = new Innerclass() {
            @Override
            public void printStuff() {
                System.out.println("anonymous class print");
            }
        };

        anonymousInnerclass.printStuff();


    }


}
