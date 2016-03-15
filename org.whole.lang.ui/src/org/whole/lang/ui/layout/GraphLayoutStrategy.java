/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.ui.layout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.graph.CompoundDirectedGraph;
import org.eclipse.draw2d.graph.CompoundDirectedGraphLayout;
import org.eclipse.draw2d.graph.DirectedGraph;
import org.eclipse.draw2d.graph.Edge;
import org.eclipse.draw2d.graph.EdgeList;
import org.eclipse.draw2d.graph.Node;
import org.eclipse.draw2d.graph.NodeList;
import org.eclipse.draw2d.graph.Subgraph;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;

/**
 * @author Riccardo Solmi
 */
public class GraphLayoutStrategy implements ILayoutStrategy {
	protected boolean translated = false; //true = leftRight; false = topDown
	
	public void layout(GraphicalEditPart containerPart) {
		CompoundDirectedGraph graph = new CompoundDirectedGraph();
		List<?> parts = containerPart.getChildren();
		
		buildGraph(graph, parts);
		calculateLayout(graph);
		applyLayout(graph); //TODO optional command based
	}
	
	public void calculateLayout(DirectedGraph graph) {
		new CompoundDirectedGraphLayout().visit(graph);
	}
	
	public void applyLayout(DirectedGraph graph) {
		NodeList nodes = graph.nodes;
		for (int i=0; i<nodes.size(); i++) {
			Node node = (Node) nodes.get(i);
			GraphicalEditPart part = (GraphicalEditPart) node.data;
			
			part.getFigure().setBounds(new Rectangle(node.x, node.y, node.width, node.height));
		}
		
		EdgeList edges = graph.edges;
		for (int i=0; i<edges.size(); i++) {
			Edge edge = (Edge) edges.get(i);
			ConnectionEditPart connectionPart = (ConnectionEditPart) edge.data;
			nodes = edge.vNodes;

			PolylineConnection conn = (PolylineConnection) connectionPart.getFigure();
			if (nodes != null) {
				List<AbsoluteBendpoint> bends = new ArrayList<AbsoluteBendpoint>();
				for (int j=0; j<nodes.size(); j++) {
					Node vn = nodes.getNode(j);
					if (edge.isFeedback) {
						bends.add(new AbsoluteBendpoint(vn.x, vn.y+vn.height));
						bends.add(new AbsoluteBendpoint(vn.x, vn.y));
					} else {
						bends.add(new AbsoluteBendpoint(vn.x, vn.y));
						bends.add(new AbsoluteBendpoint(vn.x, vn.y+vn.height));
					}
				}
				conn.setRoutingConstraint(bends);
			} else
				conn.setRoutingConstraint(Collections.EMPTY_LIST);
		}
	}
//	public void applyLayout(Map partNodeMap, List parts) {
//		for (Iterator i = parts.iterator(); i.hasNext();) {
//			GraphicalEditPart part = (GraphicalEditPart) i.next();
//			Node node = (Node) partNodeMap.get(part);
//			
//			part.getFigure().setBounds(new Rectangle(node.x, node.y, node.width, node.height));
//
//			List connectionParts = part.getSourceConnections();
//			for (Iterator j = connectionParts.iterator(); j.hasNext();) {
//				ConnectionEditPart connectionPart = (ConnectionEditPart) j.next();
//				Edge edge = (Edge) partNodeMap.get(connectionPart);
//				NodeList nodes = edge.vNodes;
//
//				PolylineConnection conn = (PolylineConnection) connectionPart.getFigure();
//				if (nodes != null) {
//					List bends = new ArrayList();
//					for (int k=0; k<nodes.size(); k++) {
//						Node vn = nodes.getNode(k);
//						if (edge.isFeedback) {
//							bends.add(new AbsoluteBendpoint(vn.x, vn.y+vn.height));
//							bends.add(new AbsoluteBendpoint(vn.x, vn.y));
//						} else {
//							bends.add(new AbsoluteBendpoint(vn.x, vn.y));
//							bends.add(new AbsoluteBendpoint(vn.x, vn.y+vn.height));
//						}
//					}
//					conn.setRoutingConstraint(bends);
//				} else
//					conn.setRoutingConstraint(Collections.EMPTY_LIST);
//			}
//			
//			if (isStructuredPart(part))
//				applyLayout(partNodeMap, part.getChildren());
//		}	
//	}
	
	public void buildGraph(DirectedGraph graph, List parts) {
		Map partNodeMap = new HashMap(1024);

		buildNodes(graph, null, parts, partNodeMap);
		buildEdges(graph, parts, partNodeMap);
	}
	
	public void buildNodes(DirectedGraph graph, Subgraph subgraph, List<GraphicalEditPart> parts, Map partNodeMap) {
		for (Iterator<GraphicalEditPart> i = parts.iterator(); i.hasNext();) {
			GraphicalEditPart part = i.next();
			
			if (isStructuredPart(part)) {
				Subgraph node = createSubgraph(part, subgraph);
				partNodeMap.put(part, node);
				graph.nodes.add(node);

				buildNodes(graph, node, part.getChildren(), partNodeMap);
			} else {
				Node node = createNode(part, subgraph);
				partNodeMap.put(part, node);
				graph.nodes.add(node);
			}
		}
	}
	protected boolean isStructuredPart(GraphicalEditPart part) {
		return part.getContentPane() != part.getFigure();
	}

	protected Subgraph createSubgraph(GraphicalEditPart part, Subgraph subgraph) {
		Subgraph node = new Subgraph(part, subgraph);
		//TODO padding and bounds
		return node;
	}
	protected Node createNode(GraphicalEditPart part, Subgraph subgraph) {
		final int NODE_PADDING = 30;
	
		Node node = new Node(part, subgraph);
		node.setPadding(new Insets(NODE_PADDING));
		setNodeBounds(node, part.getFigure().getBounds());				
		return node;
	}
	protected void setNodeBounds(Node node, Rectangle bounds) {
		if (translated) {
			node.x = bounds.y;
			node.y = bounds.x;
			node.width = bounds.height;
			node.height = bounds.width;
		} else {
			node.x = bounds.x;
			node.y = bounds.y;
			node.width = bounds.width;
			node.height = bounds.height;			
		}
	}
	
	//TODO supporto edges without parts (ex. intra Sequence connections)
	public void buildEdges(DirectedGraph graph, List parts, Map partNodeMap) {
		for (int i=0; i<parts.size(); i++) {
			GraphicalEditPart part = (GraphicalEditPart) parts.get(i);
			
			List<?> connectionParts = part.getSourceConnections();
			for (int j=0; j<connectionParts.size(); j++) {
				ConnectionEditPart connectionPart = (ConnectionEditPart) connectionParts.get(j);
				Node source = (Node) partNodeMap.get(connectionPart.getSource());
				Node target = (Node) partNodeMap.get(connectionPart.getTarget());
				
				Edge edge = createEdge(connectionPart, source, target);
				
				partNodeMap.put(connectionPart, edge);
				graph.edges.add(edge);
			}
			
			buildEdges(graph, part.getChildren(), partNodeMap);
		}
	}
	protected Edge createEdge(ConnectionEditPart part, Node source, Node target) {
		Edge edge = new Edge(part, source, target);
		//TODO weight
		return edge;
	}
}
