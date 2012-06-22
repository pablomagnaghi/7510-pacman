package main.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfiguracionPrincipal {
	
	private static ConfiguracionPrincipal instance = null;
	
	private Integer tiempoMuerto;
	private Integer tiempoPresa;
	private Integer tiempoPacman;
	private Integer cantFantasmaPerezoso = 0;
	private Integer cantFantasmaBuscador = 0;
	private Integer cantFantasmaZonzo = 0;
	private Integer distanciaPerezoso = 2;
	private Integer distanciaBuscador = 3;
	private Integer distanciaZonzo = 4;
	
	private String archivoLaberinto;
	private String directorioSalida;
	private String directorioOrdenes;
	
	private static Pattern tiemposPattern = Pattern.compile("Tiempo(Muerto|Presa|Pacman)\\s*=\\s*(\\d+)", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static Pattern fantasmasPattern = Pattern.compile("fantasma\\s*(zonzo|perezoso|buscador)", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static Pattern directoriosPattern = Pattern.compile("(ArchivoLaberinto|DirSalida|DirOrdenes)\\s*=\\s*'([^']*)'", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static Pattern distanciaPattern = Pattern.compile("distancia\\s*(buscador|perezoso|zonzo)\\s*=\\s*(\\d+)", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

	private ConfiguracionPrincipal(){
		
	}
	
	public void leerParametros(String archivoEntrada){
		FileReader fr;
		try {
			fr = new FileReader(new File(archivoEntrada));
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null){
				Boolean lineParsed = matchTiempos(line);
				if (!lineParsed){
					lineParsed = matchFantasmas(line);
					if (!lineParsed){
						lineParsed = matchDistancias(line);
						if (!lineParsed){
							lineParsed = matchArchivos(line);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Boolean matchTiempos(String line){
		Boolean result = Boolean.FALSE;
		if (this.tiempoMuerto != null && this.tiempoPresa != null && this.tiempoPacman != null){
			return result;
		}
		Matcher matcher = tiemposPattern.matcher(line);
		if (matcher.find()){
			if (Constantes.PRESA.equals(matcher.group(1))){
				this.setTiempoPresa(new Integer(matcher.group(2)));
			} else if (Constantes.MUERTO.equals(matcher.group(1))){
				this.setTiempoMuerto(new Integer(matcher.group(2)));
			} else {
				this.setTiempoPacman(new Integer(matcher.group(2)));
			}
			result = Boolean.TRUE;
		}
		return result;
	}
	
	private Boolean matchFantasmas(String line){
		Boolean result = Boolean.FALSE;
		Matcher matcher = fantasmasPattern.matcher(line);
		if (matcher.find()){
			if (Constantes.ZONZO.equals(matcher.group(1))){
				cantFantasmaZonzo++;
			} else if (Constantes.PEREZOSO.equals(matcher.group(1))){
				cantFantasmaPerezoso++;
			} else {
				cantFantasmaBuscador++;
			}
			result = Boolean.TRUE;
		}
		return result;
	}
	
	private Boolean matchDistancias(String line){
		Boolean result = Boolean.FALSE;
		Matcher matcher = distanciaPattern.matcher(line);
		if (matcher.find()){
			if (Constantes.ZONZO.equals(matcher.group(1))){
				this.setDistanciaZonzo(new Integer(matcher.group(2)));
			} else if (Constantes.PEREZOSO.equals(matcher.group(1))) {
				this.setDistanciaPerezoso(new Integer(matcher.group(2)));
			} else {
				this.setDistanciaBuscador(new Integer(matcher.group(2)));
			}
			result = Boolean.TRUE;
		}
		return result;
	}
	
	private Boolean matchArchivos(String line){
		Boolean result = Boolean.FALSE;
		Matcher matcher = directoriosPattern.matcher(line);
		if (this.archivoLaberinto != null && this.directorioOrdenes != null && this.directorioSalida!=null){
			return result;
		}
		if (matcher.find()){
			if (Constantes.ARCHIVO_LABERINTO.equals(matcher.group(1))){
				this.archivoLaberinto = matcher.group(2);
			} else if (Constantes.DIR_ORDENES.equals(matcher.group(1))){
				this.directorioOrdenes = matcher.group(2);
			} else {
				this.directorioSalida = matcher.group(2);
			}
			result = Boolean.TRUE;
		}
		return result;
	}

	public Integer getTiempoMuerto() {
		return tiempoMuerto;
	}

	private void setTiempoMuerto(Integer tiempoMuerto) {
		this.tiempoMuerto = tiempoMuerto;
	}

	public Integer getTiempoPresa() {
		return tiempoPresa;
	}

	private void setTiempoPresa(Integer tiempoPresa) {
		this.tiempoPresa = tiempoPresa;
	}

	public static ConfiguracionPrincipal getInstance(){
		if (instance == null){
			instance = new ConfiguracionPrincipal();
		}
		return instance;
	}
	
	public Integer getCantFantasmaBuscador() {
		return cantFantasmaBuscador;
	}
	
	public Integer getCantFantasmaZonzo() {
		return cantFantasmaZonzo;
	}
	
	public Integer getCantFantasmaPerezoso() {
		return cantFantasmaPerezoso;
	}
	
	public String getArchivoLaberinto() {
		return archivoLaberinto;
	}
	
	public String getDirectorioSalida() {
		return directorioSalida;
	}
	
	public String getDirectorioOrdenes() {
		return directorioOrdenes;
	}

	public Integer getDistanciaPerezoso() {
		return distanciaPerezoso;
	}

	private void setDistanciaPerezoso(Integer distanciaPerezoso) {
		this.distanciaPerezoso = distanciaPerezoso;
	}

	public Integer getDistanciaBuscador() {
		return distanciaBuscador;
	}

	private void setDistanciaBuscador(Integer distanciaBuscador) {
		this.distanciaBuscador = distanciaBuscador;
	}

	public Integer getDistanciaZonzo() {
		return distanciaZonzo;
	}

	private void setDistanciaZonzo(Integer distanciZonzo) {
		this.distanciaZonzo = distanciZonzo;
	}

	public Integer getTiempoPacman() {
		return tiempoPacman;
	}

	private void setTiempoPacman(Integer tiempoPacman) {
		this.tiempoPacman = tiempoPacman;
	}
	
}
