package week2.ogrenciNotSistemi;

public class Main {

    public static void main(String[] args) {

        Course mat = new Course("Matematik", "101", "MAT");
        Course fizik = new Course("Fizik", "101", "FZK");
        Course kimya = new Course("Kimya", "101", "KMY");

        Teacher one = new Teacher("A Hoca", "999", "MAT");
        Teacher two = new Teacher("B Hoca", "998", "FZK");
        Teacher three = new Teacher("C Hoca", "997", "KMY");

        mat.addTeacher(one);
        fizik.addTeacher(two);
        kimya.addTeacher(three);

        Student s1 = new Student("A Öğrenci", "71", "221", mat, fizik, kimya);
        s1.addBulkExamNote(100,20,80,80,60,10);
        s1.isPass();

        Student s2 = new Student("B Öğrenci", "82", "222", mat, fizik, kimya);
        s2.addBulkExamNote(40,70,30,80,90,40);
        s2.isPass();

        Student s3 = new Student("C Öğrenci", "93", "223", mat, fizik, kimya);
        s3.addBulkExamNote(66,44,90,50,30,70);
        s3.isPass();

    }
}

