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
package org.whole.lang.e4.ui.menu;

import org.whole.lang.ui.IUIBuilder;
import org.whole.lang.ui.IUIProvider;

/**
 * @author Enrico Persiani
 */
public class PopupMenuProvider<I, C extends I> implements IUIProvider<C> {
	private IUIBuilder<I, C> uiBuilder;

	public PopupMenuProvider(IUIBuilder<I, C> uiBuilder) {
		this.uiBuilder = uiBuilder;
	}

	@Override
	public void populate(C menu) {
		uiBuilder.setContainer(menu);
		uiBuilder.before();

		uiBuilder.addUndoItem();
		uiBuilder.addRedoItem();

		uiBuilder.addSeparator();

		uiBuilder.addCutItem();
		uiBuilder.addCopyItem();
		uiBuilder.addCopyEntityPathItem();
		uiBuilder.addCopyAsImageItem();
		uiBuilder.addPasteItem();
		uiBuilder.addPasteAsItem();

		uiBuilder.addSeparator();

		uiBuilder.addRemoveItem();
		uiBuilder.addSelectAllItem();

		uiBuilder.addSeparator();

		uiBuilder.addContentAssistItem();
		uiBuilder.addEntityAssistItem();
		uiBuilder.addFeatureAssistItem();

		uiBuilder.addSeparator();

		uiBuilder.addSourceItem();
		uiBuilder.addRefactorItem();
		uiBuilder.addTranslateItem();
		uiBuilder.addAnalyzeItem();
		uiBuilder.addMigrateItem();

		uiBuilder.addSeparator();

		uiBuilder.addImportItem();

		uiBuilder.addNotationsItem();

		uiBuilder.after();
	}
}
