import annotations.Private;
import annotations.Public;
import annotations.ScanMe;

import java.lang.reflect.Method;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();
        Lion lion = new Lion();
        Rabbit rabbit = new Rabbit();

        List<Animal> animals = List.of(dog, cat, lion, rabbit);

        getClassesWithScanMeAnnotation(animals);
        getMethodsWithPrivateAnnotation(animals);
        getClassesWithoutScanMeAnnotation(animals);
        getAllInformationAboutClassesWithoutScanMeAnnotation(animals);


    }

    private static void getClassesWithScanMeAnnotation(List<Animal> animals) {
        for (Animal animal : animals) {
            Class<?> animalClass = animal.getClass();
            if (animalClass.isAnnotationPresent(ScanMe.class)) {
                System.out.println("class : " + animalClass.getCanonicalName() + " has ScanMe annotation");
            }
        }
    }

    private static void getMethodsWithPrivateAnnotation(List<Animal> animals) {
        for (Animal animal : animals) {
            Class<?> animalClass = animal.getClass();
            for (Method method : animalClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Private.class) && animalClass.isAnnotationPresent(ScanMe.class)) {
                    System.out.println("Method : " + method.getName() + " in class: " + animalClass.getCanonicalName() + " has private annotation and the class has ScanMe annotation");
                }
            }
        }
    }

    private static void getClassesWithoutScanMeAnnotation(List<Animal> animals) {
        for (Animal animal : animals) {
            Class<?> animalClass = animal.getClass();
            if (!animalClass.isAnnotationPresent(ScanMe.class)) {
                System.out.println("class : " + animalClass.getCanonicalName() + " hasn't ScanMe annotation");
            }
        }
    }

    private static void getAllInformationAboutClassesWithoutScanMeAnnotation(List<Animal> animals) {
        for (Animal animal : animals) {
            Class<?> animalClass = animal.getClass();
            if (!animalClass.isAnnotationPresent(ScanMe.class)) {
                for (Method method : animalClass.getDeclaredMethods()) {
                    if (method.isAnnotationPresent(Public.class) && method.isAnnotationPresent(Private.class)) {
                        System.out.println("Class: " + animalClass.getCanonicalName() + " has not ScanMe annotation.\n" +
                                "Method has Private and Public annotation: " + method.getName());
                    } else if (method.isAnnotationPresent(Private.class)) {
                        System.out.println("Class: " + animalClass.getCanonicalName() + " has not ScanMe annotation.\n" +
                                "Method has Private annotation: " + method.getName());
                    } else if (method.isAnnotationPresent(Public.class)) {
                        System.out.println("Class: " + animalClass.getCanonicalName() + " has not ScanMe annotation.\n" +
                                "Method has Public annotation: " + method.getName());
                    } else {
                        System.out.println("Class: " + animalClass.getCanonicalName() + " has not ScanMe annotation.\n" +
                                "Method has not any annotation: " + method.getName());
                    }
                }

            }
        }
    }
}