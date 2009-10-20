package ontology.common;


import jade.content.abs.*;
import jade.content.onto.*;

/**
* Protege name: ApliesTo
* @author ontology bean generator
* @version 2009/10/17, 11:50:19
*/
public class ApliesTo implements jade.content.Predicate, Introspectable {

  private String _internalInstanceName = null;

  public ApliesTo() {
    this._internalInstanceName = "";
  }

  public ApliesTo(String instance_name) {
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
   private String descriptiveElement;
   public void setDescriptiveElement(String value) {
    this.descriptiveElement=value;
   }
   public String getDescriptiveElement() {
     return this.descriptiveElement;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(CommonTerminologyOntology.APPLIESTO_ATTRIBUTE, (AbsTerm) onto.fromObject(getAttribute()));
      abs.set(CommonTerminologyOntology.APPLIESTO_DESCRIPTIVEELEMENT, (AbsTerm) onto.fromObject(getDescriptiveElement()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising ApliesTo");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      attribute = (String)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.APPLIESTO_ATTRIBUTE));
      descriptiveElement = (String)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.APPLIESTO_DESCRIPTIVEELEMENT));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising ApliesTo");
     }
   }


}
