package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Seleccione el tipo de trabajador:");
            System.out.println("1. Trabajador a tiempo completo");
            System.out.println("2. Trabajador por días");
            System.out.println("3. Salir");

            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    trabajadorTiempoCompleto(scanner);
                    break;
                case 2:
                    trabajadorPorDias(scanner);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static void trabajadorTiempoCompleto(Scanner scanner) {
        System.out.println("Ingrese el nombre del trabajador:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la fecha de inicio del periodo a liquidar (formato DD/MM/AAAA):");
        String fechaInicio = scanner.nextLine();

        System.out.println("Ingrese la fecha de finalización del periodo a liquidar (formato DD/MM/AAAA):");
        String fechaFin = scanner.nextLine();

        System.out.println("¿Tiene derecho a auxilio de transporte? (Sí/No):");
        String tieneTransporte = scanner.nextLine();
        double transporte = 0;
        if (tieneTransporte.equalsIgnoreCase("Sí")) {
            System.out.println("Ingrese el valor del auxilio de transporte:");
            transporte = scanner.nextDouble();
            scanner.nextLine(); 
        }

        System.out.println("Seleccione la clase de riesgos laborales correspondiente (del I al V):");
        String claseRiesgos = scanner.nextLine();

        System.out.println("Ingrese el salario mensual del trabajador:");
        double salarioMensual = scanner.nextDouble();
        scanner.nextLine();

        int diasTrabajados = calcularDiasTrabajados(fechaInicio, fechaFin);

        double cesantias = salarioMensual * diasTrabajados / 360; 
        double interesesCesantias = cesantias * 0.12; 
        double primaSemestre = salarioMensual * 0.0833; 
        double primaSegundoSemestre = primaSemestre; 
        double vacaciones = salarioMensual * 0.0417; 

        double pensiones = salarioMensual * 0.04; 
        double fondoSolidaridad = salarioMensual > 4000000 ? salarioMensual * 0.01 : 0;
        double salud = salarioMensual * 0.04; 

        System.out.println("\nLiquidación del periodo:");
        System.out.printf("Periodo: %s al %s\n", fechaInicio, fechaFin);
        System.out.printf("Días laborados: %d\n", diasTrabajados);
        System.out.printf("Salario: %.2f\n", salarioMensual);
        if (tieneTransporte.equalsIgnoreCase("Sí")) {
            System.out.printf("Auxilio de transporte: %.2f\n", transporte);
        }
        System.out.printf("Cesantías: %.2f\n", cesantias);
        System.out.printf("Intereses sobre cesantías: %.2f\n", interesesCesantias);
        System.out.printf("Prima primer semestre: %.2f\n", primaSemestre);
        System.out.printf("Prima segundo semestre: %.2f\n", primaSegundoSemestre);
        System.out.printf("Vacaciones: %.2f\n", vacaciones);
        System.out.printf("Pensiones (AFP): %.2f\n", pensiones);
        System.out.printf("Fondo de solidaridad pensional: %.2f\n", fondoSolidaridad);
        System.out.printf("Salud (EPS): %.2f\n", salud);
        System.out.printf("TOTAL: %.2f\n", salarioMensual + transporte + cesantias + interesesCesantias + primaSemestre
                + primaSegundoSemestre + vacaciones - pensiones - fondoSolidaridad - salud);
    }

    private static int calcularDiasTrabajados(String fechaInicio, String fechaFin) {  
        return 30; 
    }

    private static void trabajadorPorDias(Scanner scanner) {
            System.out.println("Ingrese el nombre del trabajador:");
            String nombre = scanner.nextLine();
    
            System.out.println("Ingrese la fecha de inicio del periodo a liquidar (formato DD/MM/AAAA):");
            String fechaInicio = scanner.nextLine();
    
            System.out.println("Ingrese la fecha de finalización del periodo a liquidar (formato DD/MM/AAAA):");
            String fechaFin = scanner.nextLine();
    
            System.out.println("Ingrese el salario diario del trabajador:");
            double salarioDiario = scanner.nextDouble();
            scanner.nextLine(); 
    
            System.out.println("Ingrese los días laborados por semana:");
            int diasLaboradosSemana = scanner.nextInt();
            scanner.nextLine(); 
    
            System.out.println("¿Tiene derecho a auxilio de transporte? (Sí/No):");
            String tieneTransporte = scanner.nextLine();
            double transporte = 0;
            if (tieneTransporte.equalsIgnoreCase("Sí")) {
                System.out.println("Ingrese el valor del auxilio de transporte:");
                transporte = scanner.nextDouble();
                scanner.nextLine();
            }
    
            System.out.println("Seleccione la clase de riesgos laborales correspondiente (del I al V):");
            String claseRiesgos = scanner.nextLine();
    
            int diasTrabajadosMes = diasLaboradosSemana * 4;
            double salarioMensualizado = salarioDiario * diasTrabajadosMes;
    
            double cesantias = salarioMensualizado * diasTrabajadosMes / 360; 
            double interesesCesantias = cesantias * 0.12; 
            double primaSemestre = salarioMensualizado * 0.0833; 
            double primaSegundoSemestre = primaSemestre; 
            double vacaciones = salarioMensualizado * 0.0417; 
    
            double pensiones = salarioMensualizado * 0.04; 
            double fondoSolidaridad = salarioMensualizado > 4000000 ? salarioMensualizado * 0.01 : 0;
            double salud = salarioMensualizado * 0.04; 
    
            System.out.println("\nLiquidación del periodo:");
            System.out.printf("Periodo: %s al %s\n", fechaInicio, fechaFin);
            System.out.printf("Días laborados: %d\n", diasTrabajadosMes);
            System.out.printf("Salario diario: %.2f\n", salarioDiario);
            System.out.printf("Salario mensualizado: %.2f\n", salarioMensualizado);
            if (tieneTransporte.equalsIgnoreCase("Sí")) {
                System.out.printf("Auxilio de transporte: %.2f\n", transporte);
            }
            System.out.printf("Cesantías: %.2f\n", cesantias);
            System.out.printf("Intereses sobre cesantías: %.2f\n", interesesCesantias);
            System.out.printf("Prima primer semestre: %.2f\n", primaSemestre);
            System.out.printf("Prima segundo semestre: %.2f\n", primaSegundoSemestre);
            System.out.printf("Vacaciones: %.2f\n", vacaciones);
            System.out.printf("Pensiones (AFP): %.2f\n", pensiones);
            System.out.printf("Fondo de solidaridad pensional: %.2f\n", fondoSolidaridad);
            System.out.printf("Salud (EPS): %.2f\n", salud);
            System.out.printf("TOTAL: %.2f\n", salarioMensualizado + transporte + cesantias + interesesCesantias + primaSemestre + primaSegundoSemestre);
        }   
}