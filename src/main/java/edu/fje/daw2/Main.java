package edu.fje.daw2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Clase principal que contiene el flujo principal de la aplicación de la biblioteca.
 *
 * Gestiona clientes, libros, discos y trabajadores.
 * Proporciona un menú para crear, modificar, eliminar y buscar clientes, libros, discos y trabajadores.
 *
 * @see Cliente para la clase que representa a un cliente.
 * @see Libro para la clase que representa a un libro.
 * @see ColeccionDisco para la clase que representa una colección de discos.
 * @see Trabajador para la clase que representa a un trabajador.
 */
public class Main {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Libro> libros = new ArrayList<>();
    private static List<ColeccionDisco> discos = new ArrayList<>();
    private static List<Trabajador> trabajadores = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    static Object[][] clientesExistentes = {
            {1, "Wilos", "abc@gmail,com", 123 },
            {1, "Balvan", "abc@gmail,com", 123, "Jesuitas" }
    };

    /**
     * Método principal que inicia la ejecución del programa y muestra el menú principal.
     *
     * Inicializa las colecciones de discos, libros y trabajadores, y los agrega a sus respectivas listas.
     * Luego, se muestra un menú para interactuar con las distintas opciones de la biblioteca.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        // Inicialización de discos, trabajadores y libros
        ColeccionDisco disco = new ColeccionDisco("flores", FormatoDisco.CD);
        discos.add(disco);

        Trabajador trabajador = new Trabajador(1, "Ramiro");
        trabajadores.add(trabajador);

        Libro papel = new Papel("Quijote", "Quijote", "1242455m", 455);
        Libro audio = new Audio("Los juegos del hambre", "Los juegos del hamrbe", "2345678V", 123);
        libros.add(papel);
        libros.add(audio);

        // Crear clientes a partir de la lista de clientes existentes
        Iterator<Object[]> iter = List.of(clientesExistentes).iterator();
        while (iter.hasNext()) {
            Object[] cliente = iter.next();
            if ( cliente.length <= 4){
                ClientePrivado privado = new ClientePrivado(
                        (int) cliente[0],
                        (String) cliente[1],
                        (String) cliente[2],
                        (int) cliente[3]
                );
                clientes.add(privado);
            } else {
                ClienteEscuela escuela = new ClienteEscuela(
                        (int) cliente[0],
                        (String) cliente[1],
                        (String) cliente[2],
                        (int) cliente[3],
                        (String) cliente[4]
                );
                clientes.add(escuela);
            }
        }

        // Menú principal
        int opcion;
        do {
            System.out.println("\n📚 MENU BIBLIOTECA 📚");
            System.out.println("1. Crear");
            System.out.println("2. Prestaciones");
            System.out.println("3. Modificar");
            System.out.println("4. Buscar");
            System.out.println("5. Eliminar");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> menuCrear();
                case 2 -> menuPrestacion();
                case 3 -> menuModificar();
                case 4 -> menuBuscar();
                case 5 -> menuEliminar();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("❌ Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }
    /**
     * Muestra el menú para crear nuevos elementos como clientes, libros, discos y trabajadores.
     * Permite seleccionar la opción para crear cada tipo de objeto.
     *
     * @see crearCliente() para crear un cliente.
     * @see crearLibro() para crear un libro.
     * @see crearDisco() para crear una colección de discos.
     * @see crearTrabajador() para crear un trabajador.
     */
    private static void menuCrear() {
        int opcion;
        do {
            System.out.println("\n📚 MENU CREAR 📚");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Crear Libro");
            System.out.println("3. Crear Colección de Discos");
            System.out.println("4. Crear Trabajador");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> crearCliente();
                case 2 -> crearLibro();
                case 3 -> crearDisco();
                case 4 -> crearTrabajador();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("❌ Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    /**
     * Muestra el menú para gestionar las prestaciones como préstamos y devoluciones de libros y discos.
     * Permite seleccionar la opción para prestar/devolver libros o discos.
     *
     * @see prestarLibro() para prestar un libro a un cliente privado.
     * @see devolverLibro() para devolver un libro.
     * @see pedirDisco() para pedir una colección de discos a un cliente escuela.
     * @see devolverDisco() para devolver una colección de discos.
     * @see mostrarTodosLosPrestamos() para ver todos los préstamos realizados.
     */
    private static void menuPrestacion() {
        int opcion;
        do {
            System.out.println("\n📚 MENU PRESTACIÓN 📚");
            System.out.println("1. Prestar Libro (Solo Cliente Privado)");
            System.out.println("2. Devolver Libro");
            System.out.println("3. Pedir Colección de Discos (Solo Cliente Escuela)");
            System.out.println("4. Devolver Colección de Discos");
            System.out.println("5. Ver Préstamos Realizados");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> prestarLibro();
                case 2 -> devolverLibro();
                case 3 -> pedirDisco();
                case 4 -> devolverDisco();
                case 5 -> mostrarTodosLosPrestamos();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("❌ Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    /**
     * Muestra el menú para eliminar elementos como clientes, libros, discos y trabajadores.
     * Permite seleccionar la opción para eliminar cada tipo de objeto.
     *
     * @see eliminarCliente() para eliminar un cliente.
     * @see eliminarLibro() para eliminar un libro.
     * @see eliminarDisco() para eliminar una colección de discos.
     * @see eliminarTrabajador() para eliminar un trabajador.
     */
    private static void menuEliminar() {
        int opcion;
        do {
            System.out.println("\n📚 MENU ELIMINAR 📚");
            System.out.println("1. Eliminar Cliente");
            System.out.println("2. Eliminar Libro");
            System.out.println("3. Eliminar Colección de Discos");
            System.out.println("4. Eliminar Trabajador");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> eliminarCliente();
                case 2 -> eliminarLibro();
                case 3 -> eliminarDisco();
                case 4 -> eliminarTrabajador();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("❌ Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    /**
     * Muestra el menú para modificar elementos como clientes, libros y discos.
     * Permite seleccionar la opción para modificar un cliente o un producto (libro o disco).
     *
     * @see modificarCliente() para modificar un cliente.
     * @see modificarProducto() para modificar un libro o una colección de discos.
     */
    private static void menuModificar() {
        int opcion;
        do {
            System.out.println("\n📚 MENU MODIFICAR 📚");
            System.out.println("1. Modificar Cliente");
            System.out.println("2. Modificar Libro o Modificar Colección de Discos");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> modificarCliente();
                case 2 -> modificarProducto();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("❌ Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    /**
     * Muestra el menú para buscar elementos como clientes, libros, discos y trabajadores.
     * Permite seleccionar la opción para buscar cada tipo de objeto.
     *
     * @see buscarCliente() para buscar un cliente.
     * @see buscarLibro() para buscar un libro.
     * @see buscarDisco() para buscar una colección de discos.
     * @see buscarTrabajador() para buscar un trabajador.
     */
    private static void menuBuscar() {
        int opcion;
        do {
            System.out.println("\n📚 MENU BUSCAR 📚");
            System.out.println("1. Buscar Cliente");
            System.out.println("2. Buscar Libro");
            System.out.println("3. Buscar Colección de Discos");
            System.out.println("4. Buscar Trabajador");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> buscarCliente();
                case 2 -> buscarLibro();
                case 3 -> buscarDisco();
                case 4 -> buscarTrabajador();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("❌ Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }



    /**
     * Permite a un trabajador recibir la devolución de una colección de discos de un cliente de tipo escuela.
     * Muestra los discos disponibles y los compara alfabéticamente con el disco seleccionado.
     *
     * @throws {NullPointerException} Si no se encuentra el trabajador, cliente o disco seleccionado.
     */
    private static void devolverDisco() {
        System.out.println("\n🔄 Devolver Colección de Discos:");

        Trabajador trabajador = seleccionarTrabajador();
        if (trabajador == null) return;

        Cliente cliente = seleccionarClienteEscuela();
        if (cliente == null) return;

        ColeccionDisco disco = seleccionarDisco();
        if (disco == null) return;

        Iterator<ColeccionDisco> iterador = discos.iterator();
        while (iterador.hasNext()) {
            ColeccionDisco c = iterador.next();
            int comparacion = disco.compareTo(c);
            if (comparacion == 0) {
                System.out.println("Disco encontrado: " + c);
            } else if (comparacion < 0) {
                System.out.println("El disco " + disco.getTitulo() + " va primero alfabeticamente que " + c.getTitulo());
            } else {
                System.out.println("El disco " + disco.getTitulo() + " va después alfabeticamente que " + c.getTitulo());
            }
        }

        trabajador.recibirDevolucion(cliente, null, disco);
    }

    /**
     * Crea un nuevo trabajador y lo agrega a la lista de trabajadores.
     * Solicita el ID y nombre del trabajador y lo registra en la colección correspondiente.
     */
    private static void crearTrabajador() {
        System.out.println("\n🛠️ Crear Trabajador:");
        System.out.print("ID Trabajador: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        trabajadores.add(new Trabajador(id, nombre));
        System.out.println("✅ Trabajador creado con éxito.");
    }

    /**
     * Crea un nuevo cliente, que puede ser de tipo privado o escuela, y lo agrega a la lista de clientes.
     * Solicita los datos necesarios como el ID, nombre, correo y teléfono.
     */
    private static void crearCliente() {
        System.out.println("\n👤 Crear Cliente:");
        System.out.print("ID Cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("Teléfono: ");
        int telefono = scanner.nextInt();

        System.out.println("Tipo de Cliente: (1) Privado, (2) Escuela");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            clientes.add(new ClientePrivado(id, nombre, correo, telefono));
            System.out.println("✅ Cliente Privado creado con éxito.");
        } else if (tipo == 2) {
            System.out.print("Nombre de la Escuela: ");
            String nombreEscuela = scanner.nextLine();
            clientes.add(new ClienteEscuela(id, nombre, correo, telefono, nombreEscuela));
            System.out.println("✅ Cliente Escuela creado con éxito.");
        } else {
            System.out.println("❌ Tipo de cliente no válido.");
        }
    }

    /**
     * Crea un nuevo libro, que puede ser de tipo papel o audiolibro, y lo agrega a la lista de libros.
     * Solicita los datos necesarios como el título, autor, ISBN, y tipo de libro.
     */
    private static void crearLibro() {
        System.out.println("\n📖 Crear Libro:");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        System.out.println("Tipo de Libro: (1) Papel, (2) AudioLibro");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.print("Número de páginas: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            Libro nuevoLibro = new Papel(titulo, autor, isbn, cantidad);
            libros.add(nuevoLibro);
            System.out.println("✅ Libro en Papel creado con éxito.");

            nuevoLibro.actualizarInventario();
            nuevoLibro.mostrarInventario();
        } else if (tipo == 2) {
            Libro audio = web.crearAudioLibro(titulo, autor, isbn);
            libros.add(audio);

            System.out.println("✅ AudioLibro creado con éxito.");

            audio.actualizarInventario();
            audio.mostrarInventario();
        } else {
            System.out.println("❌ Tipo de libro no válido.");
        }
    }

    /**
     * Crea una nueva colección de discos y la agrega a la lista de discos.
     * Solicita los datos necesarios como el título y formato de la colección de discos.
     */
    private static void crearDisco() {
        System.out.println("\n💿 Crear Colección de Discos:");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Formato (CD/Vinilo/Digital): ");
        String formatoStr = scanner.nextLine().toUpperCase();

        if (!formatoStr.equals("CD") && !formatoStr.equals("VINILO") && !formatoStr.equals("DIGITAL")) {
            System.out.println("Formato no válido.");
            return;
        }

        FormatoDisco formato = FormatoDisco.valueOf(formatoStr);

        ColeccionDisco nuevo = new ColeccionDisco(titulo, formato);
        discos.add(nuevo);

        nuevo.actualizarInventario();
        nuevo.mostrarInventario();

        System.out.println("✅ Colección de Discos creada con éxito.");
    }

    /**
     * Permite a un trabajador prestar un libro a un cliente de tipo privado.
     * Solicita la selección del trabajador, cliente y libro antes de realizar el préstamo.
     */
    private static void prestarLibro() {
        System.out.println("\n Prestar Libro:");
        Trabajador trabajador = seleccionarTrabajador();
        if (trabajador == null) return;

        Cliente cliente = seleccionarClientePrivado();
        if (cliente == null) return;

        Libro libro = seleccionarLibro();
        if (libro == null) return;

        trabajador.prestar(cliente, libro, null);
    }

    /**
     * Permite a un trabajador recibir la devolución de un libro de un cliente de tipo privado.
     * Solicita la selección del trabajador, cliente y libro antes de realizar la devolución.
     */
    private static void devolverLibro() {
        System.out.println("\n Devolver Libro:");
        Trabajador trabajador = seleccionarTrabajador();
        if (trabajador == null) return;

        Cliente cliente = seleccionarClientePrivado();
        if (cliente == null) return;

        Libro libro = seleccionarLibro();
        if (libro == null) return;

        trabajador.recibirDevolucion(cliente, libro, null);
    }


    /**
     * Selecciona un cliente privado de la lista de clientes.
     * Muestra un listado de los clientes privados disponibles y permite seleccionar uno por su ID.
     *
     * @returns {Cliente} El cliente privado seleccionado o null si no se encuentra.
     */
    private static Cliente seleccionarClientePrivado() {
        System.out.println("\n Listado de Clientes:");

        Iterator<Cliente> iter = clientes.iterator();
        while (iter.hasNext()) {
            Cliente cliente = iter.next();
            if (cliente instanceof ClientePrivado) {
                System.out.println(cliente.getIdCliente() + " - " + cliente.getNombre());
            }
        }

        System.out.println("\n ID del cliente: ");
        int cli = scanner.nextInt();
        scanner.nextLine();

        iter = clientes.iterator();
        while (iter.hasNext()) {
            Cliente c = iter.next();
            if (c instanceof ClientePrivado && c.getIdCliente() == cli) {
                return c;
            }
        }

        System.out.println(" No se ha encontrado el cliente");
        return null;
    }

    /**
     * Selecciona un libro de la lista de libros.
     * Muestra los libros disponibles y permite seleccionar uno por su título.
     *
     * @returns {Libro} El libro seleccionado o null si no se encuentra.
     */
    private static Libro seleccionarLibro() {
        System.out.println("\n📚 Selecciona un Libro:");

        if (libros.isEmpty()) {
            System.out.println("❌ No hay libros disponibles.");
            return null;
        }

        Iterator<Libro> iter = libros.iterator();
        while (iter.hasNext()) {
            Libro libro = iter.next();
            System.out.println(libro.getTitulo() + " | " + (libro.isDisponible() ? "Disponible" : "No Disponible"));
        }

        System.out.print("Título del libro a seleccionar: ");
        String titulo = scanner.nextLine();

        iter = libros.iterator();
        while (iter.hasNext()) {
            Libro libro = iter.next();
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }

        System.out.println("❌ Libro no encontrado.");
        return null;
    }

    /**
     * Permite a un trabajador prestar una colección de discos a un cliente de tipo escuela.
     * Primero selecciona al trabajador, luego al cliente y finalmente la colección de discos.
     *
     * @throws {NullPointerException} Si no se encuentra el trabajador, cliente o disco seleccionado.
     */
    private static void pedirDisco() {
        System.out.println("\n🎵 Pedir Colección de Discos:");
        Trabajador trabajador = seleccionarTrabajador();
        if (trabajador == null) return;

        Cliente cliente = seleccionarClienteEscuela();
        if (cliente == null) return;

        ColeccionDisco disco = seleccionarDisco();
        if (disco == null) return;

        trabajador.prestar(cliente, null, disco);
    }

    /**
     * Selecciona un trabajador de la lista de trabajadores.
     * Muestra una lista de trabajadores y permite seleccionar uno por su ID.
     *
     * @returns {Trabajador} El trabajador seleccionado o null si no se encuentra.
     */
    private static Trabajador seleccionarTrabajador() {
        System.out.println("Seleccione un Trabajador:");

        Iterator<Trabajador> iterador = trabajadores.iterator();
        while (iterador.hasNext()) {
            Trabajador t = iterador.next();
            System.out.println(t.getId() + " - " + t.getNombre());
        }

        System.out.print("ID Trabajador: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        iterador = trabajadores.iterator();
        while (iterador.hasNext()) {
            Trabajador t = iterador.next();
            if (t.getId() == id) {
                return t;
            }
        }

        System.out.println("❌ Trabajador no encontrado.");
        return null;
    }

    /**
     * Selecciona un cliente de tipo escuela de la lista de clientes.
     * Muestra los clientes de tipo escuela y permite seleccionar uno por su ID.
     *
     * @returns {Cliente} El cliente de tipo escuela seleccionado o null si no se encuentra.
     */
    private static Cliente seleccionarClienteEscuela() {
        System.out.println("Seleccione un Cliente Escuela:");

        Iterator<Cliente> iterador = clientes.iterator();
        while (iterador.hasNext()) {
            Cliente c = iterador.next();
            if (c instanceof ClienteEscuela) {
                System.out.println(c.idCliente + " - " + c.nombre);
            }
        }

        System.out.print("ID Cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        iterador = clientes.iterator();
        while (iterador.hasNext()) {
            Cliente c = iterador.next();
            if (c instanceof ClienteEscuela && c.idCliente == id) {
                return c;
            }
        }

        System.out.println("❌ Cliente no encontrado.");
        return null;
    }

    /**
     * Selecciona una colección de discos de la lista de discos.
     * Muestra las colecciones de discos disponibles y permite seleccionar una por su título.
     *
     * @returns {ColeccionDisco} La colección de discos seleccionada o null si no se encuentra.
     */
    private static ColeccionDisco seleccionarDisco() {
        System.out.println("Seleccione una Colección de Discos:");

        Iterator<ColeccionDisco> iterador = discos.iterator();
        while (iterador.hasNext()) {
            ColeccionDisco d = iterador.next();
            System.out.println(d.getTitulo() + " - " + (d.isDisponible() ? "Disponible" : "No Disponible"));
        }

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        iterador = discos.iterator();
        while (iterador.hasNext()) {
            ColeccionDisco d = iterador.next();
            if (d.getTitulo().equalsIgnoreCase(titulo)) {
                return d;
            }
        }

        System.out.println("❌ Colección no encontrada.");
        return null;
    }



    // MMODIFICAR -------------------------------

    /**
     * Modifica los datos de un cliente según su tipo (Privado o Escuela).
     * Permite cambiar el nombre, correo y teléfono de un cliente.
     *
     * @throws java.util.InputMismatchException Si se ingresa un valor no válido para el teléfono.
     * @throws java.lang.NullPointerException Si no se encuentra el cliente seleccionado.
     */
    private static void modificarCliente() {
        System.out.println("\n✏️ Modificar Cliente: (1) Privado - (2) Escuela");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = (tipo == 1) ? seleccionarClientePrivado() : seleccionarClienteEscuela();
        if (cliente == null) return;

        System.out.print("Nuevo Nombre (" + cliente.getNombre() + "): ");
        String nuevoNombre = scanner.nextLine();
        if (!nuevoNombre.isEmpty()) cliente.setNombre(nuevoNombre);

        System.out.print("Nuevo Correo (" + cliente.getCorreo() + "): ");
        String nuevoCorreo = scanner.nextLine();
        if (!nuevoCorreo.isEmpty()) cliente.setCorreo(nuevoCorreo);

        System.out.print("Nuevo Teléfono (" + cliente.getTelefono() + "): ");
        if (scanner.hasNextInt()) {
            int nuevoTelefono = scanner.nextInt();
            cliente.setTelefono(nuevoTelefono);
            scanner.nextLine();
        } else {
            System.out.println("❌ Teléfono inválido. No se ha actualizado.");
            scanner.nextLine();
        }
        System.out.println("✅ Cliente actualizado.");
    }

    /**
     * Modifica los datos de un producto, que puede ser un libro o una colección de discos.
     * Si el tipo es 1, se modifica un libro, si es 2, se modifica una colección de discos.
     *
     * @throws java.util.InputMismatchException Si el tipo de producto o la opción ingresada no es válida.
     * @throws java.lang.NullPointerException Si no se encuentra el producto seleccionado.
     */
    private static void modificarProducto() {
        System.out.println("\nModificar Producto: (1) Libro - (2) Colección de Disco");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.println("(1) En papel --- (2) Audio libro");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.println("Modificar libro en papel...");
                Libro libro = seleccionarLibro();
                if (libro == null) return;

                System.out.print("Nuevo Título (" + libro.getTitulo() + "): ");
                String nuevoTitulo = scanner.nextLine();
                if (!nuevoTitulo.isEmpty()) libro.setTitulo(nuevoTitulo);

                System.out.print("Nuevo Autor (" + libro.getAutor() + "): ");
                String nuevoAutor = scanner.nextLine();
                if (!nuevoAutor.isEmpty()) libro.setAutor(nuevoAutor);

                System.out.print("Nuevo ISBN (" + libro.getIsbn() + "): ");
                String nuevoIsbn = scanner.nextLine();
                if (!nuevoIsbn.isEmpty()) libro.setIsbn(nuevoIsbn);

                System.out.println("Libro actualizado: " + libro.toString());
                libro.actualizarInventario();
            } else if (opcion == 2) {
                System.out.println("Modificar audio libro...");
                Audio audioLibro = (Audio) seleccionarLibro();
                if (audioLibro == null) return;

                System.out.print("Nuevo Título (" + audioLibro.getTitulo() + "): ");
                String nuevoTitulo = scanner.nextLine();
                if (!nuevoTitulo.isEmpty()) audioLibro.setTitulo(nuevoTitulo);

                System.out.print("Nuevo Autor (" + audioLibro.getAutor() + "): ");
                String nuevoAutor = scanner.nextLine();
                if (!nuevoAutor.isEmpty()) audioLibro.setAutor(nuevoAutor);

                System.out.print("Nuevo ISBN (" + audioLibro.getIsbn() + "): ");
                String nuevoIsbn = scanner.nextLine();
                if (!nuevoIsbn.isEmpty()) audioLibro.setIsbn(nuevoIsbn);

                System.out.print("Nueva Duración en minutos (" + audioLibro.getDuracionMinutos() + "): ");
                int nuevaDuracion = scanner.nextInt();
                scanner.nextLine();
                audioLibro.setDuracionMinutos(nuevaDuracion);

                System.out.println("Audio libro actualizado: " + audioLibro.toString());
                audioLibro.actualizarInventario();
            }
        } else if (tipo == 2) {
            System.out.println("Modificar colección de disco...");
            ColeccionDisco coleccionDisco = seleccionarDisco();
            if (coleccionDisco == null) return;

            System.out.print("Nuevo Título (" + coleccionDisco.getTitulo() + "): ");
            String nuevoTitulo = scanner.nextLine();
            if (!nuevoTitulo.isEmpty()) coleccionDisco.setTitulo(nuevoTitulo);

            boolean formatoValido = false;
            FormatoDisco nuevoFormato = coleccionDisco.getFormato();

            while (!formatoValido) {
                System.out.print("Nuevo Formato (" + coleccionDisco.getFormato() + "): ");
                String nuevoFormatoStr = scanner.nextLine().toUpperCase();

                try {
                    if (!nuevoFormatoStr.isEmpty()) {
                        nuevoFormato = FormatoDisco.valueOf(nuevoFormatoStr);
                    }
                    formatoValido = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("❌ Formato no válido. Los formatos válidos son: CD, VINILO, DIGITAL.");
                }
            }

            coleccionDisco.setFormato(nuevoFormato);
            System.out.println("Colección de disco actualizada: " + coleccionDisco.toString());
        }
    }

    /**
     * Modifica los datos de un trabajador.
     * Permite cambiar el nombre y el ID del trabajador.
     *
     * @throws java.util.InputMismatchException Si el ID ingresado no es válido.
     * @throws java.lang.NullPointerException Si no se encuentra el trabajador seleccionado.
     */
    private static void modificarTrabajador() {
        System.out.println("\n✏️ Modificar Trabajador:");

        Trabajador trabajador = seleccionarTrabajador();
        if (trabajador == null) return;

        System.out.print("Nuevo Nombre (" + trabajador.getNombre() + "): ");
        String nuevoNombre = scanner.nextLine();
        if (!nuevoNombre.isEmpty()) {
            trabajador.setNombre(nuevoNombre);
        }

        System.out.print("Nuevo ID (" + trabajador.getId() + "): ");
        int nuevoId = scanner.nextInt();
        scanner.nextLine();
        trabajador.setId(nuevoId);

        System.out.println("✅ Trabajador actualizado: " + trabajador.getNombre() + " (ID: " + trabajador.getId() + ")");
    }


// BUSCAR INDIVIDUALMENTE ---------------

    /**
     * Busca un libro en la biblioteca por título o autor.
     */
    private static void buscarLibro() {
        System.out.println("\n🔍 Buscar Libro:");

        System.out.println("¿Cómo quieres buscar el libro?");
        System.out.println("1. Por Título");
        System.out.println("2. Por Autor");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 1) {
            System.out.print("Introduce el título del libro: ");
            String tituloBusqueda = scanner.nextLine().toLowerCase();

            boolean encontrado = false;
            Iterator<Libro> iterador = libros.iterator();
            while (iterador.hasNext()) {
                Libro libro = iterador.next();
                if (libro.getTitulo().toLowerCase().contains(tituloBusqueda)) {
                    System.out.println(libro);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("❌ No se han encontrado libros con ese título.");
            }
        } else if (opcion == 2) {
            System.out.print("Introduce el autor del libro: ");
            String autorBusqueda = scanner.nextLine().toLowerCase();

            boolean encontrado = false;
            Iterator<Libro> iterador = libros.iterator();
            while (iterador.hasNext()) {
                Libro libro = iterador.next();
                if (libro.getAutor().toLowerCase().contains(autorBusqueda)) {
                    System.out.println(libro);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("❌ No se han encontrado libros de ese autor.");
            }
        } else {
            System.out.println("❌ Opción no válida.");
        }
    }

    /**
     * Busca un cliente por nombre o correo electrónico.
     */
    private static void buscarCliente() {
        System.out.println("\n🔍 Buscar Cliente:");

        System.out.println("¿Cómo quieres buscar al cliente?");
        System.out.println("1. Por Nombre");
        System.out.println("2. Por Correo Electrónico");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 1) {
            System.out.print("Introduce el nombre del cliente: ");
            String nombreBusqueda = scanner.nextLine().toLowerCase();

            boolean encontrado = false;
            Iterator<Cliente> iterador = clientes.iterator();
            while (iterador.hasNext()) {
                Cliente cliente = iterador.next();
                if (cliente.getNombre().toLowerCase().contains(nombreBusqueda)) {
                    System.out.println(cliente);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("❌ No se han encontrado clientes con ese nombre.");
            }
        } else if (opcion == 2) {
            System.out.print("Introduce el correo electrónico del cliente: ");
            String correoBusqueda = scanner.nextLine().toLowerCase();

            boolean encontrado = false;
            Iterator<Cliente> iterador = clientes.iterator();
            while (iterador.hasNext()) {
                Cliente cliente = iterador.next();
                if (cliente.getCorreo().toLowerCase().contains(correoBusqueda)) {
                    System.out.println(cliente);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("❌ No se han encontrado clientes con ese correo.");
            }
        } else {
            System.out.println("❌ Opción no válida.");
        }
    }

    /**
     * Busca un trabajador por ID o nombre.
     */
    private static void buscarTrabajador() {
        System.out.println("\n🔍 Buscar Trabajador:");

        System.out.println("¿Cómo quieres buscar al trabajador?");
        System.out.println("1. Por ID");
        System.out.println("2. Por Nombre");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 1) {
            System.out.print("Introduce el ID del trabajador: ");
            int idBusqueda = scanner.nextInt();
            scanner.nextLine();

            boolean encontrado = false;
            Iterator<Trabajador> iterador = trabajadores.iterator();
            while (iterador.hasNext()) {
                Trabajador trabajador = iterador.next();
                if (trabajador.getId() == idBusqueda) {
                    System.out.println(trabajador);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("❌ No se ha encontrado ningún trabajador con ese ID.");
            }
        } else if (opcion == 2) {
            System.out.print("Introduce el nombre del trabajador: ");
            String nombreBusqueda = scanner.nextLine().toLowerCase();

            boolean encontrado = false;
            Iterator<Trabajador> iterador = trabajadores.iterator();
            while (iterador.hasNext()) {
                Trabajador trabajador = iterador.next();
                if (trabajador.getNombre().toLowerCase().contains(nombreBusqueda)) {
                    System.out.println(trabajador);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("❌ No se ha encontrado ningún trabajador con ese nombre.");
            }
        } else {
            System.out.println("❌ Opción no válida.");
        }
    }


    /**
     * Método estático para buscar colecciones de discos.
     * Permite buscar por título o por formato (CD, VINILO, DIGITAL).
     *
     * @throws java.util.InputMismatchException Si el valor ingresado no es un número entero.
     * @throws java.lang.NullPointerException Si no se encuentran colecciones de discos.
     */
    private static void buscarDisco() {
        System.out.println("\n🔍 Buscar Colección de Discos:");

        System.out.println("¿Cómo quieres buscar la colección de discos?");
        System.out.println("1. Por Título");
        System.out.println("2. Por Formato");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 1) {
            System.out.print("Introduce el título de la colección: ");
            String tituloBusqueda = scanner.nextLine().toLowerCase();

            boolean encontrado = false;
            Iterator<ColeccionDisco> iterador = discos.iterator();
            while (iterador.hasNext()) {
                ColeccionDisco coleccion = iterador.next();
                if (coleccion.getTitulo().toLowerCase().contains(tituloBusqueda)) {
                    System.out.println(coleccion);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("❌ No se han encontrado colecciones con ese título.");
            }
        } else if (opcion == 2) {
            System.out.print("Introduce el formato de la colección (CD, VINILO, DIGITAL): ");
            String formatoBusqueda = scanner.nextLine().toUpperCase();

            boolean encontrado = false;
            Iterator<ColeccionDisco> iterador = discos.iterator();
            while (iterador.hasNext()) {
                ColeccionDisco coleccion = iterador.next();
                if (coleccion.getFormato().name().equalsIgnoreCase(formatoBusqueda)) {
                    System.out.println(coleccion);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("❌ No se han encontrado colecciones con ese formato.");
            }
        } else {
            System.out.println("❌ Opción no válida.");
        }
    }



    // Eliminacion -----------------------

    /**
     * Elimina un cliente privado de la lista de clientes.
     */
    private static void eliminarCliente() {
        Cliente cliente = seleccionarClientePrivado();
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("✅ Cliente eliminado con éxito.");
        } else {
            System.out.println("❌ Cliente no encontrado.");
        }
    }

    /**
     * Elimina un libro de la lista de libros.
     */
    private static void eliminarLibro() {
        Libro libro = seleccionarLibro();
        if (libro != null) {
            libros.remove(libro);
            System.out.println("✅ Libro eliminado con éxito.");
        } else {
            System.out.println("❌ Libro no encontrado.");
        }
    }

    /**
     * Elimina una colección de discos de la lista de discos.
     */
    private static void eliminarDisco() {
        ColeccionDisco disco = seleccionarDisco();
        if (disco != null) {
            discos.remove(disco);
            System.out.println("✅ Colección de Discos eliminada con éxito.");
        } else {
            System.out.println("❌ Colección de Discos no encontrada.");
        }
    }

    /**
     * Elimina un trabajador de la lista de trabajadores.
     */
    private static void eliminarTrabajador() {
        Trabajador trabajador = seleccionarTrabajador();
        if (trabajador != null) {
            trabajadores.remove(trabajador);
            System.out.println("✅ Trabajador eliminado con éxito.");
        } else {
            System.out.println("❌ Trabajador no encontrado.");
        }
    }

    /**
     * Muestra todos los préstamos realizados por los trabajadores.
     */
    private static void mostrarTodosLosPrestamos() {
        Iterator<Trabajador> iterador = trabajadores.iterator();
        while (iterador.hasNext()) {
            iterador.next().mostrarPrestamosRealizados();
        }
    }

}