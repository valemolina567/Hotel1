package udla.javs.reserva;

import udla.javs.habitacion.Habitacion;
import udla.javs.habitacion.HabitacionDeluxe;
import udla.javs.habitacion.HabitacionEconomica;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva {
    private String idReserva;
    private String cliente;
    private String cedula;
    private Date fechaEntrada;
    private Date fechaSalida;
    private int numeroNoches;
    private int numeroPersonas;
    private String metodoPago;
    private HabitacionDeluxe habitacion2;
    private Habitacion habitacion;
    private HabitacionEconomica habitacion1;
    private double precioTotal;
    private String estado; // Confirmada, Cancelada, Pendiente

    private static List<Reserva> historialReservas = new ArrayList<>();
    // Constructor modificado
    public Reserva(String idReserva, String cliente, String cedula, Date fechaEntrada, Date fechaSalida, int numeroNoches,
                   int numeroPersonas, String metodoPago, Habitacion habitacion) {  // Se añade el parámetro habitacion
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.cedula = cedula;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.numeroPersonas = numeroPersonas;
        this.metodoPago = metodoPago;
        this.habitacion = habitacion;
    }
    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getNumeroNoches() {
        return numeroNoches;
    }

    public void setNumeroNoches(int numeroNoches) {
        this.numeroNoches = numeroNoches;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Reserva() {

    }




    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    // Metodo para registrar una nueva reserva solicitando los datos desde el usuario
    public void registrarReserva() {
        // Obtención de datos
        String id = JOptionPane.showInputDialog(null, "ID Reserva:");
        String cliente = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente:");
        String cedula = JOptionPane.showInputDialog(null, "Ingrese la cédula del cliente:");
        int numeroPersonas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de personas:"));

        // Selección de la habitación (Económica o Deluxe)
        int input = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Seleccione el tipo de habitación:\n" +
                        "1. Habitación Económica\n" +
                        "2. Habitación Deluxe"));

        Habitacion habitacionSeleccionada = null;
        switch (input) {
            case 1:
                // Buscar habitación económica
                int codigoEconomica = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la habitación económica:"));
                habitacion1 = HabitacionEconomica.buscarHabitacion(codigoEconomica);
                if (habitacion1 != null) {
                    habitacionSeleccionada = habitacion1;
                } else {
                    JOptionPane.showMessageDialog(null, "Habitación económica no encontrada.");
                    return;
                }
                break;

            case 2:
                // Buscar habitación deluxe
                int codigoDeluxe = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la habitación deluxe:"));
                habitacion2 = HabitacionDeluxe.buscarHabitacionDeluxe(codigoDeluxe);
                if (habitacion2 != null) {
                    habitacionSeleccionada = habitacion2;
                } else {
                    JOptionPane.showMessageDialog(null, "Habitación deluxe no encontrada.");
                    return;
                }
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
                return;
        }

        // Verificar disponibilidad de la habitación seleccionada
        if (habitacionSeleccionada != null && habitacionSeleccionada.isEstado()) {
            habitacionSeleccionada.setEstado(false);  // Marcar como reservada
            JOptionPane.showMessageDialog(null, "La habitación está disponible y ha sido reservada.");
        } else {
            JOptionPane.showMessageDialog(null, "La habitación no está disponible o no existe.");
            return;
        }

        // Solicitar fechas de entrada y salida
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        try {
            fechaEntrada = formatoFecha.parse(JOptionPane.showInputDialog("Ingrese la fecha de entrada (dd/MM/yyyy):"));
            fechaSalida = formatoFecha.parse(JOptionPane.showInputDialog("Ingrese la fecha de salida (dd/MM/yyyy):"));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de la fecha.");
            return;
        }

        // Calcular el número de noches
        numeroNoches = calcularNumeroNoches();
        // Solicitar el método de pago
        String metodoPago = JOptionPane.showInputDialog(null, "Ingrese el método de pago (Ejemplo: Tarjeta, Efectivo, Transferencia):");

        // Crear la reserva con los valores de entrada
        Reserva reserva = new Reserva(id, cliente, cedula, fechaEntrada, fechaSalida, numeroNoches, numeroPersonas, metodoPago,habitacionSeleccionada);
        historialReservas.add(reserva);
        JOptionPane.showMessageDialog(null, "Reserva registrada exitosamente.");
    }
    // Editar reserva

    // Mostrar reservas
    public void mostrarReservas() {
        if (historialReservas == null || historialReservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
            return;
        }
        // Encabezado de la tabla
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-25s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                "ID Reserva", "Cliente", "Cédula", "Fecha Entrada", "Fecha Salida", "Método de Pago", "Número de Días", "Tipo Habitacion", "Número Habitacion");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        // Filas de la tabla
        for (Reserva reserva : historialReservas) {
            String fechaEntrada = new SimpleDateFormat("dd/MM/yyyy").format(reserva.getFechaEntrada());
            String fechaSalida = new SimpleDateFormat("dd/MM/yyyy").format(reserva.getFechaSalida());
            System.out.printf("| %-15s | %-25s | %-15s | %-15s | %-15s | %-15s | %-15d | %-15s | %-15d |\n",
                    reserva.getIdReserva(),
                    reserva.getCliente(),
                    reserva.getCedula(),
                    fechaEntrada,
                    fechaSalida,
                    reserva.getMetodoPago(),
                    numeroNoches,
                    reserva.getHabitacion().getTipoHabitacion(),
                    reserva.getHabitacion().getNumeroHabitacion());
        }

        // Línea final de la tabla
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
    }

    // Calcular número de noches
    private int calcularNumeroNoches() {
        long diff = fechaSalida.getTime() - fechaEntrada.getTime();
        return (int) (diff / (1000 * 60 * 60 * 24));
    }


    // Editar reservas.

    // Eliminar reserva por ID
    public void eliminarReservaPorId() {
        if (historialReservas == null || historialReservas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay reservas registradas.");
            return;
        }
        // Solicitar el ID de la reserva a eliminar
        String idReserva = JOptionPane.showInputDialog("Ingrese el ID de la reserva que desea eliminar:");
        // Buscar y eliminar la reserva
        Reserva reservaAEliminar = null;
        for (Reserva reserva : historialReservas) {
            if (reserva.getIdReserva().equals(idReserva)) {
                reservaAEliminar = reserva;
                break;
            }
        }

        // Si se encontró la reserva
        if (reservaAEliminar != null) {
            historialReservas.remove(reservaAEliminar);
            JOptionPane.showMessageDialog(null, "Reserva eliminada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró una reserva con ese ID.");
        }
    }


}