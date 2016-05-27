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
package org.whole.lang.java.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.whole.lang.exceptions.WholeRuntimeException;

/**
 * @author Enrico Persiani
 */
public class JavaReflectUtils {
	public static class JavaSignature {
		public final String name;
		public final Class<?>[] types;
		public final boolean isVarArgs;

		private JavaSignature(String name, Class<?>[] types, boolean isVarArgs) {
			this.name = name;
			this.types = types;
			this.isVarArgs = isVarArgs;
		}
	}

	public static JavaSignature create(String name, Class<?>[] types, boolean isVarArgs) {
		return new JavaSignature(name, types, isVarArgs);
	}

	public static JavaSignature fromMethod(Method method) {
		return new JavaSignature(method.getName(), method.getParameterTypes(),
				method.isVarArgs());
	}
	public static Method toMethod(Class<?> declaringClass, JavaSignature signature)
			throws SecurityException, NoSuchMethodException {
		return declaringClass.getMethod(signature.name, signature.types);
	}

	public static JavaSignature fromConstructor(Constructor<?> constructor) {
		return new JavaSignature(constructor.getDeclaringClass().getSimpleName(),
				constructor.getParameterTypes(), constructor.isVarArgs());
	}
	public static <T> Constructor<T> toConstructor(Class<T> declaringClass,
			JavaSignature signature) throws SecurityException, NoSuchMethodException {
		assert declaringClass.getSimpleName().equals(signature.name);
		return declaringClass.getConstructor(signature.types);
	}

		
	public static JavaSignature parse(String signature, ClassLoader loader) {
		return new JavaSignaturesPredictiveParser(signature, loader).parseSignature();
	}

	public static String unparse(JavaSignature signature) {
		StringBuilder sb = new StringBuilder();
		sb.append(signature.name);
		sb.append('(');
		int length = signature.types.length - (signature.isVarArgs ? 1 : 0);
		for (int i = 0; i < length; i++) {
			if (i>0)
				sb.append(", ");
			sb.append(signature.types[i].getCanonicalName());
		}
		if (signature.isVarArgs) {
			if (length>0)
				sb.append(", ");
			Class<?> type = signature.types[length];
			sb.append(type.getComponentType().getCanonicalName());
			sb.append("...");
		}
		sb.append(')');
		return sb.toString();
	}

	public static final Class<?> forName(String className, ClassLoader loader) {
		try {
			return Class.forName(className, true, loader);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("cannot find class", e);
		}
	}

	public static String getSignature(Constructor<?> constructor) {
		return unparse(fromConstructor(constructor));
	}
	public static String getSignature(Method method) {
		return unparse(fromMethod(method));
	}

	public static Method getMethod(String className, String signature, ClassLoader loader) {
		return getMethod(forName(className, loader), signature, loader);
	}
	public static Method getMethod(Class<?> declaringClass, String signature, ClassLoader loader) {
		return getMethod(declaringClass, parse(signature, loader));
	}
	public static Method getMethod(Class<?> declaringClass, JavaSignature signature) {
		try {
			return toMethod(declaringClass, signature);
		} catch (Exception e) {
			throw new IllegalArgumentException("cannot find method", e);
		}
	}

	public static Constructor<?> getConstructor(String className, String signature, ClassLoader loader) {
		return getConstructor(forName(className, loader), signature, loader);
	}
	public static <T> Constructor<T> getConstructor(Class<T> declaringClass, String signature, ClassLoader loader) {
		return getConstructor(declaringClass, parse(signature, loader));
	}
	public static <T> Constructor<T> getConstructor(Class<T> declaringClass, JavaSignature signature) {
		try {
			return toConstructor(declaringClass, signature);
		} catch (Exception e) {
			throw new IllegalArgumentException("cannot find method", e);
		}
	}

	public static Object invokeMethod(Method method, Object... arguments) {
		return invokeMethod(null, method, arguments);
	}
	public static Object invokeMethod(Object instance, Method method, Object... arguments) {
		try {
			return method.invoke(instance, arguments);
		} catch (InvocationTargetException e) {
			throw new WholeRuntimeException(e.getTargetException());
		} catch (Exception e) {
			throw new IllegalStateException("method invocation error", e);
		}
	}
	public static <T> T invokeConstructor(Constructor<T> constructor, Object... arguments) {
		try {
			return constructor.newInstance(arguments);
		} catch (Exception e) {
			throw new IllegalStateException("constructor invocation error", e);
		}
	}
}
