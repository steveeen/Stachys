package de.kuub.stachys.geoReferences;

import de.kuub.stachys.domain.CountingLocations;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-08-29T12:35:32.199+0200")
@StaticMetamodel(Kreise.class)
public class Kreise_ extends GeoReferenceArea_ {
	public static volatile SingularAttribute<Kreise, BigDecimal> kreis_nr;
	public static volatile ListAttribute<Kreise, Gemeinde> gemeinden;
	public static volatile ListAttribute<Kreise, CountingLocations> countareas;
}
