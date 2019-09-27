package ru.pelmegov.graph.vertex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Vertex<T> {

    private T value;

}
