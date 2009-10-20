package ontology.CBR;

import jade.content.abs.*;
import jade.content.onto.*;
import jade.util.leap.*;

/**
* Protege name: AreReasonableSolutionsTo
* @author ontology bean generator
* @version 2009/10/17, 15:02:30
*/
public class AreReasonableSolutionsTo implements jade.content.Predicate, Introspectable {

  private String _internalInstanceName = null;

  public AreReasonableSolutionsTo() {
    this._internalInstanceName = "";
  }

  public AreReasonableSolutionsTo(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: proposedSolutions
   */
   private List proposedSolutions = new ArrayList();
   public void addProposedSolutions(ProposedSolution elem) {
     proposedSolutions.add(elem);
   }
   public boolean removeProposedSolutions(ProposedSolution elem) {
     boolean result = proposedSolutions.remove(elem);
     return result;
   }
   public void clearAllProposedSolutions() {
     proposedSolutions.clear();
   }
   public Iterator getAllProposedSolutions() {return proposedSolutions.iterator(); }
   public List getProposedSolutions() {return proposedSolutions; }
   public void setProposedSolutions(List l) {proposedSolutions = l; }

   /**
   * Protege name: problem
   */
   private Problem problem;
   public void setProblem(Problem value) {
    this.problem=value;
   }
   public Problem getProblem() {
     return this.problem;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(CBRTerminologyOntology.AREREASONABLESOLUTIONSTO_PROPOSEDSOLUTIONS, (AbsTerm) onto.fromObject(getProposedSolutions()));
      abs.set(CBRTerminologyOntology.AREREASONABLESOLUTIONSTO_PROBLEM, (AbsTerm) onto.fromObject(getProblem()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising AreReasonableSolutionsTo");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      proposedSolutions = (List)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.AREREASONABLESOLUTIONSTO_PROPOSEDSOLUTIONS));
      problem = (Problem)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.AREREASONABLESOLUTIONSTO_PROBLEM));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising AreReasonableSolutionsTo");
     }
   }

}
