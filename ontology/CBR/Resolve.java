package ontology.CBR;


import jade.content.abs.*;
import jade.content.onto.*;
/**
* Protege name: Resolve
* @author ontology bean generator
* @version 2009/10/17, 15:02:30
*/
public class Resolve implements jade.content.AgentAction, Introspectable {

  private String _internalInstanceName = null;

  public Resolve() {
    this._internalInstanceName = "";
  }

  public Resolve(String instance_name) {
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

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsAgentAction abs = (AbsAgentAction) absObj;
      abs.set(CBRTerminologyOntology.RESOLVE_PROBLEM, (AbsTerm) onto.fromObject(getProblem()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Resolve");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsAgentAction abs = (AbsAgentAction) absObj;
      problem = (Problem)onto.toObject(abs.getAbsObject(CBRTerminologyOntology.RESOLVE_PROBLEM));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Resolve");
     }
   }

}
