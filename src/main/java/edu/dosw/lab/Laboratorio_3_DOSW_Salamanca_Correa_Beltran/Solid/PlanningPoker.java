package edu.dosw.lab.Laboratorio_3_DOSW_Salamanca_Correa_Beltran.Solid;

import java.util.*;

public class PlanningPoker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integrante> integrantes = new ArrayList<>();
        List<HistoriaUsuario> historias = new ArrayList<>();

        System.out.println("¿Cuántos integrantes participarán?");
        int numIntegrantes = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numIntegrantes; i++) {
            System.out.println("Ingrese el nombre del integrante " + (i + 1) + ":");
            String nombre = scanner.nextLine();
            integrantes.add(new Integrante(nombre));
        }

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n¿Desea añadir una historia de usuario? (si/no)");
            String respuesta = scanner.nextLine().toLowerCase();

            if (respuesta.equals("si")) {
                System.out.println("Ingrese la historia de usuario:");
                String historiaNueva = scanner.nextLine();
                historias.add(new HistoriaUsuario(historiaNueva));
            } else if (respuesta.equals("no")) {
                continuar = false;
            }
        }

        Votacion votacion = new Votacion();

        System.out.println("====== Planning Poker ======");
        System.out.println("Vote usando la secuencia de fibonacci (1, 2, 3, 5, 8, 13)");

        for (HistoriaUsuario historia : historias) {
            boolean acuerdo = false;
            int puntosFinal = 0;

            while (!acuerdo) {
                System.out.println("\nHistoria de usuario: " + historia.getDescripcion());

                int[] votos = new int[integrantes.size()];
                for (int i = 0; i < integrantes.size(); i++) {
                    votos[i] = votacion.pedirVoto(integrantes.get(i));
                }

                boolean todosIguales = true;
                for (int i = 1; i < votos.length; i++) {
                    if (votos[i] != votos[0]) {
                        todosIguales = false;
                        break;
                    }
                }

                if (todosIguales) {
                    acuerdo = true;
                    puntosFinal = votos[0];
                    historia.setPuntaje(puntosFinal);
                    System.out.println("Acuerdo alcanzado: " + puntosFinal);
                } else {
                    System.out.println("Votos divergentes – Discutan y vuelvan a votar");
                }
            }
            System.out.println("Historia: " + historia.getDescripcion() + " → Puntaje final: " + puntosFinal);
        }

        System.out.println("\n====== Historial de historias aceptadas ======");
        for (HistoriaUsuario historia : historias) {
            if (historia.getPuntaje() > 0) {
                System.out.println(historia.getDescripcion() + " → " + historia.getPuntaje());
            }
        }
    }
}