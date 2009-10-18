/**
 * Paquete que reune los conceptos CBR, sus relaciones y sus restricciones de uso
 */
package ontology.CBR;

import edu.stanford.smi.protege.exception.OntologyException;
import jade.content.abs.AbsConcept;
import jade.content.abs.AbsObject;
import jade.content.abs.AbsTerm;
import jade.content.onto.Introspectable;

import jade.content.onto.Ontology;
import jade.content.onto.UngroundedException;
import ontology.common.Description;
import ontology.taxonomy.TaxonomicRank;

/**
 * Representa la especificación de un problema particular a resolver
 * @author Armando
 *
 */
public class Problem implements jade.content.Concept, Introspectable {
	/**
	 * A list containing a set of Descriptor's (a description of the problem)
	 */
	private Description description;
	/**
	 * Especifica la meta de identificaci&oacute;n
	 */
	private String goalRank;
	/**
	 * Especifica la espectativa de desempe&ntilde;o m&iacute;nima
	 */
	private String leastSimilarityDegree;

	/**
	 * Constructor por defecto
	 */
	public Problem() {
		this._internalInstanceName = "";
		description = new Description();
		goalRank = null;
		leastSimilarityDegree = null;
	}
	
	private static final long serialVersionUID = 4206237779038972396L;

  	private String _internalInstanceName = null;

  	public Problem(String instance_name) {
	  this._internalInstanceName = instance_name;
  	}
//
//    Problem(Description description) {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }

  	public String toString() {
	  return _internalInstanceName;
  	}
	
	/**
	 * Constructor por defecto
	 */
	public Problem(Description description) {
		this.description = description;
		goalRank = null;
		leastSimilarityDegree = null;
	}

	/**
	 * M&eacute;todo accesor de escritura
	 * @param description
	 */
	public void setDescription(Description description) {
		this.description = description;
	}

	/**
	 * M&eacute;todo accesor de lectura
	 * @return
	 */
	public Description getDescription() {
		return description;
	}

	/**
	 * M&eacute;todo accesor de escritura
	 * @param goalRank
	 */
	public void setGoalRank(String goalRank) {
		boolean iscontained = false;

                for (int i = 0; i<TaxonomicRank.values.size();i++){
                    if (TaxonomicRank.values.get(i).equals(goalRank)){
                        iscontained = true;
                        break;
                    }
                }
		if (iscontained) this.goalRank = goalRank;
	}

	/**
	 * M&eacute;todo accesor de lectura
	 * @return
	 */
	public String getGoalRank() {
		return goalRank;
	}

	/**
	 * M&eacute;todo accesor de escritura
	 * @param leastDegreeOfCertainty
	 */
	public void setLeastSimilarityDegree(String leastDegreeOfCertainty) {
		boolean iscontained = false;

                for (int i = 0 ; i<SimilarityDegree.values.size();i++){
                    if (SimilarityDegree.values.get(i).equals(leastDegreeOfCertainty)){
                        iscontained = true;
                        break;
                    }
                }
		if (iscontained) this.leastSimilarityDegree = leastDegreeOfCertainty;;
	}
	
	/**
	 * M&eacute;todo accesor de lectura
	 * @return
	 */
	public String getLeastSimilarityDegree() {
		return leastSimilarityDegree;
	}
  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException, jade.content.onto.OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(CBRTerminologyOntology.PROBLEM_GOALRANK, (AbsTerm) onto.fromObject(getGoalRank()));
      abs.set(CBRTerminologyOntology.PROBLEM_LEASTSIMILARITYDEGREE, (AbsTerm) onto.fromObject(getLeastSimilarityDegree()));
      abs.set(CBRTerminologyOntology.PROBLEM_DESCRIPTION, (AbsTerm) onto.fromObject(getDescription()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Problem");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException, jade.content.onto.OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      goalRank = (String)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.PROBLEM_GOALRANK));
      leastSimilarityDegree = (String)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.PROBLEM_LEASTSIMILARITYDEGREE));
      description = (Description)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.PROBLEM_DESCRIPTION));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Problem");
     }
   }
	
}
