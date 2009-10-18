package ontology.CBR;


import jade.content.abs.*;
import jade.content.onto.*;

/**
* Protege name: Retrieve
* @author ontology bean generator
* @version 2009/10/17, 15:02:30
*/
public class Retrieve implements jade.content.AgentAction, Introspectable {

  private static final long serialVersionUID = 5105464549008041109L;

  private String _internalInstanceName = null;

  public Retrieve() {
    this._internalInstanceName = "";
  }

  public Retrieve(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: similarTo
   */
   private Problem similarTo;
   public void setSimilarTo(Problem value) {
    this.similarTo=value;
   }
   public Problem getSimilarTo() {
     return this.similarTo;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsAgentAction abs = (AbsAgentAction) absObj;
      abs.set(CBRTerminologyOntology.RETRIEVE_SIMILARTO, (AbsTerm) onto.fromObject(getSimilarTo()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Retrieve");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsAgentAction abs = (AbsAgentAction) absObj;
      similarTo = (Problem)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.RETRIEVE_SIMILARTO));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Retrieve");
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
//* Protege name: Retrieve
//* @author ontology bean generator
//* @version 2009/10/6, 23:03:27
//*/
//public class Retrieve implements jade.content.AgentAction, Serializable {
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
//  public Retrieve() {
//    this._internalInstanceName = "";
//  }
//
//  public Retrieve(String instance_name) {
//    this._internalInstanceName = instance_name;
//  }
//
//  public String toString() {
//    return _internalInstanceName;
//  }
//
//   /**
//   * Protege name: similarTo
//   */
//   private Problem similarTo;
//   public void setSimilarTo(Problem value) {
//     pcs.firePropertyChange("similarTo", (this.similarTo==null?new Problem():this.similarTo), value);
//    this.similarTo=value;
//   }
//   public Problem getSimilarTo() {
//     return this.similarTo;
//   }
//
//}
