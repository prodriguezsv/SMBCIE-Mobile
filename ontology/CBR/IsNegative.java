package ontology.CBR;


import jade.content.abs.*;
import jade.content.onto.*;

/**
* Protege name: IsNegative
* @author ontology bean generator
* @version 2009/10/17, 15:02:30
*/
public class IsNegative implements jade.content.Predicate, Introspectable {

  private static final long serialVersionUID = 5105464549008041109L;

  private String _internalInstanceName = null;

  public IsNegative() {
    this._internalInstanceName = "";
  }

  public IsNegative(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: case
   */
   private Case aCase;
   public void setCase(Case value) {
    this.aCase=value;
   }
   public Case getCase() {
     return this.aCase;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(CBRTerminologyOntology.ISNEGATIVE_CASE, (AbsTerm) onto.fromObject(getCase()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising IsNegative");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      aCase = (Case)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.ISNEGATIVE_CASE));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising IsNegative");
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
//* Protege name: IsNegative
//* @author ontology bean generator
//* @version 2009/10/6, 23:03:27
//*/
//public class IsNegative implements jade.content.Predicate, Serializable {
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
//  public IsNegative() {
//    this._internalInstanceName = "";
//  }
//
//  public IsNegative(String instance_name) {
//    this._internalInstanceName = instance_name;
//  }
//
//  public String toString() {
//    return _internalInstanceName;
//  }
//
//   /**
//   * Protege name: case
//   */
//   private Case aCase;
//   public void setCase(Case value) {
//     pcs.firePropertyChange("case", (this.aCase==null?new Case():this.aCase), value);
//    this.aCase=value;
//   }
//   public Case getCase() {
//     return this.aCase;
//   }
//}
