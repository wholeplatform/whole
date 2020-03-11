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
public class TokenAdapter extends AbstractEntityAdapter implements Token {
    private static final long serialVersionUID = 1;

    public TokenAdapter(IEntity implementor) {
        super(implementor);
    }

    public TokenAdapter() {
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Token> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.Token;
    }

    public TokenKind getKind() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.kind).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.TokenKind);
    }

    public void setKind(TokenKind kind) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.kind, kind);
    }

    public SourcePresence getPresence() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.presence).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.SourcePresence);
    }

    public void setPresence(SourcePresence presence) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.presence, presence);
    }

    public Trivia getLeadingTrivia() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.leadingTrivia).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Trivia);
    }

    public void setLeadingTrivia(Trivia leadingTrivia) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.leadingTrivia, leadingTrivia);
    }

    public Trivia getTrailingTrivia() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.trailingTrivia).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Trivia);
    }

    public void setTrailingTrivia(Trivia trailingTrivia) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.trailingTrivia, trailingTrivia);
    }

    public Text getText() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.text).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Text);
    }

    public void setText(Text text) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.text, text);
    }
}
