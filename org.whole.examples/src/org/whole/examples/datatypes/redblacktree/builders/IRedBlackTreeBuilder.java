package org.whole.examples.datatypes.redblacktree.builders;

import org.whole.lang.builders.IBuilder;
import org.whole.examples.datatypes.redblacktree.model.ColorEnum;

/** 
 * @generator Whole
 */
public interface IRedBlackTreeBuilder extends IBuilder {
	public void visit();

	public void right();

	public void left();

	public void color();

	public void value();

	public void RBNode();

	public void RBNode_();

	public void _RBNode();

	public void Value();

	public void Value(int value);

	public void Color();

	public void Color(ColorEnum.Value value);

	public void Color(String value);
}
