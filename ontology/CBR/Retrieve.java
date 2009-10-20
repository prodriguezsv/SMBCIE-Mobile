package ontology.CBR;


import jade.content.abs.*;
import jade.content.onto.*;

/**
* Protege name: Retrieve
* @author ontology bean generator
* @version 2009/10/17, 15:02:30
*/
public class Retrieve implements jade.content.AgentAction, Introspectable {

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
