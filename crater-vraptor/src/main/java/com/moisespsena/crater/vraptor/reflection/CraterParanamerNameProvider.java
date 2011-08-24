/**
 * 
 */
package com.moisespsena.crater.vraptor.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import br.com.caelum.vraptor.http.ParanamerNameProvider;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

/**
 * Provedor de nomes de parametros com suporte a Anotacao por
 * <code>@javax.ws.rs.PathParam</code> do JavaEE 6
 * 
 * <p>
 * É uma especialização de {@link ParanamerNameProvider} com suporte a anotacao
 * <code>@javax.ws.rs.PathParam</code> do JavaEE 6 no parametro, para determinar
 * seu alias.
 * </p>
 * 
 * @see ParanamerNameProvider
 * @author Moises P. Sena &lt;moisespsena@gmail.com&gt;
 * @since 1.0 23/08/2011
 * 
 */
@SuppressWarnings("unchecked")
@Component
@ApplicationScoped
public class CraterParanamerNameProvider extends ParanamerNameProvider {
	private static Class<? extends Annotation> pathParamClass;
	private static Method pathParamValueMethod;
	static {
		try {
			pathParamClass = (Class<? extends Annotation>) Class
					.forName("javax.ws.rs.PathParam");
			pathParamValueMethod = pathParamClass.getDeclaredMethod("value");
		} catch (final Exception e) {
		}
	}

	/**
	 * Retorna o valor de <code>@javax.ws.rs.PathParam#value()</code> via
	 * Reflection
	 * 
	 * @param annotation
	 * @return
	 */
	private static String getPathParamValue(final Object annotation) {
		Object result;
		try {
			result = pathParamValueMethod.invoke(annotation);
			return result.toString().trim();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String[] parameterNamesFor(final AccessibleObject method) {
		// obtem os nomes dos parametros via Ognl
		final String[] parameterNames = super.parameterNamesFor(method);

		// anotacoes dos parametros
		final Annotation[][] parametersAnnotations = parametersAnnotations(method);

		// procura pelo nome do parametro usando a anotacao
		// @javax.ws.rs.PathParam
		if (pathParamClass != null) {
			for (int i = 0; i < parametersAnnotations.length; i++) {
				for (final Annotation annotation : parametersAnnotations[i]) {
					// se encontrou a anotacao
					if (pathParamClass.isAssignableFrom(annotation
							.annotationType())) {

						// obtem o nome do parametro definido na anotacao
						final String value = getPathParamValue(annotation);

						// se o valor nao for vazio
						if (value.length() > 0) {
							parameterNames[i] = value;
						}

						break;
					}
				}
			}
		}
		return parameterNames;
	}

	/**
	 * Anotações dos parametros de um metodo ou contrutor
	 * 
	 * @param methodOrConstructor
	 * @return
	 */
	private Annotation[][] parametersAnnotations(
			final AccessibleObject methodOrConstructor) {
		if (methodOrConstructor instanceof Method) {
			return ((Method) methodOrConstructor).getParameterAnnotations();
		} else if (methodOrConstructor instanceof Constructor<?>) {
			return ((Constructor<?>) methodOrConstructor)
					.getParameterAnnotations();
		} else {
			throw new IllegalArgumentException(
					"Expecting a method or constructor, " + "instead got "
							+ methodOrConstructor);
		}
	}

}
