package org.whole.examples.helpers;

import java.io.File;
import java.io.FileNotFoundException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.IJavaProject;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.codebase.FilePersistenceProvider;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.java.codebase.JDTJavaSourcePersistenceKit;
import org.whole.lang.java.codebase.JavaBuilderPersistenceKit;
import org.whole.lang.java.codebase.JavaClassTemplateFactory;
import org.whole.lang.java.codebase.JavaSourceTemplateFactory;
import org.whole.lang.java.model.InterfaceDeclaration;
import org.whole.lang.java.model.MethodDeclaration;
import org.whole.lang.java.model.Type;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.properties.codebase.PropertiesTextPersistenceKit;
import org.whole.lang.properties.codebase.PropertiesXmlPersistenceKit;
import org.whole.lang.text.codebase.TextSourcePersistenceKit;
import org.whole.lang.util.StringUtils;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;
import org.whole.lang.xml.codebase.XmlSourcePersistenceKit;
import org.whole.lang.xsd.codebase.XsdPersistenceKit;
import org.whole.lang.xsd.codebase.XsiPersistenceKit;

public class Helpers {
	public static boolean isAbstractFactory(InterfaceDeclaration entity) {
		return entity.getName().getValue().endsWith("Factory");
	}
	public static boolean isFactoryMethod(MethodDeclaration entity) {
		if (!Matcher.matchImpl(JavaEntityDescriptorEnum.SimpleName, entity.getName().wGetAdaptee(false)))
			return false;
		String methodName = entity.getName().getValue();
		Type returnType = entity.getReturnType();
		return (methodName.startsWith("create") || methodName.startsWith("new")) &&
		!returnType.wGetEntityDescriptor().equals(JavaEntityDescriptorEnum.PrimitiveType) ;
	}

	public static String toClassName(String factoryMethodName) {
		if (factoryMethodName.startsWith("create"))
			return factoryMethodName.substring(6);
		else
			return factoryMethodName.substring(3);
	}

	public static String toGetterName(String name) {
		return "get"+StringUtils.toUpperCap(name);
	}

	public static String toSetterName(String name) {
		return "set"+StringUtils.toUpperCap(name);
	}

	public static String toFluentSetterName(String name) {
		return "with"+StringUtils.toUpperCap(name);
	}

	public static IEntity loadJavaClass(String className) throws Exception {
		return new JavaClassTemplateFactory(className).create();
	}

	public static IEntity loadJavaSource(String className, IJavaProject javaProject) throws Exception {
		return new JavaSourceTemplateFactory(className, javaProject).create();
	}

	public static IEntity loadJava(String fileName) throws Exception {
		return JDTJavaSourcePersistenceKit.instance().readModel(
				createFilePersistenceProvider(fileName));
	}
	public static void saveJava(IEntity model, String fileName) throws Exception {
		JDTJavaSourcePersistenceKit.instance().writeModel(model,
				createFilePersistenceProvider(fileName));
	}

	public static IEntity loadJavaBuilder(String fileName) throws Exception {
		return JavaBuilderPersistenceKit.instance().readModel(
				createFilePersistenceProvider(fileName));
	}
	public static void saveJavaBuilder(IEntity model, String fileName) throws Exception {
		JavaBuilderPersistenceKit.instance().writeModel(model,
				createFilePersistenceProvider(fileName));
	}

	public static IEntity loadXml(String fileName) throws Exception {
		return XmlSourcePersistenceKit.instance().readModel(
				createFilePersistenceProvider(fileName));
	}
	public static void saveXml(IEntity model, String fileName) throws Exception {
		XmlSourcePersistenceKit.instance().writeModel(model,
				createFilePersistenceProvider(fileName));
	}

	public static IEntity loadXmlBuilder(String fileName) throws Exception {
		return XmlBuilderPersistenceKit.instance().readModel(
				createFilePersistenceProvider(fileName));
	}
	public static void saveXmlBuilder(IEntity model, String fileName) throws Exception {
		XmlBuilderPersistenceKit.instance().writeModel(model,
				createFilePersistenceProvider(fileName));
	}

	public static IEntity loadXsi(String fileName) throws Exception {
		return XsiPersistenceKit.instance().readModel(
				createFilePersistenceProvider(fileName));
	}
	public static void saveXsi(IEntity model, String fileName) throws Exception {
		XsiPersistenceKit.instance().writeModel(model,
				createFilePersistenceProvider(fileName));
	}

	public static IEntity loadXsd(String fileName) throws Exception {
		return XsdPersistenceKit.instance().readModel(
				createFilePersistenceProvider(fileName));
	}
	public static void saveXsd(IEntity model, String fileName) throws Exception {
		XsdPersistenceKit.instance().writeModel(model,
				createFilePersistenceProvider(fileName));
	}

	public static IEntity loadString(String fileName) throws Exception {
		String text = PrettyPrinterOperation.toPrettyPrintString(
				loadText(fileName));
		return BindingManagerFactory.instance.createValue(text);
	}
	public static IEntity loadText(String fileName) throws Exception {
		return TextSourcePersistenceKit.instance().readModel(
				createFilePersistenceProvider(fileName));
	}
	public static void saveText(IEntity model, String fileName) throws Exception {
		TextSourcePersistenceKit.instance().writeModel(model,
				createFilePersistenceProvider(fileName));
	}

	public static IEntity loadProperties(String fileName) throws Exception {
		return PropertiesTextPersistenceKit.instance().readModel(
				createFilePersistenceProvider(fileName));
	}
	public static void saveProperties(IEntity model, String fileName) throws Exception {
		PropertiesTextPersistenceKit.instance().writeModel(model,
				createFilePersistenceProvider(fileName));
	}

	public static IEntity loadXmlProperties(String fileName) throws Exception {
		return PropertiesXmlPersistenceKit.instance().readModel(
				createFilePersistenceProvider(fileName));
	}
	public static void saveXmlProperties(IEntity model, String fileName) throws Exception {
		PropertiesXmlPersistenceKit.instance().writeModel(model,
				createFilePersistenceProvider(fileName));
	}

	public static IPersistenceProvider createFilePersistenceProvider(String fileName) throws FileNotFoundException {
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(fileName);
		if (resource instanceof IFile)
			return new IFilePersistenceProvider((IFile) resource);
		else
			return new FilePersistenceProvider(new File(fileName));
		//TODO also from ReflectionFactory.getPlatformClassLoader().getResourceAsStream(fileName)
	}
}
