/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.java.codebase;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.java.builders.IJavaBuilder;
import org.whole.lang.java.model.CompilationUnit;
import org.whole.lang.java.model.ModifierEnum;
import org.whole.lang.java.reflect.JavaLanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.util.UniqueIdGenerator;

/**
 * @author Enrico Persiani
 */
public class JavaClassTemplateFactory extends AbstractTemplateFactory<CompilationUnit> {
	protected Class<?> clazz;
	protected IJavaBuilder jb;
	protected ICommonsBuilder cb;
	protected boolean useCanonicalNames;

	public JavaClassTemplateFactory() {
		this((Class<?>)null);
	}
	public JavaClassTemplateFactory(String className) throws ClassNotFoundException {
		this(Class.forName(className, false, ReflectionFactory.getPlatformClassLoader()));
	}
	public JavaClassTemplateFactory(Class<?> clazz) {
		this.clazz = clazz;
		this.useCanonicalNames = true;
	}
	public JavaClassTemplateFactory useCanonicalNames(boolean useCanonicalNames) {
		this.useCanonicalNames = useCanonicalNames;
		return this;
	}

	public void apply(IBuilderOperation op) {
		cb = (ICommonsBuilder) op.wGetBuilder(CommonsLanguageKit.URI);
		jb = (IJavaBuilder) op.wGetBuilder(JavaLanguageKit.URI);
		buildCompilationUnit();
	}

	protected void buildCompilationUnit() {
		jb.CompilationUnit_();
		buildPackageDeclaration(clazz);
		buildImportDeclarations(clazz);
		buildTypeDeclarations(clazz);
		jb._CompilationUnit();
	}

	protected void buildPackageDeclaration(Class<?> clazz) {
		jb.PackageDeclaration_();
		cb.Resolver(); // JavaDoc
		cb.Resolver(); // Annotations
		jb.QualifiedName(clazz.getPackage().getName());
		jb._PackageDeclaration();
	}

	protected void buildImportDeclarations(Class<?> clazz) {
		// uses qualified names in place
		jb.ImportDeclarations();
	}

	protected void buildTypeDeclarations(Class<?> clazz) {
		jb.TypeDeclarations_();
		buildTypeDeclaration(clazz);			
		jb._TypeDeclarations();
	}

	@SuppressWarnings("unchecked")
	private void buildTypeDeclaration(Class<?> clazz) {
		if (clazz.isAnonymousClass())
			return;

		if (clazz.isAnnotation())
			buildAnnotationDeclaration((Class<Annotation>) clazz);
		else if (clazz.isInterface())
			buildInterfaceDeclaration(clazz);
		else if (clazz.isEnum())
			buildEnumDeclaration((Class<Enum<?>>) clazz);
		else
			buildClassDeclaration(clazz);
	}

	protected void buildAnnotationDeclaration(Class<? extends Annotation> clazz) {
		jb.AnnotationTypeDeclaration_();
		cb.Resolver(); // JavaDoc

		// class modifiers
		buildExtendedModifiers(clazz.getDeclaredAnnotations(), clazz.getModifiers());

		// annotation name
		buildSimpleName(clazz.getSimpleName());

		// annotation type member declarations ...
		jb.BodyDeclarations_();
		for (Method method : asSortedList(clazz.getDeclaredMethods()))
			buildAnnotationMember(method);
		for (Class<?> innerClazz : asSortedList(clazz.getDeclaredClasses()))
			buildTypeDeclaration(innerClazz);
		jb._BodyDeclarations();

		jb._AnnotationTypeDeclaration();
	}
	
