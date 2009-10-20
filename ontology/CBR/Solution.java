/**
 * Paquete que reune los conceptos CBR, sus relaciones y sus restricciones de uso
 * @see "Categoría Sukia Reasoner en SUKIA SmallTalk"
 */
package ontology.CBR;

import jade.content.abs.AbsConcept;
import jade.content.abs.AbsObject;
import jade.content.abs.AbsTerm;
import jade.content.onto.Introspectable;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import ontology.common.Description;

/**
 * Representa la soluci&oacute;n de un problema particular y c&oacute;mo fue resuelto
 * @author Armando
 *
 */
public class Solution implements jade.content.Concept, Introspectable {
    /**
         *
	 *  A list containing a set of Descriptor's (the solution path of the case, i.e., the result of the
	 *  traversal across the net and other reference structures).
	 */
	private Description justification;
	/**
	 * El rango del tax&oacute;n de la soluci&oacute;n
	 */
	private String taxonLevel;
	/**
	 * El tax&oacute;n de la soluci&oacute;n
	 */
	private String taxonName;

	/**
	 * Constructor por defecto
	 * @see "M&eacute;todo initialize del protocolo initializing en SUKIA SmallTalk"
	 */
	public Solution() {
		this._internalInstanceName = "";
		justification = new Description();
		taxonLevel = null;
		taxonName = null;
	}

	private String _internalInstanceName = null;

	public Solution(String instance_name) {
		this._internalInstanceName = instance_name;
	}

	public String toString() {
		return _internalInstanceName;
	}
	
	/**
	 * Constructor alternativo
	 * @see "M&eacute;todo initialize del protocolo initializing en SUKIA SmallTalk"
	 */
	public Solution(String aTaxonLevel, String aTaxonName) {
		justification = new Description();
		taxonLevel = aTaxonLevel;
		taxonName = aTaxonName;
	}
	
	/**
	 * M&eacute;todo accesor de escritura
	 * @param justification
	 */
	public void setJustification(Description justification) {
		this.justification = justification;
	}

	/**
	 * M&eacute;todo accesor de lectura
	 * @see "M&eacute;todo justification del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public Description getJustification() {
		return justification;
	}

	/**
	 * M&eacute;todo accesor de lectura
	 * @see "M&eacute;todo taxonLevel del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public String getTaxonLevel() {
		return taxonLevel;
	}

	/**
	 * M&eacute;todo accesor de escritura
	 * @see "M&eacute;todo taxonLevel: del protocolo adding en SUKIA SmallTalk"
	 * @param taxonLevel
	 */
	public void setTaxonLevel(String taxonLevel) {
		this.taxonLevel = taxonLevel;
	}

	/**
	 * M&eacute;todo accesor de lectura
	 * @see "M&eacute;todo taxonName del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public String getTaxonName() {
		return taxonName;
	}

	/**
	 * M&eacute;todo accesor de escritura
	 * NOTE: the method setName of the class Taxon contains useful information about the format of
	 * taxon names
	 * @see "M&eacute;todo taxonName: del protocolo adding en SUKIA SmallTalk"
	 * @param taxonName
	 */
	public void setTaxonName(String taxonName) {
		this.taxonName = taxonName;
	}
  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException, jade.content.onto.OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(CBRTerminologyOntology.SOLUTION_NAME, (AbsTerm) onto.fromObject(getTaxonName()));
      abs.set(CBRTerminologyOntology.SOLUTION_RANK, (AbsTerm) onto.fromObject(getTaxonLevel()));
      abs.set(CBRTerminologyOntology.SOLUTION_JUSTIFICATION, (AbsTerm) onto.fromObject(getJustification()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Solution");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException, jade.content.onto.OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      taxonName = (String)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.SOLUTION_NAME));
      taxonLevel = (String)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.SOLUTION_RANK));
      justification = (Description)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.SOLUTION_JUSTIFICATION));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Solution");
     }
   }

}
