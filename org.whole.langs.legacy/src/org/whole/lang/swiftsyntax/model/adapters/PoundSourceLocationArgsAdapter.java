/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.swiftsyntax.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.swiftsyntax.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class PoundSourceLocationArgsAdapter extends AbstractEntityAdapter implements PoundSourceLocationArgs {
    private static final long serialVersionUID = 1;

    public PoundSourceLocationArgsAdapter(IEntity implementor) {
        super(implementor);
    }

    public PoundSourceLocationArgsAdapter() {
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<PoundSourceLocationArgs> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.PoundSourceLocationArgs;
    }

    public Token getFileArgLabel() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.fileArgLabel).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setFileArgLabel(Token fileArgLabel) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.fileArgLabel, fileArgLabel);
    }

    public Token getFileArgColon() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.fileArgColon).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setFileArgColon(Token fileArgColon) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.fileArgColon, fileArgColon);
    }

    public Token getFileName() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.fileName).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setFileName(Token fileName) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.fileName, fileName);
    }

    public Token getComma() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.comma).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setComma(Token comma) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.comma, comma);
    }

    public Token getLineArgLabel() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.lineArgLabel).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setLineArgLabel(Token lineArgLabel) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.lineArgLabel, lineArgLabel);
    }

    public Token getLineArgColon() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.lineArgColon).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setLineArgColon(Token lineArgColon) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.lineArgColon, lineArgColon);
    }

    public Token getLineNumber() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.lineNumber).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setLineNumber(Token lineNumber) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.lineNumber, lineNumber);
    }
}
