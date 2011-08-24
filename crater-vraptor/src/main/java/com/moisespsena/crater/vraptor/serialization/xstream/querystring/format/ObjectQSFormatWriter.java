package com.moisespsena.crater.vraptor.serialization.xstream.querystring.format;

import com.moisespsena.crater.vraptor.serialization.xstream.querystring.QSWriter.Path;
import com.thoughtworks.xstream.core.util.QuickWriter;

/**
 * Formatação no estilo Objeto
 * 
 * <p>
 * Formata os valores da Query String em forma de Objetos
 * </p>
 * <p>
 * Considere a Classe:
 * </p>
 * 
 * <pre>
 * <code>puclic class User {
 * 	private String name = "MyName";
 * 	private String lastName = "TheLastName";
 * 
 * 	// getters and setters ...
 * }</code>
 * </pre>
 * 
 * <p>
 * Apos a serializacao, tera resultado semelhante a:
 * </p>
 * 
 * <pre>
 * <code>user.name=MyName&amp;user.lastName=TheLastName</code>
 * </pre>
 * 
 * @author Moises P. Sena &lt;moisespsena@gmail.com&gt;
 * @since 1.0 23/08/2011
 * 
 */
public class ObjectQSFormatWriter extends AbstractQSFormatWriter {

	public ObjectQSFormatWriter() {
		super();
	}

	public ObjectQSFormatWriter(final char[] varSeparator) {
		super(varSeparator);
	}

	public ObjectQSFormatWriter(final String encoding) {
		super(encoding);
	}

	public ObjectQSFormatWriter(final String encoding, final char[] varSeparator) {
		super(encoding, varSeparator);
	}

	@Override
	protected void writePathIntersection(final Path path,
			final QuickWriter writer) {
		if (!path.isIndex()) {
			writer.write('.');
		}
	}

}
