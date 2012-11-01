package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface Resource extends IFramesEntity, ResourceIdentifier {
	public URI getUri();

	public void setUri(URI uri);

	public Location getLocation();

	public void setLocation(Location location);

	public Persistence getPersistence();

	public void setPersistence(Persistence persistence);
}
