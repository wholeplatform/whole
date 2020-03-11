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
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.TokenKind;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.SourcePresence;
import org.whole.lang.swiftsyntax.model.Trivia;
import org.whole.lang.swiftsyntax.model.Text;

/**
 *  @generator Whole
 */
public class TokenImpl extends AbstractSimpleEntity implements Token {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Token> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.Token;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.Token_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private TokenKind kind;

    public TokenKind getKind() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.kind, kind);
    }

    public void setKind(TokenKind kind) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.kind, this.kind, this.kind = kind);
    }
    private SourcePresence presence;

    public SourcePresence getPresence() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.presence, presence);
    }

    public void setPresence(SourcePresence presence) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.presence, this.presence, this.presence = presence);
    }
    private Trivia leadingTrivia;

    public Trivia getLeadingTrivia() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.leadingTrivia, leadingTrivia);
    }

    public void setLeadingTrivia(Trivia leadingTrivia) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.leadingTrivia, this.leadingTrivia, this.leadingTrivia = leadingTrivia);
    }
    private Trivia trailingTrivia;

    public Trivia getTrailingTrivia() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.trailingTrivia, trailingTrivia);
    }

    public void setTrailingTrivia(Trivia trailingTrivia) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.trailingTrivia, this.trailingTrivia, this.trailingTrivia = trailingTrivia);
    }
    private Text text;

    public Text getText() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.text, text);
    }

    public void setText(Text text) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.text, this.text, this.text = text);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getKind().wGetAdaptee(false);
            case 1 :
            return getPresence().wGetAdaptee(false);
            case 2 :
            return getLeadingTrivia().wGetAdaptee(false);
            case 3 :
            return getTrailingTrivia().wGetAdaptee(false);
            case 4 :
            return getText().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setKind(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.TokenKind));
            break;
            case 1 :
            setPresence(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.SourcePresence));
            break;
            case 2 :
            setLeadingTrivia(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Trivia));
            break;
            case 3 :
            setTrailingTrivia(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Trivia));
            break;
            case 4 :
            setText(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Text));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
