package ontology.CBR;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.util.leap.*;

/**
* Protege name: AreEvaluatedSolutionsTo
* @author ontology bean generator
* @version 2009/10/20, 12:01:13
*/
public class AreEvaluatedSolutionsTo implements jade.content.Predicate, Introspectable {

	  private String _internalInstanceName = null;

	  public AreEvaluatedSolutionsTo() {
	    this._internalInstanceName = "";
	  }

	  public AreEvaluatedSolutionsTo(String instance_name) {
	    this._internalInstanceName = instance_name;
	  }

	  public String toString() {
	    return _internalInstanceName;
	  }

	   /**
	   * Protege name: to
	   */
	   private Problem to;
	   public void setTo(Problem value) { 
	    this.to=value;
	   }
	   public Problem getTo() {
	     return this.to;
	   }

	   /**
	   * Protege name: successfulConflictSet
	   */
	   private List successfulConflictSet = new ArrayList();
	   public void addSuccessfulConflictSet(Hypothesis elem) { 
	     successfulConflictSet.add(elem);
	   }
	   public boolean removeSuccessfulConflictSet(Hypothesis elem) {
	     boolean result = successfulConflictSet.remove(elem);
	     return result;
	   }
	   public void clearAllSuccessfulConflictSet() {
	     successfulConflictSet.clear();
	   }
	   public Iterator getAllSuccessfulConflictSet() {return successfulConflictSet.iterator(); }
	   public List getSuccessfulConflictSet() {return successfulConflictSet; }
	   public void setSuccessfulConflictSet(List l) {successfulConflictSet = l; }

	   /**
	   * Protege name: failureConflictSet
	   */
	   private List failureConflictSet = new ArrayList();
	   public void addFailureConflictSet(Hypothesis elem) { 
	     failureConflictSet.add(elem);
	   }
	   public boolean removeFailureConflictSet(Hypothesis elem) {
	     boolean result = failureConflictSet.remove(elem);
	     return result;
	   }
	   public void clearAllFailureConflictSet() {
	     failureConflictSet.clear();
	   }
	   public Iterator getAllFailureConflictSet() {return failureConflictSet.iterator(); }
	   public List getFailureConflictSet() {return failureConflictSet; }
	   public void setFailureConflictSet(List l) {failureConflictSet = l; }

	  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
	    try {
	      AbsPredicate abs = (AbsPredicate) absObj;
	      abs.set(CBRTerminologyOntology.AREEVALUATEDSOLUTIONSTO_TO, (AbsTerm) onto.fromObject(getTo()));
	      abs.set(CBRTerminologyOntology.AREEVALUATEDSOLUTIONSTO_SUCCESSFULCONFLICTSET, (AbsTerm) onto.fromObject(getSuccessfulConflictSet()));
	      abs.set(CBRTerminologyOntology.AREEVALUATEDSOLUTIONSTO_FAILURECONFLICTSET, (AbsTerm) onto.fromObject(getFailureConflictSet()));
	     } catch (ClassCastException cce) {
	       throw new OntologyException("Error externalising AreEvaluatedSolutionsTo");
	     }
	   }

	  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
	    try {
	      AbsPredicate abs = (AbsPredicate) absObj;
	      to = (Problem)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.AREEVALUATEDSOLUTIONSTO_TO));
	      successfulConflictSet = (List)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.AREEVALUATEDSOLUTIONSTO_SUCCESSFULCONFLICTSET));
	      failureConflictSet = (List)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.AREEVALUATEDSOLUTIONSTO_FAILURECONFLICTSET));
	     } catch (ClassCastException cce) {
	       throw new OntologyException("Error internalising AreEvaluatedSolutionsTo");
	     }
	   }

}
