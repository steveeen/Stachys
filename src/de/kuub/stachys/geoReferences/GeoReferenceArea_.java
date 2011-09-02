package de.kuub.stachys.geoReferences;

import com.vividsolutions.jts.geom.Geometry;
import de.kuub.stachys.domain.CountingLocations;
import de.kuub.stachys.domain.TracebleClass_;
import de.kuub.stachys.geoReferences.GeoReferenceArea.AreaTypes;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-08-29T12:35:32.162+0200")
@StaticMetamodel(GeoReferenceArea.class)
public class GeoReferenceArea_ extends TracebleClass_ {
	public static volatile SingularAttribute<GeoReferenceArea, Integer> georefarea_id;
	public static volatile SingularAttribute<GeoReferenceArea, Geometry> area;
	public static volatile ListAttribute<GeoReferenceArea, GeoRefAreaNames> areaNames;
	public static volatile SingularAttribute<GeoReferenceArea, AreaTypes> areatype;
	public static volatile ListAttribute<GeoReferenceArea, CountingLocations> countareas;
}
