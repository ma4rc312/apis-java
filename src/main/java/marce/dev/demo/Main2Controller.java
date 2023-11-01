package marce.dev.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main2Controller {
    @PostMapping("/convertirHoraEnPalabras")
    public String convertirHoraEnPalabras(@RequestBody HMRequest request) {
        int hora = request.getHora();
        int minutos = request.getMinutos();

        if (hora >= 1 && hora < 12 && minutos >= 0 && minutos < 60) {
            String[] horasEnPalabras = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "once"};
            String[] minutosEnPalabras = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve", "veinte", "veintiún", "veintidós", "veintitrés", "veinticuatro", "veinticinco", "veintiséis", "veintisiete", "veintiocho", "veintinueve", "treinta", "treinta y uno", "treinta y dos", "treinta y tres", "treinta y cuatro", "treinta y cinco", "treinta y seis", "treinta y siete", "treinta y ocho", "treinta y nueve", "cuarenta", "cuarenta y uno", "cuarenta y dos", "cuarenta y tres", "cuarenta y cuatro", "cuarenta y cinco", "cuarenta y seis", "cuarenta y siete", "cuarenta y ocho", "cuarenta y nueve", "cincuenta"};

            String horaEnPalabras = horasEnPalabras[hora];
            String minutosEnPalabrasFinal = "";

            if (minutos == 0) {
                minutosEnPalabrasFinal = "en punto";
            } else if (minutos % 15 == 0) {
                minutosEnPalabrasFinal = "y " + minutosEnPalabras[minutos];
            } else if (minutos < 30) {
                minutosEnPalabrasFinal = "y " + minutosEnPalabras[minutos];
            } else {
                minutosEnPalabrasFinal = "menos " + minutosEnPalabras[60 - minutos];
            }

            if (minutos != 0 && minutos != 15 && minutos != 30) {
                minutosEnPalabrasFinal += " minutos";
            }

            return horaEnPalabras + " " + minutosEnPalabrasFinal;
        } else {
            return "Entrada inválida. Por favor, asegúrate de que la hora está entre 1 y 11 y los minutos están entre 0 y 59.";
        }
    }
}
