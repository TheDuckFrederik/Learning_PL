import java.io.*;
import java.util.*;

public class laberint_pepito_new {

	public static void main(String[] args) throws IOException {
		
		// Variables inicials que es ressetejaran a l'inici de cada joc (quan s'obre el programa)
		Scanner teclado = new Scanner(System.in);
		PrintWriter ficheroSalida = new PrintWriter(new File("ultima.txt"));
		String eleccio = "o";
		String eleccioJoc = "o";
		String moviment = "o";
		int contadorPartides = 0;
		// contadorMoviments és un Array perquè així contem separadament els moviments en funció del nivell (f, n, d, fitxer)
		int[] contadorMoviments = {0, 0, 0, 0};
			
		// MENÚ - 1r Bucle que es manté mentre no escolleixis una opcio valida
		while (!eleccio.equalsIgnoreCase("j") && !eleccio.equalsIgnoreCase("r") && !eleccio.equalsIgnoreCase("q")) {
			mostrarMenu();	 
			eleccio = teclado.next();
			
			// Missatge de error si no escolleixes una opcio valida
			if (!eleccio.equalsIgnoreCase("j") && !eleccio.equalsIgnoreCase("r") && !eleccio.equalsIgnoreCase("q")) {
				System.out.println("\nSiusplau introdueix una opció valida.\n");
				//Misssatge de despedida si decideixes sortir del joc
			} else if (eleccio.equalsIgnoreCase("q")) {
				System.out.println();
				System.out.println("----------------------------"
						   	   + "\n-          ¡ADEU!          -"
						   	   + "\n-    GRACIES PER JUGAR     -"
						   	   + "\n----------------------------");
			System.out.println();
			}
			
			
			// SUBMENÚ J: Elecció j JUGAR
			if (eleccio.equalsIgnoreCase("j")) {
				
				// 2n Bucle:  que es manté mentre no seleccionis una opcio valida del menu de joc
				while (!eleccio.equalsIgnoreCase("f") && !eleccio.equalsIgnoreCase("n") && !eleccio.equalsIgnoreCase("d") && !eleccio.equalsIgnoreCase("e")) {
					menuJugarPartida();
					eleccio = teclado.next();
					
					
					// resetejem el moviment de "q" a "o" original per poder tornar a entrar als bucles (laberints)
					moviment = "o";
					
					// Elecció Jugar modo fàcil
					if (eleccio.equalsIgnoreCase("f")) {
						eleccioJoc = "F";
						contadorPartides++;
						String[][] laberintFacil = crearMatriuLaberint(eleccio);
						
						// Arrays on es guarden les posicions del final de cada laberint per a poder saber quan acaba
						int[] posicioSortidaF = trobarPosicioSortida(laberintFacil);
						
						mostrarLaberint(laberintFacil);
						
						// MOVIMENT: 3r Bucle mentres pepito no estigui a la posicio de sortida el joc segueix
						while (!laberintFacil[posicioSortidaF[0]][posicioSortidaF[1]].equals("P") && !moviment.equalsIgnoreCase("q")) {
							moviment = teclado.next();
							canviarMatriuMourePepito(laberintFacil, moviment);
							mostrarLaberint(laberintFacil);
							if (pepitoMou(moviment)) {
								contadorMoviments[0]++;
							}
							
							
							
							if (moviment.equalsIgnoreCase("q")) {
								menuFugir();
							
							}
					
						} // 3r bucle tancament

						
					// Elecció Jugar modo normal
					} else if (eleccio.equalsIgnoreCase("n")) {
						eleccioJoc = "N";
						contadorPartides++;
						String[][] laberintNormal = crearMatriuLaberint(eleccio);
						int[] posicioSortidaN = trobarPosicioSortida(laberintNormal);
						mostrarLaberint(laberintNormal);
						
						// MOVIMENT: 3r Bucle mentres pepito no estigui a la posicio de sortida el joc segueix
						while (!laberintNormal[posicioSortidaN[0]][posicioSortidaN[1]].equals("P") && !moviment.equalsIgnoreCase("q")) {
							moviment = teclado.next();
							canviarMatriuMourePepito(laberintNormal, moviment);
							mostrarLaberint(laberintNormal);
							if (pepitoMou(moviment)) {
								contadorMoviments[1]++;
							}
							
							if (moviment.equalsIgnoreCase("q")) {
								menuFugir();
							
							}
						} // 3r bucle tancament
					
					// Elecció Jugar modo difícil
					} else if (eleccio.equalsIgnoreCase("d")) {
						eleccioJoc = "D";
						contadorPartides++;
						String[][] laberintDificil = crearMatriuLaberint(eleccio);
						int[] posicioSortidaD = trobarPosicioSortida(laberintDificil);
						mostrarLaberint(laberintDificil);
						
						// MOVIMENT: 3r Bucle mentres pepito no estigui a la posicio de sortida el joc segueix
						while (!laberintDificil[posicioSortidaD[0]][posicioSortidaD[1]].equals("P") && !moviment.equalsIgnoreCase("q")) {
							moviment = teclado.next();
							canviarMatriuMourePepito(laberintDificil, moviment);
							mostrarLaberint(laberintDificil);
							if (pepitoMou(moviment)) {
								contadorMoviments[2]++;
							}
							
							if (moviment.equalsIgnoreCase("q")) {
								menuFugir();
							
							}
							
						} // 3r bucle tancament

					// Elecció Jugar des d'un fitxer
					} else if (eleccio.equalsIgnoreCase("e")) {
						eleccioJoc = "E";
						contadorPartides++;
						System.out.print("Sense el .txt escriu el nom del fitxer: ");
						String nomFitxer = teclado.next();
						String[][] matriuFitxer = llegirDeFitxer(nomFitxer);
						int[] posicioSortidaE = trobarPosicioSortida(matriuFitxer);
						mostrarLaberint(matriuFitxer);
						
						// MOVIMENT: 3r Bucle mentres pepito no estigui a la posicio de sortida el joc segueix
						while (!matriuFitxer[posicioSortidaE[0]][posicioSortidaE[1]].equals("P") && !moviment.equalsIgnoreCase("q")) {
							moviment = teclado.next();
							canviarMatriuMourePepito(matriuFitxer, moviment);
							mostrarLaberint(matriuFitxer);
							
							if (pepitoMou(moviment)) {
								contadorMoviments[3]++;
							}
							if (moviment.equalsIgnoreCase("q")) {
								menuFugir();
							
							}
						} // 3r bucle tancament
					
					// ERROR EN ELEGIR OPCIÓ DE JUGABILITAT
					} else {
						System.out.println("\nSiusplau introdueix una opció valida.\n");
					}
					//GUARDEM LES DADES DEL JOC EN ELS FITXERS CORRESPONENTS AMB LES FUNCIONS SEGUENTS
					guardarDadesEnFitxer(moviment, eleccioJoc, contadorMoviments, contadorPartides);
					guardarDadesEnFitxerHistoric(moviment, eleccioJoc, contadorMoviments);
				
				} // 2n bucle tancament
			
				
			// SUBMENÚ R: Elecció resultat partides
			} else if (eleccio.equalsIgnoreCase("R")) {
				//MOSTRAR EL RESULTAT
				//Creem el array de strings on es guardaran els resultats
				String[] liniaResultat = new String[contadorPartides];
				String[] liniaResultatHistoric = new String[20];	
				
				// bucle per a repetir en cas d'error. Mostrem últim o històric.
				while (!eleccio.equalsIgnoreCase("H") && !eleccio.equalsIgnoreCase("U")) {
					menuResultats();
					// demanem una altra vegada l'eleccio per entrar en les opcions del submenú
					eleccio = teclado.next();
					
					// mostrar les ultimes partides fetes
					if (eleccio.equalsIgnoreCase("U")) {
						
						 llegirDeFitxerUltim(liniaResultat, contadorPartides);
					
					// mostrar l'historic de partides	 
					} else if (eleccio.equalsIgnoreCase("H")) {
						
						llegirDeFitxerHistoric(liniaResultatHistoric);
						
					// error en cas que no s'escrigui u/h, s'arriba al final del codi
					// i torna a començar el bucle fins que no s'escolleixi una opció vàlida
					} else {
						System.out.println("\nSiusplau introdueix una opció valida.\n");
					}
				}
			}
				
		} // Tanquem 1r bucle

		
	} // FI PROGRAMA MAIN

		
	
