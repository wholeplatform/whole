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
package org.whole.lang.semantics.factories;

import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.*;
import org.whole.lang.factories.DefaultEntityRegistryConfiguration;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;

/**
 * @author Riccardo Solmi
 */
public class SemanticsDefaultEntityRegistryConfiguration extends DefaultEntityRegistryConfiguration {
	public void apply(IEntityRegistry er) {
		super.apply(er);
		SemanticsEntityFactory ef = SemanticsEntityFactory.instance(er);
		
		er.put(ef.createProductType(2));
		er.put(ef.createUnionType(2));
		er.put(ef.createChooseTemplate(2));
		er.put(ef.createInputBindings(2));
		er.put(ef.createOutputBindings(2));
		er.put(ef.createRenameGroup(2));
		er.put(ef.createRules(1));
		er.put(ef.createBindingsScope(
				ef.createStructuredVariable(ef.createVariable("env"),
						createResolver(SemanticsEntityDescriptorEnum.Num),
						createResolver(SemanticsEntityDescriptorEnum.Num)),
				ef.createLocalBindings(0),
				createResolver(SemanticsEntityDescriptorEnum.BindingsScope)));
		er.put(ef.createEnvironmentVariable(
				ef.createStructuredVariable(ef.createVariable("env"),
						createResolver(SemanticsEntityDescriptorEnum.Num),
						createResolver(SemanticsEntityDescriptorEnum.Num)),
				ef.createStructuredVariable(ef.createVariable("var"),
						createResolver(SemanticsEntityDescriptorEnum.Num),
						createResolver(SemanticsEntityDescriptorEnum.Num))));
		er.put(ef.createSemanticFunction(
				ef.createName("functionName"),
				ef.createFunctionType(ef.createAnyType(), ef.createAnyType()),
				ef.createRules(
						ef.createExecutionRule())));
	}
}
