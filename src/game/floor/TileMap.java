package game.floor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import items.Door;

public class TileMap {
	Tile[][] TileMap;
	int TileMapWidth = 0;
	int TileMapHeight = 0;
	int optionalCode = -1; // default value of map does not contain a door

	public int getMapWidth() { return TileMapWidth; }
	public int getMapHeight() { return TileMapHeight; }
	public int getOptionalCode() { return optionalCode; }

	public TileMap(Tile[][] TileMap) {
		this.TileMap = TileMap;
	}


	public TileMap createTileMap(String f) {
		String map = convertFileToTileString(f);
		return convertStringToTileMap(map);

	}
	public String convertFileToTileString(String fileName) {

		String fileString = null;

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			fileString = sb.toString();
			br.close();

		} catch (Exception e) { e.printStackTrace(); }

		return fileString;
	}

	public TileMap convertStringToTileMap(String Tiles) {

		Scanner s = new Scanner(Tiles);

		String scode = null, swidth = null, sheight = null;



		int code = Integer.parseInt(s.nextLine());
		int width = Integer.parseInt(s.nextLine());
		int height = Integer.parseInt(s.nextLine());


		TileMap TileMapper = new TileMap(new Tile[width][height]);

		 TileMapper.optionalCode = code;
		TileMapper.TileMapWidth = width;
		TileMapper.TileMapHeight = height;

//		System.out.println(code + " " + width + " " + height);

		//int width = s.nextInt();
		//int height = s.nextInt();
		s.close();

		Tiles = Tiles.substring(Tiles.indexOf('.') + 1); // concatenate dimensions now that is is loaded

		int count = 0;

				for (int y = 0; y < height; y++) {
						for (int x = 0; x < width; x++){


							char c = Tiles.charAt(count);

							Location loc = new Location(x,y);
						//	System.out.println(loc);

						if (c == 'w') {
							WallTile w = new WallTile();
							w.setLocation(loc);
							TileMapper.TileMap[x][y] = w;
						} else if ( c == 'x') {
							EmptyTile e = new EmptyTile();
							e.setLocation(loc);
							TileMapper.TileMap[x][y] = e;
						} else if ( c == 'd') {
							DoorTile d = new DoorTile();
							d.setLocation(loc);
							d.setDoor(Door.getDoor(code)); // gets the door with the given code
							TileMapper.TileMap[x][y] = d;
						}

						//System.out.println(c);

						count++;
				}
	}

					return TileMapper;

	}
}
