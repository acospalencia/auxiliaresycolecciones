import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

class Empleado {
    private int id;
    private String codigo;
    private String nombre;
    private String apellido;
    private String departamento;
    private double salario;

    public Empleado(int id, String nombre, String apellido, String departamento, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
        this.salario = salario;
        this.codigo = generarCodigo(apellido, departamento);
    }

    private String generarCodigo(String apellido, String departamento) {
        String ap = apellido.length() >= 2 ? apellido.substring(0, 2).toUpperCase() : apellido.toUpperCase();
        String dep = departamento.length() >= 3 ? departamento.substring(0, 3).toUpperCase() : departamento.toUpperCase();
        int numero = new Random().nextInt(900) + 100;
        return ap + dep + numero;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Código: " + codigo +
                ", Nombre: " + nombre +
                ", Apellido: " + apellido +
                ", Departamento: " + departamento +
                ", Salario: " + salario;
    }
}

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Empleado> empleados = new LinkedList<>();
        int id = 1;

        while (true) {
            System.out.println("Registro de nuevo empleado:");

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();

            System.out.print("Departamento: ");
            String departamento = scanner.nextLine();

            System.out.print("Salario: ");
            double salario = Double.parseDouble(scanner.nextLine());

            Empleado emp = new Empleado(id, nombre, apellido, departamento, salario);
            empleados.add(emp);
            id++;

            System.out.print("¿Desea registrar otro empleado? (s/n): ");
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        }

        System.out.println("\nEmpleados registrados:");
        for (Empleado emp : empleados) {
            System.out.println(emp.toString());
        }

        scanner.close();
    }
}
