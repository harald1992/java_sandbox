package reflection;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class ReflectionMain {

    public static void reflectionStart() throws IllegalAccessException, InvocationTargetException {
        MusicMetadata song = new MusicMetadata("Fields of Gold", "Sting", new byte[20], new Date());
        Class<? extends MusicMetadata> songClass = song.getClass();
        System.out.println(songClass);

     Field[] fields = songClass.getDeclaredFields();
     for (Field field: fields) {
         System.out.println(field.getName());
         if (field.getName().equals("name")) {
             field.setAccessible(true);
             field.set(song, "Every Breath You Take");
         }
     }

        System.out.println();

        for (Field field: fields) {
            field.setAccessible(true);
            System.out.println(field.get(song));
        }

        System.out.println();

        for (Method method: songClass.getDeclaredMethods()) {
            System.out.println(method);
            method.setAccessible(true);
            method.invoke(song);
        }
    }

}
