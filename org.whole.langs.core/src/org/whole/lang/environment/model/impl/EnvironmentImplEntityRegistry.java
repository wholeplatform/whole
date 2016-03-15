/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.environment.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class EnvironmentImplEntityRegistry extends AbstractEntityRegistry {

    public EnvironmentImplEntityRegistry() {
        super(EnvironmentEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new BooleanDataImpl());
        put(new ByteDataImpl());
        put(new CharDataImpl());
        put(new DoubleDataImpl());
        put(new FloatDataImpl());
        put(new IntDataImpl());
        put(new LongDataImpl());
        put(new ShortDataImpl());
        put(new StringDataImpl());
        put(new DateDataImpl());
        put(new ObjectDataImpl());
        put(new TupleImpl());
        put(new ContainmentTupleImpl());
        put(new VoidImpl());
        put(new ContextViewModelImpl());
        put(new SampleViewModelImpl());
        put(new DebugViewModelImpl());
        put(new JobsImpl());
        put(new JobImpl());
        put(new ExecutionStackImpl());
        put(new ExecutionFrameImpl());
        put(new VariablesViewModelImpl());
        put(new EnvironmentsImpl());
        put(new EnvironmentImpl());
        put(new ScopedBindingsImpl());
        put(new BindingsImpl());
        put(new BindingImpl());
        put(new ScopeImpl());
        put(new IdImpl());
        put(new NamesImpl());
        put(new NameImpl());
        put(new IndexImpl());
        put(new ValueImpl());
        put(new EnvironmentManagerImpl());
        put(new BindingManagerImpl());
        put(new BindingScopeImpl());
    }
}
