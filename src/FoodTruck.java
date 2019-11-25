
public class FoodTruck {

	public static int nextTruckId = 0;
	private String name;
	private String type;
	private int rating;
	private int id;

	public FoodTruck(String name, int rating, String type) {
		this.id = this.nextTruckId;
		this.rating = rating;
		this.name = name;
		this.type = type;
		this.nextTruckId++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "FoodTruck [name=" + name + ", type=" + type + ", rating=" + rating + ", id=" + id + "]";
	}

}
