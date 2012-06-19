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
	private Integer cantFantasmaPerezoso = 0;
	private Integer cantFantasmaBuscador = 0;
	private Integer cantFantasmaZonzo = 0;
	private String archivoLaberinto;
	private String directorioSalida;
	private String directorioOrdenes;
	
	private static Pattern tiempoMuertoPattern = Pattern.compile("tiempomuerto\\s*=\\s*(\\d+)", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static Pattern tiempoPresaPattern = Pattern.compile("tiempopresa\\s*=\\s*(\\d+)", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static Pattern fantasmasPattern = Pattern.compile("fantasma\\s*(zonzo|perezoso|buscador)", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static Pattern laberintoPattern = Pattern.compile("ArchivoLaberinto\\s*=\\s*'([^']*)'", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static Pattern salidaPattern = Pattern.compile("DirSalida\\s*=\\s*'([^']*)'", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static Pattern ordenesPattern = Pattern.compile("DirOrdenes\\s*=\\s*'([^']*)'", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	
	private ConfiguracionPrincipal(){
		leerParametros(Constantes.ARCHIVO_CONFIGURACION);
	}
	
	public void leerParametros(String archivoEntrada){
		FileReader fr;
		try {
			fr = new FileReader(new File(archivoEntrada));
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null){
				Matcher matcher = tiempoMuertoPattern.matcher(line);
				if (matcher.find()){
					this.setTiempoMuerto(new Integer(matcher.group(1)));
				} else {
					matcher = tiempoPresaPattern.matcher(line);
					if (matcher.find()){
						this.setTiempoPresa(new Integer(matcher.group(1)));
					}
					else {
						matcher = fantasmasPattern.matcher(line);
						if (matcher.find()){
							if (Constantes.ZONZO.equals(matcher.group(1))){
								cantFantasmaZonzo++;
							} else if(Constantes.PEREZOSO.equals(matcher.group(1))){
								cantFantasmaPerezoso++;
							} else if(Constantes.BUSCADOR.equals(matcher.group(1))){
								cantFantasmaBuscador++;
							}
						} else {
							matcher = laberintoPattern.matcher(line);
							if (matcher.find()){
								this.archivoLaberinto = matcher.group(1);
							}
							else {
								matcher = salidaPattern.matcher(line);
								if (matcher.find()){
									this.directorioSalida = matcher.group(1);
								} else {
									matcher = ordenesPattern.matcher(line);
									if (matcher.find()){
										this.directorioOrdenes = matcher.group(1);
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
}
