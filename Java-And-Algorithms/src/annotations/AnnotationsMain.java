package annotations;

import java.lang.reflect.Method;

public class AnnotationsMain {

    /* Annotations are like metadata, to put in the code
     * @SuppressWarnings("unused") to remove warnings for unused.
     */
    public static void annotationsStart() {
        AnnotatedCat cat = new AnnotatedCat("Meowster");

        if (cat.getClass().isAnnotationPresent(VeryImportantAnnotation.class)) {
            System.out.println("Important class");
        } else {
            System.out.println("Not important");
        }

        for (Method declaredMethod : cat.getClass().getDeclaredMethods()) {
            try {
                if (declaredMethod.isAnnotationPresent(RunImmediately.class)) {
                    RunImmediately annotationObject = declaredMethod.getAnnotation(RunImmediately.class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(cat, annotationObject.parameter());
                }

            } catch (Exception e) {
            }
        }

    }

}
