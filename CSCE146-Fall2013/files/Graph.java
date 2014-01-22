public class Graph {
	DLList<DSNode> nodes;
	DLList<Edge> edges;

	public Graph() {
		nodes = new DLList<DSNode>();
		edges = new DLList<Edge>();
	}
	
	public void initialize() {
		nodes.add(new DSNode("A"));
		nodes.add(new DSNode("B"));
		nodes.add(new DSNode("C"));
		nodes.add(new DSNode("D"));
		nodes.add(new DSNode("E"));
		nodes.add(new DSNode("F"));
		nodes.add(new DSNode("G"));
		
		edges.add(new Edge(nodes.get(0), nodes.get(3), 5));
		edges.add(new Edge(nodes.get(2), nodes.get(4), 5));
		edges.add(new Edge(nodes.get(3), nodes.get(5), 6));
		edges.add(new Edge(nodes.get(0), nodes.get(1), 7));
		edges.add(new Edge(nodes.get(1), nodes.get(4), 7));
		edges.add(new Edge(nodes.get(1), nodes.get(2), 8));
		edges.add(new Edge(nodes.get(4), nodes.get(5), 8));
		edges.add(new Edge(nodes.get(1), nodes.get(3), 9));
		edges.add(new Edge(nodes.get(4), nodes.get(6), 9));
		edges.add(new Edge(nodes.get(5), nodes.get(6), 11));
		edges.add(new Edge(nodes.get(3), nodes.get(4), 15));
	}
	
	public static void makeSet(DSNode x) {
		x.parent = x;
		x.rank = 0;
	}
	
	public static DSNode findSet(DSNode x) {
		if(x.parent != x) 
			x.parent = findSet(x.parent);
		return x.parent;
	}
	
	public static void Union(DSNode x, DSNode y) {
		DSNode xRoot = findSet(x);
		DSNode yRoot = findSet(y);
		
		if(!xRoot.equals(yRoot)) {
			if(xRoot.rank < yRoot.rank)
				xRoot.parent = yRoot;
			else if(xRoot.rank > yRoot.rank)
				yRoot.parent = xRoot;
			else {
				yRoot.parent = xRoot;
				xRoot.rank = xRoot.rank + 1;
			}
				
		}
	}
	
	@Override
	public String toString() {
		return "Graph [edges=" + edges + "]";
	}

	public class DSNode<T> {
		T data;
		DSNode parent;
		int rank;
		
		public DSNode(T t) {
			data = t;
		}
		
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}
	
	public class Edge {
		DSNode n1;
		DSNode n2;
		int weight;
		
		@Override
		public String toString() {
			return n1.data + "-" + n2.data + ":" + weight;
		}

		public Edge(DSNode n1, DSNode n2, int weight) {
			this.n1 = n1;
			this.n2 = n2;
			this.weight = weight;
		}
	}
}
