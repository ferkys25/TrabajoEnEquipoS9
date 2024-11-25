package udla.grupo.hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel UDLA", 5);
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Menú de Opciones ===");
            System.out.println("1. Listar habitaciones");
            System.out.println("2. Listar reservas");
            System.out.println("3. Agregar una reserva");
            System.out.println("4. Cancelar una reserva");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado de las habitaciones:");
                    hotel.listarHabitaciones();
                    break;
                case 2:
                    System.out.println("\nListado de reservas:");
                    hotel.listarReservas();
                    break;
                case 3:
                    System.out.print("\nIngrese el nombre del cliente: ");
                    String cliente = scanner.nextLine();
                    hotel.agregarReserva(cliente);
                    break;
                case 4:
                    System.out.print("\nIngrese el número de la habitación a cancelar: ");
                    int numeroHabitacion = scanner.nextInt();
                    hotel.cancelarReserva(numeroHabitacion);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