	protected List<Method> asSortedList(Method... methods) {
		List<Method> methodList = Arrays.asList(methods);
		Collections.sort(methodList, new Comparator<Method>() {
			public int compare(Method m1, Method m2) {
				int result = m1.getName().compareTo(m2.getName());
				if (result != 0)
					return result;

				Class<?>[] pts1 = m1.getParameterTypes();
				Class<?>[] pts2 = m2.getParameterTypes();
				result = pts1.length - pts2.length;
				if (result != 0)
					return result;

				for (int i=0; i<pts1.length; i++) {
					result = pts1[i].getName().compareTo(pts2[i].getName());
					if (result != 0)
						return result;
				}

				return 0; // unreachable
			}
		});
		return methodList;
	}
	protected List<Constructor<?>> asSortedList(Constructor<?>... constructors) {
		List<Constructor<?>> constructorList = Arrays.asList(constructors);
		Collections.sort(constructorList, new Comparator<Constructor<?>>() {
			public int compare(Constructor<?> c1, Constructor<?> c2) {
				Class<?>[] pts1 = c1.getParameterTypes();
				Class<?>[] pts2 = c2.getParameterTypes();
				int result = pts1.length - pts2.length;
				if (result != 0)
					return result;

				for (int i=0; i<pts1.length; i++) {
					result = pts1[i].getName().compareTo(pts2[i].getName());
					if (result != 0)
						return result;
				}
				return 0; // unreachable
			}
		});
		return constructorList;
	}
	
	protected List<Field> asSortedList(Field... fields) {
		List<Field> filedList = Arrays.asList(fields);
		Collections.sort(filedList, new Comparator<Field>() {
			public int compare(Field f1, Field f2) {
				return f1.getName().compareTo(f2.getName());
			}
		});
		return filedList;
	}
	protected List<Class<?>> asSortedList(Class<?>... classes) {
		List<Class<?>> classList = Arrays.asList(classes);
		Collections.sort(classList, new Comparator<Class<?>>() {
			public int compare(Class<?> c1, Class<?> c2) {
				return c1.getName().compareTo(c2.getName());
			}
		});
		return classList;
	}
	protected List<Annotation> asSortedList(Annotation... annotations) {
		List<Annotation> annotationList = Arrays.asList(annotations);
		Collections.sort(annotationList, new Comparator<Annotation>() {
			public int compare(Annotation a1, Annotation a2) {
				return a1.annotationType().getName().compareTo(a2.annotationType().getName());
			}
		});
		return annotationList;
	}
	protected List<Enum<?>> asSortedList(Enum<?>... enums) {
		List<Enum<?>> enumList = Arrays.asList(enums);
		Collections.sort(enumList, new Comparator<Enum<?>>() {
			public int compare(Enum<?> e1, Enum<?> e2) {
				return e1.name().compareTo(e2.name());
			}
		});
		return enumList;
	}

	protected void buildInterfaceDeclaration(Class<?> clazz) {
		jb.InterfaceDeclaration_();
		cb.Resolver(); // JavaDoc

		// interface modifiers
		buildExtendedModifiers(clazz.getDeclaredAnnotations(), clazz.getModifiers());

		// interface name
		buildSimpleName(clazz.getSimpleName());

		// generic type parameters
		buildTypeParameters(clazz.getTypeParameters());

		// extends
		buildTypes(clazz.getGenericInterfaces());

		// fields, methods, annotations, inner classes ...
		jb.BodyDeclarations_();
		for (Field filed : asSortedList(clazz.getDeclaredFields()))
			buildField(filed);
		for (Method method : asSortedList(clazz.getDeclaredMethods()))
			buildMethod(method);
		for (Class<?> innerClazz : asSortedList(clazz.getDeclaredClasses()))
			buildTypeDeclaration(innerClazz);
		jb._BodyDeclarations();

		jb._InterfaceDeclaration();
	}

