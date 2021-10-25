package cat.itb.m9.uf3.exercicis.ex04.controladors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ControladorExemples {
    @RequestMapping(value = "/hola", method = RequestMethod.GET)
    public String hola() {
        return "hola";
    }

    /* només pot haver un mapping per url i, evidentment, els noms dels mètodes
     * no poden estar repetits, a no ser que estiguin sobrecarregats, com és normal en Java */
    @GetMapping("/hola2")
    public String hola2() {
        return "hola";
    }

    /** es retorna un atribut a la vista, a través de la classe Model*/
    @GetMapping("/exemple1")
    public String exemple1(Model m){
        /* la classe Model és com un map <k,v> */
        m.addAttribute("atribut","Això és el valor de l'atribut");
        /* l'atribut es recull a la vista, amb aquest nom */
        return "/exemples/exemple1";
    }


//    /** es retorna un atribut a la vista, a través de la classe Model*/
//    @PostMapping("/exemple_post")
//    public String exemple_post( Model m){
//        /* la classe Model és com un map <k,v> */
//        //m.addAttribute("atribut","Això és el valor de l'atribut");
//        m.addAttribute("nomParam","POST");
//        /* l'atribut es recull a la vista, amb aquest nom */
//        return "/exemples/exemple2";
//    }

    @GetMapping("/exemple2")
  //  public String exemple2(@RequestParam(name="nomParam",required = false, defaultValue = "Valor per defecte") String n, Model m){
  public String exemple2(@RequestParam("nom") String n, Model m){
        //name="nom" significa que "nom" es el name del paràmetre en la URL
        //així el recurs es crida -> http://localhost:8080/exemple2?nom=Paquita
        //String n és la variable local que utilitzo en aquest mètode
        //"nomParam" és el nom de l'atribut que passo a la vista
        m.addAttribute("nomParam", n);
        return "/exemples/exemple2"; //retorna a la plantilla "exemple2.html"
    }
    //TODO --> /exemple2?nom=Paquita&cognoms=Salas

    @GetMapping("/exemple2bis")
    public String exemple2Bis(@RequestParam(name="nom") Optional<String> n, Model m){
        m.addAttribute("nomParam", n.orElse("Valor per defecte bis"));
        return "/exemples/exemple2"; //retorna a la plantilla "exemple2.html"
    }


    //estil REST
    @GetMapping("/exemple3/{nom}")
    //per sol·licitar un recurs com /exemple3/{Paquita}
    public String saludarPathVariable(@PathVariable("nom") String n, Model m){
        m.addAttribute("nomParam",n);
        return "/exemples/exemple3";
    }

    //estil MVC
    @GetMapping("/exemple3")
    //per sol·licitar un recurs com /exemple3?nom=Paquita
    public String saludar3ReqParam(@RequestParam("nom") String n, Model m){
        m.addAttribute("nomParam",n);
        return "/exemples/exemple3";
    }

    @GetMapping("/2param")
    public String saludar2param(@RequestParam("nom") String nom, @RequestParam ("cognom") String cognoms, Model m){
        m.addAttribute("nom",nom);
        m.addAttribute("cognom",cognoms);
        return "2param";
    }

    @GetMapping("/2param/{nom}/{cognom}")
    public String saludar2Path(@PathVariable("nom") String nom, @PathVariable ("cognom") String cognoms, Model m){
        m.addAttribute("nom",nom);
        m.addAttribute("cognom",cognoms);
        return "2param";
    }
    //TODO --> /exemple3/{Paquita}/{Salas}

}
