package annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)       // specify which kind of java element this should be used on. ElementType.TYPE is class
// @Target({ElementType.TYPE, ElementType.METHOD})          // if more options
@Retention(RetentionPolicy.RUNTIME)        // keep the annotation around during runtime
public @interface VeryImportantAnnotation {

}
