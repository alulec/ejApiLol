package ico.fes.apilol.modelo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Personaje {
    private String nombre;
    private String region;
    private String rol;
    private int noSkin;
    private double winrate;
    private String dificultad;
    private String lore;
    private String urlImagen;

}
