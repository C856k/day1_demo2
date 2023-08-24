package day1.demo2_day1.api;

import day1.demo2_day1.entity.Player;
import day1.demo2_day1.reporsitory.PlayerReporsitory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    PlayerReporsitory playerRepository;
    public PlayerController(PlayerReporsitory playerRepository) {
        this.playerRepository = playerRepository;
    }
    @GetMapping
    List<Player> getPlayers() {
        return  playerRepository.findAll();
    }
}
