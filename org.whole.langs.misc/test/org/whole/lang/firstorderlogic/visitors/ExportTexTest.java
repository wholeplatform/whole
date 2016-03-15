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
package org.whole.lang.firstorderlogic.visitors;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.models.codebase.FirstOrderLogicModel;
import org.whole.lang.models.codebase.RDFModel;
import org.whole.lang.models.codebase.TopicMapsModel;
import org.whole.lang.operations.ExportTexOperation;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Riccardo Solmi
 */
public class ExportTexTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Test
    public void testExportTex() {
    	System.out.print(ExportTexOperation.export(
    			new FirstOrderLogicModel().create(), true));

    	System.out.print(ExportTexOperation.export(
    			new RDFModel().create(), false));

    	System.out.print(ExportTexOperation.export(
    			new TopicMapsModel().create(), false));
    }
}
