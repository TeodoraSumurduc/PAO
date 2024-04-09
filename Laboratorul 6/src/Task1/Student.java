package Task1;

public class Student {
    private String nume;
    private Double notaLaborator, notaPartial, notaExamen;

    public Student(String nume, Double notaLaborator, Double notaPartial, Double notaExamen) {
        this.nume = nume;
        this.notaLaborator = notaLaborator;
        this.notaPartial = notaPartial;
        this.notaExamen = notaExamen;
    }

    public double getNotaTotala() {
        return this.notaExamen + this.notaLaborator + this.notaPartial;
    }

    public double getNotaPartial() {
        return notaPartial;
    }

    public double getMedie() {
        return (this.notaExamen + this.notaLaborator + this.notaPartial) / 3;
    }

    public String getNume() {
        return nume;
    }

    public Double getNotaLaborator() {
        return notaLaborator;
    }

    public Double getNotaExamen() {
        return notaExamen;
    }
}
