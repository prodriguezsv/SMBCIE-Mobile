package ontology.common;


import jade.content.abs.*;
import jade.content.onto.*;

/**
* Protege name: DescribedBy
* @author ontology bean generator
* @version 2009/10/17, 13:38:30
*/
public class DescribedBy implements Introspectable {

  private String _internalInstanceName = null;

  public DescribedBy() {
    this._internalInstanceName = "";
  }

  public DescribedBy(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: score
   */
   private String score;
   public String getScore() {return score; }
   public void setScore(String l) {score = l; }

   /**
   * Protege name: attribute
   */
   private String attribute;
   public void setAttribute(String value) { 
    this.attribute=value;
   }
   public String getAttribute() {
     return this.attribute;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(CommonTerminologyOntology.DESCRIBEDBY_SCORE, (AbsTerm) onto.fromObject(getScore()));
      abs.set(CommonTerminologyOntology.DESCRIBEDBY_ATTRIBUTE, (AbsTerm) onto.fromObject(getAttribute()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising DescribedBy");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      score = (String)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.DESCRIBEDBY_SCORE));
      attribute = (String)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.DESCRIBEDBY_ATTRIBUTE));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising DescribedBy");
     }
   }

}
