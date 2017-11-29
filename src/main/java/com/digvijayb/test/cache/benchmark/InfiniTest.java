package com.digvijayb.test.cache.benchmark;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import org.infinispan.manager.DefaultCacheManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import java.util.UUID;

public class InfiniTest {

    @Rule
    public org.junit.rules.TestRule benchmarkRun = new BenchmarkRule();

    private static org.infinispan.Cache<String, String> map;

    @BeforeClass
    public static void beforeClass() throws Exception {
        map = new DefaultCacheManager().getCache("benchmark");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        map.stop();
    }

    @BenchmarkOptions(benchmarkRounds = 1000000, warmupRounds = 100000)
    @Test
    public void testInfinispan() throws Exception {
        map.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
    }

}