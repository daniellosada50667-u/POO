package view;

import domain.*;
import java.util.Scanner;

public class TestTransport {

    private static Scanner scanner = new Scanner(System.in);
    private static TransportService[] services = new TransportService[5];
    private static int count = 0;

    public static void main(String[] args) {
        int option = 0;

        while (option != 5) {
            System.out.println();
            System.out.println("===== SERVICIOS DE TRANSPORTE =====");
            System.out.println("1. Crear un servicio");
            System.out.println("2. Mostrar todos los servicios");
            System.out.println("3. Consultar un servicio por id");
            System.out.println("4. Calcular el total de las tarifas");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    createService();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    findService();
                    break;
                case 4:
                    showTotal();
                    break;
                case 5:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void createService() {
        System.out.print("Id del nuevo servicio (el que usted elija): ");
        int newId = scanner.nextInt();

        if (idExists(newId)) {
            System.out.println("Ya existe un servicio con el id " + newId);
            return;
        }

        System.out.println("Tipo: 1) Taxi  2) Bus  3) Train  4) Airplane  5) Boat");
        System.out.print("Seleccione el tipo: ");
        int type = scanner.nextInt();
        TransportService service = null;

        try {
            switch (type) {
                case 1:
                    System.out.print("Distancia (km): ");
                    float taxiDistance = scanner.nextFloat();
                    service = new Taxi(newId, taxiDistance);
                    break;
                case 2:
                    System.out.print("Número de pasajeros: ");
                    int busPassengers = scanner.nextInt();
                    service = new Bus(newId, busPassengers);
                    break;
                case 3:
                    System.out.print("Distancia (km): ");
                    float trainDistance = scanner.nextFloat();
                    service = new Train(newId, trainDistance);
                    break;
                case 4:
                    System.out.print("Peso del equipaje (kg): ");
                    float planeWeight = scanner.nextFloat();
                    service = new Airplane(newId, planeWeight);
                    break;
                case 5:
                    System.out.print("Distancia (km): ");
                    float boatDistance = scanner.nextFloat();
                    service = new Boat(newId, boatDistance);
                    break;
                default:
                    System.out.println("Tipo no válido");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("El servicio no fue creado");
        }

        if (service != null) {
            addService(service);
            System.out.println("Servicio creado con id " + newId);
        }
    }

    private static boolean idExists(int searchId) {
        for (int i = 0; i < count; i++) {
            if (services[i].getId() == searchId) {
                return true;
            }
        }
        return false;
    }

    private static void addService(TransportService service) {
        if (count == services.length) {
            TransportService[] biggerArray = new TransportService[services.length * 2];
            for (int i = 0; i < services.length; i++) {
                biggerArray[i] = services[i];
            }
            services = biggerArray;
        }
        services[count] = service;
        count = count + 1;
    }

    private static void showServices() {
        if (count == 0) {
            System.out.println("No hay servicios almacenados");
        }
        for (int i = 0; i < count; i++) {
            TransportService service = services[i];
            System.out.println("----------------------------------------");
            System.out.println("Tipo: " + service.getClass().getSimpleName());
            System.out.println("ID: " + service.getId());
            System.out.println("Tarifa: " + service.calculateFare());
        }
    }

    private static void findService() {
        System.out.print("Id a consultar: ");
        int searchId = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            TransportService service = services[i];
            if (service.getId() == searchId) {
                System.out.println("Tipo: " + service.getClass().getSimpleName());
                System.out.println("ID: " + service.getId());
                System.out.println("Tarifa: " + service.calculateFare());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No existe un servicio con ese id");
        }
    }

    private static void showTotal() {
        float total = 0;
        for (int i = 0; i < count; i++) {
            total = total + services[i].calculateFare();
        }
        System.out.println("Total de las tarifas: " + total);
    }
}
