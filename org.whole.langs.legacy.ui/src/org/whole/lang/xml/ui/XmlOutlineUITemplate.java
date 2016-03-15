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
package org.whole.lang.xml.ui;

import static org.whole.lang.xml.reflect.XmlEntityDescriptorEnum.*;
import static org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum.*;
import static org.eclipse.jface.resource.ImageDescriptor.*;
import static org.whole.lang.ui.notations.NotationImages.*;
import static org.whole.lang.ui.templates.OutlineKinds.*;

import org.whole.lang.ui.templates.AbstractUITemplate;
import org.whole.lang.ui.templates.IOutlineBuilder;
import org.whole.lang.ui.templates.IPaletteBuilder;

/**
 * @author Riccardo Solmi
 */
public class XmlOutlineUITemplate extends AbstractUITemplate {
	protected void applyOutlineOnly(IOutlineBuilder builder) {
		builder.Template(Document, null,
				COMPOSITE_NODE, true, prolog, element);
		
		builder.Template(XMLDecl, createFromImage(XML_PI16),
				SIMPLE_NODE, true, version, encoding, standalone);
		builder.Template(DocTypeDecl, createFromImage(XML_DOCTYPE16),
				SIMPLE_NODE, true, name, externalId);

		builder.Template(Element, createFromImage(XML_ELEMENT16),
				SIMPLE_NODE, true, tag, attributes, content);
		builder.Template(Attribute, createFromImage(XML_ATTRIBUTE16),
				SIMPLE_NODE, true, name, value);
		builder.Template(CharData, createFromImage(XML_TEXT16),
				LEAF, true);
		builder.Template(CDataSect, createFromImage(XML_CDATASECT16),
				COMPOSITE_NODE, true);
		builder.Template(CDataSectData, createFromImage(XML_TEXT16),
				LEAF, true);

		builder.Template(PI, createFromImage(XML_PI16),
				SIMPLE_NODE, true, name, instruction);
		builder.Template(Comment, createFromImage(XML_COMMENT16),
				SIMPLE_NODE, true, text);
	}

	public void applyPalette(IPaletteBuilder builder) {
		//TODO
	}
}
