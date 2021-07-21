/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.modelo.clases;

/**
 *
 * @author Matias
 */
public enum Marca {

    FIAT(new String[]{
        "Freemont",
        "Doblò",
        "Punto",
        "Panda",
        "500",
        "500L",
        "Fiorino",
        "Bravo",
        "Tipo",
        "124 Spider"
    }),
    FORD(new String[]{
        "C-Max",
        "Fiesta",
        "Focus",
        "Mondeo",
        "Ka",
        "S-MAX",
        "B-MAX",
        "Grand C-Max",
        "Tourneo Custom",
        "Kuga",
        "Galaxy",
        "Grand Tourneo Connect",
        "Tourneo Connect",
        "EcoSport",
        "Tourneo Courier",
        "Mustang",
        "Transit Connect",
        "Edge",
        "Ka+",
        "124 Spider"
    }),
    HONDA(new String[]{
        "Accord",
        "Jazz",
        "Civic",
        "CR-V",
        "HR-V"
    }),
    CITROEN(new String[]{
        "C4",
        "C3",
        "C5",
        "C3 Picasso",
        "C4 Picasso",
        "Grand C4 Picasso",
        "C4 Aircross",
        "Nemo",
        "Berlingo",
        "C-Elysée",
        "C4 Cactus",
        "C1",
        "C-Zero",
        "C-Elysée",
        "Spacetourer",
        "E-Mehari",
        "C3 Aircross"
    }),
    BMW(new String[]{
        "Serie 3",
        "Serie 5",
        "Serie 4",
        "Serie 7",
        "Z4",
        "X5",
        "Serie 1",
        "X3",
        "Serie 6",
        "X1",
        "X6",
        "I3",
        "Serie 2",
        "X4",
        "I8",
        "Serie 2 Gran Tourer",
        "Serie 2 Active Tourer",
        "X2"
    }),
    AUDI(new String[]{
        "A4",
        "A8",
        "A3",
        "TT",
        "A5",
        "A4 Allroad Quattro",
        "A6",
        "A7",
        "Q3",
        "Q5",
        "S5",
        "A1",
        "A6 Allroad Quattro",
        "S7",
        "S6",
        "S8",
        "RS4",
        "RS5",
        "R8",
        "SQ5",
        "Q7",
        "RS6",
        "RS7",
        "RS Q3",
        "S3",
        "S1",
        "TTS",
        "S4",
        "RS3",
        "SQ7",
        "Q2",
        "TTS",
        "SQ7",
        "S4",
        "S6",
        "S7"
    }),
    PEUGEOT(new String[]{
        "308",
        "807",
        "Bipper",
        "508",
        "Partner",
        "3008",
        "208",
        "2008",
        "RCZ",
        "5008",
        "4008",
        "108",
        "207",
        "Ion",
        "Traveller"
    });

    public static String[] valueOf(Object selectedItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String[] nombreModelos;

    private Marca(String[] nombreModelos) {
        this.nombreModelos = nombreModelos;
    }

    public String[] getNombreModelos() {
        return nombreModelos;
    }

}