	// Funció canviarEstetica: canvia l'estètica de la matriu en la consola per emoticones
	public static void canviarEstetica(String[][] matriuLaberint, int fil, int col) {
		//Si és P mostrarem ☺, si és M mostrarem ▓, si és S mostrarem ♡:
		if (matriuLaberint[fil][col].equals("P")) { 
			System.out.print("☺");

		} else if (matriuLaberint[fil][col].equals("M")) {
			System.out.print("▓");

		} else if (matriuLaberint[fil][col].equals("S")) {
			System.out.print("♡");

		} else {
			System.out.print(" ");
			
		}
	}

	// FUNCIÓ-Mostrar Laberint (cridem caviarEstetica per a mostrar el laberint amb emoticones)
	public static void mostrarLaberint (String[][] matriuLaberint) {

		// Bucle perquè imprimi una posició rere l'altre de la matriu laberint:
		for (int fil = 0; fil < matriuLaberint.length; fil++) {
			for (int col = 0; col < matriuLaberint[fil].length; col++) { 

				//Si és P mostrarem ☺, si és M mostrarem ▓, si és S mostrarem ♡:
				canviarEstetica(matriuLaberint, fil, col);

			}
			System.out.println();
		}

	}
	


	// Funcio trobarPosicioSortida que retorna un array de dos posicions en 
	// el que cada posicio es la fila i la columna d'on es troba la sortida de laberint
	public static int[] trobarPosicioSortida (String[][] matriuLaberint) {
		int[] arrayPosicio = {0, 0};
		for (int fil = 0; fil < matriuLaberint.length; fil++) {
			for (int col = 0; col < matriuLaberint[fil].length; col++) {

				if (matriuLaberint[fil][col].equals("S")) {
					arrayPosicio[0] = fil;
					arrayPosicio[1] = col;
				}
			}
		}

		return arrayPosicio;
	}

	

