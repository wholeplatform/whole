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
package org.whole.lang.reusables.builders;

import org.whole.lang.builders.IBuilder;

/**
 *  @generator Whole
 */
public interface IReusablesBuilder extends IBuilder {


    public void visit();

    public void uri();

    public void persistence();

    public void locator();

    public void variantRevision();

    public void variant();

    public void source();

    public void adaptedRevision();

    public void adapted();

    public void adapter();

    public void original();

    public void Adapt();

    public void Adapt_();

    public void _Adapt();

    public void Reuse();

    public void Reuse_();

    public void _Reuse();

    public void Synch();

    public void Synch_();

    public void _Synch();

    public void Include();

    public void Include_();

    public void _Include();

    public void Reusables();

    public void Reusables_();

    public void Reusables_(int initialCapacity);

    public void _Reusables();

    public void ReferenceStep();

    public void ReferenceStep_();

    public void _ReferenceStep();

    public void Resource();

    public void Resource_();

    public void _Resource();

    public void Registry();

    public void Registry_();

    public void _Registry();

    public void WorkspacePath();

    public void WorkspacePath(String value);

    public void FileSystemPath();

    public void FileSystemPath(String value);

    public void ClassPathURI();

    public void ClassPathURI(String value);

    public void URI();

    public void URI(String value);

    public void Persistence();

    public void Persistence(String value);
}
