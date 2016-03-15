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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @author Riccardo Solmi
 */
public class WholeImages {
    public static final Image SHARED = new Image(null, WholeImages.class.getResourceAsStream("images/shared.gif"));
    public static final Image UNSHARED = new Image(null, WholeImages.class.getResourceAsStream("images/unshared.gif"));
    public static final Image ROUND_EXPAND = new Image(null, WholeImages.class.getResourceAsStream("images/round_expand.gif"));
    public static final Image ROUND_COLLAPSE = new Image(null, WholeImages.class.getResourceAsStream("images/round_collapse.gif"));
    public static final Image ARROW_EXPAND = new Image(null, WholeImages.class.getResourceAsStream("images/arrow_expand.gif"));
    public static final Image ARROW_COLLAPSE = new Image(null, WholeImages.class.getResourceAsStream("images/arrow_collapse.gif"));
    public static final Image EXPAND = new Image(null, WholeImages.class.getResourceAsStream("images/expand.gif"));
    public static final Image COLLAPSE = new Image(null, WholeImages.class.getResourceAsStream("images/collapse.gif"));
    public static final Image COLLAPSE_ALL = new Image(null, WholeImages.class.getResourceAsStream("images/collapseall.gif"));
    public static final Image COLLAPSE_ALL_DISABLED = new Image(null, WholeImages.class.getResourceAsStream("images/collapseall_disabled.gif"));
    public static final Image OUTLINE = new Image(null, WholeImages.class.getResourceAsStream("images/outline.gif"));
    public static final Image OVERVIEW = new Image(null, WholeImages.class.getResourceAsStream("images/overview.gif"));
    public static final Image STAGE_UP = new Image(null, WholeImages.class.getResourceAsStream("images/stageUp.gif"));
    public static final Image STAGE_DOWN = new Image(null, WholeImages.class.getResourceAsStream("images/stageDown.gif"));

    public static final Image ASSIST_ERROR_OVR16 = new Image(null, WholeImages.class.getResourceAsStream("images/assist_error_ovr16.gif"));
    public static final Image ASSIST_OVR16 = new Image(null, WholeImages.class.getResourceAsStream("images/assist_ovr16.gif"));
    public static final Image ASSIST_WARNING_OVR16 = new Image(null, WholeImages.class.getResourceAsStream("images/assist_warning_ovr16.gif"));
    public static final Image BREAKPOINT_OVR16 = new Image(null, WholeImages.class.getResourceAsStream("images/breakpoint_ovr16.gif"));
    public static final Image DONE_OVR16 = new Image(null, WholeImages.class.getResourceAsStream("images/done_ovr16.gif"));
    public static final Image ERROR_OVR = new Image(null, WholeImages.class.getResourceAsStream("images/error_ovr.gif"));
    public static final Image ERROR_OVR16 = new Image(null, WholeImages.class.getResourceAsStream("images/error_ovr16.gif"));
    public static final Image HELP_OVR16 = new Image(null, WholeImages.class.getResourceAsStream("images/help_ovr16.gif"));
    public static final Image WARNING_OVR = new Image(null, WholeImages.class.getResourceAsStream("images/warning_ovr.gif"));
    public static final Image WARNING_OVR16 = new Image(null, WholeImages.class.getResourceAsStream("images/warning_ovr16.gif"));
    public static final Image NOT_ALLOWED_OVR16 = new Image(null, WholeImages.class.getResourceAsStream("images/not_allowed_ovr16.gif"));
    public static final Image INFO_OVR = new Image(null, WholeImages.class.getResourceAsStream("images/info_ovr.gif"));

    public static final Image VALIDATOR = new Image(null, WholeImages.class.getResourceAsStream("images/validator.gif"));
    public static final Image NORMALIZER = new Image(null, WholeImages.class.getResourceAsStream("images/normalizer.gif"));
    public static final Image PRETTY_PRINTER = new Image(null, WholeImages.class.getResourceAsStream("images/pretty_printer.gif"));
    public static final Image INTERPRETER = new Image(null, WholeImages.class.getResourceAsStream("images/interpreter.gif"));
    public static final Image GENERATOR = new Image(null, WholeImages.class.getResourceAsStream("images/generator.gif"));

    public static final Image INVARIANT = new Image(null, WholeImages.class.getResourceAsStream("images/invariant.gif"));
    public static final Image VALIDATE = new Image(null, WholeImages.class.getResourceAsStream("images/validate.gif"));
    public static final Image INITIALIZE = new Image(null, WholeImages.class.getResourceAsStream("images/initialize.gif"));
    public static final Image DERIVE = new Image(null, WholeImages.class.getResourceAsStream("images/derive.gif"));
    
    public static final Image LINK = new Image(null, WholeImages.class.getResourceAsStream("images/link.gif"));

    public static final Image CHOICE_SELECTED = new Image(null, WholeImages.class.getResourceAsStream("images/choice_selected.gif"));
    public static final Image CHOICE_NOT_SELECTED = new Image(null, WholeImages.class.getResourceAsStream("images/choice_not_selected.gif"));
    public static final Image CHOICE_SELECTED_DISABLED = new Image(null, WholeImages.class.getResourceAsStream("images/choice_selected_disabled.gif"));
    public static final Image CHOICE_NOT_SELECTED_DISABLED = new Image(null, WholeImages.class.getResourceAsStream("images/choice_not_selected_disabled.gif"));

    public static final ImageDescriptor EMPTY = ImageDescriptor.createFromFile(WholeImages.class, "images/empty16.gif");
    public static final ImageDescriptor RESOLVER = ImageDescriptor.createFromFile(WholeImages.class, "images/resolver16.gif");
    public static final ImageDescriptor CONNECTION = ImageDescriptor.createFromFile(WholeImages.class, "images/connection.gif");
    public static final ImageDescriptor DESC_ERROR_OVR = ImageDescriptor.createFromFile(WholeImages.class, "images/error_ovr.gif");
    public static final ImageDescriptor DESC_WARNING_OVR = ImageDescriptor.createFromFile(WholeImages.class, "images/warning_ovr.gif");

	public static final ImageDescriptor DESC_TEXT_TOOL_16 = ImageDescriptor.createFromFile(WholeImages.class, "images/text16.gif"); 
	public static final ImageDescriptor DESC_TEXT_TOOL_24 = ImageDescriptor.createFromFile(WholeImages.class, "images/text24.gif"); 

}
