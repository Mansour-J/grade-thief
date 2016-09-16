package items;

import java.util.List;

public abstract class Item extends GameObject {
	String itemType;
	List<String> options; // items that are interactable may have a list of options to choose from
	// items should also have a GameWorld Position
	public int itemID;

	public Item( int itemID) {
		super(itemID);
		this.itemID = itemID;
	}


	// Location location;



	// Model file ?






}