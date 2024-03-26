package thiGK.ntu63135414.service;

import thiGK.ntu63135414.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public Optional<Student> findStudentById(String id) {

        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
