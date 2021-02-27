package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.util.UserInputService;

import java.util.List;
@Component
public class StudentManagementConsoleImpl implements StudentManagement{
    private StudentDao studentDao;
    private UserInputService userInputService;

@Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
@Autowired
    public void setUserInputService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    @Override
    public Student create() {
     System.out.println("write student name:");
     String newName = userInputService.getString();
     Student student = new Student();
     student.setName(newName);
     return save(student);
    }

    @Override
    public Student save(Student student) {
        studentDao.save(student);
        return student;
    }

    @Override
    public Student find(int id) {

        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
    Student removedStudent = studentDao.find(id);
    if ((removedStudent != null)) studentDao.delete(id);
    return removedStudent;

    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
    if (student == null) throw new IllegalArgumentException("Student can't be found");
    Student student1 = find(student.getStudentId());
    student1.setName(userInputService.getString());
        return student1;
    }
}
