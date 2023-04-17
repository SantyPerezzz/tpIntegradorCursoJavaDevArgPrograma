package programa;

import fulbo.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    
	public static Partido buscarPartido(ArrayList<Partido> partidos,Equipo team1, Equipo team2) {
		Partido aux= new Partido();
		for(Partido part: partidos) {
			if((part.getEquipo1()==team1 || part.getEquipo2()==team1)&&(part.getEquipo1()==team2 || part.getEquipo2()==team2)) {
				aux=part;
			}
		}
		
		return aux;
	}
	
	public static int posEquipo(ArrayList<Equipo> equipos,String nombre) {
		int pos=-1;
		for(Equipo eq:equipos) {
			if(eq.getNombre()==nombre) {
				pos=equipos.indexOf(eq);
			}
		}
		
		return pos;
	}

    public static void main(String[] args) {
        Path resultadosPath = Path.of("D:\\ProgramFilesx86\\workspace\\tpIntegradorFtFer\\src\\main\\java\\programa\\resultados");
        Path pronosticoPath = Path.of("D:\\ProgramFilesx86\\workspace\\tpIntegradorFtFer\\src\\main\\java\\programa\\pronostico.txt");

        ArrayList<Partido> partidos = new ArrayList<Partido>();
        ArrayList<Pronostico> pronosticos = new ArrayList<Pronostico>();
        ArrayList<Equipo> equipos= new ArrayList<Equipo>();
        
        try {
            for (String linea : Files.readAllLines(resultadosPath)) {
            	String nomEq1=linea.split(",")[0];
            	String nomEq2=linea.split(",")[3];
            	Equipo aux1 = new Equipo(linea.split(",")[0], "");
                if(posEquipo(equipos, nomEq1)!=-1) {
                	aux1 = equipos.get(posEquipo(equipos,nomEq1));	
                }else {
                	equipos.add(aux1);
                }
                Equipo aux2 = new Equipo(nomEq2, "");
                if(posEquipo(equipos,nomEq2)!=-1) {
                	aux2= equipos.get(posEquipo(equipos,nomEq2));
                }else {
                	equipos.add(aux2);
                }
                
                partidos.add(new Partido(aux1, aux2, Integer.parseInt(linea.split(",")[1]),Integer.parseInt(linea.split(",")[2])));
            }
            /*for(String linea: Files.readAllLines(pronosticoPath)) {
            	Equipo auxEq1= 
            	Partido aux=buscarPartido(partidos, );
            	Pronostico aux1= new Pronostico();
            }*/
 
        } catch (IOException e) {
            System.err.println(e);
        }
        
        
        /* try {
            for (String linea : Files.readAllLines(pronosticoPath)) {
                Equipo aux1 = new Equipo(linea.split(",")[0], "");
                if (linea.split(",")[1] == "x") {
                    pronosticos.add(new Pronostico(partidos.getPartido(), aux1, Partido.Resultado.gano));
                }
                if (linea.split(",")[2] == "x") {
                    pronosticos.add(new Pronostico(partidos, aux1, Partido.Resultado.empato));
                }
                if (linea.split(",")[3] == "x") {
                    pronosticos.add(new Pronostico(partidos, aux1, Partido.Resultado.perdio));
                }
            }

        } catch (IOException e) {
            System.err.println(e);
        }*/
    }
}