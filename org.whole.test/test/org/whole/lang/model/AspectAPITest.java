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
package org.whole.lang.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.editors.codebase.PojoTextualEditor;
import org.whole.lang.editors.model.Editor;
import org.whole.lang.editors.model.ViewComponent;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.versions.factories.VersionsEntityFactory;
import org.whole.lang.versions.model.History;
import org.whole.lang.versions.model.Version;
import org.whole.lang.versions.reflect.VersionsFeatureDescriptorEnum;

public class AspectAPITest {
	private Editor editorModel;

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Before
    public void setUp() {
        editorModel = new PojoTextualEditor().create();
    }

    @Test
    public void testToManyFeatureWithReferenceOppositeAdd() {
        History history = VersionsEntityFactory.instance.createHistory();
        Version v1 = VersionsEntityFactory.instance.createVersion();
        int size = history.getVersions().wSize();//TODO workaround
        
        assertEquals(0, history.wInverseAdjacentSize());
        
        history.getVersions().add(v1);

        assertSame(history, v1.getHistory());

        assertEquals(size+1, history.getVersions().wSize());
        assertEquals(1, history.wInverseAdjacentSize());
        assertEquals(0, v1.wInverseAdjacentSize());
        assertSame(v1, history.wInverseAdjacents().iterator().next());
    }

    @Test
    public void testReferenceFeatureWithToManyOppositeSet() {
        History history = VersionsEntityFactory.instance.createHistory();
        Version v1 = VersionsEntityFactory.instance.createVersion();
        int size = history.getVersions().wSize();//TODO workaround
        
        assertEquals(0, history.wInverseAdjacentSize());

        v1.setHistory(history);

        assertTrue(history.getVersions().contains(v1));

        assertEquals(size+1, history.getVersions().wSize());
        assertEquals(1, history.wInverseAdjacentSize());
        assertEquals(0, v1.wInverseAdjacentSize());
        assertSame(v1, history.wInverseAdjacents().iterator().next());
    }

    @Test
    public void testToManyReferenceFeatureWithToManyReferenceOppositeAdd() {
        History history = VersionsEntityFactory.instance.createHistory();
        Version v1 = VersionsEntityFactory.instance.createVersion();
        Version v2 = VersionsEntityFactory.instance.createVersion();
        Version v3 = VersionsEntityFactory.instance.createVersion();
        Version v4 = VersionsEntityFactory.instance.createVersion();

        v1.setHistory(history);
        v2.setHistory(history);
        v3.setHistory(history);
        v4.setHistory(history);

        //FIXME workaround for reference resolvers
        v1.setSuccessors(VersionsEntityFactory.instance.createVersionsRefs(0));
        v4.setSuccessors(VersionsEntityFactory.instance.createVersionsRefs(0));
        v2.setPredecessors(VersionsEntityFactory.instance.createVersionsRefs(0));
        v3.setPredecessors(VersionsEntityFactory.instance.createVersionsRefs(0));

        //FIXME .add() fails with UOE
        v1.getSuccessors().wAdd(v2);
        v1.getSuccessors().wAdd(v3);
        v4.getSuccessors().wAdd(v3);

        assertTrue(v1.getSuccessors().contains(v2));
        assertTrue(v1.getSuccessors().contains(v3));
        assertTrue(v4.getSuccessors().contains(v3));
        assertTrue(v2.getPredecessors().contains(v1));
        assertTrue(v3.getPredecessors().contains(v1));
        assertTrue(v3.getPredecessors().contains(v4));

        assertEquals(2, v1.wInverseAdjacentSize());
        assertEquals(1, v2.wInverseAdjacentSize());
        assertEquals(2, v3.wInverseAdjacentSize());
        assertEquals(1, v4.wInverseAdjacentSize());
    }

    @Test
    public void testAspectualReferenceFeatureWithReferenceOppositeSet() {
        Version vcVersion = VersionsEntityFactory.instance.createVersion();
    	ViewComponent viewComponent = editorModel.getViewComponent();
        
    	viewComponent.wSet(VersionsFeatureDescriptorEnum.baseVersion, vcVersion);

        assertSame(vcVersion, viewComponent.wGet(VersionsFeatureDescriptorEnum.baseVersion));
        assertSame(viewComponent, vcVersion.wGet(VersionsFeatureDescriptorEnum.versionable));
    }

    @Test
    public void testReferenceFeatureWithAspectualReferenceOppositeSet() {
        Version vcVersion = VersionsEntityFactory.instance.createVersion();
    	ViewComponent viewComponent = editorModel.getViewComponent();
    	
    	vcVersion.wSet(VersionsFeatureDescriptorEnum.versionable, viewComponent);

        assertSame(vcVersion, viewComponent.wGet(VersionsFeatureDescriptorEnum.baseVersion));
        assertSame(viewComponent, vcVersion.wGet(VersionsFeatureDescriptorEnum.versionable));
    }
}
