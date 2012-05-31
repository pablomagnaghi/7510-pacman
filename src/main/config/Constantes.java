package main.config;

public class Constantes {
	
	public static Integer IRA_MINIMA = 1;
	public static Integer IRA_MAXIMA = 5;
	public static Integer DEATH_TIME = 3000;
	
	public static String CAZADOR = "Cazador";
	public static String ELIMINAR_CAZADOR = "No me podes comer, soy cazador";
	public static String REVIVIR_CAZADOR = "No me podes revivir, ya estoy vivo";
	public static String MOVER_CAZADOR = "Soy cazador y me muevo con nivel de agresividad ";
	public static String CONVERTIR_CAZADOR_A_PRESA = "Soy cazador y me convierto en presa";
	public static String CONVERTIR_CAZADOR_A_CAZADOR = "Ya soy cazador";
	public static String AUMENTAR_IRA_CAZADOR = "Aumentando ira del cazador";
	public static String AUMENTAR_IRA_MAX_CAZADOR = "Cazador ha llegado a su maxima ira";

	
	public static String MUERTO = "Muerto";
	public static String MOVER_MUERTO = "Estoy muerto, no me puedo mover";
	public static String INCREMENTAR_IRA_MUERTO = "Estoy muerto, no puedo incrementar ira";
	public static String ELIMINAR_MUERTO = "Estoy muerto, no puedo volver a morir";
	public static String REVIVIR_MUERTO = "Estoy muerto y me reviven";
	public static String CONVERTIR_MUERTO_A_PRESA = "Estoy muerto y no puedo ser presa";
	public static String CONVERTIR_MUERTO_A_CAZADOR = "Estoy muerto y vuelvo a ser cazador";
	
	public static String PRESA = "Presa";
	public static String MOVER_PRESA = "Soy presa y me escapo";
	public static String INCREMENTAR_IRA_PRESA = "Soy presa, no puedo incrementar ira";
	public static String ELIMINAR_PRESA = "Soy presa y me comiste";
	public static String REVIVIR_PRESA = "Soy presa, no puedo revivir";
	public static String CONVERTIR_PRESA_A_PRESA = "Soy presa no me puedo convertir en presa";
	public static String CONVERTIR_PRESA_A_CAZADOR = "Soy presa y me muevo a convertir en cazador";
	
}
