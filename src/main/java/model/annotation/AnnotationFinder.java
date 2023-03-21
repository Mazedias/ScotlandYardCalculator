package model.annotation;

import org.reflections.Reflections;
import model.util.Constants;
import view.InputOutputHandler;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class contains methods to find classes with specific annotations
 * @author Mazedias
 */
public class AnnotationFinder {

    /**
     * This method find annotated classes in a specific package with a specific abstract class
     * @param packageName Name of the package to search in
     * @param annotation Annotation to search for
     * @param abstractClass Abstract class the annotated class must be extending
     * @return Returns list of instances of the annotated classes
     */
    public List<Object> getAnnotatedClasses(
            String packageName, Class<? extends Annotation> annotation, Class<?> abstractClass) {

        Reflections reflections = new Reflections(packageName);
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(annotation);

        List<Object> objects = new ArrayList<>();

        for (Class<?> clazz : annotated) {
            try {
                final Object newInstance = clazz.getDeclaredConstructor().newInstance();
                objects.add(newInstance);
            } catch (NoSuchMethodException | InvocationTargetException |
                     InstantiationException | IllegalAccessException ex) {
                InputOutputHandler.printDebugMessage(ex.toString());
            }
        }

        Map<Boolean, List<Object>> annotatedClass = objects.stream().collect(
                Collectors.partitioningBy(object -> abstractClass.isAssignableFrom(object.getClass())));

        List<Object> commands = annotatedClass.get(true);
        List<Object> otherClasses = annotatedClass.get(false);

        otherClasses.forEach(element -> InputOutputHandler.printDebugMessage(
                "The @AbstractCommand annotations must only be " + "applied to classes extending '"
                        + abstractClass.toString() + "' not to " + element.getClass().toString()));

        return commands;
    }

}
