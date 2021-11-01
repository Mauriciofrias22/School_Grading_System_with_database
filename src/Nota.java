public class Nota {
    private int persona;
    private int materia;
    private int genero;
    private double nota;

    public Nota() {
    }

    public Nota(int persona, int materia, int genero, double nota) {
        this.persona = persona;
        this.materia = materia;
        this.genero = genero;
        this.nota = nota;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    public int getMateria() {
        return materia;
    }

    public void setMateria(int materia) {
        this.materia = materia;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}