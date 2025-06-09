package org.scoula.main;


import org.scoula.beans.Parrot;
import org.scoula.beans.Person;
import org.scoula.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person p = context.getBean(Person.class);
        Parrot p1 = context.getBean(Parrot.class);

        System.out.println("Person name: " + p.getName());
        System.out.println("Parrot name: " + p1.getName());
        System.out.println("Person`s parrot: " + p.getParrot());
    }
}
