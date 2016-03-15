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
package org.whole.lang.xml.builders;

import org.whole.lang.builders.IBuilder;

/**
 *  @generator Whole
 */
public interface IXmlBuilder extends IBuilder {


    public void visit();

    public void nameSpace();

    public void value();

    public void content();

    public void attributes();

    public void tag();

    public void text();

    public void instruction();

    public void pubidLiteral();

    public void systemLiteral();

    public void externalId();

    public void name();

    public void standalone();

    public void encoding();

    public void version();

    public void misc();

    public void docTypeDecl();

    public void xmlDecl();

    public void element();

    public void prolog();

    public void Document();

    public void Document_();

    public void _Document();

    public void Prolog();

    public void Prolog_();

    public void _Prolog();

    public void XMLDecl();

    public void XMLDecl_();

    public void _XMLDecl();

    public void Version();

    public void Version(String value);

    public void Encoding();

    public void Encoding(String value);

    public void Standalone();

    public void Standalone(boolean value);

    public void DocTypeDecl();

    public void DocTypeDecl_();

    public void _DocTypeDecl();

    public void SystemId();

    public void SystemId_();

    public void _SystemId();

    public void SystemLiteral();

    public void SystemLiteral(String value);

    public void PublicId();

    public void PublicId_();

    public void _PublicId();

    public void PubidLiteral();

    public void PubidLiteral(String value);

    public void Misc();

    public void Misc_();

    public void Misc_(int initialCapacity);

    public void _Misc();

    public void PI();

    public void PI_();

    public void _PI();

    public void Instruction();

    public void Instruction(String value);

    public void Comment();

    public void Comment_();

    public void _Comment();

    public void CommentText();

    public void CommentText(String value);

    public void Element();

    public void Element_();

    public void _Element();

    public void Attributes();

    public void Attributes_();

    public void Attributes_(int initialCapacity);

    public void _Attributes();

    public void Attribute();

    public void Attribute_();

    public void _Attribute();

    public void Name();

    public void Name(String value);

    public void QualifiedName();

    public void QualifiedName_();

    public void _QualifiedName();

    public void NameSpace();

    public void NameSpace(String value);

    public void Value();

    public void Value(String value);

    public void Content();

    public void Content_();

    public void Content_(int initialCapacity);

    public void _Content();

    public void CharData();

    public void CharData(String value);

    public void CDataSect();

    public void CDataSect_();

    public void CDataSect_(int initialCapacity);

    public void _CDataSect();

    public void CDataSectData();

    public void CDataSectData(String value);
}
