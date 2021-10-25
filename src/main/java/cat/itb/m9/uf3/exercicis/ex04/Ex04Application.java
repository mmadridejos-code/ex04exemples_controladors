package cat.itb.m9.uf3.exercicis.ex04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* Exemple amb l'annotation @Controller
 * Té més prioritat l'estereotip @Controller que @Configuration + WebMvcConfigurer
 * Tant la configuracio com el controlador mapegen /hola
 * /hola --> hola.html  amb @Configuration (no funciona, no s'aplica)
 * /hola --> salutacio.html amb @Controller (sí funciona, sí s'aplica)
 *
 * Des del controlador enviem un paràmetre a la vista a través de la classe Model
 * + annotation @GetMapping + @RequestParam
 */

@SpringBootApplication
public class Ex04Application {

    public static void main(String[] args) {
        SpringApplication.run(Ex04Application.class, args);
    }

}
