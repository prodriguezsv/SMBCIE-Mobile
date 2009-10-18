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

  private static final long serialVersionUID = 5105464549008041109L;

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

//package ontology.CBR;
//
//import java.io.Serializable;
//import java.beans.PropertyChangeSupport;
//import java.beans.PropertyChangeListener;
//
//import jade.util.leap.*;
//
///**
//* Protege name: AreSimilarTo
//* @author ontology bean generator
//* @version 2009/10/6, 23:03:27
//*/
//public class AreSimilarTo implements jade.content.Predicate, Serializable {
//	   // bean stuff
//	   protected PropertyChangeSupport pcs = new PropertyChangeSupport(this);
//
//	   public void addPropertyChangeListener(PropertyChangeListener pcl) {
//	     pcs.addPropertyChangeListener(pcl);
//	   }
//
//	   public void removePropertyChangeListener(PropertyChangeListener pcl) {
//	     pcs.removePropertyChangeListener(pcl);
//	   }
//
//
//	  private static final long serialVersionUID = -6222351541834602176L;
//
//	  private String _internalInstanceName = null;
//
//	  public AreSimilarTo() {
//	    this._internalInstanceName = "";
//	  }
//
//	  public AreSimilarTo(String instance_name) {
//	    this._internalInstanceName = instance_name;
//	  }
//
//	  public String toString() {
//	    return _internalInstanceName;
//	  }
//
//	   /**
//	   * Protege name: successfulConflictSet
//	   */
//	   private List successfulConflictSet = new ArrayList();
//	   public void addSuccessfulConflictSet(Hypothesis elem) {
//	     successfulConflictSet.add(elem);
//	     //pcs.firePropertyChange("successfulConflictSet", oldList, this.successfulConflictSet);
//	   }
//	   public boolean removeSuccessfulConflictSet(Hypothesis elem) {
//	     boolean result = successfulConflictSet.remove(elem);
//	     //pcs.firePropertyChange("successfulConflictSet", oldList, this.successfulConflictSet);
//	     return result;
//	   }
//	   public void clearAllSuccessfulConflictSet() {
//	     successfulConflictSet.clear();
//	     //pcs.firePropertyChange("successfulConflictSet", oldList, this.successfulConflictSet);
//	   }
//	   public Iterator getAllSuccessfulConflictSet() {return successfulConflictSet.iterator(); }
//	   public List getSuccessfulConflictSet() {return successfulConflictSet; }
//	   public void setSuccessfulConflictSet(List l) {successfulConflictSet = l; }
//
//	   /**
//	   * Protege name: problem
//	   */
//	   private Problem problem;
//	   public void setProblem(Problem value) {
//	     pcs.firePropertyChange("problem", (this.problem==null?new Problem():this.problem), value);
//	    this.problem=value;
//	   }
//	   public Problem getProblem() {
//	     return this.problem;
//	   }
//
//	   /**
//	   * Protege name: failureConflictSet
//	   */
//	   private List failureConflictSet = new ArrayList();
//	   public void addFailureConflictSet(Hypothesis elem) {
//	     failureConflictSet.add(elem);
//	     //pcs.firePropertyChange("failureConflictSet", oldList, this.failureConflictSet);
//	   }
//	   public boolean removeFailureConflictSet(Hypothesis elem) {
//	     boolean result = failureConflictSet.remove(elem);
//	     //pcs.firePropertyChange("failureConflictSet", oldList, this.failureConflictSet);
//	     return result;
//	   }
//	   public void clearAllFailureConflictSet() {
//	     failureConflictSet.clear();
//	     //pcs.firePropertyChange("failureConflictSet", oldList, this.failureConflictSet);
//	   }
//	   public Iterator getAllFailureConflictSet() {return failureConflictSet.iterator(); }
//	   public List getFailureConflictSet() {return failureConflictSet; }
//	   public void setFailureConflictSet(List l) {failureConflictSet = l; }
//
//}
