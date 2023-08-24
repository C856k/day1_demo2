package day1.demo2_day1.reporsitory;

import day1.demo2_day1.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerReporsitory extends JpaRepository<Player,Integer> {
    Player findByName(String player);
    Player findByNameLike(String name);
}
