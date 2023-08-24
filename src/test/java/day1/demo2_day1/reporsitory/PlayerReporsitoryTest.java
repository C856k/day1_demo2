package day1.demo2_day1.reporsitory;

import day1.demo2_day1.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class PlayerReporsitoryTest {

    @Autowired
    PlayerReporsitory playerReporsitory;
    boolean isInitialized = false;
    @BeforeEach
    void setUp() {
        if (!isInitialized){
            playerReporsitory.save(new Player("Lionel Messi","C1","P1"));
            playerReporsitory.save(new Player("P2","C2","P2"));
            isInitialized = true;
        }
    }
    @Test
    public void deleteAll(){
        playerReporsitory.deleteAll();
        assertEquals(0,playerReporsitory.count());
    }
    @Test
    public void testAll(){
        Long count = playerReporsitory.count();
        assertEquals(2,count);
    }
    @Test
    void findByName() {
        Player p1 = playerReporsitory.findByName("P2");
        assertEquals("P2",p1.getName());
    }


    @Test
    void findByNameLike() {
        Player p1 = playerReporsitory.findByNameLike("%Messi");
        assertEquals("Lionel Messi", p1.getName());
    }

}