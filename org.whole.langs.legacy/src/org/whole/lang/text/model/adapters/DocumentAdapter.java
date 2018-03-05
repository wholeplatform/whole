package org.whole.lang.text.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.text.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.text.visitors.ITextVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class DocumentAdapter extends AbstractListEntityAdapter<IRow> implements Document {
	private static final long serialVersionUID = 1;

	public DocumentAdapter(IEntity implementor) {
		super(implementor);
	}

	public DocumentAdapter() {
	}

	public void accept(ITextVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Document> wGetEntityDescriptor() {
		return TextEntityDescriptorEnum.Document;
	}
}
