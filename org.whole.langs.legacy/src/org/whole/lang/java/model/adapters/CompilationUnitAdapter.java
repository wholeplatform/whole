package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class CompilationUnitAdapter extends AbstractEntityAdapter implements
		CompilationUnit {
	private static final long serialVersionUID = 1;

	public CompilationUnitAdapter(IEntity implementor) {
		super(implementor);
	}

	public CompilationUnitAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CompilationUnit> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.CompilationUnit;
	}

	public PackageDeclaration getPackage() {
		return wGet(JavaFeatureDescriptorEnum._package).wGetAdapter(
				JavaEntityDescriptorEnum.PackageDeclaration);
	}

	public void setPackage(PackageDeclaration _package) {
		wSet(JavaFeatureDescriptorEnum._package, _package);
	}

	public ImportDeclarations getImports() {
		return wGet(JavaFeatureDescriptorEnum.imports).wGetAdapter(
				JavaEntityDescriptorEnum.ImportDeclarations);
	}

	public void setImports(ImportDeclarations imports) {
		wSet(JavaFeatureDescriptorEnum.imports, imports);
	}

	public TypeDeclarations getTypes() {
		return wGet(JavaFeatureDescriptorEnum.types).wGetAdapter(
				JavaEntityDescriptorEnum.TypeDeclarations);
	}

	public void setTypes(TypeDeclarations types) {
		wSet(JavaFeatureDescriptorEnum.types, types);
	}
}
