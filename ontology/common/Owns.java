package ontology.common;


import jade.content.abs.*;
import jade.content.onto.*;

/**
* Protege name: Owns
* @author ontology bean generator
* @version 2009/10/17, 13:38:30
*/
public class Owns implements Introspectable {

  private static final long serialVersionUID = -5592382702946686995L;

  private String _internalInstanceName = null;

  public Owns() {
    this._internalInstanceName = "";
  }

  public Owns(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

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

   /**
   * Protege name: descriptiveElement
   */
   private Object descriptiveElement;
   public void setDescriptiveElement(Object value) { 
    this.descriptiveElement=value;
   }
   public Object getDescriptiveElement() {
     return this.descriptiveElement;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(CommonTerminologyOntology.OWNS_ATTRIBUTE, (AbsTerm) onto.fromObject(getAttribute()));
      abs.set(CommonTerminologyOntology.OWNS_DESCRIPTIVEELEMENT, (AbsTerm) onto.fromObject(getDescriptiveElement()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Owns");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      attribute = (String)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.OWNS_ATTRIBUTE));
      descriptiveElement = (Object)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.OWNS_DESCRIPTIVEELEMENT));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Owns");
     }
   }

}
