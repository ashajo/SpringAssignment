package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService userInputService = context.getBean(UserInputService.class);
        StudentManagement studentManagement = context.getBean(StudentManagement.class);

        System.out.println("create student:");
        System.out.println(studentManagement.create());

        System.out.println("------------------------");

        System.out.println("save student");

        Student student1 = studentManagement.save(new Student("Asha"));
        Student student2 = studentManagement.save(new Student("Anna"));

        System.out.println("find student by id 1:");
        System.out.println(studentManagement.find(1));

        System.out.println("find all students");
        List<Student> findAll = studentManagement.findAll();
        findAll.forEach(System.out::println);

        System.out.println("deleted student by id (id 1)");
        studentDao.delete(1);

        Student editStudent = studentManagement.edit(student1);
        System.out.println("-------------------");
    }

}
