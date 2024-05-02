package week2.ogrenciNotSistemi;

public class Course {
//Teacher classının atanması
    Teacher courseTeacher;
//Nitelikler
    String name;
    String code;
    String prefix;
    int note;
    int sozlu;
//Metotlar
    public Course(String name, String code, String prefix) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        int note = 0;
        int sozlu = 0;
    }

    public void addTeacher(Teacher teacher) {
        if (this.prefix.equals(teacher.branch)) {
            this.courseTeacher = teacher;
            return;
        } else {
            System.out.println(teacher.name + " Dersin Hocası Değil.");
        }
    }
}



