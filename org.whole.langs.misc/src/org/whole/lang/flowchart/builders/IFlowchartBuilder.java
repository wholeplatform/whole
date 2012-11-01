package org.whole.lang.flowchart.builders;

import org.whole.lang.builders.IBuilder;

/** 
 * @generator Whole
 */
public interface IFlowchartBuilder extends IBuilder {
	public void visit();

	public void targetTransitions();

	public void falseSourceTransition();

	public void trueSourceTransition();

	public void targetTransition();

	public void sourceTransition();

	public void description();

	public void height();

	public void width();

	public void y();

	public void x();

	public void label();

	public void target();

	public void source();

	public void transitions();

	public void nodes();

	public void Flowchart();

	public void Flowchart_();

	public void _Flowchart();

	public void Nodes();

	public void Nodes_();

	public void Nodes_(int initialCapacity);

	public void _Nodes();

	public void Transitions();

	public void Transitions_();

	public void Transitions_(int initialCapacity);

	public void _Transitions();

	public void SimpleTransition();

	public void SimpleTransition_();

	public void _SimpleTransition();

	public void LabeledTransition();

	public void LabeledTransition_();

	public void _LabeledTransition();

	public void Pixels();

	public void Pixels(int value);

	public void Text();

	public void Text(String value);

	public void Entry();

	public void Entry_();

	public void _Entry();

	public void Exit();

	public void Exit_();

	public void _Exit();

	public void Block();

	public void Block_();

	public void _Block();

	public void Choice();

	public void Choice_();

	public void _Choice();

	public void Join();

	public void Join_();

	public void _Join();
}
