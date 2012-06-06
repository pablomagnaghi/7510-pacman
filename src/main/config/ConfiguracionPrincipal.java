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
	
	private static Pattern tiempoMuertoPattern = Pattern.compile("tiempomuerto\\s*=\\s*(\\d+)", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static Pattern tiempoPresaPattern = Pattern.compile("tiempopresa\\s*=\\s*(\\d+)", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	
	private ConfiguracionPrincipal(){
		
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
	
}
