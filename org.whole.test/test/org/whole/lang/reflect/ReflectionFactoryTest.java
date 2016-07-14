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

import java.util.Collection;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.whole.lang.commons.reflect.CommonsLanguageDeployer;
import org.whole.lang.models.reflect.ModelsLanguageDeployer;
import org.whole.lang.ui.notations.tree.TreeUIDeployer;
import org.whole.lang.xml.reflect.XmlLanguageKit;
import org.whole.lang.xml.ui.XmlTextualEditorKit;

/**
 * @author Riccardo Solmi
 */
public class ReflectionFactoryTest {
    @Before
    public synchronized void deployWholePlatform() {
    	ReflectionFactory.undeployWholePlatform();
    	ReflectionFactory.undeploy(new AbstractLanguageDeployer() {
			public void deploy(ReflectionFactory platform) {
			}
			public void undeploy(ReflectionFactory platform) {
				Collection<IEditorKit> editorKits = ReflectionFactory.getEditorKits();
				for (IEditorKit ek : new HashSet<>(editorKits))
					platform.removeEditorKit(ek.getId());
			}
		});
    }

	@Test
	public synchronized void testDeploy() {
		int languageKitsSize = ReflectionFactory.getLanguageKits(true).size();
		int editorKitsSize = ReflectionFactory.getEditorKits().size();

		ReflectionFactory.deploy(CommonsLanguageDeployer.class);
		ReflectionFactory.deploy(ModelsLanguageDeployer.class);
		ReflectionFactory.deploy(TreeUIDeployer.class);

		Assert.assertEquals(languageKitsSize+2, ReflectionFactory.getLanguageKits(true).size());
		Assert.assertEquals(editorKitsSize+4, ReflectionFactory.getEditorKits().size());

		ReflectionFactory.deploy(CommonsLanguageDeployer.class);
		ReflectionFactory.deploy(ModelsLanguageDeployer.class);
		ReflectionFactory.deploy(TreeUIDeployer.class);

		Assert.assertEquals(languageKitsSize+2, ReflectionFactory.getLanguageKits(true).size());
		Assert.assertEquals(editorKitsSize+4, ReflectionFactory.getEditorKits().size());

		ReflectionFactory.undeploy(ModelsLanguageDeployer.class);
		ReflectionFactory.undeploy(TreeUIDeployer.class);

		Assert.assertEquals(languageKitsSize+1, ReflectionFactory.getLanguageKits(true).size());
		Assert.assertEquals(editorKitsSize, ReflectionFactory.getEditorKits().size());
	}

	@Test
	public synchronized void testAddLanguageKit() {
		int languageKitsSize = ReflectionFactory.getLanguageKits(true).size();
		int editorKitsSize = ReflectionFactory.getEditorKits().size();

		ReflectionFactory.deploy(
				DynamicLanguageKit.getDeployer(new XmlLanguageKit()));
		Assert.assertEquals(languageKitsSize+1, ReflectionFactory.getLanguageKits(true).size());
		Assert.assertEquals(editorKitsSize, ReflectionFactory.getEditorKits().size());
	}

	@Test
	public synchronized void testAddEditorKit() {
		int languageKitsSize = ReflectionFactory.getLanguageKits(true).size();
		int editorKitsSize = ReflectionFactory.getEditorKits().size();
		
		ReflectionFactory.deploy(
				DynamicLanguageKit.getDeployer(new XmlLanguageKit()));
		ReflectionFactory.deploy(new EditorKitDeployer(XmlTextualEditorKit.ID));

		Assert.assertEquals(ReflectionFactory.getLanguageKits(true).size(), languageKitsSize);
		Assert.assertEquals(ReflectionFactory.getEditorKits().size(), editorKitsSize+1);
	}
	
	@Test
	public synchronized void testAddOperationKit() {
		//TODO
	}
}
