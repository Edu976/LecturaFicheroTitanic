package ejercicioParcialTitanic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParcialTitanic {
	/**
	 * pre:
	 * post: en esta clase java se pide un programa que lea el fichero de texto de 
	 * la base de datos del titanic y nos muestre por pantalla el numero de pasajeros,
	 * el numero de hombres y el de mujeres, el numero de hombres y mujeres muertos y su 
	 * porcentaje
	 */
	private static void lectura(String nombre) {
		/*
		 * en este metodo leeremos el fichero y segun las condiciones que se nos dan en el 
		 * enunciado iremos mostrando lo que se nos pide
		 */
		int contadorPasajeros = 0;
		int contadorH = 0;
		int contadorHmuertos = 0;
		int porcentajeHombres = 0;
		int contadorM = 0;
		int contadorMmuertas = 0;
		int porcentajeMujeres = 0;
		File file = new File(nombre);
		try {
			Scanner f = new Scanner(file);
			while(f.hasNextLine()) {
				// leemos el fichero linea por linea 
				String linea = f.nextLine();
				/*
				 *  lo metemos dentro de una tabla y metemos dentro de cada celda lo que esta 
				 *  separado por comas, es decir la primera celda osea la 0 contendra todo lo 
				 *  vaya antes de la primera ",", en la segunda la segunda y así sucesivamente
				 */
				String [] linesep = linea.split(","); 
				for(int i = 0; i < linesep.length; i++) {
					// cada vez que la "i" sea 11 contaremos un pasajero
					if(i == 11) {
						contadorPasajeros++;
					}
					// cada vez que se lea la palabra "male" se contara un hombre
					if(linesep[i].equals("male")) {
						contadorH++;
					}
					// cada vez que se lea la palabra "female" se contara una mujer
					else if(linesep[i].equals("female")) {
						contadorM++;
					}
					/*
					 *  cada vez que se lea la palabra "male" y la celda 1 sea 0,
					 *  contara un hombre muerto
					 */
					if(linesep[i].equals("male") && linesep[1].equals("0")) {
						contadorHmuertos++;
					}
					/*
					 *  cada vez que se lea la palabra "female" y la celda 1 sea 0,
					 *  contara una mujer muerta
					 */
					else if(linesep[i].equals("female") && linesep[1].equals("0")) {
						contadorMmuertas++;
					}
				}
			}
			/*
			 *  como para contar los pasajeros he conado cada vezz que la tabla
			 *  llegaba a la ultima posicion, tambien coge la cabecera, por lo
			 *  que habra que restar 1 pasajero para que nos de el resultado real
			 */
			contadorPasajeros = contadorPasajeros - 1;
			// sacamos el porcentaje de hombres y mujeres muertos
			porcentajeHombres = (contadorHmuertos * 100)/ contadorH;
			porcentajeMujeres = (contadorMmuertas * 100)/ contadorM;
			// mostramos por pantalla el resultado
			System.out.println("el numero total de pasajeros es: " + contadorPasajeros);
			System.out.println("El numero total de hombres en el titanic fue: " + contadorH);
			System.out.println("El numero total de mujeres en el titanic fue: " + contadorM);
			System.out.println("El numero total de hombres muertos en el titanic fue: " + contadorHmuertos);
			System.out.println("El numero total de mujeres muertas en el titanic fue: " + contadorMmuertas);
			System.out.println("El porcentaje de hombres muertos es de: " + porcentajeHombres + "%");
			System.out.println("El porcentaje de mujeres muertas es de: " + porcentajeMujeres + "%");
			f.close();

		} catch(FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto.");
		}
	}
	
	public static void main(String[] args) {
		/*
		 * en este metodo le indicamos la ruta del fichero que tendrá que leer 
		 */
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dame la ruta + nombre del fichero: ");
		// RUTA
		// C:\Users\Gestor\Desktop\Programacion\EjercicioParcialTitanic\titanic.csv
		String fichero = entrada.nextLine();
		// pasamos la ruta al metodo de lectura
		lectura(fichero);
	}
}
