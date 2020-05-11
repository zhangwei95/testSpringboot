package com.example.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestApplicationTests {

    @Test
    public void contextLoads() {


        List<Integer> arr = new ArrayList<>();
        for (Integer i = 0; i < 10; i++) {
            arr.add(i);
        }

        for (int i = 9; i >= 0; i--) {
            System.out.println(arr.get(i));
            if (i == 5) {
                arr.remove(i);
            }
            System.out.println(arr.get(i));
        }

        for (Integer i : arr) {
            if (i == 5) {
                arr.remove(i);
            }
        }
    }

}
