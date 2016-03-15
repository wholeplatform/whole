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
package org.whole.lang.xsd.factories;

import org.whole.lang.factories.DefaultEntityRegistryConfiguration;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.xsd.model.Annotation;
import org.whole.lang.xsd.model.ComplexTypeDef;

public class XsdDefaultEntityRegistryConfiguration extends DefaultEntityRegistryConfiguration {
	public void apply(IEntityRegistry er) {
		super.apply(er);
		XsdEntityFactory xf = XsdEntityFactory.instance(er);
		
		Annotation annotation = xf.createAnnotation();
		annotation.setList(xf.createAnnotationList(0));
		er.put(annotation);

		ComplexTypeDef complexTypeDef = xf.createComplexTypeDef();
		complexTypeDef.setContent(xf.createDeclaredContent());
		er.put(complexTypeDef);
	}
}
