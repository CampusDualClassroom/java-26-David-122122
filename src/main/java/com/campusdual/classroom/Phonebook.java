package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    private Map<String, Contact> data = new HashMap<>();



    public void addContact(Contact contact) {
        data.put(contact.generateCode(), contact);
    }

    public Contact aContacto() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del contacto: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese los apellidos del contacto: ");
        String apellidos = sc.nextLine();
        System.out.print("Ingrese el número de teléfono del contacto: ");
        String telefono = sc.nextLine();

        return new Contact(nombre, apellidos, telefono);
    }


    public void showPhonebook() {
        if (data.isEmpty()) {
            System.out.println("No hay contactos, vacio");
        } else {
            for (Map.Entry<String, Contact> entry : data.entrySet()) {
                System.out.println("code: " + entry.getKey() + " Nombre: " + entry.getValue().getName() +
                        " Apellidos: " + entry.getValue().getSurnames() +
                        " Telefono: " + entry.getValue().getPhone());
            }
        }
    }


    public String selectContact() {
        if (!data.isEmpty()) {
            showPhonebook();
            Scanner scanner = new Scanner(System.in);
            int op = scanner.nextInt();
            if (op >= 0 && data.size() > op) {
                int indice = 0;
                for (Map.Entry<String, Contact> entry : data.entrySet()) {
                    if (indice == op) {
                        return entry.getKey();
                    }
                    indice++;
                }
            }
        }
        return "";
    }

    public void eliminarContacto() {
        showPhonebook();
        String code = selectContact();
        deleteContact(code);
    }


    public void deleteContact(String code) {
        if (data.isEmpty()) {
            System.out.println("No hay contactos, vacio");
        } else {
            if (data.containsKey(code)) {
                data.remove(code);
                System.out.println("Contacto eliminado correctamente.");
            } else {
                System.out.println("No se encontró el contacto con el código proporcionado.");
            }
        }
    }

    public Map<String, Contact> getData() {
        return data;
    }

    public void setData(Map<String, Contact> data) {
        this.data = data;
    }
}
