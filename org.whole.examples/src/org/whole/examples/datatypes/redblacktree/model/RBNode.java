package org.whole.examples.datatypes.redblacktree.model;

/** 
 * @generator Whole
 */
public interface RBNode extends IRedBlackTreeEntity {
	public Value getValue();

	public void setValue(Value value);

	public Color getColor();

	public void setColor(Color color);

	public RBNode getLeft();

	public void setLeft(RBNode left);

	public RBNode getRight();

	public void setRight(RBNode right);
}
