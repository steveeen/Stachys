package de.kuub.stachys.geoReferences;

import de.kuub.stachys.domain.CountingLocations;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-08-29T12:35:32.097+0200")
@StaticMetamodel(Gemeinde.class)
public class Gemeinde_ extends GeoReferenceArea_ {
	public static volatile SingularAttribute<Gemeinde, BigDecimal> gem_nr;
	public static volatile SingularAttribute<Gemeinde, Kreise> kreis;
	public static volatile ListAttribute<Gemeinde, CountingLocations> countareas;
}
