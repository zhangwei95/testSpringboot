package com.example.test.controller;


import com.example.test.Long2LocalDateTime;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/api")
public class DemoResource {
    private static final Logger LOGGER= LoggerFactory.getLogger("demo");

    LoadingCache<Long, AtomicLong> counter= CacheBuilder.newBuilder()
            .expireAfterWrite(2, TimeUnit.SECONDS)
            .build(new CacheLoader<Long, AtomicLong>() {
                @Override
                public AtomicLong load(Long aLong) throws Exception {
                    return new AtomicLong(0);
                }
            });
    int limit=2;
    int unit=1000;

    RateLimiter rateLimiter=RateLimiter.create(10);
    @PostMapping("/testLong2LocalDateTime")
    public void reportTask(@RequestBody @Valid Long2LocalDateTime dto) {
        LOGGER.error(dto.toString());
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable(value = "id") Long id) throws ExecutionException {
        //漏桶
//        Long current = System.currentTimeMillis()/unit;
//        if(counter.get(current).incrementAndGet()>limit){
//            return "Deny";
//        }
        double acquire = rateLimiter.acquire();
        System.out.println(acquire);
        return String.valueOf(acquire);
    }
    @PostMapping("/testLong2LocalDateTimeParam")
    public void reportTask(@RequestParam(value = "startTime") LocalDateTime startTime, @RequestParam(value = "endTime") Date endTime) {
        LOGGER.error(startTime.toString());
        LOGGER.error(endTime.toString());
    }
}
