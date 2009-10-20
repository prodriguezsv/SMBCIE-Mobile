/**
 * @see "Categor&iacute;a Main de SUKIA Smalltalk"
 */
package ontology.common;

import jade.content.abs.AbsConcept;
import jade.content.abs.AbsObject;
import jade.content.abs.AbsTerm;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import jade.util.leap.ArrayList;
import jade.util.leap.List;

/**
 * Descriptor es un elemento descriptivo de la descripción de un caso: el par attribute-value.
 * Generaliza conceptos en normas.
 * Todas las raíces de red (especializaciónes de normas) contienen un descriptor de la forma (nil, nil),
 * ya que ning&uacute;n par attribute-value particular generaliza todos los casos bajo ellos.
 * 
*/
public class MSCharacterDescriptor extends QualitativeCharacterDescriptor {
	private List value;
	
	public MSCharacterDescriptor() {
		value = new ArrayList();
	}
	
	private static final long serialVersionUID = -3087841394215437493L;

	public MSCharacterDescriptor(String instance_name) {
		super(instance_name);
		value = new ArrayList();
	}
	
	/**
	 * Class instance invariant: self MUST always have exactly two values. The first
	 * element corresponds to the descriptor's attribute, and the second one to the value.
	 * Extreme care should be taken when using this method, as it assumes an empty self."
	 * @see "M&eacute;todo initialize del protocolo initializing en SUKIA SmallTalk"
	 */
	public MSCharacterDescriptor(String aStructure, String anAttribute, List aValue) {
		super(aStructure, anAttribute);
		this.setValue(aValue);
	}
   
   public void setValue(Object value) {
	   this.value = (List) value;
   }
	
   public Object getValue() {
	   return (List)value;
   }
   
   public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(CommonTerminologyOntology.MSCHARACTERDESCRIPTOR_VALUE, (AbsTerm) onto.fromObject(getValue()));
      abs.set(CommonTerminologyOntology.DESCRIPTOR_ATTRIBUTE, (AbsTerm) onto.fromObject(getAttribute()));
      abs.set(CommonTerminologyOntology.DESCRIPTOR_STRUCTURE, (AbsTerm) onto.fromObject(getStructure()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising MSCharacterDescriptor");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      value = (List)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.MSCHARACTERDESCRIPTOR_VALUE));
      setAttribute((String)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.DESCRIPTOR_ATTRIBUTE)));
      setStructure((String)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.DESCRIPTOR_STRUCTURE)));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising MSCharacterDescriptor");
     }
   }

}
