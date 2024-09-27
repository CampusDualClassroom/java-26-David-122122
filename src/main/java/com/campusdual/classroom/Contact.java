package com.campusdual.classroom;

import java.text.Normalizer;
import java.util.Scanner;

public class Contact implements ICallActions {
    private String name;
    private String surnames;
    private String phone;
    private String code;


    public Contact(String name, String surnames, String phone) {
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.code = generateCode();
    }

    @Override
    public void callMyNumber() {

        System.out.println("Se está llamando a " + this.name + " " + this.surnames + " en el número: " + this.phone);
    }

    @Override
    public void callOtherNumber(String number) {

        System.out.println(this.name + " " + this.surnames + " está llamando al número: " + number);
    }

    @Override
    public void showContactDetails() {

        System.out.println("Detalles del Contacto: ");
        System.out.println("Nombre: " + name);
        System.out.println("Apellidos: " + surnames);
        System.out.println("Teléfono: " + phone);
        System.out.println("Código: " + code);
    }


    public String generateCode() {

        String apellidosNormalizados = Normalizer.normalize(surnames, Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
                .toLowerCase();

        String[] apellidos = apellidosNormalizados.split(" ");

        if (apellidos.length == 1) {

            return name.toLowerCase().charAt(0) +  apellidos[0];
        }
        StringBuilder restoAp = new StringBuilder();

        for (int i = 1; i < apellidos.length; i++) {
            restoAp.append(apellidos[i].replace(" ", ""));
        }

        return name.toLowerCase().charAt(0) + apellidos[0].substring(0, 1) + restoAp.toString();
    }


    public void mostrarMenuContacto() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú del Contacto ---");
            System.out.println("1. Llamar a mi número");
            System.out.println("2. Llamar a otro número");
            System.out.println("3. Mostrar detalles del contacto");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    callMyNumber();
                    break;
                case 2:
                    System.out.print("Ingrese el número al que desea llamar: ");
                    String otroNumero = scanner.nextLine();
                    callOtherNumber(otroNumero);
                    break;
                case 3:
                    showContactDetails();
                    break;
                case 4:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
        this.code = generateCode();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
