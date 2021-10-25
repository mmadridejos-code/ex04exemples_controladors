package cat.itb.m9.uf3.exercicis.ex04.controladors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UnControladorPerSaludar {

    //@RequestMapping(value={"/hola","/hola_ocult"}, method= RequestMethod.GET)
    @GetMapping({"/saluda","/hola_ocult"})
    public String saludar(@RequestParam(name="nom", required=false, defaultValue="món") String n, Model model){
        model.addAttribute("nom",n);
        return "salutacio";
    }
}
