package udla.javs.habitacion;

abstract public class Habitacion {
    // Atributos que definen a la clase habitación

    // Cualitativos
    private String tipoHabitacion; // Ejemplo: "Individual", "Doble", "Familiar".
    private String vistaHabitacion; // Ejemplo: "Mar", "Ciudad", "Jardín".
    private int numeroHabitacion; // Identificador único de la habitación.
    private boolean estado;

    // Cuantitativos
    private double tarifaPorNoche; // Costo por noche.
    private double tamanoHabitacion; // Tamaño de la habitación en m².
    private int numeroCamas; // Número de camas en la habitación.
    private int numeroBanos; // Número de baños en la habitación.


    // Creación de constructor
    public Habitacion(){

    }

    public Habitacion(String tipoHabitacion, String vistaHabitacion, int numeroHabitacion, double tarifaPorNoche, double tamanoHabitacion, int numeroCamas, int numeroBanos,boolean estado) {
        this.tipoHabitacion = tipoHabitacion;
        this.vistaHabitacion = vistaHabitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.tarifaPorNoche = tarifaPorNoche;
        this.tamanoHabitacion = tamanoHabitacion;
        this.numeroCamas = numeroCamas;
        this.numeroBanos = numeroBanos;
        this.estado = estado;
    }

    // Creación de getters y setters


    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getVistaHabitacion() {
        return vistaHabitacion;
    }

    public void setVistaHabitacion(String vistaHabitacion) {
        this.vistaHabitacion = vistaHabitacion;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public double getTarifaPorNoche() {
        return tarifaPorNoche;
    }

    public void setTarifaPorNoche(double tarifaPorNoche) {
        this.tarifaPorNoche = tarifaPorNoche;
    }

    public double getTamanoHabitacion() {
        return tamanoHabitacion;
    }

    public void setTamanoHabitacion(double tamanoHabitacion) {
        this.tamanoHabitacion = tamanoHabitacion;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    public int getNumeroBanos() {
        return numeroBanos;
    }

    public void setNumeroBanos(int numeroBanos) {
        this.numeroBanos = numeroBanos;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    // Creación de metodo abstracto.
    abstract public void registrarHabitaciones();
    abstract public void mostrarHabitaciones();

}
