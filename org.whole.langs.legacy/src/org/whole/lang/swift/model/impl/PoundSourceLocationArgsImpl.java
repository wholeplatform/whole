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
package org.whole.lang.swift.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.swift.model.PoundSourceLocationArgs;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Identifier;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.StringLiteral;
import org.whole.lang.swift.model.IntegerLiteral;

/**
 *  @generator Whole
 */
public class PoundSourceLocationArgsImpl extends AbstractSimpleEntity implements PoundSourceLocationArgs {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PoundSourceLocationArgs> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.PoundSourceLocationArgs;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.PoundSourceLocationArgs_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Identifier fileArgLabel;

    public Identifier getFileArgLabel() {
        return notifyRequested(SwiftFeatureDescriptorEnum.fileArgLabel, fileArgLabel);
    }

    public void setFileArgLabel(Identifier fileArgLabel) {
        notifyChanged(SwiftFeatureDescriptorEnum.fileArgLabel, this.fileArgLabel, this.fileArgLabel = fileArgLabel);
    }
    private StringLiteral fileName;

    public StringLiteral getFileName() {
        return notifyRequested(SwiftFeatureDescriptorEnum.fileName, fileName);
    }

    public void setFileName(StringLiteral fileName) {
        notifyChanged(SwiftFeatureDescriptorEnum.fileName, this.fileName, this.fileName = fileName);
    }
    private Identifier lineArgLabel;

    public Identifier getLineArgLabel() {
        return notifyRequested(SwiftFeatureDescriptorEnum.lineArgLabel, lineArgLabel);
    }

    public void setLineArgLabel(Identifier lineArgLabel) {
        notifyChanged(SwiftFeatureDescriptorEnum.lineArgLabel, this.lineArgLabel, this.lineArgLabel = lineArgLabel);
    }
    private IntegerLiteral lineNumber;

    public IntegerLiteral getLineNumber() {
        return notifyRequested(SwiftFeatureDescriptorEnum.lineNumber, lineNumber);
    }

    public void setLineNumber(IntegerLiteral lineNumber) {
        notifyChanged(SwiftFeatureDescriptorEnum.lineNumber, this.lineNumber, this.lineNumber = lineNumber);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getFileArgLabel().wGetAdaptee(false);
            case 1 :
            return getFileName().wGetAdaptee(false);
            case 2 :
            return getLineArgLabel().wGetAdaptee(false);
            case 3 :
            return getLineNumber().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setFileArgLabel(value.wGetAdapter(SwiftEntityDescriptorEnum.Identifier));
            break;
            case 1 :
            setFileName(value.wGetAdapter(SwiftEntityDescriptorEnum.StringLiteral));
            break;
            case 2 :
            setLineArgLabel(value.wGetAdapter(SwiftEntityDescriptorEnum.Identifier));
            break;
            case 3 :
            setLineNumber(value.wGetAdapter(SwiftEntityDescriptorEnum.IntegerLiteral));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
