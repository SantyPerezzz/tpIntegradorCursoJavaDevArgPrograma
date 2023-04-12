package programa;

import fulbo.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public enum Resultado {
        gano, perdio, empato
    }

    public static void main(String[] args) {
        Path resultadosPath = Path.of(
                "resultados");
        Path pronosticoPath = Path.of(
                "pronostico");

        ArrayList<Partido> partidos = new ArrayList<Partido>();
        ArrayList<Pronostico> pronosticos = new ArrayList<Pronostico>();

        try {
            for (String linea : Files.readAllLines(resultadosPath)) {
                Equipo aux1 = new Equipo(linea.split(",")[0], "");
                Equipo aux2 = new Equipo(linea.split(",")[3], "");

                partidos.add(new Partido(aux1, aux2, Integer.parseInt(linea.split(",")[1]),
                        Integer.parseInt(linea.split(",")[2])));
            }

        } catch (IOException e) {
            System.err.println(e);

        }
        try {
            for (String linea : Files.readAllLines(resultadosPath)) {
                Equipo aux1 = new Equipo(linea.split(",")[0], "");
                if (linea.split(",")[1] == "x") {
                    pronosticos.add(new Pronostico(partidos, aux1, Resultado.gano));
                }
                if (linea.split(",")[2] == "x") {
                    pronosticos.add(new Pronostico(partidos, aux1, Resultado.empato));
                }
                if (linea.split(",")[3] == "x") {
                    pronosticos.add(new Pronostico(partidos, aux1, Resultado.perdio));
                }
            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}