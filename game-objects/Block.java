enum BlockType {
	GRASS, DIRT, STONE, WOOD, LEAF, IRON_ORE, DIAMOND_ORE, NETHERRACK, PORTAL_BLOCK;
}

public class Block {
	public int health = 10;
	public Location loc;
	private BlockType type;
	
	public BlockType getType() {
		return type;
	}
	
	public Block(BlockTypes type, double x, double y) {
		this.type = type;
		this.loc = new Location(x, y);
		spawn();
	}
	
	public void takeDamage(int damage) {
		health -= damage;
		if(health <= 0) {
			despawn();
		}
	}
	
	public void despawn() {
		//delete object from game
	}
	
	public void spawn(String filepath) {
		/* spawn block in world */
	}
	
	
	public boolean breakable(Player player) {
		// if(player.pickaxe
		/* Check to see if player has correct kind of pickaxe */
	}
}