package ru.pelmegov.graph.path;

import ru.pelmegov.graph.edge.Edge;
import ru.pelmegov.graph.vertex.Vertex;

import java.util.List;
import java.util.Map;

import static java.util.List.of;

/**
 * SEE PICTURE #2 - resources/directed_graph.png
 */
public class DirectedGraphData {

    Vertex<String> london = new Vertex<>("LONDON");
    Vertex<String> paris = new Vertex<>("PARIS");
    Vertex<String> brussels = new Vertex<>("BRUSSELS");
    Vertex<String> frankfurt = new Vertex<>("FRANKFURT");
    Vertex<String> amsterdam = new Vertex<>("AMSTERDAM");
    Vertex<String> cologne = new Vertex<>("COLOGNE");
    Vertex<String> vienna = new Vertex<>("VIENNA");
    Vertex<String> rome = new Vertex<>("ROME");

    Edge<String> londonToParis = new Edge<>(london, paris);
    Edge<String> amsterdamToParis = new Edge<>(amsterdam, paris);
    Edge<String> amsterdamToBrussels = new Edge<>(amsterdam, brussels);
    Edge<String> brusselsToFrankfurt = new Edge<>(brussels, frankfurt);
    Edge<String> frankfurtToAmsterdam = new Edge<>(frankfurt, amsterdam);
    Edge<String> amsterdamToCologne = new Edge<>(amsterdam, cologne);
    Edge<String> cologneToRome = new Edge<>(cologne, rome);
    Edge<String> romeToVienna = new Edge<>(rome, vienna);

    List<Edge<String>> edgesBetweenCities = of(londonToParis, amsterdamToCologne, amsterdamToParis, amsterdamToBrussels, brusselsToFrankfurt, frankfurtToAmsterdam, cologneToRome, romeToVienna);

    Map<Vertex<String>, List<Vertex<String>>> adjacencyList = Map.of(
            london, of(paris),
            amsterdam, of(paris, cologne, brussels),
            brussels, of(frankfurt),
            frankfurt, of(amsterdam),
            paris, of(),
            cologne, of(rome),
            rome, of(vienna)
    );

}
