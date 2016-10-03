package items;

import gui.*;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Stefan Vrecic on 22/09/16.
 */
public class MapDraw extends Item {
    private final int MAP_THICKNESS = 1;

    private java.util.List<Cube> cubes;
    private double x;
    private double y;
    private double z;
    private double width;
    private double length;
    private double height;
    private Color color;

    public String toString() {
        return x + " " + y + " " + z + " " + width + " " + length + " " + height + " " + color;
    }

    public MapDraw(int itemID, String itemType, double x, double y, double z, double width, double length, double height, Color c) {
        super(itemID, itemType, x, y, z, width, length, height, c);
        cubes = new ArrayList<>();

        // Screen
        cubes.add(new Cube(x, y + length, z, width, MAP_THICKNESS, height, c));
    }

    @Override
    public void setRotAdd() {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateDirection(double toX, double toY) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updatePoly() {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeCube() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean containsPoint(int x, int y, int z) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<gui.Polygon> getPolygons() {
        // TODO Auto-generated method stub
        return null;
    }

	@Override
	public boolean pointNearObject(double x, double y, int z) {
		   if ((this.x + DETECT_PLAYER_BOUNDARY + this.width) > x && (this.y + DETECT_PLAYER_BOUNDARY + this.length) > y
	                && this.x - DETECT_PLAYER_BOUNDARY< x && this.y - DETECT_PLAYER_BOUNDARY< y){
	        return true;
	        }else{
	            return false;
	        }
	}

}
