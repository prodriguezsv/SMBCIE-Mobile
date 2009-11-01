package ontology.taxonomy;


import jade.content.abs.*;
import jade.content.onto.*;


/**
* Protege name: Modifier
* @author ontology bean generator
* @version 2009/10/17, 17:24:41
*/
public class Modifier implements jade.content.Concept, Introspectable {

  private String _internalInstanceName = null;

  public Modifier() {
    this._internalInstanceName = "";
  }

  public Modifier(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

  	public Modifier(String structureWeight, String atributeWeight, String valueWeight) {
		setStructureWeight(structureWeight);
		setAttributeWeight(atributeWeight);
		setAttributeWeight(valueWeight);
	}

   /**
   * Protege name: structureWeight
   */
   private String structureWeight;
   public void setStructureWeight(String value) {
    this.structureWeight=value;
   }
   public String getStructureWeight() {
     return this.structureWeight;
   }

   /**
   * Protege name: scoreWeight
   */
   private String valueWeight;
   public void setValueWeight(String value) {
    this.valueWeight=value;
   }
   public String getValueWeight() {
     return this.valueWeight;
   }

   /**
   * Protege name: attributeWeight
   */
   private String attributeWeight;
   public void setAttributeWeight(String value) {
    this.attributeWeight=value;
   }
   public String getAttributeWeight() {
     return this.attributeWeight;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(TaxonomyOntology.MODIFIER_STRUCTUREWEIGHT, (String)structureWeight);
      abs.set(TaxonomyOntology.MODIFIER_VALUEWEIGHT, (String)valueWeight);
      abs.set(TaxonomyOntology.MODIFIER_ATTRIBUTEWEIGHT, (String)attributeWeight);
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Modifier");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      structureWeight = (String)onto.toObject(abs.getAbsObject(TaxonomyOntology.MODIFIER_STRUCTUREWEIGHT));
      valueWeight = (String)onto.toObject(abs.getAbsObject(TaxonomyOntology.MODIFIER_VALUEWEIGHT));
      attributeWeight = (String)onto.toObject(abs.getAbsObject(TaxonomyOntology.MODIFIER_ATTRIBUTEWEIGHT));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Modifier");
     }
   }

}
