package com.kexie.videoapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VideoappApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void AccountTest(){

        String account;
        int random;
        for (int i = 0; i < 10; i++) {
            random = (int)((Math.random()*9+1)*100000);
            account = "bt"+ String.valueOf(random);

            System.out.println(random);
            System.out.println(account);
        }
    }



}
