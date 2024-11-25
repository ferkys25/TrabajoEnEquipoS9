package udla.grupo.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;

    public Hotel(String nombre, int numeroHabitaciones) {
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
        for (int i = 1; i <= numeroHabitaciones; i++) {
            habitaciones.add(new Habitacion(i));
        }
    }

    public Habitacion buscarHabitacionDisponible() {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.isDisponible()) {
                return habitacion;
            }
        }
        return null; // No hay habitaciones disponibles
    }


    public void listarHabitaciones() {
        for (Habitacion habitacion : habitaciones) {
            System.out.println(habitacion);
        }
    }

    public void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas.");
        } else {
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }

    public boolean agregarReserva(String cliente) {
        Habitacion habitacionDisponible = buscarHabitacionDisponible();
        if (habitacionDisponible != null) {
            Reserva nuevaReserva = new Reserva(habitacionDisponible.getNumero(), cliente);
            reservas.add(nuevaReserva);

            // Actualizar estado de la habitación
            habitaciones.get(habitacionDisponible.getNumero() - 1).setDisponible(false);

            System.out.println("Reserva creada exitosamente: " + nuevaReserva);
            return true;
        } else {
            System.out.println("No hay habitaciones disponibles para reservar.");
            return false;
        }
    }

    public boolean cancelarReserva(int numeroHabitacion) {
        for (Reserva reserva : reservas) {
            if (reserva.getNumero() == numeroHabitacion) {
                reservas.remove(reserva);

                // Liberar la habitación
                habitaciones.get(numeroHabitacion - 1).setDisponible(true);

                System.out.println("Reserva cancelada exitosamente: " + reserva);
                return true;
            }
        }
        System.out.println("No se encontró una reserva para la habitación " + numeroHabitacion);
        return false;
    }
}

