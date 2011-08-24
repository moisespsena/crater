package com.moisespsena.crater.vraptor.serialization.xstream.querystring.format;

import com.moisespsena.crater.vraptor.serialization.xstream.querystring.QSWriter.Path;
import com.thoughtworks.xstream.core.util.QuickWriter;

/**
 * Formatação no estilo Objeto
 * 
 * <p>
 * Formata os valores da Query String em forma de arquivo .properties
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
 * <code>user.name=MyName
 * user.lastName=TheLastName</code>
 * </pre>
 * 
 * @author Moises P. Sena &lt;moisespsena@gmail.com&gt;
 * @since 1.0 23/08/2011
 * 
 */
public class PropertiesQSFormatWriter extends ObjectQSFormatWriter {

	public PropertiesQSFormatWriter() {
		super(null, VAR_NEW_LINE_SEPARATOR);
	}

	@Override
	protected String formatedValue(String value) throws Exception {
		value = value.replace('\r', '0');
		value = value.replaceAll("\n", "\\\\\n\t");

		return value;
	}

	@Override
	protected void writePathEntry(final Path path, final QuickWriter writer,
			final boolean hasMore, final boolean isFirst) {
		String pathValue = path.getPath();
		pathValue = pathValue.replaceAll("(\\W)", "\\\\$1");
		writer.write(pathValue);
	}
}
