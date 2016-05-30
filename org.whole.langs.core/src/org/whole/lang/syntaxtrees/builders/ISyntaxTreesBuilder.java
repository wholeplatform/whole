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
package org.whole.lang.syntaxtrees.builders;

import org.whole.lang.builders.IBuilder;

/**
 *  @generator Whole
 */
public interface ISyntaxTreesBuilder extends IBuilder {


    public void visit();

    public void text();

    public void children();

    public void name();

    public void Rule();

    public void Rule_();

    public void _Rule();

    public void Nodes();

    public void Nodes_();

    public void Nodes_(int initialCapacity);

    public void _Nodes();

    public void Terminal();

    public void Terminal_();

    public void _Terminal();

    public void Literal();

    public void Literal_();

    public void _Literal();

    public void Data();

    public void Data_();

    public void _Data();

    public void Error();

    public void Error_();

    public void _Error();

    public void Text();

    public void Text(String value);

    public void Name();

    public void Name(String value);
}
