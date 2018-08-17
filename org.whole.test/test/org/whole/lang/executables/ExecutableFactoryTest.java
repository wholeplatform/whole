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
package org.whole.lang.executables;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Riccardo Solmi
 */
public class ExecutableFactoryTest {
	protected static IteratorFactory f;
	protected static BindingManagerFactory bmf;
	protected static IEntity[] values;

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();

//    	f = IteratorFactory.regularInstance;
    	f = new RegularExecutableFactory();
    	bmf = BindingManagerFactory.instance;

    	values = new IEntity[] {
    			bmf.createValue(0), bmf.createValue(1), bmf.createValue(2), bmf.createValue(3), bmf.createValue(4),
    			bmf.createValue(5), bmf.createValue(6), bmf.createValue(7), bmf.createValue(8), bmf.createValue(9)
    	};
    }

    @Test
    public void testEmpty() {
    	IEntityIterator<?> i = f.emptyIterator();
    	i.setBindings(bmf.createBindingManager());
    	i.reset(values[0]);

    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
 
    	i.reset(values[0]);
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateRemaining());
    	 
    	i.reset(values[0]);
    	assertNull(i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    }

    @Test
    public void testConstant() {
    	IEntityIterator<?> i = f.constantIterator(values[0], false);
    	i.setBindings(bmf.createBindingManager());
    	i.reset(values[1]);

    	assertSame(values[0], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
 
    	i.reset(values[1]);
    	assertSame(values[0], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateRemaining());
    	 
    	i.reset(values[1]);
    	assertSame(values[0], i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    }

    @Test
    public void testSequence() {
    	@SuppressWarnings("unchecked")
		IEntityIterator<?> i = f.sequenceIterator(
    			f.constantIterator(values[0], false),
    			f.constantIterator(values[1], false),
    			f.constantIterator(values[2], false),
    			f.sequenceIterator(
    	    			f.constantIterator(values[3], false),
    	    			f.constantIterator(values[4], false)),
    			f.sequenceIterator(
    	    			f.constantIterator(values[5], false),
    	    			f.constantIterator(values[6], false),
    	    			f.constantIterator(values[7], false))
    	);
    	i.setBindings(bmf.createBindingManager());
    	i.reset(values[0]);

    	for (int at=0; at<8; at++)
    		assertSame(values[at], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
 
    	i.reset(values[0]);
    	for (int at=0; at<8; at++)
    		assertSame(values[at], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateRemaining());
    	 
    	i.reset(values[0]);
    	assertSame(values[7], i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    }

    @Test
    public void testChooseByOrder() {
    	@SuppressWarnings("unchecked")
		IEntityIterator<?> i = f.chooseIterator(
    			f.emptyIterator(),
    			f.emptyIterator(),
    			f.sequenceIterator(
    	    			f.constantIterator(values[0], false),
    	    			f.constantIterator(values[1], false),
    	    			f.constantIterator(values[2], false)),
    			f.constantIterator(values[3], false),
    			f.constantIterator(values[4], false)
    	);
    	i.setBindings(bmf.createBindingManager());
    	i.reset(values[0]);

    	for (int at=0; at<3; at++)
    		assertSame(values[at], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
 
    	i.reset(values[0]);
    	for (int at=0; at<3; at++)
    		assertSame(values[at], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateRemaining());
    	 
    	i.reset(values[0]);
    	assertSame(values[2], i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    }
}

