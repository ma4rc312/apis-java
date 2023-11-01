package marce.dev.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/equipments")
public class EquipementController {
    private List<Equipment> equipmentList = new ArrayList<>();

    @PostMapping("/add")
    public void addEquipment(@RequestBody Equipment equipment) {
        equipmentList.add(equipment);
    }

    @GetMapping("/reportBasic/{equipmentIndex}")
    public String generateBasicReport(@PathVariable("equipmentIndex") int equipmentIndex) {
        if (equipmentIndex < 0 || equipmentIndex >= equipmentList.size()) {
            return "Equipo no encontrado";
        }
        Equipment equipment = equipmentList.get(equipmentIndex);
        return "Nombre del equipo: " + equipment.getName() + "\n" +
                "Títulos ganados: " + equipment.getTitles() + "\n" +
                "Cantidad total de jugadores: " + (equipment.getPlayers().size() + equipment.getSubstitutes().size());
    }

    @GetMapping("/reportDetailed/{equipmentIndex}")
    public String generateDetailedReport(@PathVariable("equipmentIndex") int equipmentIndex) {
        if (equipmentIndex < 0 || equipmentIndex >= equipmentList.size()) {
            return "Equipo no encontrado";
        }
        Equipment equipment = equipmentList.get(equipmentIndex);
        StringBuilder report = new StringBuilder();
        report.append("Nombre del equipo: ").append(equipment.getName()).append("\n");
        report.append("Detalle de titulares:\n");
        for (Player player : equipment.getPlayers()) {
            report.append("Nombre: ").append(player.getName()).append(", Posición: ").append(player.getPosition()).append("\n");
        }
        report.append("Detalle de suplentes:\n");
        for (Player player : equipment.getSubstitutes()) {
            report.append("Nombre: ").append(player.getName()).append(", Posición: ").append(player.getPosition()).append("\n");
        }
        return report.toString();
    }

    static class Equipment {
        private String name;
        private int titles;
        private List<Player> players;
        private List<Player> substitutes;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTitles() {
            return titles;
        }

        public void setTitles(int titles) {
            this.titles = titles;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public void setPlayers(List<Player> players) {
            this.players = players;
        }

        public List<Player> getSubstitutes() {
            return substitutes;
        }

        public void setSubstitutes(List<Player> substitutes) {
            this.substitutes = substitutes;
        }
    }

    static class Player {
        private String name;
        private String position;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }
}