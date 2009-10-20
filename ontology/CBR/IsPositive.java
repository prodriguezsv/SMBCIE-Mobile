package ontology.CBR;


import jade.content.abs.*;
import jade.content.onto.*;

/**
* Protege name: IsPositive
* @author ontology bean generator
* @version 2009/10/17, 15:02:30
*/
public class IsPositive implements jade.content.Predicate, Introspectable {

  private String _internalInstanceName = null;

  public IsPositive() {
    this._internalInstanceName = "";
  }

  public IsPositive(String instance_name) {
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
      abs.set(CBRTerminologyOntology.ISPOSITIVE_CASE, (AbsTerm) onto.fromObject(getCase()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising IsPositive");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      aCase = (Case)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.ISPOSITIVE_CASE));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising IsPositive");
     }
   }

}