	// FUNCIO CANVIAR MATRIU (Moure al pepito per la matriu)
	public static String[][] canviarMatriuMourePepito (String[][] matriuLaberint, String moviment) {

		for (int fil = 0; fil < matriuLaberint.length; fil++) {
			for (int col = 0; col < matriuLaberint[fil].length; col++) {


				if (matriuLaberint[fil][col].equalsIgnoreCase("P")) {
					
					
					// Moure's cap a dalt ("W") -> fila menys
					if (moviment.equalsIgnoreCase("W") && normativaLab(matriuLaberint, moviment, fil, col)) {
						matriuLaberint[fil -1][col] = "P";
						matriuLaberint[fil][col] = " ";
						return matriuLaberint;
						


						// Moure's cap a l'esquerra ("A") -> columna menys
					}
					if (moviment.equalsIgnoreCase("A") && normativaLab(matriuLaberint, moviment, fil, col)) {
						matriuLaberint[fil][col - 1] = "P";
						matriuLaberint[fil][col] = " ";
						return matriuLaberint;

						// Moure's cap a baix ("S") -> fila més
					}
					if (moviment.equalsIgnoreCase("S") && normativaLab(matriuLaberint, moviment, fil, col)) {
						matriuLaberint[fil + 1][col] = "P";
						matriuLaberint[fil][col] = " ";
						return matriuLaberint;


					}
						// Moure's cap a la dreta ("D") -> columna més
					if (moviment.equalsIgnoreCase("D") && normativaLab(matriuLaberint, moviment, fil, col)) {
						matriuLaberint[fil][col + 1] = "P";
						matriuLaberint[fil][col] = " ";
						return matriuLaberint;
						
					}

					
				}
			}
		}

		return matriuLaberint;
	}


