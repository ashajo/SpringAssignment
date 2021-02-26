package se.lexicon.dao;

import se.lexicon.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl  implements StudentDao{
    @Override
    public Student save(Student student) {

        return null;
    }

    @Override
    public Student find(int id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    private List<Student> students = new ArrayList<>();
}
