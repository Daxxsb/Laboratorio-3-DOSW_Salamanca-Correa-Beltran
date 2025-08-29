package edu.dosw.lab.Laboratorio_3_DOSW_Salamanca_Correa_Beltran.Solid;

public class PlanningPoker {
    public static void main(String[] args) {
        HistoriaUsuario[] historias = {
                new HistoriaUsuario("COMO Cliente QUIERO crear una cuenta válida PARA poder ahorrar."),
                new HistoriaUsuario("COMO Cliente QUIERO consultar mi saldo en la cuenta PARA saber cuánto dinero tengo disponible."),
                new HistoriaUsuario("COMO Cliente QUIERO depositar dinero PARA aumentar el saldo de mi cuenta."),
                new HistoriaUsuario("COMO Bankify QUIERO validar la integridad PARA mantener el estandar PCI.")
        };

        Integrante[] integrantes = {
                new Integrante("Elizabeth Correa"),
                new Integrante("Sebastian Ortega"),
                new Integrante("David Salamanca")
        };

        Votacion votacion = new Votacion();

        System.out.println("====== Planning Poker ======");
        System.out.println("Vote usando la secuencia de fibonacci (1, 2, 3, 5, 8, 13)");

        for (HistoriaUsuario historia : historias) {
            boolean acuerdo = false;
            int puntosFinal = 0;

            while (!acuerdo) {
                System.out.println("\nHistoria de usuario: " + historia.getDescripcion());

                int[] votos = new int[integrantes.length];
                for (int i = 0; i < integrantes.length; i++) {
                    votos[i] = votacion.pedirVoto(integrantes[i]);
                }

                if (votos[0] == votos[1] && votos[1] == votos[2]) {
                    acuerdo = true;
                    puntosFinal = votos[0];
                    System.out.println("Acuerdo alcanzado: " + puntosFinal);
                } else {
                    System.out.println("Votos divergentes – Discutan y vuelvan a votar");
                }
            }
            System.out.println("Historia: " + historia.getDescripcion() + " → Puntaje final: " + puntosFinal);
        }
    }
}