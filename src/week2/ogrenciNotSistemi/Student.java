package week2.ogrenciNotSistemi;

public class Student {
//Nitelikler
    String name;
    String no;
    String classes;
    Course mat;
    Course fizik;
    Course kimya;
    double average;
    boolean isPass;
//Metotlar
    public Student(String name, String no, String classes, Course mat, Course fizik, Course kimya) {
        this.name = name;
        this.no = no;
        this.classes = classes;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        this.average = 0.0;
        this.isPass = false;
    }

    public void addBulkExamNote(int mat, int fizik, int kimya, int matSoz, int fizikSoz, int kimyaSoz) {

        if ((mat >= 0 && mat <= 100) && (matSoz >= 0 && matSoz <= 100)) {
            this.mat.note = mat;
            this.mat.sozlu = matSoz;
        }

        if ((fizik >= 0 && fizik <= 100) && (fizikSoz >= 0 && fizikSoz <= 100)) {
            this.fizik.note = fizik;
            this.fizik.sozlu = fizikSoz;
        }

        if ((kimya >= 0 && kimya <= 100) && (kimyaSoz >= 0 && kimyaSoz <= 100)) {
            this.kimya.note = kimya;
            this.kimya.sozlu = kimyaSoz;
        }

    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar yanlış girildi.");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.average);
            if (this.isPass) {
                System.out.println("Geçti. ");
            } else {
                System.out.println("Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        double matAvrg = (this.mat.note * 0.85) + (this.mat.sozlu * 0.15);
        double fizikAvrg = (this.fizik.note * 0.8) + (this.fizik.sozlu * 0.2);
        double kimyaAvrg = (this.kimya.note * 0.7) + (this.kimya.sozlu * 0.3);
        this.average = (fizikAvrg + matAvrg + kimyaAvrg) / 3.0;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.average > 55;
    }

    public void printNote() {
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);

    }

}
