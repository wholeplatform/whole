package org.whole.lang.unifiedlambdadelta.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaFeatureDescriptorEnum;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaSpecificBuilderAdapter extends
		GenericBuilderContext implements IUnifiedLambdaDeltaBuilder {
	public UnifiedLambdaDeltaSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public UnifiedLambdaDeltaSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void postfix() {
		wFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.postfix);
	}

	public void prefix() {
		wFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.prefix);
	}

	public void access() {
		wFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.access);
	}

	public void level() {
		wFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.level);
	}

	public void index() {
		wFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.index);
	}

	public void back() {
		wFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.back);
	}

	public void front() {
		wFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.front);
	}

	public void polarity() {
		wFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity);
	}

	public void name() {
		wFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.name);
	}

	public void visit() {
	}

	public void Declaration() {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Declaration);
	}

	public void Declaration_() {
		wEntity_(UnifiedLambdaDeltaEntityDescriptorEnum.Declaration);
	}

	public void _Declaration() {
		_wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Declaration);
	}

	public void Definition() {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Definition);
	}

	public void Definition_() {
		wEntity_(UnifiedLambdaDeltaEntityDescriptorEnum.Definition);
	}

	public void _Definition() {
		_wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Definition);
	}

	public void Top() {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Top);
	}

	public void Top_() {
		wEntity_(UnifiedLambdaDeltaEntityDescriptorEnum.Top);
	}

	public void _Top() {
		_wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Top);
	}

	public void Application() {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Application);
	}

	public void Application_() {
		wEntity_(UnifiedLambdaDeltaEntityDescriptorEnum.Application);
	}

	public void _Application() {
		_wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Application);
	}

	public void Cast() {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Cast);
	}

	public void Cast_() {
		wEntity_(UnifiedLambdaDeltaEntityDescriptorEnum.Cast);
	}

	public void _Cast() {
		_wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Cast);
	}

	public void Abstraction() {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Abstraction);
	}

	public void Abstraction_() {
		wEntity_(UnifiedLambdaDeltaEntityDescriptorEnum.Abstraction);
	}

	public void _Abstraction() {
		_wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Abstraction);
	}

	public void Abbreviation() {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Abbreviation);
	}

	public void Abbreviation_() {
		wEntity_(UnifiedLambdaDeltaEntityDescriptorEnum.Abbreviation);
	}

	public void _Abbreviation() {
		_wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Abbreviation);
	}

	public void Local() {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Local);
	}

	public void Local_() {
		wEntity_(UnifiedLambdaDeltaEntityDescriptorEnum.Local);
	}

	public void _Local() {
		_wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Local);
	}

	public void Sort() {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Sort);
	}

	public void Sort_() {
		wEntity_(UnifiedLambdaDeltaEntityDescriptorEnum.Sort);
	}

	public void _Sort() {
		_wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Sort);
	}

	public void Polarity() {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Polarity);
	}

	public void Polarity(boolean value) {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Polarity, value);
	}

	public void Index() {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Index);
	}

	public void Index(int value) {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Index, value);
	}

	public void Level() {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Level);
	}

	public void Level(int value) {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Level, value);
	}

	public void Name() {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Name);
	}

	public void Name_() {
		wEntity_(UnifiedLambdaDeltaEntityDescriptorEnum.Name);
	}

	public void _Name() {
		_wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Name);
	}

	public void Access() {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Access);
	}

	public void Access(boolean value) {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Access, value);
	}

	public void Prefix() {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Prefix);
	}

	public void Prefix(String value) {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Prefix, value);
	}

	public void Postfix() {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Postfix);
	}

	public void Postfix(int value) {
		wEntity(UnifiedLambdaDeltaEntityDescriptorEnum.Postfix, value);
	}
}
