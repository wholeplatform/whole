package org.whole.lang.pojo.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.pojo.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class LibraryImpl extends AbstractSimpleEntity implements Library {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Library> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.Library;
	}

	public int wGetEntityOrd() {
		return PojoEntityDescriptorEnum.Library_ord;
	}

	public void accept(IPojoVisitor visitor) {
		visitor.visit(this);
	}

	private Annotations annotations;

	public Annotations getAnnotations() {
		return notifyRequested(PojoFeatureDescriptorEnum.annotations,
				annotations);
	}

	public void setAnnotations(Annotations annotations) {
		notifyChanged(PojoFeatureDescriptorEnum.annotations, this.annotations,
				this.annotations = annotations);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(PojoFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(PojoFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private LanguageURI languageURI;

	public LanguageURI getLanguageURI() {
		return notifyRequested(PojoFeatureDescriptorEnum.languageURI,
				languageURI);
	}

	public void setLanguageURI(LanguageURI languageURI) {
		notifyChanged(PojoFeatureDescriptorEnum.languageURI, this.languageURI,
				this.languageURI = languageURI);
	}

	private Declarations declarations;

	public Declarations getDeclarations() {
		return notifyRequested(PojoFeatureDescriptorEnum.declarations,
				declarations);
	}

	public void setDeclarations(Declarations declarations) {
		notifyChanged(PojoFeatureDescriptorEnum.declarations,
				this.declarations, this.declarations = declarations);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getAnnotations().wGetAdaptee(false);
		case 1:
			return getName().wGetAdaptee(false);
		case 2:
			return getLanguageURI().wGetAdaptee(false);
		case 3:
			return getDeclarations().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setAnnotations(value
					.wGetAdapter(PojoEntityDescriptorEnum.Annotations));
			break;
		case 1:
			setName(value.wGetAdapter(PojoEntityDescriptorEnum.Name));
			break;
		case 2:
			setLanguageURI(value
					.wGetAdapter(PojoEntityDescriptorEnum.LanguageURI));
			break;
		case 3:
			setDeclarations(value
					.wGetAdapter(PojoEntityDescriptorEnum.Declarations));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
