package ru.lashin.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.*;

public class Stream<T> {
    interface Action<V,P> {
        Optional<V> doAction(P element);
    }

    public final List<T> values;
    private final List<Action> actions = new ArrayList<>();


    private Stream(List<T> values) {
        this.values = values;
    }

    public static <T> Stream<T> of(List<T> values) {
        return new Stream<>(values);
    }

    public <P> Stream<P> map(Function<T, P> mapper) {
        Action<P,T> action = x-> Optional.ofNullable(mapper.apply(x));
        actions.add(action);
        return (Stream<P>) this;
    }

    public Stream<T> filter(Predicate<T> predicate) {
        Action<T, T> action = x-> {
            if (predicate.test(x)) return Optional.ofNullable(x);
            else return null;
        };
        actions.add(action);
        return this;
    }

    public T reduce(T identity, BinaryOperator<T> accumulator) {
        T result = identity;
        T value;
        for (T element : values) {
            Optional check = applyTransformations(element);
            if (check == null) continue;
            value = (T) check.orElse(null);
            result = accumulator.apply(result, value);
        }
        return result;
    }

    public <P> P collect(Supplier<P> creator, BiConsumer<T,P> collector) {
        P collection = creator.get();
        T value;
        for (T element : values) {
            Optional check = applyTransformations(element);
            if (check == null) continue;
            value = (T) check.orElse(null);
            collector.accept(value, collection);
        }
        return collection;
    }


    private Optional<?> applyTransformations(T element) {
        Optional result = Optional.ofNullable(element);
        for (Action action : actions) {
            if (result == null) break;
            result = action.doAction(result.orElse(null));
        }
        return result;
    }
}

class Test2 {
    public static void main(String[] args) {
        int res = Stream.of(List.of("12", "15", "-6", "-2"))
                .map(Integer::parseInt)
                .filter(x->x>0)
                .reduce(0, (x,y)->x+y);
        System.out.println(res);

    }
}