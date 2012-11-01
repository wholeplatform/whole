package org.whole.lang.unifiedlambdadelta.builders;

import org.whole.lang.builders.IBuilder;

/** 
 * @generator Whole
 */
public interface IUnifiedLambdaDeltaBuilder extends IBuilder {
	public void visit();

	public void postfix();

	public void prefix();

	public void access();

	public void level();

	public void index();

	public void back();

	public void front();

	public void polarity();

	public void name();

	public void Declaration();

	public void Declaration_();

	public void _Declaration();

	public void Definition();

	public void Definition_();

	public void _Definition();

	public void Top();

	public void Top_();

	public void _Top();

	public void Application();

	public void Application_();

	public void _Application();

	public void Cast();

	public void Cast_();

	public void _Cast();

	public void Abstraction();

	public void Abstraction_();

	public void _Abstraction();

	public void Abbreviation();

	public void Abbreviation_();

	public void _Abbreviation();

	public void Local();

	public void Local_();

	public void _Local();

	public void Sort();

	public void Sort_();

	public void _Sort();

	public void Polarity();

	public void Polarity(boolean value);

	public void Index();

	public void Index(int value);

	public void Level();

	public void Level(int value);

	public void Name();

	public void Name_();

	public void _Name();

	public void Access();

	public void Access(boolean value);

	public void Prefix();

	public void Prefix(String value);

	public void Postfix();

	public void Postfix(int value);
}
