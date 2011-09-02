/**
 * @(#) AnonymousSearcher.java
 */

package de.kuub.stachys.services;

import de.kuub.stachys.domain.CountingDatas;
import de.kuub.stachys.domain.Species;
import de.kuub.stachys.transfer.PersonDTO;

public interface AnonymousSearcher {
	
	public PersonDTO findMapper();
	
	public PersonDTO findAuthors();
	
	public CountingDatas getCountingDatasbyMapper();

	public Species getCountingDatasbyGeoReferences();

	public CountingDatas getCountingDatasbyArea();

	public CountingDatas getCountingDatasbyYear();

	public CountingDatas getCountingDatasbySpecies();

}
