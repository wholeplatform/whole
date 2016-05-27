package org.whole.lang.commons.factories;

import org.whole.lang.commons.model.QuantifierEnum;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.factories.AbstractEntityRegistryConfiguration;
import org.whole.lang.factories.IEntityRegistry;

/** 
 * @author Riccardo Solmi
 */
public class CommonsDefaultEntityRegistryConfiguration extends AbstractEntityRegistryConfiguration {
	@Override
	public void apply(IEntityRegistry er) {
		super.apply(er);
		CommonsEntityFactory ef = CommonsEntityFactory.instance(er);

		er.put(ef.createPhase("phase"));
		er.put(ef.createVarName("varName"));
		er.put(ef.createVarType(CommonsEntityDescriptorEnum.Any));
		er.put(ef.createQuantifier(QuantifierEnum.MANDATORY));
		er.put(ef.createVariable(ef.createVarType(), ef.createVarName(), ef.createQuantifier()));
		er.put(ef.createInlineVariable(ef.createVarType(), ef.createVarName(), ef.createQuantifier()));
		er.put(ef.createRootFragment(ef.createResolver()));
		er.put(ef.createStageUpFragment(ef.createResolver()));
		er.put(ef.createSameStageFragment(ef.createResolver()));
		er.put(ef.createStageDownFragment(ef.createResolver()));
		er.put(ef.createBaseFragment(ef.createResolver().wGetAdapter(CommonsEntityDescriptorEnum.Phase), ef.createResolver()));
		er.put(ef.createTemplateFragment(ef.createResolver().wGetAdapter(CommonsEntityDescriptorEnum.Phase), ef.createResolver()));
	}
}