package cafezinho.util;

import java.util.ArrayList;
import java.util.List;

/**
 * User: pdemello
 * Date: 7/27/13
 * Time: 5:18 PM CDT
 */
public class GraphNode<T> {
    T data;
    List<T> edges;

    public GraphNode(T data) {
        this.data = data;
        edges = new ArrayList<>();
    }
    public List<T> getEdges() {
        return edges;
    }
    public T getData() {
        return data;
    }
}