	// Funcio dinsDeMatriu que asegura que la posició sigui dintre de la propia matriu
	public static boolean dinsDeMatriu(String[][] matriu, int fil, int col) {

		return (fil >= 0 && fil < matriu.length 
				&& col >= 0 && col < matriu[fil].length);
	}


	
	
	// Funció normativaLab: Normes del laberint. com per exemple no sortir de la matriu o no traspasar murs
	public static boolean normativaLab(String[][] matriu, String moviment, int fil, int col) {
		

				// Si al moures esta dins de matriu i la cel·la no es una "M" (mur) retorna true, es a dir que es pot moure; sino retorna false
				if (moviment.equalsIgnoreCase("w")
						&& dinsDeMatriu(matriu, fil -1, col) && !hiHaMur(matriu, fil-1, col)) {
					return true;
					
				} else if ((moviment.equalsIgnoreCase("a"))
						&& dinsDeMatriu(matriu, fil, col -1) && !hiHaMur(matriu, fil, col-1)) {
					return true;
				} else if ((moviment.equalsIgnoreCase("s"))
						&& dinsDeMatriu(matriu, fil +1, col) && !hiHaMur(matriu, fil+1, col)) {
					return true;
				} else if ((moviment.equalsIgnoreCase("d"))
						&& dinsDeMatriu(matriu, fil, col +1) && !hiHaMur(matriu, fil, col+1)) {
					return true;
				} else {
					return false;
				}
			

	}

	// Funcio hiHaMur  que determina si la posicio es un mur i en cas de que sí et retorna true (ESTETIC)
	public static boolean hiHaMur (String[][] matriu, int fil, int col) {
		return(matriu[fil][col].equalsIgnoreCase("M"));
	}
	
	// funcio pepitoMou que determina si un moviment es correcte per a poder comptarlo
	public static boolean pepitoMou (String moviment) {
		return (moviment.equalsIgnoreCase("W") || moviment.equalsIgnoreCase("A") || moviment.equalsIgnoreCase("S") || moviment.equalsIgnoreCase("D"));
	}

	// FUNCIO MOSTRARMENU: per mostrar el MENU DEL JOC
	public static void mostrarMenu() {
			System.out.print("_______LABERINT DE PEPITO_______ \n"
					+ "| J = Jugar partida. \n"
					+ "| R = Resultats partides. \n"
					+ "| Q = Sortir. \n"
					+ "|  Que escolleixes?  ");
		}
	

	// funció menuJugarPartida per mostrar el submenu de dificultat al escollir jugar partida
	public static void menuJugarPartida() {
			System.out.print("_______LABERINT DE PEPITO_______ \n"
					+ "| ---Jugar partida--- \n");

			System.out.print("Nivells de dificultat: \n"
					+ "\nF- Facil \n"
					+ "N- Normal \n"
					+ "D- Dificil \n"
					+ "E- Escollir fitxer \n"
					+ "\nQue escolleixes? ");
			
		}

	//funció menuResultats per mostrar el submenu d'opcions al escollir veure resultats partides
	public static void menuResultats() {
		System.out.print("\n_______LABERINT DE PEPITO_______ \n"
				+ "| ---Resultats partides--- \n");

		System.out.print("Quin resultat vols revisar?: \n"
				+ "\nU- Ultima partida \n"
				+ "H- Historic de partides \n"
				+ "\nQue escolleixes? ");
	}
		
