package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class LibraryAdapter extends AbstractEntityAdapter implements Library {
	private static final long serialVersionUID = 1;

	public LibraryAdapter(IEntity implementor) {
		super(implementor);
	}

	public LibraryAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Library> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.Library;
	}

	public Annotations getAnnotations() {
		return wGet(PojoFeatureDescriptorEnum.annotations).wGetAdapter(
				PojoEntityDescriptorEnum.Annotations);
	}

	public void setAnnotations(Annotations annotations) {
		wSet(PojoFeatureDescriptorEnum.annotations, annotations);
	}

	public Name getName() {
		return wGet(PojoFeatureDescriptorEnum.name).wGetAdapter(
				PojoEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(PojoFeatureDescriptorEnum.name, name);
	}

	public LanguageURI getLanguageURI() {
		return wGet(PojoFeatureDescriptorEnum.languageURI).wGetAdapter(
				PojoEntityDescriptorEnum.LanguageURI);
	}

	public void setLanguageURI(LanguageURI languageURI) {
		wSet(PojoFeatureDescriptorEnum.languageURI, languageURI);
	}

	public Declarations getDeclarations() {
		return wGet(PojoFeatureDescriptorEnum.declarations).wGetAdapter(
				PojoEntityDescriptorEnum.Declarations);
	}

	public void setDeclarations(Declarations declarations) {
		wSet(PojoFeatureDescriptorEnum.declarations, declarations);
	}
}
