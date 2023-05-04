package ico.fes.apilol.controlador;

import ico.fes.apilol.modelo.Personaje;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Controller
public class PersonajeControlador {

    private ArrayList<Personaje> listaCampeones;

    public PersonajeControlador(){
        ArrayList<Personaje> listPersonajes = new ArrayList<>();
        listPersonajes.add( new Personaje("Caitlyn", "Piltóver", "Tirador",9 , 48.7, "Alta", "Reconocida como la mejor pacificadora, Caitlyn también es la mejor oportunidad de Piltóver para deshacerse de los elementos criminales elusivos de su ciudad. A veces hace equipo con Vi y es un buen contrapunto para la naturaleza más impulsiva de su compañera. Aunque carga un rifle hextech único, el arma más poderosa de Caitlyn es su intelecto superior, el cual le permite tender trampas elaboradas para malhechores que son suficientemente tontos para operar en la Ciudad del Progreso.", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.3_etdriXGAN6_O6EI2ApjQHaEX%26pid%3DApi&f=1&ipt=a162a367ca2f956647c79eed04af8f78773c80aec518841a883aa08edd2d7fb6&ipo=images"));
        listPersonajes.add( new Personaje("Seraphine", "Piltóver", "Mago", 7, 50.3,"Baja" , "Nacida en Piltóver de padres zaunitas, Seraphine es capaz de escuchar las almas de otros; el mundo canta para ella, y ella canta para él. Aunque estos sonidos la abrumaban en su juventud, ahora acude a ellos para inspirarse y convertir el caos en una sinfonía. Se presenta en las ciudades hermanas para recordarles a sus ciudadanos que no están solos, que son más fuertes juntos y que, ante sus ojos, su potencial es ilimitado.", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.5lsApaRgWBrNf-CIKtGqkQHaEK%26pid%3DApi&f=1&ipt=151525b84c190336b80ab13d01cd700769fe96478ef13436c9ee50a0435da557&ipo=images"));
        listPersonajes.add( new Personaje("Camille", "Piltóver", "Peleador", 6, 66.4, "Alta", "Armada para operar fuera de los límites de la ley, Camille es la principal inteligencia del clan Ferros: una elegante agente de élite que se asegura de que la máquina de Piltóver y el submundo zaunita funcionen sin problemas. Adaptable y precisa, ve las técnicas torpes como una vergüenza que necesita ponerse en línea. Con una mente tan brillante y afilada como las cuchillas que porta, la búsqueda de Camille por la superioridad a través de las mejoras de cuerpo de Hextech han hecho que la gente se pregunte si es más máquina que mujer.", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.explicit.bing.net%2Fth%3Fid%3DOIP.BljzUYs7OjvA8dsX1p95jAHaEK%26pid%3DApi&f=1&ipt=be6f2ad882e29cbd5bcecb0d5acba48c06228e504929c3b2d8a8d738f1ebbb69&ipo=images"));
        listPersonajes.add( new Personaje("Akali", "Jonia", "Asesino",5, 49.8, "Alta", "Tras renunciar a la Orden Kinkou y a su título como el Puño de la Sombra, Akali pelea sola, lista para ser el arma letal que su pueblo necesita. Aunque conserva todo lo que aprendió de su maestro Shen, juró defender a Jonia de sus enemigos, una muerte a la vez. Puede que Akali ataque en silencio, pero su mensaje resonará con fuerza y claridad: teman a la asesina sin maestro.", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.gIljLk3zieiosEjx-gvdHQHaEK%26pid%3DApi&f=1&ipt=20d44b825ff062ab05b9adf7e410c4a517cd669b881d8f6e27784f5e5ddebbe9&ipo=images"));
        listPersonajes.add( new Personaje("Irelia", "Jonia", "Peleador", 11, 50.5, "Alta", "La invasión de Jonia a manos de Noxus produjo muchos héroes, pero ninguno fue tan improbable como la joven Irelia de Navori. Entrenada en las ancestrales danzas de su región, adaptó su arte para la guerra y ahora usa sus movimientos refinados y llenos de gracia para controlar un arsenal de cuchillas letales. Después de demostrar ser una guerrera, se le asignó el papel de líder y ejemplo de la resistencia. Hoy en día, sigue dedicada a defender su territorio.", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.vJn0OeHWPiJRQGACeMGPzwHaEK%26pid%3DApi&f=1&ipt=7e05e8e483f383efea062a31137cd20fa1b35fe694369db3a9e2d87a2730bfa6&ipo=images"));
        listPersonajes.add( new Personaje("Karma", "Jonia", "Mago", 11, 55.6, "Media", "Ningún mortal es capaz de ilustrar mejor las tradiciones espirituales de Jonia que Karma. Ella es la personificación de un alma antigua que ha reencarnado innumerables veces, transmitiendo sus recuerdos acumulados en cada una de las vidas nuevas, bendecida con un poder que muy pocos pueden comprender. Ha dado lo mejor de sí para guiar a su gente en los tiempos de crisis recientes, aunque sabe bien que la paz y la armonía tienen un costo considerable, tanto para ella como para la tierra que atesora como lo más preciado.", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.1CN2VktvLy-3xzDcx3IxgQHaEK%26pid%3DApi&f=1&ipt=5271ed36243cdc0ee3a878f22ec3dce0ddcf3713d19163404aeadbd624faabff&ipo=images"));
        listPersonajes.add( new Personaje("Ashe", "Fréljord", "Tirador", 4, 60.3, "Baja", "Como Hija del Hielo y madre de guerra de la tribu Avarosa, Ashe comanda la más grande horda en el norte. Estoica, inteligente e idealista, pero incómoda con su rol de líder, ella aprovecha las magias ancestrales de su linaje para portar un arco de Hielo Puro. Apoyada por la creencia de su gente que ella es el héroe mitológico reencarnado de Avarosa, Ashe espera unificar el Fréljord una vez más al retomar sus tierras antiguas y tribales.", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.rqiDQMltqbsd7cD5vUASgQHaEK%26pid%3DApi&f=1&ipt=5828ae1968057dc2e97331d96807826f497315117638826ccff2ceb6d8683733&ipo=images"));
        listPersonajes.add( new Personaje("Sejuani", "Fréljord", "Tanque", 6, 77.4, "Media", "Sejuani es la brutal e implacable Matriarca de la Garra Invernal, una de las tribus más temibles del Fréljord. La supervivencia de su gente es una constante y desesperada batalla contra los elementos, lo que los obliga a invadir a noxianos, demacianos y avarosanos por igual para sobrevivir a los duros inviernos. Sejuani encabeza los ataques más peligrosos montada en su jabalí, Bristle, mientras empuña su mangual de Hielo Puro para congelar y destrozar a sus enemigos.", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.-kyLFyje80880ucsxVu7JgEsCl%26pid%3DApi&f=1&ipt=fac1bec2c2f9fac396d628fea60660dd842d8ea2ae97e56fff8ba04e10047f02&ipo=images"));
        listPersonajes.add( new Personaje("Braum", "Fréljord", "Soporte", 12, 44.1, "Media", "Dotado de bíceps inmensos y un corazón aún más grande, Braum es un querido héroe Hijo del Hielo del Fréljord. En todas las tabernas al norte de Frostheld brindan por su fuerza legendaria y se cuentan relatos de cómo taló un bosque de robles en una sola noche e hizo añicos una montaña entera de un solo puñetazo. Con una puerta de bóveda encantada forjada hace mucho tiempo como escudo, Braum recorre el norte congelado como un protector jovial y ayuda a los desvalidos mientras persigue su sueño de pacificar el Fréljord.", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.MTH4tWKhEajRhxMqGYPmqgHaEK%26pid%3DApi&f=1&ipt=39565d8926876f87c26ee16f5b737a47dfba2201a75485733d68a527bbf67286&ipo=images"));
        listaCampeones = listPersonajes;

    }

    @GetMapping("/personajes/")
    public String getPersonajes(Model model){

        model.addAttribute("personajes", listaCampeones);
        return "index";
    }

    @GetMapping("/personaje/{id}")
    public String getPersonaje(@PathVariable(required = true, name = "id") int id, Model model){
        model.addAttribute("campeon", listaCampeones.get(id));
        return "unSoloPersonaje";
    }

    @PostMapping("/super/vender")
    public ResponseEntity<Boolean> vender(@RequestBody(required=true) Producto elCoso){

        return new ResponseEntity<>(SM.venderProducto(elCoso.getId()), HttpStatus.OK);
    }


}
