package programa;

import fulbo.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Path resultadosPath= Path.of("resultados");
//        Path pronosticoPath= Path.of(args[1]);
        
        ArrayList<Partido> partidos= new ArrayList<Partido>();
        
        try {
            for (String linea : Files.readAllLines(resultadosPath)) {
            	Equipo aux1= new Equipo(linea.split(",")[0],"");
            	Equipo aux2= new Equipo(linea.split(",")[3],"");
            	
            	partidos.add(new Partido(aux1,aux2,Integer.parseInt(linea.split(",")[1]),Integer.parseInt(linea.split(",")[2])));
            }

        } catch (IOException e) {
            System.err.println(e);
        }
   
    }
}