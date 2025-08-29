package edu.dosw.lab.Laboratorio_3_DOSW_Salamanca_Correa_Beltran.Solid;

import java.util.*;

public class Votacion {
    private final Set<Integer> permitidos = new HashSet<>(Arrays.asList(1, 2, 3, 5, 8, 13));
    private final Scanner sc = new Scanner(System.in);

    public int pedirVoto(Integrante integrante) {
        int voto;
        while (true) {
            System.out.print("Integrante " + integrante.getNombre() + ": ");
            voto = sc.nextInt();
            if (permitidos.contains(voto)) {
                return voto;
            } else {
                System.out.println("Número incorrecto, solo son válidos los números: (1, 2, 3, 5, 8, 13).");
            }
        }
    }
}