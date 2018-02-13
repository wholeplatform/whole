package org.whole.examples.datatypes;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class RedBlackTreeExample extends AbstractTemplateFactory<org.whole.examples.datatypes.redblacktree.model.RBNode> {

    public void apply(IBuilderOperation op) {
        org.whole.examples.datatypes.redblacktree.builders.IRedBlackTreeBuilder b0 = (org.whole.examples.datatypes.redblacktree.builders.IRedBlackTreeBuilder) op.wGetBuilder(org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeLanguageKit.URI);
        b0.RBNode_();
        b0.Value(13);
        b0.Color("BLACK");
        b0.RBNode_();
        b0.Value(8);
        b0.Color("RED");
        b0.RBNode_();
        b0.Value(1);
        b0.Color("BLACK");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.RBNode_();
        b0.Value(6);
        b0.Color("RED");
        b1.Resolver();
        b1.Resolver();
        b0._RBNode();
        b0._RBNode();
        b0.RBNode_();
        b0.Value(11);
        b0.Color("BLACK");
        b1.Resolver();
        b1.Resolver();
        b0._RBNode();
        b0._RBNode();
        b0.RBNode_();
        b0.Value(17);
        b0.Color("RED");
        b0.RBNode_();
        b0.Value(15);
        b0.Color("BLACK");
        b1.Resolver();
        b1.Resolver();
        b0._RBNode();
        b0.RBNode_();
        b0.Value(25);
        b0.Color("BLACK");
        b0.RBNode_();
        b0.Value(22);
        b0.Color("RED");
        b1.Resolver();
        b1.Resolver();
        b0._RBNode();
        b0.RBNode_();
        b0.Value(27);
        b0.Color("RED");
        b1.Resolver();
        b1.Resolver();
        b0._RBNode();
        b0._RBNode();
        b0._RBNode();
        b0._RBNode();
    }
}
