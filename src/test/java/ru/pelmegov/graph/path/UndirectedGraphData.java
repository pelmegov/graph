package ru.pelmegov.graph.path;

import ru.pelmegov.graph.edge.Edge;
import ru.pelmegov.graph.vertex.Vertex;

import java.util.List;
import java.util.Map;

import static java.util.List.of;

/**
 * SEE PICTURE #1 - resources/undirected_graph.png
 */
public class UndirectedGraphData {

    Vertex<String> london = new Vertex<>("LONDON");
    Vertex<String> paris = new Vertex<>("PARIS");
    Vertex<String> brussels = new Vertex<>("BRUSSELS");
    Vertex<String> frankfurt = new Vertex<>("FRANKFURT");
    Vertex<String> amsterdam = new Vertex<>("AMSTERDAM");
    Vertex<String> cologne = new Vertex<>("COLOGNE");
    Vertex<String> vienna = new Vertex<>("VIENNA");
    Vertex<String> rome = new Vertex<>("ROME");

    Edge<String> londonToParis = new Edge<>(london, paris);
    Edge<String> parisToBrussels = new Edge<>(paris, brussels);
    Edge<String> brusselsToFrankfurt = new Edge<>(brussels, frankfurt);
    Edge<String> brusselsToAmsterdam = new Edge<>(brussels, amsterdam);
    Edge<String> amsterdamToCologne = new Edge<>(amsterdam, cologne);
    Edge<String> cologneToVienna = new Edge<>(cologne, vienna);
    Edge<String> viennaToRome = new Edge<>(vienna, rome);

    List<Edge<String>> edgesBetweenCities = of(londonToParis, parisToBrussels, brusselsToFrankfurt, brusselsToAmsterdam, amsterdamToCologne, cologneToVienna, viennaToRome);

    Map<Vertex<String>, List<Vertex<String>>> adjacencyList = Map.of(
            london, of(paris),
            paris, of(brussels, london),
            brussels, of(frankfurt, amsterdam, paris),
            frankfurt, of(brussels),
            amsterdam, of(cologne, brussels),
            cologne, of(vienna, amsterdam),
            vienna, of(rome, cologne),
            rome, of(vienna)
    );

}
