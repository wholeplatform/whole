package org.whole.lang.text.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.text.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class TextIdentitySwitchVisitor extends AbstractVisitor
		implements ITextVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case TextEntityDescriptorEnum.Document_ord:
			visit((Document) entity);
			break;
		case TextEntityDescriptorEnum.Indent_ord:
			visit((Indent) entity);
			break;
		case TextEntityDescriptorEnum.RowSeparator_ord:
			visit((RowSeparator) entity);
			break;
		case TextEntityDescriptorEnum.TextSeparator_ord:
			visit((TextSeparator) entity);
			break;
		case TextEntityDescriptorEnum.Row_ord:
			visit((Row) entity);
			break;
		case TextEntityDescriptorEnum.Text_ord:
			visit((Text) entity);
			break;
		}
	}
}
