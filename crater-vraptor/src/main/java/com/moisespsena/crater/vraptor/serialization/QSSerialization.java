/**
 * 
 */
package com.moisespsena.crater.vraptor.serialization;

import java.io.IOException;

import br.com.caelum.vraptor.serialization.NoRootSerialization;
import br.com.caelum.vraptor.serialization.Serialization;
import br.com.caelum.vraptor.serialization.Serializer;

import com.moisespsena.crater.vraptor.serialization.xstream.querystring.QSFormatWriter;
import com.moisespsena.crater.vraptor.serialization.xstream.querystring.QSHierarchicalStreamDriver.WriterCreatedListener;

/**
 * Query String Serialization
 * 
 * @author Moises P. Sena &lt;moisespsena@gmail.com&gt;
 * @since 1.0 23/08/2011
 * 
 */
public interface QSSerialization extends Serialization {
	public QSSerialization arrayFormat();

	<T> Serializer from(T object, String alias, QSFormatWriter formatWriter);

	<T> Serializer from(T object, String alias,
			final WriterCreatedListener writerCreatedListener);

	<T> Serializer from(T object, String alias,
			final WriterCreatedListener writerCreatedListener,
			QSFormatWriter formatWriter);

	public QSSerialization objectFormat();

	public QSSerialization propertiesFormat();

	/**
	 * Exclude the root alias from serialization.
	 * 
	 * @since 1.0
	 * @throws IOException
	 */
	<T> NoRootSerialization withoutRoot();
}
