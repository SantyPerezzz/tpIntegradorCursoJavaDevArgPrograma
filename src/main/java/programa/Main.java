package programa;

import fulbo.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path fPath = Path.of("C:\\Users\\Fer\\eclipse-workspace\\Java_curso\\src\\fulbo\\resultados.txt");
        try {
            for (String num : Files.readAllLines(fPath)) {
                System.out.println(num.split(",")[1]);
            }

        } catch (IOException e) {
            System.err.println(e);
        }
        Equipo river = new Equipo("River Plate", "Club Atletico River Plate");
        Equipo boca = new Equipo("Boca Juniors", "Club Atletico Boca Juniors");
        Partido boca_river = new Partido(river, boca, 12, 12);
        Partido.Resultado resultado = null;
        Pronostico pronosticoBocaRiver = new Pronostico(boca_river, river, resultado);
    }
}