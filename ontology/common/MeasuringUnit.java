/**
 * @see "Categoría Sukia Domain Theory de SUKIA Smalltalk"
 */
package ontology.common;

import jade.util.leap.ArrayList;
import jade.util.leap.List;

/**
 * The first level MUST always be ROOT. All other level names MUST be added
 * according to their hierarchical ordering.  Thus, the second name in the list represents the MOST general
 * taxonomic rank, while the last name represents the most specific taxonomic rank.
 * PRECONDITION: There must be at least two taxonomic level names: ROOR + aTaxonomicLevelName.
 * @see "Método initialize del protocolo de clase class initialization en SUKIA SmallTalk"
 * @author Armando
 *
 */
public class MeasuringUnit {
	/**
	 * Constantes de la enumeraci&oacute;n
	 */
//	MM("mm"),
//	CM("cm"),
//	M("m"),
//	INCH("inch"),
//	COUNT("count");

        public static String MM = "mm";
        public static String CM = "cm";
        public static String M = "m";
        public static String INCH = "inch";
        public static String COUNT = "count";
        public static List values;

        static {
            values = new ArrayList();
            values.add(MM);
            values.add(CM);
            values.add(M);
            values.add(INCH);
            values.add(COUNT);
        }
	/**
	 * Variable para manejar el valor de la constante
	 */
	private static String unit;
	
	/**
	 * Contructor de la enumeraci&oacute;n
	 * @param similaryDegree
	 */
	MeasuringUnit(String unit) {
		MeasuringUnit.unit = unit;
	}
	
	/**
	 * M&eacute;todo accesor de lectura
	 * @return
	 */
	public static String getMeasuringUnit() {
		return unit;
	}
}
