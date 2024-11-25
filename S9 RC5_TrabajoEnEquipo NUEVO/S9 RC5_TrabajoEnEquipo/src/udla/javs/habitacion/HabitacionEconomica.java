package udla.javs.habitacion;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class HabitacionEconomica extends Habitacion {
    // Atributos específicos para la clase.
    private int numeroVentiladores;
    private static List<HabitacionEconomica> habitacionesEconomicas = new ArrayList<>();

    // Creación de constructor.
    public HabitacionEconomica(){

    }

    public HabitacionEconomica(int numeroVentiladores, String tipoHabitacion, String vistaHabitacion, int numeroHabitacion, double tarifaPorNoche, double tamanoHabitacion, int numeroCamas, int numeroBanos, boolean estado) {
        super(tipoHabitacion,vistaHabitacion, numeroHabitacion, tarifaPorNoche, tamanoHabitacion,numeroCamas,numeroBanos, estado); // Cuando heredo los atributos también heredo gettes y setters.
        this.numeroVentiladores = numeroVentiladores;
    }
    // Creación de getters y setters

    public int getNumeroVentiladores() {
        return numeroVentiladores;
    }

    public void setNumeroVentiladores(int numeroVentiladores) {
        this.numeroVentiladores = numeroVentiladores;
    }



    // Implementación del metodo abstracto

    @Override
    public void registrarHabitaciones() {
        // Esta línea podría ser en la parte del menú : int continuar = Integer.parseInt(JOptionPane.showConfirmDialog(null,"Registrando Habitación Económica...", "Confirmación", JOptionPane.YES_NO_OPTION);
        String tipohabitacion = JOptionPane.showInputDialog(null,"Tipo Habitación");
        String vistahabitacion = JOptionPane.showInputDialog(null,"Vista Habitación");
        int numeroHabitacion = Integer.parseInt(JOptionPane.showInputDialog(null,"Número de habitación"));
        double tamano = Double.parseDouble(JOptionPane.showInputDialog(null,"Tamaño de la habitación"));
        int numerocamas = Integer.parseInt(JOptionPane.showInputDialog(null,"Número de camas"));
        int numerobanos = Integer.parseInt(JOptionPane.showInputDialog(null,"Número de baños"));
        int numeroventiladores = Integer.parseInt(JOptionPane.showInputDialog(null,"Número de ventiladores"));
        double tarifa = Double.parseDouble(JOptionPane.showInputDialog(null,"Tarifa por noche"));
        boolean estado = JOptionPane.showConfirmDialog(null, "¿Está disponible?", "Estado",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        HabitacionEconomica h = new HabitacionEconomica(numeroVentiladores,tipohabitacion,vistahabitacion,
                numeroHabitacion,tarifa, tamano, numerocamas,numerobanos,estado);
        habitacionesEconomicas.add(h);
    }

    @Override
    public void mostrarHabitaciones() {
        if (habitacionesEconomicas == null || habitacionesEconomicas.isEmpty()) {
            System.out.println("No hay habitaciones económicas registradas.");
            return;
        }

        // Encabezado de la tabla
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-20s | %-15s | %-10s | %-8s | %-10s | %-10s | %-15s | %-15s | %-10s |\n",
                "Tipo Habitación", "Vista", "Número", "Tamaño", "Camas", "Baños", "Ventiladores", "Tarifa x Noche", "Estado");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

        // Filas de la tabla
        for (HabitacionEconomica habitacion : habitacionesEconomicas) {
            System.out.printf("| %-20s | %-15s | %-10d | %-8.2f | %-10d | %-10d | %-15d | $%-14.2f | %-10s |\n",
                    habitacion.getTipoHabitacion(),
                    habitacion.getVistaHabitacion(),
                    habitacion.getNumeroHabitacion(),
                    habitacion.getTamanoHabitacion(),
                    habitacion.getNumeroCamas(),
                    habitacion.getNumeroBanos(),
                    habitacion.getNumeroVentiladores(),
                    habitacion.getTarifaPorNoche(),
                    habitacion.isEstado() ? "Disponible" : "Reservado");
        }

        // Línea final de la tabla
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
    }




    public static HabitacionEconomica buscarHabitacion(int numeroHabitacion) {
        // Verificar si la lista de habitaciones está vacía
        if (habitacionesEconomicas == null || habitacionesEconomicas.isEmpty()) {
            return null; // Retorna null si no hay habitaciones registradas
        }

        // Iterar sobre la lista para buscar la habitación
        for (HabitacionEconomica habitacion : habitacionesEconomicas) {
            if (habitacion.getNumeroHabitacion() == numeroHabitacion) {
                return habitacion; // Retorna la instancia de la habitación encontrada
            }
        }
        return null; // Retorna null si no se encontró la habitación
    }




}
