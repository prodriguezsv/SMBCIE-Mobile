/**
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




/**
 * @author Armando
 *
 */
public class ProposedSolution implements jade.content.Concept, Introspectable{
	private String certaintyDegree;
	private PossibleSolution solution;
	private boolean state;

	/**
	 * @see "Método initialize del protocolo initializing en SUKIA SmallTalk"
	 */
	public ProposedSolution() {
		this._internalInstanceName = "";
		this.setSolution(null);
		this.setState(true);
		this.setCertaintyDegree(CertaintyDegree.UNKNOWN);
	}

	private String _internalInstanceName = null;

  	public ProposedSolution(String instance_name) {
	  this._internalInstanceName = instance_name;
  	}

  	public String toString() {
	  return _internalInstanceName;
  	}

	/**
	 * The only possible values for this variable are:
	 * #unknown or #uncertain or #doubfult or #certain
	 * @param certaintyDegree
	 */
	public void setCertaintyDegree(String aCertaintyDegree) {
		this.certaintyDegree = aCertaintyDegree;
	}

	/**
	 * @see "Método degreeOfCertainty del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public String getCertaintyDegree() {
		return certaintyDegree;
	}

	/**
	 * @see "Método solution: del protocolo adding en SUKIA SmallTalk"
	 * @param solution
	 */
	public void setSolution(PossibleSolution solution) {
		this.solution = solution;
	}

	/**
	 * @see "Método solution del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public PossibleSolution getSolution() {
		return solution;
	}

	/**
	 * The only possible values for this variable are:
	 * #+ (a positive PossibleSolution)
	 * #- (a negative PossibleSolution)"
	 * @param status
	 */
	public void setState(boolean status) {
		this.state = status;
	}

	/**
	 * @see "Método status del protocolo accessing en SUKIA SmallTalk"
	 * @return
	 */
	public boolean getState() {
		return state;
	}

 public void externalise(AbsObject absObj, Ontology onto) throws OntologyException, jade.content.onto.OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(CBRTerminologyOntology.PROPOSEDSOLUTION_STATE, state);
      abs.set(CBRTerminologyOntology.PROPOSEDSOLUTION_CERTAINTYDEGREE, (AbsTerm) onto.fromObject(getCertaintyDegree()));
      abs.set(CBRTerminologyOntology.PROPOSEDSOLUTION_SOLUTION, (AbsTerm) onto.fromObject(getSolution()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising ProposedSolution");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException, jade.content.onto.OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      state = abs.getBoolean(CBRTerminologyOntology.PROPOSEDSOLUTION_STATE);
      certaintyDegree = (String)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.PROPOSEDSOLUTION_CERTAINTYDEGREE));
      solution = (PossibleSolution)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.PROPOSEDSOLUTION_SOLUTION));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising ProposedSolution");
     }
   }

}
