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
package org.whole.lang.reflect;

import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.model.adapters.DynamicAdaptersEntityRegistry;
import org.whole.lang.model.impl.DynamicImplEntityRegistry;
import org.whole.lang.model.impl.DynamicStrictImplEntityRegistry;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.templates.DynamicTemplateManager;
import org.whole.lang.templates.ITemplateManager;

/**
 * @author Riccardo Solmi
 */
public class DynamicLanguageKit extends AbstractLanguageKit {
	private EntityDescriptorEnum entityDescriptorEnum;
	private FeatureDescriptorEnum featureDescriptorEnum;
	private IDataTypeParser[] dataTypeParsers = new IDataTypeParser[DataTypeParsers.values().length];
	
	public static IDeployer getDeployer(final ILanguageKit languageKit) {
		return new AbstractDynamicLanguageDeployer() {
			public void deploy(ReflectionFactory platform) {
				platform.addLanguageKit(languageKit);
			}
			public void undeploy(ReflectionFactory platform) {
				platform.removeLanguageKit(languageKit.getURI());
			}
		};
	}

	public boolean isDynamic() {
		return true;
	}

	public final EntityDescriptorEnum getEntityDescriptorEnum() {
		if (entityDescriptorEnum == null)
			entityDescriptorEnum = createEntityDescriptorEnum();
		return entityDescriptorEnum;
	}
	protected EntityDescriptorEnum createEntityDescriptorEnum() {
		return new EntityDescriptorEnum();
	}

	public final FeatureDescriptorEnum getFeatureDescriptorEnum() {
		if (featureDescriptorEnum == null)
			featureDescriptorEnum = createFeatureDescriptorEnum();
		return featureDescriptorEnum;
	}
	protected FeatureDescriptorEnum createFeatureDescriptorEnum() {
		return new FeatureDescriptorEnum();
	}

	@Override
	protected IEntityRegistry createImplEntityRegistry() {
		return new DynamicImplEntityRegistry(getEntityDescriptorEnum());
	}
	@Override
	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new DynamicStrictImplEntityRegistry(getEntityDescriptorEnum());
	}
	@Override
	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new DynamicAdaptersEntityRegistry(getEntityDescriptorEnum());
	}

	public IDataTypeParser getDataTypeParser(DataTypeParsers kind) {
		IDataTypeParser parser = dataTypeParsers[kind.ordinal()];
		return parser != null ? parser : super.getDataTypeParser(kind);
	}
	public void setDataTypeParser(DataTypeParsers kind, IDataTypeParser parser) {
		dataTypeParsers[kind.ordinal()] = parser;
	}

    private ITemplateManager templateManager;
	public ITemplateManager getTemplateManager() {
		if (templateManager == null)
			templateManager = new DynamicTemplateManager(getEntityDescriptorEnum());
		return templateManager;
	}
}
