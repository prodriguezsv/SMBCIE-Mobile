package ontology.common;

public abstract class CharacterDescriptor extends Descriptor {
	public CharacterDescriptor() {
		super();
	}

	private static final long serialVersionUID = 6381899419476052518L;

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

