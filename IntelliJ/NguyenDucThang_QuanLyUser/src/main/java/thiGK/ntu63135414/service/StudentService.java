package thiGK.ntu63135414.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {
    private List<StudentDTO> students;

    public StudentService() {
        this.students = new ArrayList<>();
        // Hard-code some students
        this.students.add(new StudentDTO("1", "Nguyen Duc Thang", 8.5));
        this.students.add(new StudentDTO("2", "Nguyen Quoc Tinh", 9.0));
    }

    public Optional<StudentDTO> findStudentById(String id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    public List<StudentDTO> getAllStudents() {
        return new ArrayList<>(students);
    }

    public void addStudent(StudentDTO student) {
        students.add(student);
    }
}
