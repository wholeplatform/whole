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
package org.whole.lang.ui;

import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Enrico Persiani
 */
public interface IUIBuilder<I, C extends I> {
	public C getContainer();
	public C setContainer(C container);

	public void before();
	public void after();

	public void addSeparator();
	public void addSeparator(String groupName);
	public void addGroupMarker(String groupName);

	public void addUndoItem();
	public void addRedoItem();

	public void addCutItem();
	public void addCopyItem();
	public void addCopyEntityPathItem();
	public void addCopyAsImageItem();
	public void addPasteItem();
	public void addPasteAsItem();

	public void addSelectAllItem();
	
	public void addContentAssistItem();
	public void addEntityAssistItem();
	public void addFeatureAssistItem();

	public void addSourceItem();
	public void addRefactorItem();
	public void addTranslateItem();
	public void addAnalyzeItem();
	public void addMigrateItem();

	public void addNotationsItem();
	public void addImportItem();

	public void addDefaultItem();
	public void addDeleteItem();
	public void addRemoveItem();

	public void addReplaceEntityItem(EntityDescriptor<?> ed);
	public void addAddEntityItem(EntityDescriptor<?> ed);
}
