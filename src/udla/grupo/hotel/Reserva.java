package udla.grupo.hotel;

public class Reserva extends Habitacion {
    private String cliente;

    public Reserva(int numero, String cliente) {
        super(numero);
        this.cliente = cliente;
        this.setDisponible(false);
    }

    public String getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Reserva para " + cliente + " en habitación " + getNumero();
    }
}

