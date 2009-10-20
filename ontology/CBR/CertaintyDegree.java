/**
 * @see "Categoría Sukia Similarity Assessment de SUKIA Smalltalk"
 */
package ontology.CBR;

import jade.util.leap.ArrayList;
import jade.util.leap.List;


/**
 * The instance variable status indicates the search status at the end of the process.
 * The possible values it may have are:
 * fail - the dialog was unsuccessful. This is the default value.
 * success - at least one taxon reached the goal.
 * cancel - the user canceled the dialog process.
 * error - a processing error occurred.
 * @author Armando
 *
 */
public class CertaintyDegree {
	/**
	 * Constantes de la enumeraci&oacute;n
	 */

        public static String UNKNOWN = "Unknown";
        public static String UNCERTAIN = "Uncertain";
        public static String DOUBTFUL = "doubtful";
        public static String CERTAIN = "Certain";
        public static List values;

        static {
            values = new ArrayList();
            values.add(UNKNOWN);
            values.add(UNCERTAIN);
            values.add(DOUBTFUL);
            values.add(CERTAIN);

        }


	/**
	 * Variable para manejar el valor de la constante
	 */
	private final String degree;
	
	/**
	 * Contructor de la enumeraci&oacute;n
	 * @param degree
	 */
	CertaintyDegree(String degree) {
		this.degree = degree;
	}
	
	/**
	 * M&eacute;todo accesor de lectura
	 * @return
	 */
	public String getDegree() {
		return degree;
	}	
}
