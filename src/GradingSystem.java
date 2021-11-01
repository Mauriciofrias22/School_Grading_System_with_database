import java.util.Locale;

public class GradingSystem {
	private double[][] matriz;
	private int n;
	public double sumatoria = 0;

	public double[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(double[][] matriz) {
		this.matriz = matriz;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int stat1() {
		double promedio = sumatoria / n;
		int valor_nota = 0;
		for (double[] z : matriz) {
			if (z[3] < promedio)
				valor_nota += 1;
		}
		return valor_nota;
	}

	public String stat2() {
		double conteo_porcentaje = 0;
		for (double[] z : matriz) {
			if (z[3] > 9.0 && z[3] <= 10.0)
				conteo_porcentaje += 1;
		}
		double porcentaje = conteo_porcentaje / n;
		return (String.format(Locale.US,"%.2f",porcentaje));
	}

	public String stat3() {
		int[] note_class = new int[3];
		String[] nombre_materia = { "idiomas", "historia", "literatura" };
		for (double[] z : matriz) {
			if (z[3] < 6)
				note_class[(int) z[2] - 1] += 1;
		}
		int limite = 0;
		int indice = 0;
		for (int pos = 0; pos < note_class.length; pos++) {
			if (note_class[pos] > limite) {
				limite = note_class[pos];
				indice = pos;
			}
		}
		return nombre_materia[indice];

	}

	public String stat4() {
		double[] nota_estudiante = new double[6];
		String[] nombre_estudiante = { "armando", "nicolas", "daniel", "maria", "marcela", "alexandra" };
		for (double[] z : matriz) {
			if (z[2] == 1.0)
				nota_estudiante[(int) z[0] - 1] += z[3];
		}
		double limite1 = 0;
		int indice1 = 0;
		for (int pos1 = 0; pos1 < nota_estudiante.length; pos1++) {
			if (nota_estudiante[pos1] > limite1) {
				limite1 = nota_estudiante[pos1];
				indice1 = pos1;
			}
		}
		return nombre_estudiante[indice1];

	}

}
