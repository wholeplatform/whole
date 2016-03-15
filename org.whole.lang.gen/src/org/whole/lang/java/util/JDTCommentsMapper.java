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
package org.whole.lang.java.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Comment;
import org.eclipse.jdt.core.dom.Javadoc;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public class JDTCommentsMapper {
	private String source;
	private List<Comment> comments;
	private IEntity orphanComments;

	public JDTCommentsMapper(String source) {
		this.source = source;
		this.comments = Collections.emptyList();
		this.orphanComments = BindingManagerFactory.instance.createTuple();
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments != null ? new ArrayList<Comment>(comments) : Collections.<Comment>emptyList();
	}
	public boolean removeJavadoc(Javadoc comment) {
		return comments.remove(comment);
	}
	public void appendOrphanCommentsToBlock(IEntity block) {
		IEntityIterator<IEntity> iterator = IteratorFactory.childIterator();
		iterator.reset(orphanComments);
		for (IEntity child : iterator) {
			block.wAdd(child);
			iterator.remove();
		}
	}
	public void addOrphanComment(IEntity comment) {
		orphanComments.wAdd(comment);
	}

	protected String sourceSubString(int beginIndex, int endIndex) {
		return source != null ? source.substring(beginIndex, endIndex) : "";
	}
	protected boolean isAdjacentTo(ASTNode node, ASTNode toNode, boolean newLinesAllowed) {
		int nodeEnd = node.getStartPosition()+node.getLength();
		int toNodeStart = toNode.getStartPosition();
		return isAdjacentTo(nodeEnd, toNodeStart, newLinesAllowed);
	}
	protected boolean isAdjacentTo(int from, int to, boolean newLinesAllowed) {
		if (from > to)
			return false;
		String betweenText = sourceSubString(from, to);
		for (char c : betweenText.toCharArray())
			if (!Character.isWhitespace(c) || (!newLinesAllowed && StringUtils.isNewLineChar(c)))
				return false;
		return true;
	}
	protected boolean isLineComment(Comment comment) {
		return comment.getNodeType() == ASTNode.LINE_COMMENT ||
		!containsNewLineChar(getText(comment));
	}

	public List<Comment> extractNodeComments(ASTNode node) {
		List<Comment> extracted = new ArrayList<Comment>();
		boolean findAdjacentComment = false;
		ASTNode prevNode = node;

		// search backward
		int i=comments.size();
		while (--i >=0) {
			Comment comment = comments.get(i);
			// look for a following comment line
			if (!findAdjacentComment && isLineComment(comment) && isAdjacentTo(node, comment, false)) {
				extracted.add(0, comment);
				comments.remove(i);
			} else if (isAdjacentTo(comment, prevNode, true)) {
				prevNode = comment;
				extracted.add(0, comment);
				comments.remove(i);
				findAdjacentComment = true;
			} else if (findAdjacentComment)
				break;
		}
		return extracted;
	}

	public List<Comment> extractContainerComments(ASTNode container) {
		List<Comment> extracted = new ArrayList<Comment>();
		Comment node = null;

		int i=comments.size();
		while (--i>=0) {
			Comment comment = comments.get(i);
			if (node == null) {
				int from = comment.getStartPosition()+comment.getLength();
				int to = container.getStartPosition()+container.getLength()-1;
				if (isAdjacentTo(from, to, true)) {
					extracted.add(0, node = comment);
					comments.remove(i);
				}
			} else if (isAdjacentTo(comment, node, true)) {
				extracted.add(0, node = comment);
				comments.remove(i);
			} else
				break;
		}
		return extracted;
	}

	public String getText(Comment comment) {
		int start = comment.getStartPosition();
		switch (comment.getNodeType()) {
		case ASTNode.LINE_COMMENT:
			return sourceSubString(start+2, start+comment.getLength());
		case ASTNode.BLOCK_COMMENT:
			return sourceSubString(start+2, start+comment.getLength()-2);
		case ASTNode.JAVADOC:
		default:
			return sourceSubString(start+3, start+comment.getLength()-2);
		}
	}
	public static boolean containsNewLineChar(String s) {
		for (int i=0; i<s.length(); i++)
			if (StringUtils.isNewLineChar(s.charAt(i)))
				return true;
		return false;
	}
	public Javadoc getPackageJavadoc() {
		Comment comment;
		if (comments.isEmpty() || (comment = comments.get(0)).getNodeType() != ASTNode.JAVADOC)
			return null;

		String text = sourceSubString(0, comment.getStartPosition());
		return text.matches("\\p{javaWhitespace}*") ? 
				(Javadoc) comment : null;
	}
}
