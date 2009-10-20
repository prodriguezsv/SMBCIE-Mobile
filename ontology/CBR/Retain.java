package ontology.CBR;


import jade.content.abs.*;
import jade.content.onto.*;

/**
* Protege name: Retain
* @author ontology bean generator
* @version 2009/10/17, 15:02:30
*/
public class Retain implements jade.content.AgentAction, Introspectable {

  private String _internalInstanceName = null;

  public Retain() {
    this._internalInstanceName = "";
  }

  public Retain(String instance_name) {
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
      AbsAgentAction abs = (AbsAgentAction) absObj;
      abs.set(CBRTerminologyOntology.RETAIN_CASE, (AbsTerm) onto.fromObject(getCase()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Retain");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsAgentAction abs = (AbsAgentAction) absObj;
      aCase = (Case)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.RETAIN_CASE));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Retain");
     }
   }

}
