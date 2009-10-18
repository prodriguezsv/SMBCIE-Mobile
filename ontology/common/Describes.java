package ontology.common;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.util.leap.*;

/**
* Protege name: Describes
* @author ontology bean generator
* @version 2009/10/17, 13:38:30
*/
public class Describes implements Introspectable {

  private static final long serialVersionUID = -5592382702946686995L;

  private String _internalInstanceName = null;

  public Describes() {
    this._internalInstanceName = "";
  }

  public Describes(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: score
   */
   private List score = new ArrayList();
   public void addScore(Object elem) { 
     score.add(elem);
   }
   public boolean removeScore(Object elem) {
     boolean result = score.remove(elem);
     return result;
   }
   public void clearAllScore() {
     score.clear();
   }
   public Iterator getAllScore() {return score.iterator(); }
   public List getScore() {return score; }
   public void setScore(List l) {score = l; }

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
      abs.set(CommonTerminologyOntology.DESCRIBES_SCORE, (AbsTerm) onto.fromObject(getScore()));
      abs.set(CommonTerminologyOntology.DESCRIBES_ATTRIBUTE, (AbsTerm) onto.fromObject(getAttribute()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Describes");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      score = (List)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.DESCRIBES_SCORE));
      attribute = (String)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.DESCRIBES_ATTRIBUTE));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Describes");
     }
   }

}
