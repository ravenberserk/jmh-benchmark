package es.ravensoft;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Getter;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@Getter
@State(Scope.Benchmark)
public class TestList {

    private Collection<Listable> list;

    @Setup(Level.Trial)
    public void setUp() {
        this.list = IntStream.range(1, 1000001).boxed().map(Listable::new).collect(Collectors.toList());
    }

    @TearDown
    public void tearDown() {
        this.list = Collections.emptyList();
    }

}