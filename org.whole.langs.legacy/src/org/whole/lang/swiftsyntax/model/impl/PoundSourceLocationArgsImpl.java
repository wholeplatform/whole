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
package org.whole.lang.swiftsyntax.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.swiftsyntax.model.PoundSourceLocationArgs;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class PoundSourceLocationArgsImpl extends AbstractSimpleEntity implements PoundSourceLocationArgs {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PoundSourceLocationArgs> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.PoundSourceLocationArgs;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.PoundSourceLocationArgs_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token fileArgLabel;

    public Token getFileArgLabel() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.fileArgLabel, fileArgLabel);
    }

    public void setFileArgLabel(Token fileArgLabel) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.fileArgLabel, this.fileArgLabel, this.fileArgLabel = fileArgLabel);
    }
    private Token fileArgColon;

    public Token getFileArgColon() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.fileArgColon, fileArgColon);
    }

    public void setFileArgColon(Token fileArgColon) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.fileArgColon, this.fileArgColon, this.fileArgColon = fileArgColon);
    }
    private Token fileName;

    public Token getFileName() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.fileName, fileName);
    }

    public void setFileName(Token fileName) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.fileName, this.fileName, this.fileName = fileName);
    }
    private Token comma;

    public Token getComma() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.comma, comma);
    }

    public void setComma(Token comma) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.comma, this.comma, this.comma = comma);
    }
    private Token lineArgLabel;

    public Token getLineArgLabel() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.lineArgLabel, lineArgLabel);
    }

    public void setLineArgLabel(Token lineArgLabel) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.lineArgLabel, this.lineArgLabel, this.lineArgLabel = lineArgLabel);
    }
    private Token lineArgColon;

    public Token getLineArgColon() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.lineArgColon, lineArgColon);
    }

    public void setLineArgColon(Token lineArgColon) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.lineArgColon, this.lineArgColon, this.lineArgColon = lineArgColon);
    }
    private Token lineNumber;

    public Token getLineNumber() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.lineNumber, lineNumber);
    }

    public void setLineNumber(Token lineNumber) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.lineNumber, this.lineNumber, this.lineNumber = lineNumber);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getFileArgLabel().wGetAdaptee(false);
            case 1 :
            return getFileArgColon().wGetAdaptee(false);
            case 2 :
            return getFileName().wGetAdaptee(false);
            case 3 :
            return getComma().wGetAdaptee(false);
            case 4 :
            return getLineArgLabel().wGetAdaptee(false);
            case 5 :
            return getLineArgColon().wGetAdaptee(false);
            case 6 :
            return getLineNumber().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setFileArgLabel(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setFileArgColon(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setFileName(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setComma(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 4 :
            setLineArgLabel(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 5 :
            setLineArgColon(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 6 :
            setLineNumber(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 7;
    }
}