	protected void buildEnumDeclaration(Class<Enum<?>> clazz) {
		jb.EnumDeclaration_();
		cb.Resolver(); // JavaDoc

		// enumeration modifiers
		buildExtendedModifiers(clazz.getDeclaredAnnotations(), clazz.getModifiers(), Modifier.TRANSIENT | Modifier.VOLATILE | Modifier.FINAL);

		// enumeration name
		buildSimpleName(clazz.getSimpleName());

		// extends
		buildTypes(clazz.getGenericInterfaces());

		// enumeration constants
		buildEnumConstants(clazz.getEnumConstants());

		// fields, methods, annotations, inner classes ...
		jb.BodyDeclarations_();
		for (Field field : asSortedList(clazz.getDeclaredFields()))
			if (!field.isEnumConstant())
				buildField(field);
		for (Constructor<?> constructor : asSortedList(clazz.getDeclaredConstructors()))
			buildConstructor(constructor);
		for (Method method : asSortedList(clazz.getDeclaredMethods())) {
			String methodName = method.getName();
			Class<?> methodReturnType = method.getReturnType();
			Class<?>[] methodParameterTypes = method.getParameterTypes();
			if ("valueOf".equals(methodName) && clazz.equals(methodReturnType) &&
					methodParameterTypes.length == 1 && String.class.equals(methodParameterTypes[0]))
				continue;
			else if ("values".equals(methodName) && methodReturnType.isArray() &&
					clazz.equals(methodReturnType.getComponentType()) && methodParameterTypes.length == 0)
				continue;
			else
				buildMethod(method);
		}
		for (Class<?> innerClazz : asSortedList(clazz.getDeclaredClasses()))
			buildTypeDeclaration(innerClazz);
		jb._BodyDeclarations();

		jb._EnumDeclaration();
	}

	protected void buildClassDeclaration(Class<?> clazz) {		
		jb.ClassDeclaration_();
		cb.Resolver(); // JavaDoc

		// class modifiers
		buildExtendedModifiers(clazz.getDeclaredAnnotations(), clazz.getModifiers());
		// class name
		buildSimpleName(clazz.getSimpleName());

		// generic type parameters
		buildTypeParameters(clazz.getTypeParameters());

		// extends
		Class<?> superclass = clazz.getSuperclass();
		if (Object.class.equals(superclass))
			cb.Resolver();
		else
			buildType(superclass);

		// implements
		buildTypes(clazz.getGenericInterfaces());

		// fields, methods, annotations, inner classes ...
		jb.BodyDeclarations_();
		for (Field filed : asSortedList(clazz.getDeclaredFields()))
			buildField(filed);
		for (Constructor<?> constructor : asSortedList(clazz.getDeclaredConstructors()))
			buildConstructor(constructor);
		for (Method method : asSortedList(clazz.getDeclaredMethods()))
			buildMethod(method);
		for (Class<?> innerClazz : asSortedList(clazz.getDeclaredClasses()))
			buildTypeDeclaration(innerClazz);
		jb._BodyDeclarations();

		jb._ClassDeclaration();
	}

	protected void buildField(Field field) {
		if (field.isSynthetic())
			return;

		jb.FieldDeclaration_();
		cb.Resolver(); // JavaDoc

		// field modifiers
		buildExtendedModifiers(field.getAnnotations(), field.getModifiers(), 0);

		// filed type
		buildType(field.getGenericType());

		// field declaration
		jb.VariableDeclarationFragments_();
		jb.VariableDeclarationFragment_();
		buildSimpleName(field.getName());
		cb.Resolver(); // extra dimensions
		cb.Resolver(); // initializer
		jb._VariableDeclarationFragment();
		jb._VariableDeclarationFragments();
		jb._FieldDeclaration();
	}

	protected void buildConstructor(Constructor<?> constructor) {
		if (constructor.isSynthetic())
			return;

		jb.ConstructorDeclaration_();
		cb.Resolver(); // JavaDoc

		// constructor modifiers
		buildExtendedModifiers(constructor.getAnnotations(), constructor.getModifiers());

		// generic type parameters
		buildTypeParameters(constructor.getTypeParameters());
		
		// constructor name
		String name = constructor.getName().replaceAll(".*\\$", "");
		buildSimpleName(name);

		// constructor parameters
		buildParameters(constructor.getGenericParameterTypes(), constructor.isVarArgs());

		cb.Resolver(); // extra dimensions

		// exceptions
		buildExceptions(constructor.getGenericExceptionTypes());

		jb.Block(); // empty body

		jb._ConstructorDeclaration();
	}

