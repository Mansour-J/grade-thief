package game.floor;

public class EmptyTile implements Tile {

	Location location;

	@Override
	public Location tileLocation() {
		return location;
	}

	@Override
	public boolean occupied() {
		return false;
	}

	@Override
	public void setLocation(Location l) {
		this.location = l;

	}


	public String toString() {
		return this.getClass().getSimpleName() + " " + location.toString();
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "E";
	}
}
