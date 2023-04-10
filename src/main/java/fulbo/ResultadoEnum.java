package fulbo;

public class ResultadoEnum {
	
	//enum Resultado{GANO, PERDIO, EMPATO}
	
	
	private char resultado;
	
	public ResultadoEnum() {
		this.resultado= '\0';
	}
	
	public ResultadoEnum(char resultado) {
		this.resultado=resultado;
	}

	public char getResultado() {
		return resultado;
	}

	public void setResultado(char resultado) {
		this.resultado = resultado;
	}
	
}
