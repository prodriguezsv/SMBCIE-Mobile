package ontology.CBR;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.util.leap.*;

/**
* Protege name: AreSimilarTo
* @author ontology bean generator
* @version 2009/10/17, 15:02:30
*/
public class AreSimilarTo implements jade.content.Predicate, Introspectable {

  private String _internalInstanceName = null;

  public AreSimilarTo() {
    this._internalInstanceName = "";
  }

  public AreSimilarTo(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

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
      abs.set(CBRTerminologyOntology.ARESIMILARTO_PROBLEM, (AbsTerm) onto.fromObject(getProblem()));
      abs.set(CBRTerminologyOntology.ARESIMILARTO_SUCCESSFULCONFLICTSET, (AbsTerm) onto.fromObject(getSuccessfulConflictSet()));
      abs.set(CBRTerminologyOntology.ARESIMILARTO_FAILURECONFLICTSET, (AbsTerm) onto.fromObject(getFailureConflictSet()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising AreSimilarTo");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      problem = (Problem)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.ARESIMILARTO_PROBLEM));
      successfulConflictSet = (List)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.ARESIMILARTO_SUCCESSFULCONFLICTSET));
      failureConflictSet = (List)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.ARESIMILARTO_FAILURECONFLICTSET));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising AreSimilarTo");
     }
   }

}