	// Funció crearMatriuLaberint per crear les matrius a l'inici de cada partida. A cada partida la matriu es ressetejarà.
	public static String[][] crearMatriuLaberint(String eleccio) {
		
		// Laberint de nivell fàcil
		if (eleccio.equalsIgnoreCase("f")) {
			
			String[][] laberintFacil = {
					{"P", " ", "M", "M", " "},
					{"M", " ", " ", " ", " "},
					{" ", " ", "M", "M", " "},
					{"M", "M", "M", "S", " "}};
			
			return laberintFacil;
		
		// Laberint de nivell normal
		} else if (eleccio.equalsIgnoreCase("n")) {
			
			String[][] laberintMig = {
					{"P", " ", " ", " ", "M", " ", " ", " "},
					{"M", " ", "M", " ", "M", " ", "M", " "},
					{" ", " ", " ", " ", "M", " ", "M", " "},
					{" ", "M", "M", "M", "M", " ", "M", " "},
					{" ", "M", "M", " ", "M", " ", "M", " "},
					{" ", " ", " ", " ", " ", " ", "M", " "},
					{"M", " ", "M", "M", " ", "M", "M", "S"}};
			
			return laberintMig;
		
			// Laberint de nivell difícil
		} else if (eleccio.equalsIgnoreCase("d")) {
			
			String[][] laberintDificil = {
				    {"P", " ", "M", "M", " ", " ", " ", " ", " ", "M", "M", "M", "M", "M"},
				    {"M", " ", " ", " ", " ", "M", " ", "M", " ", " ", " ", " ", " ", " "},
				    {" ", " ", "M", "M", " ", "M", " ", "M", "M", "M", "M", "M", " ", "M"},
				    {" ", "M", "M", "M", " ", "M", " ", " ", " ", " ", "M", " ", " ", "M"},
				    {" ", " ", " ", "M", "M", "M", "M", "M", "M", "M", "M", "M", " ", "M"},
				    {"M", "M", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
				    {" ", "M", " ", "M", "M", "M", " ", "M", "M", "M", "M", "M", "M", " "},
				    {" ", " ", " ", "M", " ", "M", " ", "M", " ", " ", " ", " ", "M", " "},
				    {"M", "M", " ", " ", " ", " ", " ", "M", " ", "M", "M", " ", "M", " "},
				    {"M", "M", " ", "M", "M", " ", "M", "M", " ", "M", " ", " ", "M", " "},
				    {" ", " ", " ", "M", "M", " ", " ", " ", " ", "M", " ", "M", "M", "M"},
				    {" ", "M", " ", " ", "M", "M", "M", " ", "M", "M", " ", " ", " ", "S"}};
			
			return laberintDificil;
		
		// per a retornar una matriu artificial sense valor en cas d'error (tot i que mai entrarem en aquesta opció)
		} else {
			
			String[][] matriuError = {{}};
			return matriuError;
		}
				
	
	}

	// Funcio llegirDeFitxer que llegeix el fitxer i et retorna una matriu
	public static String[][] llegirDeFitxer(String nomArxiu) throws FileNotFoundException {

	    Scanner fichero = new Scanner(new File(nomArxiu + ".txt"));

	    int filas = fichero.nextInt();
	    int columnas = fichero.nextInt();

	    fichero.nextLine();
	    
	    // CREO MATRIZ
	    String[][] matriuStr = new String[filas][columnas];
	    String[] arrayStr = new String[filas];

	    // GUARDO LABERINT EN MATRIU LINEA A LINEA
	
	    for (int fil = 0; fil < filas; fil++) {
	    		//SI EL FICHER TE LINEA AFEGIRHO AL ARRAY DE STRINGS
	    		if (fichero.hasNextLine()) {
    			arrayStr[fil] = fichero.nextLine();
	    		}
	    		
		}
	    
	    //CREEM UNA MATRIU DE CHARS PER A PODER AFEGIR EL LABERINT
	    char[][] matriuChar = new char[filas][columnas];
	    
	    //RECORREM LA MATRIU DE CHARS
	    for (int fil = 0; fil < matriuChar.length; fil++) {
			for (int col = 0; col < matriuChar[fil].length; col++) {
				
				//ORGANITZERM LA MATRIU DE CHARS
				char resultat = arrayStr[fil].charAt(col);
				//PASEM LA MATRIU DE CHARS A STRINGS
				String resultatStr = String.valueOf(resultat);
				matriuStr[fil][col] = resultatStr;
				
			}
		}
	    fichero.close();
	    return matriuStr;

	    
	}
	
	// FUNCIO menufugir (si s'apreta la q, s'acaba el laberint i torna a sortir el menú)
	public static void menuFugir () {
					System.out.println("----------------------------"
								   + "\n-    ¡Has apretat la Q!    -"
								   + "\n- JOC PERDUT, T'HAS RENDIT -"
								   + "\n----------------------------");
					System.out.println();
				
	}

			
	//Funcio que guarda un registre historic al arxiu historic.txt
	// AMB HISTORIC VOL DIR QUE DA IGUAL QUE TANQUIS EL PROGRAMA QUE LES DADES SEGUIRAN GUARDANTSE I ACUMULANTSE
	public static void guardarDadesEnFitxerHistoric(String moviment, String eleccioJoc, int[] contadorMoviment) throws IOException {
		//Nom del arxiu (posat en variable per a que sigui mes senzill de cambiar en cas de voler cambiarlo)
		String nomArxiu = "historic.txt";
		//Boolea que comproba si el fitxer existeix
		boolean fitxerExist = new File(nomArxiu).exists();
		//Obrim fileWriter per editar fitxer existent sense petar les dades del anterior
		FileWriter ficheroSalida = new FileWriter(nomArxiu, true);
		//Variable que serveix per a contar les partides (mes endevant incrementa segons la ultima partida)
		int contadorPartides = ultimNumHistoric(nomArxiu);
		// Si no existeix creem el fitxer i li posem "historic" com a nom
		if (!fitxerExist) {
			ficheroSalida = new FileWriter(new File(nomArxiu));
		}
				
		contadorPartides++;

		ficheroSalida.append("\n");


		if (eleccioJoc.equalsIgnoreCase("F")) {
			ficheroSalida.append(contadorPartides + " - " + contadorMoviment[0] + " moviments " + "- FACIL");
						
		} else if (eleccioJoc.equalsIgnoreCase("N")) {
			ficheroSalida.append(contadorPartides + " - " + contadorMoviment[1] + " moviments " + "- NORMAL");
						
		} else if (eleccioJoc.equalsIgnoreCase("D")) {
			ficheroSalida.append(contadorPartides + " - " + contadorMoviment[2] + " moviments " + "- DIFICIL");
						
		} else if (eleccioJoc.equalsIgnoreCase("E")) {
			ficheroSalida.append(contadorPartides + " - " + contadorMoviment[3] + " moviments " + "- FITXER EXTERN");
		}

		if (moviment.equalsIgnoreCase("Q")) {
			ficheroSalida.append(" - DERROTA" );
		} else {
			ficheroSalida.append(" - VICTORIA" );
		}
			
		ficheroSalida.append("\n");
					
		ficheroSalida.close();
		
	}
					
			
	//FUNCIO QUE GUARDA LES DADES DE LA ULTIMA PARTIDA EN UN FITXER ANOMENAT "ultima.txt"
	public static void guardarDadesEnFitxer(String moviment, String eleccioJoc, int[] contadorMoviment, int contadorPartides) throws IOException {
				
		//CREACIO DEL FITXER FETA A LA MAIN
		//AQUI SIMPLEMENT OBRE FITXER
		PrintWriter ficheroSalida = new PrintWriter(new FileWriter("ultima.txt", true));

		ficheroSalida.append("\n");
				
		// INFORMACIO QUE MOSTRA EL FITXER I LA SEVA ESTRUCTURA
		ficheroSalida.append("Partida numero: " + contadorPartides);
		
		if (eleccioJoc.equalsIgnoreCase("F")) {
			ficheroSalida.append(" - Mode de joc: " + eleccioJoc.toUpperCase() + " -> FACIL" + " - Numero de moviments: " + contadorMoviment[0]);
						
		} else if (eleccioJoc.equalsIgnoreCase("N")) {
			ficheroSalida.append(" - Mode de joc: " + eleccioJoc.toUpperCase() + " -> NORMAL" + " - Numero de moviments: " + contadorMoviment[1]);
						
		} else if (eleccioJoc.equalsIgnoreCase("D")) {
			ficheroSalida.append(" - Mode de joc: " + eleccioJoc.toUpperCase() + " -> DIFICIL" + " - Numero de moviments: " + contadorMoviment[2]);
						
		} else if (eleccioJoc.equalsIgnoreCase("E")) {
			ficheroSalida.append(" - Mode de joc: " + eleccioJoc.toUpperCase() + " -> ESCOLLIR FITXER" + " - Numero de moviments: " + contadorMoviment[3]);
		}

		if (moviment.equalsIgnoreCase("Q")) {
			ficheroSalida.append(" - DERROTA" );
		} else {
			ficheroSalida.append(" - VICTORIA" );
		}
			
		ficheroSalida.append("\n");
							
		ficheroSalida.close();
		
	}

	// FUNCIO QUE LLEGEIX EL FITXER "ultima.txt" I EL MOSTRA PER CONSOLA
	public static void llegirDeFitxerUltim(String[] liniaResultat, int contadorPartides) throws FileNotFoundException {

		Scanner fichero = new Scanner(new File("ultima.txt"));
				 
		for (int i = 0; i < contadorPartides; i++) {
			liniaResultat[i] = fichero.nextLine();
			
			if (fichero.hasNextLine()) {
				liniaResultat[i] = fichero.nextLine();
			} 
		}
		
		System.out.println();
		
		for (int i = 0; i < contadorPartides; i++) {
			System.out.println(liniaResultat[i]);
		}
				 
		System.out.println();
						
	}
			
	// FUNCIO QUE LLEGEIX EL FITXER "historic.txt" I EL MOSTRA PER CONSOLA
	public static void llegirDeFitxerHistoric(String[] liniaResultat) throws IOException {

		String nomArxiu = "historic.txt";
		Scanner fichero = new Scanner(new File(nomArxiu));
	    int quantitatPartides = ultimNumHistoric(nomArxiu);
				
		for (int i = 0; i < quantitatPartides; i++) {
		
			liniaResultat[i] = fichero.nextLine();
			
			if (fichero.hasNextLine()) {
				liniaResultat[i] = fichero.nextLine();
			}
		}
		
		System.out.println();
			
		for (int i = 0; i < quantitatPartides; i++) {
			System.out.println(liniaResultat[i]);
		}
		
		System.out.println();
						
	}
			
	// FUNCIO QUE LLEGEIX QUIN ES L'ULTIM NUMERO DEL REGISTRE HISTORIC
	public static int ultimNumHistoric(String nomArxiu) throws IOException {
				
		//Obrim fileWriter per editar fitxer existent sense petar les dades del anterior
		FileWriter ficheroSalida = new FileWriter(nomArxiu, true);
		//Variable que serveix per a contar les partides (mes endevant incrementa segons la ultima partida)
		int contadorPartides = 0;
		//Scanner para poder leer cual es el ultimo numero de la partida jugada
	    Scanner fichero = new Scanner(new File(nomArxiu));
	    String ultimaLinia = " ";
		//CODIGO QUE DESFRAGMENTA LA ULTIMA LINIA DEL ARCHIVO DE TEXTO PARA LEER POR QUE NUMERO DE PARTIDA SE VA
	    // se guardan todas las lineas sobrescriviendose en la misma variable, por lo tanto solo se guarda la ultima
		while (fichero.hasNextLine()) {
			ultimaLinia = fichero.nextLine();
		}

		//Separamos la linea en un array para coger la parte 0 que seria el numero de partida
		String[] partes = ultimaLinia.split(" ");
				  
		if (partes.length > 0) {
			contadorPartides = Integer.parseInt(partes[0]);
		} else {
			contadorPartides = 0;
		}
		
		return contadorPartides;
			
	}
					
} // FI PROGRAMA LABERINT_PEPITO