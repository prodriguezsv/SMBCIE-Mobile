package ontology.taxonomy;


import jade.content.abs.*;
import jade.content.onto.*;


/**
* Protege name: Modifier
* @author ontology bean generator
* @version 2009/10/17, 17:24:41
*/
public class Modifier implements jade.content.Concept, Introspectable {

  private static final long serialVersionUID = 1077790999883901504L;

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

  	public Modifier(float structureWeight, float atributeWeight, float valueWeight) {
		setStructureWeight(structureWeight);
		setAttributeWeight(atributeWeight);
		setAttributeWeight(valueWeight);
	}

   /**
   * Protege name: structureWeight
   */
   private float structureWeight;
   public void setStructureWeight(float value) {
    this.structureWeight=value;
   }
   public float getStructureWeight() {
     return this.structureWeight;
   }

   /**
   * Protege name: scoreWeight
   */
   private float scoreWeight;
   public void setScoreWeight(float value) {
    this.scoreWeight=value;
   }
   public float getScoreWeight() {
     return this.scoreWeight;
   }

   /**
   * Protege name: attributeWeight
   */
   private float attributeWeight;
   public void setAttributeWeight(float value) {
    this.attributeWeight=value;
   }
   public float getAttributeWeight() {
     return this.attributeWeight;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(TaxonomyOntology.MODIFIER_STRUCTUREWEIGHT, (long)structureWeight);
      abs.set(TaxonomyOntology.MODIFIER_VALUEWEIGHT, (long)scoreWeight);
      abs.set(TaxonomyOntology.MODIFIER_ATTRIBUTEWEIGHT, (long)attributeWeight);
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Modifier");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      structureWeight = abs.getLong(TaxonomyOntology.MODIFIER_STRUCTUREWEIGHT);
      scoreWeight = abs.getLong(TaxonomyOntology.MODIFIER_VALUEWEIGHT);
      attributeWeight = abs.getLong(TaxonomyOntology.MODIFIER_ATTRIBUTEWEIGHT);
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Modifier");
     }
   }

}


///**
// *
// */
//package ontology.taxonomy;
//
//import java.io.Serializable;
//
///**
// * @author Armando
// *
// */
//public class Modifier implements jade.content.Concept, Serializable {
//	private double structureWeight;
//	private double attributeWeight;
//	private double valueWeight;
//
//	/**
//	 *
//	 */
//	public Modifier() {
//		this._internalInstanceName = "";
//	}
//
//	private static final long serialVersionUID = -8627856865395943317L;
//
//	private String _internalInstanceName = null;
//
//  	public Modifier(String instance_name) {
//	  this._internalInstanceName = instance_name;
//  	}
//
//  	public String toString() {
//	  return _internalInstanceName;
//  	}
//
//	/**
//	 *
//	 */
//	public Modifier(double structureWeight, double atributeWeight, double valueWeight) {
//		setStructureWeight(structureWeight);
//		setAttributeWeight(atributeWeight);
//		setValueWeight(valueWeight);
//	}
//
//	/**
//	 *
//	 * @param structureWeight
//	 */
//	public void setStructureWeight(double structureWeight) {
//		this.structureWeight = structureWeight;
//	}
//
//	/**
//	 *
//	 * @return
//	 */
//	public double getStructureWeight() {
//		return structureWeight;
//	}
//
//	/**
//	 *
//	 * @param atributeWeight
//	 */
//	public void setAttributeWeight(double atributeWeight) {
//		this.attributeWeight = atributeWeight;
//	}
//
//	/**
//	 *
//	 * @return
//	 */
//	public double getAttributeWeight() {
//		return attributeWeight;
//	}
//
//	/**
//	 *
//	 * @param valueWeight
//	 */
//	public void setValueWeight(double valueWeight) {
//		this.valueWeight = valueWeight;
//	}
//
//	/**
//	 *
//	 * @return
//	 */
//	public double getValueWeight() {
//		return valueWeight;
//	}
//}
