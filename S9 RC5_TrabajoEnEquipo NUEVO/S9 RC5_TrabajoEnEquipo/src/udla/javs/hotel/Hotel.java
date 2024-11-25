package udla.javs.hotel;

import udla.javs.habitacion.Habitacion;
import udla.javs.habitacion.HabitacionDeluxe;
import udla.javs.habitacion.HabitacionEconomica;
import udla.javs.reserva.Reserva;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombreHotel = "Hotel Marriot";
    private String ubicacionHotel = "Amazonas y Orellana";
    private List<String> serviciosOfrecidos;
    private int numeroDeHabitaciones;
    private Reserva reserva;
    private Habitacion habitacion;
    private HabitacionDeluxe habitacionDeluxe;
    private HabitacionEconomica habitacionEconomica;



    public Hotel() {
        serviciosOfrecidos = new ArrayList<>();
        serviciosOfrecidos.add("Wi-Fi");
        serviciosOfrecidos.add("Restaurante");
        serviciosOfrecidos.add("Gimnasio");
        serviciosOfrecidos.add("Piscina");
        serviciosOfrecidos.add("Spa");
        serviciosOfrecidos.add("Servicio de habitaciones");
        numeroDeHabitaciones = 100;
        // Instanciación
        reserva = new Reserva();
        habitacionDeluxe = new HabitacionDeluxe();
        habitacionEconomica = new HabitacionEconomica();
    }

    // Metodo para mostrar la información del hotel en un JOptionPane
    public void mostrarInformacion() {
        StringBuilder informacion = new StringBuilder();
        informacion.append("Nombre del Hotel: ").append(nombreHotel).append("\n");
        informacion.append("Ubicación: ").append(ubicacionHotel).append("\n");
        informacion.append("Número de Habitaciones: ").append(numeroDeHabitaciones).append("\n");
        //informacion.append("Servicios Ofrecidos: ").append("\n");

        /*for (String servicio : serviciosOfrecidos) {
            informacion.append(" - ").append(servicio).append("\n");
        }*/

        JOptionPane.showMessageDialog(null, informacion.toString(), "Información del Hotel", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarServicios() {
        StringBuilder servicios = new StringBuilder();
        for (String servicio : serviciosOfrecidos) {
            servicios.append(servicio).append("\n");
        }
        JOptionPane.showMessageDialog(null, servicios.toString(), "Servicios Ofrecidos", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMenu() {
        do {
            String input = JOptionPane.showInputDialog(null,
                    "1. Ver información del hotel\n" +
                            "2. Añadir habitación\n" +
                            "3. Mostrar habitaciones\n" +
                            "4. Ver servicios ofrecidos\n" +
                            "5. Realizar una reserva\n" +
                            "6. Cancelar una reserva\n" +
                            "7. Mostrar Reservas\n" +
                            "8. Salir");
            try {
                int option = Integer.parseInt(input);
                switch (option) {
                    case 1:
                        mostrarInformacion();
                        break;
                    case 2:
                        agregarHabitacion();
                        break;
                    case 3:
                        mostrarHabitaciones();
                        break;
                    case 4:
                        mostrarServicios();
                        break;
                    case 5:
                        realizarReserva();
                        break;
                    case 6:
                        cancelarReserva();
                        break;
                    case 7:
                        mostrarReserva();
                        break;
                    case 8:
                        int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas salir?", "Confirmar Salida", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            System.exit(0);
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida! Intenta de nuevo.");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido.");
            }
        } while (true);
    }

    public void agregarHabitacion() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Agregar Habitación.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) { // JOptionPane.YES_OPTION devuelve el valor 0.
            String input = JOptionPane.showInputDialog(null,
                    "Seleccione el tipo de habitación a agregar:\n" +
                            "1. Habitación Económica\n" +
                            "2. Habitación Deluxe");
            try {
                int opcion = Integer.parseInt(input); // Convertir la entrada a un entero.
                switch (opcion) {
                    case 1:
                        habitacionEconomica.registrarHabitaciones(); // Lógica para agregar habitación económica
                        JOptionPane.showMessageDialog(null, "Habitación económica agregada exitosamente.");
                        break;
                    case 2:
                        habitacionDeluxe.registrarHabitaciones(); // Lógica para agregar habitación deluxe
                        JOptionPane.showMessageDialog(null, "Habitación deluxe agregada exitosamente.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
        }
    }

    public void mostrarHabitaciones() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Mostrar Habitaciones.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) { // JOptionPane.YES_OPTION devuelve el valor 0.
            String input = JOptionPane.showInputDialog(null,
                    "Seleccione el tipo de habitación a mostrar:\n" +
                            "1. Habitación Económica\n" +
                            "2. Habitación Deluxe");
            try {
                int opcion = Integer.parseInt(input); // Convertir la entrada a un entero.
                switch (opcion) {
                    case 1:
                        habitacionEconomica.mostrarHabitaciones();
                        break;
                    case 2:
                        habitacionDeluxe.mostrarHabitaciones();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
        }
    }


    public void realizarReserva() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Realizar Reserva.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            reserva.registrarReserva();
        }
    }


    public void cancelarReserva() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Cancelar Reserva.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            reserva.eliminarReservaPorId();
        }
    }

    public void mostrarReserva() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Mostrar Reservas.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            reserva.mostrarReservas();
        }
    }

}
