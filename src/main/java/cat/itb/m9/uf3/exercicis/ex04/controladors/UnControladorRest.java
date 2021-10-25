package cat.itb.m9.uf3.exercicis.ex04.controladors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UnControladorRest {
    @GetMapping("/hola_rest")
    public String hello(@RequestParam(value="nom", defaultValue="Món") String n){
        return "Hola "+n;
    }

    @GetMapping("/numero")
    public int numero(){
        return new Random().nextInt(10);
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/info")
    public String info() {
        StringBuilder message = new StringBuilder("Fent proves!");
        try {
            InetAddress ip = InetAddress.getLocalHost();
            message.append(" From host: " + ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return message.toString();
    }
}
