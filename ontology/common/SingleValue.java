/**
 * @see "Categor�a Sukia Values de SUKIA Smalltalk"
 */
package ontology.common;

import jade.content.abs.AbsConcept;
import jade.content.abs.AbsObject;
import jade.content.abs.AbsPrimitive;
import jade.content.abs.AbsTerm;
import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;

/**
 * @author Armando
 *
 */
public class SingleValue extends Value{
	private String value;

  	private String _internalInstanceName = null;

  	public String get_internalInstanceName() {
		return _internalInstanceName;
	}

	public SingleValue() {
	  this._internalInstanceName = "";
  	}

  	public SingleValue(String instance_name) {
	  this._internalInstanceName = instance_name;
  	}	

	/**
	 * Constructor altenativo
	 */
	public SingleValue(String aValue, String measuringUnit) {
		this.setValue(aValue);
		this.setMeasuringUnit(measuringUnit);
	}
	
	/**
	 * Constructor altenativo
	 */
	public SingleValue(SingleValue aSingleValue) {
		this.setValue(aSingleValue.getValue());
		this.setMeasuringUnit(aSingleValue.getMeasuringUnit());
	}
	
	/**
	 * @see "M�todo value del protocolo accessing-weighted values en SUKIA SmallTalk"
	 * @return
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * @see "M�todo value: del protocolo adding-weighted values en SUKIA SmallTalk"
	 * @param state
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * M�todo agregado
	 * @param aValue
	 * @return
	 */
	public boolean equals(Object aValue) {
		if (aValue == null) return false;
		if (!(aValue instanceof SingleValue)) return false;
		
		if (this.getValue() == ((SingleValue)aValue).getValue())
			return true;
		else return false;
	}
	
 
    /**
	 * 
	 */
	public String toString() {
		return  this.getValue()+ " " + this.getMeasuringUnit();
	}


        public void externalise(AbsObject absObj, Ontology onto) throws OntologyException, jade.content.onto.OntologyException {
            try {
                AbsConcept abs = (AbsConcept) absObj;
                abs.set(CommonTerminologyOntology.VALUE_MEASURINGUNIT, (AbsTerm) onto.fromObject(getMeasuringUnit()));
                AbsPrimitive aPrimitive = new AbsPrimitive(BasicOntology.STRING);
                aPrimitive.set(getValue());
                abs.set(CommonTerminologyOntology.SINGLEVALUE_VALUE, aPrimitive);
            } catch (ClassCastException cce) {
                throw new OntologyException("Error externalising Value");
            }
        }

        public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException, jade.content.onto.OntologyException {
            try {
                AbsConcept abs = (AbsConcept) absObj;
                setMeasuringUnit((String)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.VALUE_MEASURINGUNIT)));
                setValue(((AbsPrimitive)(abs.getAbsTerm(CommonTerminologyOntology.SINGLEVALUE_VALUE))).getString());
            } catch (ClassCastException cce) {
                throw new OntologyException("Error internalising Value");
            }
        }
}
