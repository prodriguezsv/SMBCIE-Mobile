package ontology.CBR;

import jade.content.abs.*;
import jade.content.onto.*;

/**
* Protege name: IsTheMostReasonableTo
* @author ontology bean generator
* @version 2009/10/17, 15:02:30
*/
public class IsTheMostReasonableTo implements jade.content.Predicate, Introspectable {

  private static final long serialVersionUID = 5105464549008041109L;

  private String _internalInstanceName = null;

  public IsTheMostReasonableTo() {
    this._internalInstanceName = "";
  }

  public IsTheMostReasonableTo(String instance_name) {
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
   * Protege name: proposedSolution
   */
   private ProposedSolution proposedSolution;
   public void setProposedSolution(ProposedSolution value) {
    this.proposedSolution=value;
   }
   public ProposedSolution getProposedSolution() {
     return this.proposedSolution;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(CBRTerminologyOntology.ISTHEMOSTREASONABLETO_PROBLEM, (AbsTerm) onto.fromObject(getProblem()));
      abs.set(CBRTerminologyOntology.ISTHEMOSTREASONABLETO_PROPOSEDSOLUTION, (AbsTerm) onto.fromObject(getProposedSolution()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising IsTheMostReasonableTo");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      problem = (Problem)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.ISTHEMOSTREASONABLETO_PROBLEM));
      proposedSolution = (ProposedSolution)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.ISTHEMOSTREASONABLETO_PROPOSEDSOLUTION));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising IsTheMostReasonableTo");
     }
   }

}

//package ontology.CBR;
//
//import java.io.Serializable;
//import java.beans.PropertyChangeSupport;
//import java.beans.PropertyChangeListener;
//
//
///**
//* Protege name: IsTheMostReasonableTo
//* @author ontology bean generator
//* @version 2009/10/6, 23:03:27
//*/
//public class IsTheMostReasonableTo implements jade.content.Predicate, Serializable {
//   // bean stuff
//   protected PropertyChangeSupport pcs = new PropertyChangeSupport(this);
//
//   public void addPropertyChangeListener(PropertyChangeListener pcl) {
//     pcs.addPropertyChangeListener(pcl);
//   }
//
//   public void removePropertyChangeListener(PropertyChangeListener pcl) {
//     pcs.removePropertyChangeListener(pcl);
//   }
//
//
//  private static final long serialVersionUID = 4206237779038972396L;
//
//  private String _internalInstanceName = null;
//
//  public IsTheMostReasonableTo() {
//    this._internalInstanceName = "";
//  }
//
//  public IsTheMostReasonableTo(String instance_name) {
//    this._internalInstanceName = instance_name;
//  }
//
//  public String toString() {
//    return _internalInstanceName;
//  }
//
//   /**
//   * Protege name: proposedSolution
//   */
//   private ProposedSolution proposedSolution;
//   public void setProposedSolution(ProposedSolution value) {
//     pcs.firePropertyChange("proposedSolution", (this.proposedSolution==null?new ProposedSolution():this.proposedSolution), value);
//    this.proposedSolution=value;
//   }
//   public ProposedSolution getProposedSolution() {
//     return this.proposedSolution;
//   }
//
//   /**
//   * Protege name: problema
//   */
//   private Problem problema;
//   public void setProblema(Problem value) {
//     pcs.firePropertyChange("problema", (this.problema==null?new Problem():this.problema), value);
//    this.problema=value;
//   }
//   public Problem getProblema() {
//     return this.problema;
//   }
//
//}
