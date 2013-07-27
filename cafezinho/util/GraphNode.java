package cafezinho.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pdemello
 * Date: 7/27/13
 * Time: 5:18 PM CDT
 * To change this template use File | Settings | File Templates.
 */
public class GraphNode<T> {
    T data;
    List<GraphNode<T>> children;

    public GraphNode(T data) {
        this.data = data;
        children = new ArrayList<>();
    }
    public List<GraphNode<T>> getChildren() {
        return children;
    }
    public T getData() {
        return data;
    }
}
