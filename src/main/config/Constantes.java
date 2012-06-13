package main.config;

public abstract class Constantes {

	public static final String ARCHIVO_LABERINTO 			= "./././res/escenario2.txt";
	public static final String ARCHIVO_CONFIGURACION		= "./././res/ArchivoEntrada.txt";
	public static final String ARCHIVO_PACMAN				= "./././res/Ordenes.txt";
	public static final String DERECHA						= "DERECHA";
	public static final String ABAJO						= "ABAJO";
	public static final String ARRIBA						= "ARRIBA";
	public static final String IZQUIERDA					= "IZQUIERDA";
	public static final Integer PACMAN_ARRIBA				= 0;
	public static final Integer PACMAN_ABAJO				= 1;
	public static final Integer PACMAN_DERECHA				= 2;
	public static final Integer PACMAN_IZQUIERDA			= 3;
	public static final Integer PACMAN_FIN					= 4;
	//public static final Integer LABERINTO_WIDTH				= 28;
	public static final Integer LABERINTO_WIDTH				= 28;
	public static final Integer LABERINTO_HEIGHT			= 3;
	//public static final Integer LABERINTO_HEIGHT			= 31;
	public static final String COLOR_ROJO					= "Rojo";
	public static final String COLOR_VERDE					= "Verde";
	public static final String COLOR_AMARILLO				= "Amarillo";
	public static final String COLOR_NEGRO					= "Negro";
	public static final String ERROR_PARAMETROS				= "Error de parametros, ingrese la ruta del archivo de configuracion al iniciar";
	public static final Integer LINEAS_MAXIMA				= 16;
	public static final Integer IRA_MINIMA 					= 1;
	public static final Integer IRA_MAXIMA 					= 3;
	public static final String CAZADOR 						= "Cazador";
	public static final String ELIMINAR_CAZADOR 			= "No me podes comer, soy cazador";
	public static final String REVIVIR_CAZADOR 				= "No me podes revivir, ya estoy vivo";
	public static final String MOVER_CAZADOR 				= "Soy cazador y me muevo con nivel de agresividad ";
	public static final String CONVERTIR_CAZADOR_A_PRESA	= "Soy cazador y me convierto en presa";
	public static final String CONVERTIR_CAZADOR_A_CAZADOR 	= "Ya soy cazador";
	public static final String AUMENTAR_IRA_CAZADOR 		= "Aumentando ira del cazador";
	public static final String AUMENTAR_IRA_MAX_CAZADOR 	= "Cazador ha llegado a su maxima ira";
	public static final String MUERTO 						= "Muerto";
	public static final String MOVER_MUERTO 				= "Estoy muerto, no me puedo mover";
	public static final String INCREMENTAR_IRA_MUERTO 		= "Estoy muerto, no puedo incrementar ira";
	public static final String ELIMINAR_MUERTO 				= "Estoy muerto, no puedo volver a morir";
	public static final String REVIVIR_MUERTO 				= "Estoy muerto y me reviven";
	public static final String CONVERTIR_MUERTO_A_PRESA 	= "Estoy muerto y no puedo ser presa";
	public static final String CONVERTIR_MUERTO_A_CAZADOR 	= "Estoy muerto y no puedo ser convertido a cazador";

	public static final String PRESA 						= "Presa";
	public static final String MOVER_PRESA				 	= "Soy presa y me escapo";
	public static final String INCREMENTAR_IRA_PRESA 		= "Soy presa, no puedo incrementar ira";
	public static final String ELIMINAR_PRESA 				= "Soy presa y me comiste";
	public static final String REVIVIR_PRESA 				= "Soy presa, no puedo revivir";
	public static final String CONVERTIR_PRESA_A_PRESA 		= "Soy presa no me puedo convertir en presa";
	public static final String CONVERTIR_PRESA_A_CAZADOR	= "Soy presa y me vuelvo a convertir en cazador";

	public static final String ERROR_FANTASMA_NO_INICIADO 	= "Debe iniciar primero el fantasma para poder hacer esta accion";
	public static final String FANTASMA_YA_INICIADO 		= "Fantasma ya iniciado";

}
