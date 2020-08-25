package es.ravensoft;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Measurement(iterations = 2, timeUnit = TimeUnit.MILLISECONDS)
@Warmup(iterations = 2, timeUnit = TimeUnit.MILLISECONDS)
@Fork(value = 2, warmups = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class LoopVsStreamBenchmark {

    @Benchmark
    public void streamLoop(TestList sample, Blackhole bh) {
        Collection<Integer> ids = sample.getList().stream().map(Listable::getId).collect(Collectors.toList());
        bh.consume(ids);
    }

    @Benchmark
    public void forLoop(TestList sample, Blackhole bh) {
        Collection<Integer> ids = new ArrayList<>(sample.getList().size());
        for (Listable listable : sample.getList()) {
            ids.add(listable.getId());
        }
        bh.consume(ids);
    }

    @Benchmark
    public void streamFilterLoop(TestList sample, Blackhole bh) {
        Collection<Integer> ids = sample.getList()
                .stream()
                .filter(Listable::isEven)
                .map(Listable::getId)
                .collect(Collectors.toList());
        bh.consume(ids);
    }

    @Benchmark
    public void forFilterLoop(TestList sample, Blackhole bh) {
        Collection<Integer> ids = new ArrayList<>(sample.getList().size());
        for (Listable listable : sample.getList()) {
            if (listable.isEven()) {
                ids.add(listable.getId());
            }
        }
        bh.consume(ids);
    }

}
