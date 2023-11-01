package marce.dev.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @PostMapping("/verificarNumero")
    public String verificarNumero(@RequestBody NumeroRequest request) {
        int numero = request.getNumero();

        if (numero % 2 != 0) {
            return "Quipux";
        } else {
            if (numero >= 2 && numero <= 5) {
                return "No Quipux";
            } else if (numero >= 6 && numero <= 20) {
                return "Quipux";
            } else if (numero > 20) {
                return "No Quipux";
            }
        }
        return "";
    }
}
