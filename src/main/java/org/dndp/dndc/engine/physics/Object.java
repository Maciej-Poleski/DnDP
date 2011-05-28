/**
 * This package contains all physics-related classes.
 */
package org.dndp.dndc.engine.physics;

import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class provides basics for all physical object. Object is in
 * fact a graph with points as nodes.
 * 
 * @author evil
 * 
 */
public abstract class Object {
	public class Node {
		private final Point point;
		private List<Edge> edges;

		/**
		 * @param point
		 */
		public Node(Point point) {
			this.point = point;
			this.edges = null;
		}

		/**
		 * @return the edges
		 */
		public List<Edge> getEdges() {
			return edges;
		}

		/**
		 * @param edges
		 *            the edges to set
		 */
		public void setEdges(List<Edge> edges) {
			this.edges = edges;
		}

		/**
		 * @return the point
		 */
		public Point getPoint() {
			return point;
		}

		public void addEdge(Edge edge) {
			if (edges == null)
				edges = new ArrayList<Object.Edge>();
			edges.add(edge);
		}
	}

	public class Edge {
		private final Node destination;

		/**
		 * @param destination
		 */
		public Edge(Node destination) {
			this.destination = destination;
		}

		/**
		 * @return the destination
		 */
		public Node getDestination() {
			return destination;
		}

	}

	List<Node> nodes;

	/**
	 * Initialize Object stub. You must add some points to get real object.
	 * 
	 * @param nodes
	 */
	public Object() {
		this.nodes = null;
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean addPoint(Point e) {
		if (nodes == null)
			nodes = new ArrayList<Object.Node>();
		if (contains(e))
			return false;
		return nodes.add(new Node(e));
	}

	/**
	 * [PL] Dodaje krawędź między zadanymi punktami.
	 * 
	 * @param a
	 * @param b
	 */
	public void addEdge(Point a, Point b) {
		if (a == null || b == null)
			throw new IllegalArgumentException("Point mustn't be null");
		Node aNode = getNode(a);
		Node bNode = getNode(b);
		if (aNode == null || bNode == null)
			throw new IllegalArgumentException("Points must exist in graph");
		aNode.addEdge(new Edge(bNode));
		bNode.addEdge(new Edge(aNode));
	}

	/**
	 * [PL] Dodaje obiekt do Obiektu (powiększa graf punktów o punky innego
	 * obiektu przesunięte i rotowane łącznie z krawędziami.
	 * 
	 * @param object
	 *            Obiekt który zostanie dołączony
	 * @param O
	 *            Przesunięcie środka układu współrzędnych obiektu object.
	 * @param rotation
	 *            Rotacja w odpowiadających współrzędnych obiektu object.
	 */
	public void addObject(Object object, Point O, Point rotation) {
		// FIXME TODO Zaimplementować te funkcje SOLIDNIE.
		throw new UnsupportedOperationException(
				"Metoda engine.phisics.Object.addObject(Object,Point,Point) Nie została zaimplementowana.");
	}

	public final double getDistance(Measurable measure) {
		if (nodes == null)
			throw new IllegalStateException(
					"Unable to get size of non-existent object");
		if (nodes.size() < 2)
			throw new IllegalStateException(
					"Unable to get size of non-size object");
		Point a, b;
		a = b = nodes.get(0).getPoint();
		for (Node node : nodes) {
			if (Point.distanceBetween(a, b, measure) < Point
					.distanceBetween(a, node.getPoint(), measure))
				b = node.getPoint();
		}
		{
			Point c = a;
			a = b;
			b = c;
		}
		for (Node node : nodes) {
			if (Point.distanceBetween(a, b, measure) < Point
					.distanceBetween(a, node.getPoint(), measure))
				b = node.getPoint();
		}
		return Point.distanceBetween(a, b, measure);
	}

	/**
	 * 
	 * @see java.util.List#clear()
	 */
	public void clear() {
		nodes.clear();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#contains(java.lang.Object)
	 */
	public boolean contains(java.lang.Object o) {
		return nodes.contains(o);
	}

	public boolean contains(Point point) {
		for (Node node : nodes) {
			if (node.getPoint().equals(point))
				return true;
		}
		return false;
	}

	/**
	 * @param index
	 * @return
	 * @see java.util.List#get(int)
	 */
	public Node get(int index) {
		return nodes.get(index);
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	public int indexOf(java.lang.Object o) {
		return nodes.indexOf(o);
	}

	/**
	 * Return Point as Node.
	 */
	private Node getNode(Point p) {
		for (Node node : nodes) {
			if (node.getPoint().equals(p))
				return node;
		}
		return null;
	}

	/**
	 * @return
	 * @see java.util.List#isEmpty()
	 */
	public boolean isEmpty() {
		return nodes.isEmpty();
	}

	/**
	 * @param index
	 * @return
	 * @see java.util.List#remove(int)
	 */
	public Node remove(int index) {
		return nodes.remove(index);
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean remove(java.lang.Object o) {
		return nodes.remove(o);
	}

	/**
	 * @return
	 * @see java.util.List#size()
	 */
	public int size() {
		return nodes.size();
	}

}