	protected void buildAnnotationMember(Method method) {
		jb.AnnotationTypeMemberDeclaration_();
		cb.Resolver(); // JavaDoc

		// member modifiers
		int modifiers = method.getModifiers();
		buildExtendedModifiers(method.getAnnotations(), modifiers, Modifier.TRANSIENT | Modifier.VOLATILE | Modifier.ABSTRACT | Modifier.PUBLIC);

		// member name
		buildSimpleName(method.getName());
		
		// member type
		buildType(method.getGenericReturnType());

		cb.Resolver(); // default

		jb._AnnotationTypeMemberDeclaration();
	}

	protected void buildMethod(Method method) {
		if (method.isSynthetic())
			return;

		jb.MethodDeclaration_();
		cb.Resolver(); // JavaDoc

		// method modifiers
		int modifiers = method.getModifiers();
		buildExtendedModifiers(method.getAnnotations(), modifiers);

		// generic type parameters
		buildTypeParameters(method.getTypeParameters());

		// return type
		buildType(method.getGenericReturnType());

		// method name
		buildSimpleName(method.getName());

		// method parameters
		buildParameters(method.getGenericParameterTypes(), method.isVarArgs());

		cb.Resolver(); // extra dimensions

		// exceptions
		buildExceptions(method.getGenericExceptionTypes());
		
		if (method.getDeclaringClass().isInterface() || Modifier.isAbstract(modifiers)) // method body
			cb.Resolver();
		else
			jb.Block();

		jb._MethodDeclaration();
	}

	protected void buildEnumConstants(Enum<?>[] enumConstants){
		if (enumConstants.length == 0)
			return;

		jb.EnumConstants_();
		for (Enum<?> enumConstant : asSortedList(enumConstants)) {
			jb.EnumConstantDeclaration_();

			cb.Resolver(); // JavaDoc

			cb.Resolver(); // modifiers

			buildSimpleName(enumConstant.name());

			cb.Resolver(); // arguments
			cb.Resolver(); // anonymous class declaration

			jb._EnumConstantDeclaration();
		}
		jb._EnumConstants();
	}

	protected void buildParameters(Type[] parameterTypes, boolean hasVarArgs) {
		jb.Parameters_();
		UniqueIdGenerator idgen = UniqueIdGenerator.newUniqueIdGenerator("arg", 0);
		for (int i=0; i<parameterTypes.length; i++) {
			Type parameterType = parameterTypes[i];
			jb.SingleVariableDeclaration_();
			cb.Resolver(); // modifiers
			if (hasVarArgs && i == parameterTypes.length -1)  {
				if (parameterType instanceof GenericArrayType)
					buildType(((GenericArrayType) parameterType).getGenericComponentType());
				else
					buildType(((Class<?>) parameterType).getComponentType());
				jb.Varargs(true);
			} else {
				buildType(parameterType);
				cb.Resolver();
			}
			buildSimpleName(idgen.next());
			cb.Resolver(); // extra dimensions
			cb.Resolver(); // expression
			jb._SingleVariableDeclaration();
		}
		jb._Parameters();
	}

	protected void buildExtendedModifiers(Annotation[] annotations, int modifiers) {
		buildExtendedModifiers(annotations, modifiers, Modifier.TRANSIENT | Modifier.VOLATILE);
	}
	protected void buildExtendedModifiers(Annotation[] annotations, int modifiers, int ignoreModifiers) {
		jb.ExtendedModifiers_();
		buildModifiers(modifiers, ignoreModifiers);
		for (Annotation annotation : asSortedList(clazz.getDeclaredAnnotations()))
			buildAnnotation(annotation.annotationType());
		jb._ExtendedModifiers();
	}
	private void buildAnnotation(Class<? extends Annotation> clazz) {
		//FIXME there's no support for finding annotations
	}

