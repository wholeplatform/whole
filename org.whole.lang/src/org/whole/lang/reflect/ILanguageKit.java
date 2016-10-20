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

import java.util.SortedSet;

import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.events.IChangeEventHandler;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.IFragmentModel;
import org.whole.lang.operations.IOperation;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.resources.IResource;
import org.whole.lang.templates.ITemplateFactory;
import org.whole.lang.templates.ITemplateManager;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/**
 * @author Riccardo Solmi
 */
public interface ILanguageKit extends IResource {
	public boolean isDynamic();
	public boolean isCurrent();

	public IEntity getMetaModel();
	public ITemplateFactory<?> getMetaModelTemplate();
	public void setMetaModelTemplate(ITemplateFactory<?> metaModelTemplate);

	public SortedSet<IEditorKit> getEditorKits();
	public IEditorKit getDefaultEditorKit();
	public SortedSet<IPersistenceKit> getPersistenceKits();
	public IPersistenceKit getDefaultPersistenceKit();

	public String getDefaultFileExtension();
	public void setDefaultFileExtension(String extension);

	public IFragmentModel createFragmentModel();

    public EntityDescriptorEnum getEntityDescriptorEnum();
    public FeatureDescriptorEnum getFeatureDescriptorEnum();

    public IEntityRegistry getEntityRegistry(RegistryConfigurations registryConfig);
    public IDataTypeParser getDataTypeParser(DataTypeParsers kind);
	public ITemplateManager getTemplateManager();
	
	public void addReactionsHandler(IChangeEventHandler eventHandler);
	public void removeReactionsHandler(IChangeEventHandler eventHandler);
	public IChangeEventHandler getReactionsHandler();
	
	public void addBuilderFactory(String operationId, IBuilderFactory builderFactory);
	public boolean hasBuilder(String name);
	public IBuilderFactory getBuilder(String name);

	public void addVisitorFactory(String operationId, IVisitorFactory visitorFactory);
	public boolean hasVisitor(String operationId);
	public boolean hasVisitor(IOperation operation);
	public IVisitor getVisitor(IOperation operation, int stage);
}
