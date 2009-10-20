package ontology.taxonomy;

import jade.content.abs.AbsConcept;
import jade.content.abs.AbsObject;
import jade.content.abs.AbsTerm;
import jade.content.onto.Introspectable;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import ontology.common.Descriptor;

/**
 * 
 * @author Armando
 *
 */
public class WeightedDescriptor implements jade.content.Concept, Introspectable {
	private Descriptor descriptor;
	private Modifier modifier;

	/**
	 * 
	 * @param descriptor
	 */
	public WeightedDescriptor(Descriptor descriptor) {
		this.setDescriptor(descriptor);
		this.setModifier(new Modifier(1, 1, 1));
	}

	public WeightedDescriptor(Descriptor descriptor, Modifier modifier) {
		this.setDescriptor(descriptor);
		this.setModifier(modifier);
	}

	private String _internalInstanceName = null;

	public WeightedDescriptor() {
		this._internalInstanceName = "";
	}

	public WeightedDescriptor(String instance_name) {
		this._internalInstanceName = instance_name;
	}

	public String toString() {
		return _internalInstanceName;
	}

	public void setDescriptor(Descriptor descriptor) {
		this.descriptor = descriptor;
	}

	public Descriptor getDescriptor() {
		return descriptor;
	}

	public void setModifier(Modifier modifier) {
		this.modifier = modifier;
	}

	public Modifier getModifier() {
		return modifier;
	}
  public void externalise(AbsObject absObj, Ontology onto) throws jade.content.onto.OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(TaxonomyOntology.WEIGHTEDDESCRIPTOR_MODIFIER, (AbsTerm) onto.fromObject(getModifier()));
      abs.set(TaxonomyOntology.WEIGHTEDDESCRIPTOR_DESCRIPTOR, (AbsTerm) onto.fromObject(getDescriptor()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising WeightedDescriptor");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, jade.content.onto.OntologyException{
    try {
      AbsConcept abs = (AbsConcept) absObj;
      modifier = (Modifier)onto.toObject(abs.getAbsObject(TaxonomyOntology.WEIGHTEDDESCRIPTOR_MODIFIER));
      descriptor = (Descriptor)onto.toObject(abs.getAbsObject(TaxonomyOntology.WEIGHTEDDESCRIPTOR_DESCRIPTOR));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising WeightedDescriptor");
     }
   }
}
