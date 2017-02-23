package com.example;

import com.example.domain.entity.system.Banana;
import com.example.domain.entity.system.Minion;
import com.example.domain.repository.BananaRepository;
import com.example.domain.repository.MinionRepository;
import com.example.sdk.BananaSdk;
import javaslang.collection.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpEntity;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final MinionRepository minionRepository;
    private final BananaRepository bananaRepository;

    private final BananaSdk bananaSdk;

    public DemoApplication(MinionRepository minionRepository, BananaRepository bananaRepository, BananaSdk bananaSdk) {
        this.minionRepository = minionRepository;
        this.bananaRepository = bananaRepository;
        this.bananaSdk = bananaSdk;
    }

    public static void main(final String... args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(final String... strings) throws Exception {
        final Minion dave = new Minion();

        dave.setName("Dave");
        dave.setDespicability(25);

        final Minion savedDave = minionRepository.save(dave);

        logger.info("Dave's ID: " + savedDave.getId());

        Iterator.range(0, 100)
                .forEach(count -> {
                    final Banana banana = new Banana();

                    banana.setJuicy(count.doubleValue());
                    banana.setMinion(dave);

                    bananaRepository.save(banana);
                });

        bananaSdk.getAll()
                .map(HttpEntity::getBody)
                .map(Slice::getContent)
                .map(List::size)
                .getOption()
                .stdout();
    }
}
