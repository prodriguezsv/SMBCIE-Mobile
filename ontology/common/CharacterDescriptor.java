package ontology.common;

public abstract class CharacterDescriptor extends Descriptor {
	public CharacterDescriptor() {
		super();
	}

	public CharacterDescriptor(String instance_name) {
		super(instance_name);
	}

	/**
	 * Método agregado
	 */
	public CharacterDescriptor(String aStructure, String anAttribute) {
		super(aStructure, anAttribute);
	}
}

