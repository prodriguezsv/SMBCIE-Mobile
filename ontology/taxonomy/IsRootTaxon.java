package ontology.taxonomy;


import jade.content.abs.*;
import jade.content.onto.*;

/**
* Protege name: IsRootTaxon
* @author ontology bean generator
* @version 2009/10/17, 17:24:41
*/
public class IsRootTaxon implements jade.content.Predicate, Introspectable {

  private static final long serialVersionUID = 1077790999883901504L;

  private String _internalInstanceName = null;

  public IsRootTaxon() {
    this._internalInstanceName = "";
  }

  public IsRootTaxon(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: taxon
   */
   private Taxon taxon;
   public void setTaxon(Taxon value) {
    this.taxon=value;
   }
   public Taxon getTaxon() {
     return this.taxon;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(TaxonomyOntology.ISROOTTAXON_TAXON, (AbsTerm) onto.fromObject(getTaxon()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising IsRootTaxon");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      taxon = (Taxon)onto.toObject(abs.getAbsObject(TaxonomyOntology.ISROOTTAXON_TAXON));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising IsRootTaxon");
     }
   }

}


//package ontology.taxonomy;
//
//import java.io.Serializable;
//import java.beans.PropertyChangeSupport;
//import java.beans.PropertyChangeListener;
//
//
///**
//* Protege name: IsRootTaxon
//* @author ontology bean generator
//* @version 2009/09/30, 13:34:31
//*/
//public class IsRootTaxon implements jade.content.Predicate, Serializable {
//	// bean stuff
//   protected PropertyChangeSupport pcs = new PropertyChangeSupport(this);
//
//   public void addPropertyChangeListener(PropertyChangeListener pcl) {
//     pcs.addPropertyChangeListener(pcl);
//   }
//
//   public void removePropertyChangeListener(PropertyChangeListener pcl) {
//     pcs.removePropertyChangeListener(pcl);
//   }
//
//
//  private static final long serialVersionUID = -8627856865395943317L;
//
//  private String _internalInstanceName = null;
//
//  public IsRootTaxon() {
//    this._internalInstanceName = "";
//  }
//
//  public IsRootTaxon(String instance_name) {
//    this._internalInstanceName = instance_name;
//  }
//
//  public String toString() {
//    return _internalInstanceName;
//  }
//
//   /**
//   * Protege name: taxon
//   */
//   private Taxon taxon;
//   public void setTaxon(Taxon value) {
//     pcs.firePropertyChange("taxon", (this.taxon==null?new Taxon():this.taxon), value);
//    this.taxon=value;
//   }
//   public Taxon getTaxon() {
//     return this.taxon;
//   }
//}
