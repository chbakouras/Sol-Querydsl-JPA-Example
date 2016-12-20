package com.example;

import com.example.domain.entity.system.Banana;
import com.example.domain.entity.system.Minion;
import com.example.domain.repository.BananaRepository;
import com.example.domain.repository.MinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final MinionRepository minionRepository;
    private final BananaRepository bananaRepository;

    @Autowired
    public DemoApplication(MinionRepository minionRepository, BananaRepository bananaRepository) {
        this.minionRepository = minionRepository;
        this.bananaRepository = bananaRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Minion dave = new Minion();
        dave.setName("Dave");
        dave.setDespicability(25);

        final Minion savedMinion = minionRepository.save(dave);

        System.out.println(savedMinion.getId());

        for (Integer i = 0; i < 100; i++) {
            Banana banana = new Banana();
            banana.setJuicy(200D);
            banana.setMinion(dave);

            bananaRepository.save(banana);
        }
    }
}