	protected void buildModifiers(int modifier, int ignoreModifiers) {
		if(!Modifier.isPrivate(ignoreModifiers) && Modifier.isPrivate(modifier))
			jb.Modifier(ModifierEnum._private);
		if(!Modifier.isProtected(ignoreModifiers) && Modifier.isProtected(modifier))
			jb.Modifier(ModifierEnum._protected);
		if(!Modifier.isPublic(ignoreModifiers) && Modifier.isPublic(modifier))
			jb.Modifier(ModifierEnum._public);

		if(!Modifier.isAbstract(ignoreModifiers) && Modifier.isAbstract(modifier))
			jb.Modifier(ModifierEnum._abstract);
		if(!Modifier.isStatic(ignoreModifiers) && Modifier.isStatic(modifier))
			jb.Modifier(ModifierEnum._static);
		if(!Modifier.isFinal(ignoreModifiers) && Modifier.isFinal(modifier))
			jb.Modifier(ModifierEnum._final);
		if(!Modifier.isNative(ignoreModifiers) && Modifier.isNative(modifier))
			jb.Modifier(ModifierEnum._native);
		if(!Modifier.isSynchronized(ignoreModifiers) && Modifier.isSynchronized(modifier))
			jb.Modifier(ModifierEnum._synchronized);

		if(!Modifier.isTransient(ignoreModifiers) && Modifier.isTransient(modifier))
			jb.Modifier(ModifierEnum._transient);
		if(!Modifier.isVolatile(ignoreModifiers) && Modifier.isVolatile(modifier))
			jb.Modifier(ModifierEnum._volatile);

		if(!Modifier.isStrict(ignoreModifiers) && Modifier.isStrict(modifier))
			jb.Modifier(ModifierEnum.strictftp);
	}
	protected void buildExceptions(Type[] exceptionTypes) {
		if (exceptionTypes.length == 0)
			cb.Resolver();
		else {
			jb.Types_();
			for (Type exceptionType : exceptionTypes)
				buildType(exceptionType);
			jb._Types();
		}
	}
	protected void buildTypes(Type[] types) {
		if (types.length == 0)
			cb.Resolver();
		else {
			jb.Types_();
			for (Type interfaceType : types)
				buildType(interfaceType);
			jb._Types();
		}
	}
	protected void buildTypeParameters(TypeVariable<?>[] typeParameters) {
		jb.TypeParameters_();
		for (TypeVariable<?> typeParameter : typeParameters) {
			jb.TypeParameter_();
			buildSimpleName(typeParameter.getName());
			buildTypes(typeParameter.getBounds());
			jb._TypeParameter();
		}
		jb._TypeParameters();
	}
	protected void buildType(Type type) {
		if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;
			Type[] typeArguments = parameterizedType.getActualTypeArguments();
			Type rawType = parameterizedType.getRawType();
			jb.ParameterizedType_();
			buildType(rawType);
			buildTypes(typeArguments);
			jb._ParameterizedType();
		} else if (type instanceof GenericArrayType) {
			jb.ArrayType_();
			buildType(((GenericArrayType) type).getGenericComponentType());
			jb._ArrayType();
		} else if (type instanceof TypeVariable) {
			TypeVariable<?> typeVariable = (TypeVariable<?>) type;
			jb.SimpleType(typeVariable.getName());
		} else if (type instanceof WildcardType) {
			jb.WildcardType_();
			WildcardType wildcardType = (WildcardType) type;
			if (wildcardType.getLowerBounds().length == 0) {
				Type upperBound = wildcardType.getUpperBounds()[0];
				if (Object.class.equals(upperBound)) {
					cb.Resolver();
					jb.UpperBound();
				} else {
					buildType(upperBound);
					jb.UpperBound(true);
				}
			} else {
				buildType(wildcardType.getLowerBounds()[0]);
				jb.UpperBound(false);
			}
			jb._WildcardType();
		} else {
			// non generic types
			Class<?> clazz = (Class<?>) type;
			if (clazz.isArray()) {
				jb.ArrayType_();
				buildType(clazz.getComponentType());
				jb._ArrayType();
			} else if (clazz.isPrimitive()) {
				jb.PrimitiveType(clazz.getName());
			} else {
				String canonicalName = clazz.getCanonicalName();
				if (canonicalName != null)
					jb.QualifiedType(useCanonicalNames ? canonicalName : clazz.getName());
				else
					jb.SimpleType(clazz.getSimpleName());
			}
		}
	}
	protected void buildSimpleName(String name) {
		jb.SimpleName(name);
	}
	protected void buildQualifiedName(String name) {
		jb.QualifiedName(name);
	}
}
