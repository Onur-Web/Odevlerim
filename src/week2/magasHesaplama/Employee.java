package week2.magasHesaplama;

public class Employee {

    private String name;
    private double salary;
    private int workHours;
    private int hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax() {
        if (this.salary < 1000) {
            return 0;
        } else {
            return this.salary * 3 / 100;
        }
    }

    public int bonus() {
        if (this.workHours > 40) {
            int exceedHours = this.workHours - 40;
            return exceedHours * 30;
        }
        return 0;
    }

    public double raiseSalary() {
        if (2021 - this.hireYear < 10) {
            return this.salary * 5 / 100;
        } else if (2021 - this.hireYear >= 10 && 2021 - this.hireYear < 20) {
            return this.salary * 10 / 100;
        } else if (2021 - this.hireYear > 19) {
            return this.salary * 15 / 100;
        }
        return 0;
    }
//Alternatif
    /*
    public void printInfo() {
        System.out.println("Adı : " + this.name);
        System.out.println("Maaşı : " + this.salary);
        System.out.println("Çalışma Saati : " + this.workHours);
        System.out.println("Başlangıç Yılı : " + this.hireYear);
        System.out.println("Vergi : " + tax());
        System.out.println("Bonus : " + bonus());
        System.out.println("Maaş Artışı : " + raiseSalary());
        System.out.println("Vergi ve Bonuslar ile birlikte maaş : " + (this.salary + bonus() - tax()));
        System.out.println("Toplam Maaş : " + (this.salary + bonus() - tax() + raiseSalary()));
    }
*/
    public String toString() {
        String result = "";
        result += "Adı : " + this.name + "\n";
        result += "Maaşı : " + this.salary + "\n";
        result += "Çalışma Saati : " + this.workHours + "\n";
        result += "Başlangıç Yılı : " + this.hireYear + "\n";
        result += "Vergi : " + tax() + "\n";
        result += "Bonus : " + bonus() + "\n";
        result += "Maaş Artışı : " + raiseSalary() + "\n";
        result += "Vergi ve Bonuslar ile birlikte maaş : " + (this.salary + bonus() - tax()) + "\n";
        result += "Toplam Maaş : " + (this.salary + bonus() - tax() + raiseSalary()) + "\n";
        return result;
    }
}