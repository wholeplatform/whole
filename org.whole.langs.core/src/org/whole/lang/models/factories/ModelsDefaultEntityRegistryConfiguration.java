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
package org.whole.lang.models.factories;

import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createResolver;
import org.whole.lang.factories.DefaultEntityRegistryConfiguration;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;

/**
 * @author Riccardo Solmi
 */
public class ModelsDefaultEntityRegistryConfiguration extends DefaultEntityRegistryConfiguration {
	public void apply(IEntityRegistry er) {
		super.apply(er);
		ModelsEntityFactory ef = ModelsEntityFactory.instance(er);

		er.put(ef.createFeature(
				ef.createFeatureModifiers(0),
				ef.createSimpleName("Type"),
				ef.createSimpleName("name"),
				createResolver(ModelsEntityDescriptorEnum.SimpleName)));
		er.put(ef.createSimpleEntity(
				ef.createEntityModifiers(0),
				ef.createSimpleName("EntityName"),
				ef.createTypes(0),
				ef.createFeatures()));
		er.put(ef.createModel(
				ef.createSimpleName("ModelName"),
				ef.createTypeRelations(0),
				ef.createModelDeclarations(ef.createSimpleEntity()),
				createResolver(ModelsEntityDescriptorEnum.Namespace),
				createResolver(ModelsEntityDescriptorEnum.Version),
				createResolver(ModelsEntityDescriptorEnum.URI)));
		er.put(ef.createCompositeEntity(
				ef.createEntityModifiers(0),
				ef.createSimpleName("EntityName"),
				ef.createTypes(0),
				ef.createComponentModifiers(0),
				ef.createSimpleName("ElementType")));
		er.put(ef.createDataEntity(
				ef.createEntityModifiers(0),
				ef.createSimpleName("EntityName"),
				ef.createTypes(0),
				ef.createDataType("String")));
		er.put(ef.createEnumEntity(
				ef.createEntityModifiers(0),
				ef.createSimpleName("EntityName"),
				ef.createTypes(0),
				ef.createEnumValues(ef.createEnumValue("ENUM_VALUE"))));
		er.put(ef.createMapEntity(
				ef.createEntityModifiers(0),
				ef.createSimpleName("EntityName"),
				ef.createTypes(0),
				ef.createSimpleName("KeyType"),
				ef.createSimpleName("ValueType")));
	}
}
