package Lesson_8.Patients;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main (String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Hospital hospital = context.getBean("hospital", Hospital.class);

        hospital.printPatients();
    }

}
