package bbdd;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	// TODO rellenar constantes
	private static final String HOST = "localhost";
	private static final String BBDD = "bibliotecadb";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final int SALIR = 0;
	private static ModeloLibro libro = new ModeloLibro(BBDD, HOST, USERNAME, PASSWORD);
	private static ModeloUsuario usuario = new ModeloUsuario(BBDD, HOST, USERNAME, PASSWORD);

	public static void main(String[] args) throws SQLException {

		int opcion = 0;
		int aukera;
		boolean logeado = false;

		int aux = 0;
		do {
			menuinicial();

			int opcion1 = Integer.parseInt(sc.nextLine());

			switch (opcion1) {
			case SALIR:
				System.out.println("El programa se ha cerrado....");
				break;
			case 1:

				while (aux < 3 && !logeado) {
					System.out.print("introduzca un login: ");
					String user = sc.nextLine();
					System.out.print("Introduzca su pass:");
					String pass = sc.nextLine();

					if (usuario.select_like(user).get(0).getPassword().equals(pass)) {
						logeado = true;
					}
					aux++;
				}

				if (logeado) {

					do {
						menuPrincipal();

						opcion = Integer.parseInt(sc.nextLine());

						switch (opcion) {
						case 1:

							menuLibros();
							aukera = Integer.parseInt(sc.nextLine());

							switch (aukera) {
							case 1:
								listarlibros();

								break;
							case 2:
								buscarlibros();

								break;
							case 3:
								verlibros();

								break;
							case 4:
								editarlibros();

								break;
							case 5:
								eliminarlibro();
								break;
							case SALIR:
								System.out.println("El programa se ha cerrado....");
								break;
							default:
								System.out.println("Opcion incorrecta");
								break;
							}
							break;
						case 2:
							menuUsuarios();
							aukera = Integer.parseInt(sc.nextLine());

							switch (aukera) {
							case 1:
								listarusuarios();
								break;
							case 2:
								buscarusuarios();
								break;

							case 3:
								verusuarios();
								break;
							case 4:
								editarusuario();
								break;
							case 5:
								eliminarusuario();
								break;
							case SALIR:
								System.out.println("El programa se ha cerrado....");
								break;
							default:
								System.out.println("Opcion incorrecta");
								break;
							}

							break;

						case 3:
							menuPrestamos();
							aukera = Integer.parseInt(sc.nextLine());

							switch (aukera) {
							case 1:

								break;
							case 2:

								break;

							case 3:

								break;
							case SALIR:
								System.out.println("El programa se ha cerrado....");
								break;
							default:
								System.out.println("Opcion incorrecta");
								break;
							}

							break;

						case SALIR:
							System.out.println("El programa se ha cerrado....");
							break;
						default:
							System.out.println("Opcion incorrecta");
							break;
						}

					} while (opcion != SALIR);

				}
			}
		} while (opcion != SALIR);

	}

	private static void menuinicial() {
		// TODO Auto-generated method stub
		System.out.println("....................MENU...........................");
		System.out.println("\n0- Salir" + "\n1- Buscar un usuario en la base de datos");
	}

	private static void eliminarusuario() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("¿Que libro quieres eliminar?" + "\nIntroduce el ID del libro");
		String dni = sc.nextLine();
		usuario.eliminar_usuario(dni);
	}

	private static void editarusuario() throws SQLException {
		// TODO Auto-generated method stub
		String password;
		System.out.println("Introduzca nombre:");
		System.out.println("**********************************************************************************");
		password = sc.nextLine();
		String dni;
		System.out.println("Introduzca dni:");
		System.out.println("**********************************************************************************");
		dni = sc.nextLine();
		usuario.editar_usuario(password, dni);
	}

	private static void verusuarios() {
		// TODO Auto-generated method stub
		String nombre;
		System.out.println("Introduzca nombre:");
		System.out.println("**********************************************************************************");
		nombre = sc.nextLine();
		usuario.ver_usuario(nombre);
		System.out.println(usuario.ver_usuario(nombre).toString());

	}

	private static void buscarusuarios() {
		// TODO Auto-generated method stub
		System.out.println("Introduzca la parte del nombre del usuario que quieres buscar:");
		System.out.println("**********************************************************************************");
		String partes = sc.nextLine();
		usuario.select_like(partes);
		for (int i = 0; i < usuario.select_like(partes).size(); i++) {
			System.out.println(usuario.select_like(partes).get(i));
		}
	}

	private static void listarusuarios() {
		// TODO Auto-generated method stub
		usuario.selectALL();
		System.out.println("Lista de los usuarios:");
		System.out.println("**********************************************************************************");
		for (int i = 0; i < usuario.selectALL().size(); i++) {

			System.out.println(usuario.selectALL().get(i));
		}
	}

	private static void eliminarlibro() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("¿Que libro quieres eliminar?" + "\nIntroduce el ID del libro");
		int id = Integer.parseInt(sc.nextLine());
		libro.eliminar_libro(id);
	}

	private static void editarlibros() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("¿Que libro quieres editar?");
		System.out.println("Introduce el titulo:");
		System.out.println("**********************************************************************************");
		String titulo = sc.nextLine();
		System.out.println("Introduce el nuevo numero de paginas:");
		System.out.println("**********************************************************************************");
		int num = Integer.parseInt(sc.nextLine());
		libro.editar_libro(titulo, num);
	}

	private static void buscarlibros() {
		// TODO Auto-generated method stub
		System.out.println("Introduzca la parte del nombre del socio que quieres buscar:");
		System.out.println("**********************************************************************************");
		String partes = sc.nextLine();
		libro.select_like(partes);
		for (int i = 0; i < libro.select_like(partes).size(); i++) {
			System.out.println(libro.select_like(partes).get(i));
		}
	}

	private static void verlibros() {
		// TODO Auto-generated method stub
		String nombre;
		System.out.println("Introduzca nombre:");
		System.out.println("**********************************************************************************");
		nombre = sc.nextLine();
		libro.ver_libro(nombre);
		System.out.println(libro.ver_libro(nombre).toString());

	}

	private static void listarlibros() throws SQLException {
		// TODO Auto-generated method stub
		libro.selectALL();
		System.out.println("Lista de los libros:");
		System.out.println("**********************************************************************************");
		for (int i = 0; i < libro.selectALL().size(); i++) {

			System.out.println(libro.selectALL().get(i));
		}

	}

	private static void menuPrincipal() {

		System.out.println("...............................................");
		System.out.println("¿Que quieres hacer?" + "\n1- Entrar en la gestion de libros"
				+ "\n2- Entrar en la gestion de usuarios" + "\n3- Entrar en la gestion de prestamos" + "\n0- Salir");
	}

	private static void menuLibros() {
		System.out.println("...............................................");
		System.out.println("¿Que quieres hacer?" + "\n1- Listar los libros de la base de datos"
				+ "\n2- Buscar un libro en la base de datos" + "\n3- Pedir un libro y buscar la información pertinente"
				+ "\n4- Pedir un libro y editar la información" + "\n5- Eliminar un libro" + "\n0- Salir");
	}

	private static void menuUsuarios() {
		System.out.println("...............................................");
		System.out.println("¿Que quieres hacer?" + "\n1- Listar los usuarios de la base de datos"
				+ "\n2- Buscar un usuario en la base de datos"
				+ "\n3- Pedir un usuario y buscar la información pertinente"
				+ "\n4- Pedir un usuario y editar la información" + "\n5- Eliminar un usuario" + "\n0- Salir");
	}

	public static void menuPrestamos() {

	}

}