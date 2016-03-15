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
package org.whole.lang.environment.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class EnvironmentAdaptersEntityRegistry extends AbstractEntityRegistry {

    public EnvironmentAdaptersEntityRegistry() {
        super(EnvironmentEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new DataAdapter());
        put(new BooleanDataAdapter());
        put(new ByteDataAdapter());
        put(new CharDataAdapter());
        put(new DoubleDataAdapter());
        put(new FloatDataAdapter());
        put(new IntDataAdapter());
        put(new LongDataAdapter());
        put(new ShortDataAdapter());
        put(new StringDataAdapter());
        put(new DateDataAdapter());
        put(new ObjectDataAdapter());
        put(new TupleAdapter());
        put(new ContainmentTupleAdapter());
        put(new VoidAdapter());
        put(new ContextViewModelAdapter());
        put(new SampleViewModelAdapter());
        put(new DebugViewModelAdapter());
        put(new JobsAdapter());
        put(new JobAdapter());
        put(new ExecutionStackAdapter());
        put(new ExecutionFrameAdapter());
        put(new VariablesViewModelAdapter());
        put(new EnvironmentsAdapter());
        put(new EnvironmentAdapter());
        put(new BindingsModelAdapter());
        put(new ScopedBindingsAdapter());
        put(new BindingsAdapter());
        put(new BindingAdapter());
        put(new ScopeAdapter());
        put(new IdAdapter());
        put(new NamesAdapter());
        put(new NameAdapter());
        put(new IndexAdapter());
        put(new ValueAdapter());
        put(new EnvironmentManagerAdapter());
        put(new BindingManagerAdapter());
        put(new BindingScopeAdapter());
        put(new BindingOrScopeAdapter());
    }
}
