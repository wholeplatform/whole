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
package org.whole.lang.ui.actions;

import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.ui.util.UIUtils;

/**
 * @author Enrico Persiani
 */
public interface IActionConstants {
	public static final ImageDescriptor INSERT_ICON = UIUtils.getImageDescriptor("icons/actions/insert.gif");
	public static final ImageDescriptor REPLACE_ICON = UIUtils.getImageDescriptor("icons/actions/replace.gif");
	public static final ImageDescriptor WRAP_ICON = UIUtils.getImageDescriptor("icons/actions/wrap.gif");
	public static final ImageDescriptor TEXT_ICON = UIUtils.getImageDescriptor("icons/actions/text.gif");
	public static final ImageDescriptor SELECT_STAGE_ICON = UIUtils.getImageDescriptor("icons/actions/select_stage.gif");
	public static final ImageDescriptor SELECT_LANGUAGE_ICON = UIUtils.getImageDescriptor("icons/actions/select_language.gif");
	public static final ImageDescriptor SELECT_PERSISTENCE_ICON = UIUtils.getImageDescriptor("icons/actions/select_persistence.gif");
	public static final ImageDescriptor IMPORT_FRAGMENT_ICON = UIUtils.getImageDescriptor("icons/actions/import_fragment.gif");
}
