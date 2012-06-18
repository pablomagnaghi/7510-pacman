package main.config;

public abstract class Constantes {

//	public static final String ARCHIVO_LABERINTO 			= "./././res/Laberinto.xml";
//	public static final String ARCHIVO_LABERINTO 			= "./././res/xml-escenarioDePrueba";
//	public static final String ARCHIVO_LABERINTO 			= "./././res/pruebaBasica.xml";
//	public static final String ARCHIVO_LABERINTO 			= "./././res/ejemploCatedra.xml";
	public static final String ARCHIVO_LABERINTO 			= "./././res/escenario2.xml";
	public static final String ARCHIVO_LABERINTO_SALIDA		= "./././res/LaberintoTick";
	public static final String ARCHIVO_PERSONAJES_SALIDA	= "./././res/PersonajesTick";
	
	public static final String ARCHIVO_CONFIGURACION		= "./././res/ArchivoEntrada.txt";
	public static final String ARCHIVO_PACMAN				= "./././res/Ordenes";
	public static final String DERECHA						= "derecha";
	public static final String ABAJO						= "abajo";
	public static final String ARRIBA						= "arriba";
	public static final String IZQUIERDA					= "izquierda";
	public static final String BOLITA						= "bolita";
	public static final String BOLON						= "bolon";
	public static final Integer PACMAN_VELOCIDAD			= 2;
	public static final Integer FANTASMA_VELOCIDAD_NORMAL	= 3;
	public static final Integer FANTASMA_VELOCIDAD_MOLESTO	= 2;
	public static final Integer FANTASMA_VELOCIDAD_FURIOSO	= 1;
	public static final Integer DISTANCIA_MAX				= 60000;
	
	public static final Integer FANTASMA_TICKS_ENOJO		= 2;
	
	public static final String COLOR_ROJO					= "Rojo";
	public static final String COLOR_VERDE					= "Verde";
	public static final String COLOR_AMARILLO				= "Amarillo";
	public static final String COLOR_NEGRO					= "Negro";
	public static final String ERROR_PARAMETROS				= "Error de parametros, ingrese la ruta del archivo de configuracion al iniciar";
	public static final Integer LINEAS_MAXIMA				= 16;
	public static final Integer IRA_ESTADO_NORMAL 			= 1;
	public static final Integer IRA_ESTADO_MOLESTO			= 2;
	public static final Integer IRA_ESTADO_FURIOSO			= 3;
	public static final String CAZADOR 						= "cazador";
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

	public static final String PRESA 						= "presa";
	public static final String MOVER_PRESA				 	= "Soy presa y me escapo";
	public static final String INCREMENTAR_IRA_PRESA 		= "Soy presa, no puedo incrementar ira";
	public static final String ELIMINAR_PRESA 				= "Soy presa y me comiste";
	public static final String REVIVIR_PRESA 				= "Soy presa, no puedo revivir";
	public static final String CONVERTIR_PRESA_A_PRESA 		= "Soy presa no me puedo convertir en presa";
	public static final String CONVERTIR_PRESA_A_CAZADOR	= "Soy presa y me vuelvo a convertir en cazador";

	public static final String ERROR_FANTASMA_NO_INICIADO 	= "Debe iniciar primero el fantasma para poder hacer esta accion";
	public static final String FANTASMA_YA_INICIADO 		= "Fantasma ya iniciado";

	public static final String ZONZO 						= "zonzo";
	public static final String PEREZOSO 					= "perezoso";
	public static final String BUSCADOR 					= "buscador";
	public static final String BUSCADOR_T 					= "buscadorT";
	public static final Integer DISTANCIA_ZONZO 			= 1;
	public static final Integer DISTANCIA_PEREZOSO 			= 2;
	public static final Integer DISTANCIA_BUSCADOR 			= 3;
	public static final Integer ACCION_ESCAPAR 				= 0;
	public static final Integer ACCION_ACERCAR 				= 1;
	
}
