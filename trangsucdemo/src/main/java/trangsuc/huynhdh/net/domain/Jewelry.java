package trangsuc.huynhdh.net.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trangsuc")
public class Jewelry implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "[id]", nullable = false)
	private int id;

	@Column(name = "[group]", nullable = false)
	private String group;
	
	@Column(name = "[type]", nullable = false)
	private String type;

	@Column(name = "[name]")
	private String name;

	@Column(name = "[price]", nullable = false)
	private String price;

	@Column(name = "[description]")
	private String description;

	@Column(name = "[image]", nullable = false)
	private String image;

	@Column(name = "[collection]")
	private String collection;

	@Column(name = "[stonetype]", nullable = false)
	private String stonetype;

	@Column(name = "[stonecolor]")
	private String stonecolor;

	@Column(name = "[stoneshape]", nullable = false)
	private String stoneshape;

	public Jewelry() {
		super();
	}
	
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Jewelry(int id, String group, String type, String name, String price, String description, String image,
			String collection, String stonetype, String stonecolor, String stoneshape) {
		super();
		this.id = id;
		this.group = group;
		this.type = type;
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
		this.collection = collection;
		this.stonetype = stonetype;
		this.stonecolor = stonecolor;
		this.stoneshape = stoneshape;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getStonetype() {
		return stonetype;
	}

	public void setStonetype(String stonetype) {
		this.stonetype = stonetype;
	}

	public String getStonecolor() {
		return stonecolor;
	}

	public void setStonecolor(String stonecolor) {
		this.stonecolor = stonecolor;
	}

	public String getStoneshape() {
		return stoneshape;
	}

	public void setStoneshape(String stoneshape) {
		this.stoneshape = stoneshape;
	}

}
