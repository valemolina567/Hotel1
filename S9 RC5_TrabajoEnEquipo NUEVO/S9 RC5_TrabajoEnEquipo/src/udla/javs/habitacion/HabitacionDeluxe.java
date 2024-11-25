package udla.javs.habitacion;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class HabitacionDeluxe extends Habitacion {
    // Atributos específicos para esta clase
    private boolean incluyeDesayuno;
    private boolean accesoInternet;
    private boolean tieneBalcon;
    private static List<HabitacionDeluxe> habitacionesDeluxe = new ArrayList<>();

    // Constructor predeterminado
    public HabitacionDeluxe() {
        super(); // Llama al constructor de la clase base
    }

    // Constructor parametrizado
    public HabitacionDeluxe(boolean incluyeDesayuno, boolean accesoInternet, boolean tieneBalcon,
                            String tipoHabitacion, String vistaHabitacion, int numeroHabitacion,
                            double tarifaPorNoche, double tamanoHabitacion, int numeroCamas, int numeroBanos, boolean estado) {
        super(tipoHabitacion, vistaHabitacion, numeroHabitacion, tarifaPorNoche, tamanoHabitacion, numeroCamas, numeroBanos, estado);
        this.incluyeDesayuno = incluyeDesayuno;
        this.accesoInternet = accesoInternet;
        this.tieneBalcon = tieneBalcon;
    }

    // Getters y setters
    public boolean isIncluyeDesayuno() {
        return incluyeDesayuno;
    }

    public void setIncluyeDesayuno(boolean incluyeDesayuno) {
        this.incluyeDesayuno = incluyeDesayuno;
    }

    public boolean isAccesoInternet() {
        return accesoInternet;
    }

    public void setAccesoInternet(boolean accesoInternet) {
        this.accesoInternet = accesoInternet;
    }

    public boolean isTieneBalcon() {
        return tieneBalcon;
    }

    public void setTieneBalcon(boolean tieneBalcon) {
        this.tieneBalcon = tieneBalcon;
    }

    // Implementación del método abstracto
    @Override
    public void registrarHabitaciones() {
        // Solicitar datos específicos para la habitación deluxe
        String tipoHabitacion = JOptionPane.showInputDialog(null, "Tipo Habitación");
        String vistaHabitacion = JOptionPane.showInputDialog(null, "Vista Habitación");
        int numeroHabitacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Número de habitación"));
        double tarifa = Double.parseDouble(JOptionPane.showInputDialog(null, "Tarifa por noche"));
        double tamano = Double.parseDouble(JOptionPane.showInputDialog(null, "Tamaño de la habitación"));
        int numeroCamas = Integer.parseInt(JOptionPane.showInputDialog(null, "Número de camas"));
        int numeroBanos = Integer.parseInt(JOptionPane.showInputDialog(null, "Número de baños"));
        boolean incluyeDesayuno = JOptionPane.showConfirmDialog(null, "¿Incluye desayuno?", "Desayuno",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        boolean accesoInternet = JOptionPane.showConfirmDialog(null, "¿Tiene acceso a internet?", "Internet",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        boolean tieneBalcon = JOptionPane.showConfirmDialog(null, "¿Tiene balcón?", "Balcón",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        boolean estado = JOptionPane.showConfirmDialog(null, "¿Está disponible?", "Estado",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        // Crear nueva habitación deluxe
        HabitacionDeluxe h = new HabitacionDeluxe(incluyeDesayuno, accesoInternet, tieneBalcon,
                tipoHabitacion, vistaHabitacion, numeroHabitacion, tarifa, tamano, numeroCamas, numeroBanos, estado);
        habitacionesDeluxe.add(h); // Agregar a la lista

    }

    @Override
    public void mostrarHabitaciones() {
        if (habitacionesDeluxe == null || habitacionesDeluxe.isEmpty()) {
            System.out.println("No hay habitaciones deluxe registradas.");
            return;
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-20s | %-15s | %-10s | %-8s | %-10s | %-10s | %-10s | %-15s | %-12s | %-12s | %-12s |\n",
                "Tipo Habitación", "Vista", "Número", "Tamaño", "Camas", "Baños", "Desayuno", "Internet", "Balcón", "Tarifa", "Estado");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");

        for (HabitacionDeluxe habitacion : habitacionesDeluxe) {
            System.out.printf("| %-20s | %-15s | %-10d | %-8.2f | %-10d | %-10d | %-10s | %-15s | %-12s | $%-11.2f | %-12s |\n",
                    habitacion.getTipoHabitacion(),
                    habitacion.getVistaHabitacion(),
                    habitacion.getNumeroHabitacion(),
                    habitacion.getTamanoHabitacion(),
                    habitacion.getNumeroCamas(),
                    habitacion.getNumeroBanos(),
                    habitacion.isIncluyeDesayuno() ? "Sí" : "No",
                    habitacion.isAccesoInternet() ? "Sí" : "No",
                    habitacion.isTieneBalcon() ? "Sí" : "No",
                    habitacion.getTarifaPorNoche(),
                    habitacion.isEstado() ? "Disponible" : "Reservado");
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static HabitacionDeluxe buscarHabitacionDeluxe(int numeroHabitacion) {
        // Verificar si la lista de habitaciones está vacía
        if (habitacionesDeluxe == null || habitacionesDeluxe.isEmpty()) {
            return null; // Retorna null si no hay habitaciones registradas
        }

        // Iterar sobre la lista para buscar la habitación
        for (HabitacionDeluxe habitacion : habitacionesDeluxe) {
            if (habitacion.getNumeroHabitacion() == numeroHabitacion) {
                return habitacion; // Retorna la instancia de la habitación encontrada
            }
        }
        return null; // Retorna null si no se encontró la habitación
    }


}
