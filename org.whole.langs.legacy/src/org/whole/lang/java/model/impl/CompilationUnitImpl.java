package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class CompilationUnitImpl extends AbstractSimpleEntity implements
		CompilationUnit {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<CompilationUnit> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.CompilationUnit;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.CompilationUnit_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private PackageDeclaration _package;

	public PackageDeclaration getPackage() {
		return notifyRequested(JavaFeatureDescriptorEnum._package, _package);
	}

	public void setPackage(PackageDeclaration _package) {
		notifyChanged(JavaFeatureDescriptorEnum._package, this._package,
				this._package = _package);
	}

	private ImportDeclarations imports;

	public ImportDeclarations getImports() {
		return notifyRequested(JavaFeatureDescriptorEnum.imports, imports);
	}

	public void setImports(ImportDeclarations imports) {
		notifyChanged(JavaFeatureDescriptorEnum.imports, this.imports,
				this.imports = imports);
	}

	private TypeDeclarations types;

	public TypeDeclarations getTypes() {
		return notifyRequested(JavaFeatureDescriptorEnum.types, types);
	}

	public void setTypes(TypeDeclarations types) {
		notifyChanged(JavaFeatureDescriptorEnum.types, this.types,
				this.types = types);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getPackage().wGetAdaptee(false);
		case 1:
			return getImports().wGetAdaptee(false);
		case 2:
			return getTypes().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setPackage(value
					.wGetAdapter(JavaEntityDescriptorEnum.PackageDeclaration));
			break;
		case 1:
			setImports(value
					.wGetAdapter(JavaEntityDescriptorEnum.ImportDeclarations));
			break;
		case 2:
			setTypes(value
					.wGetAdapter(JavaEntityDescriptorEnum.TypeDeclarations));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
