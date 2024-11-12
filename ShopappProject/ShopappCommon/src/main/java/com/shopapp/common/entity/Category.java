package com.shopapp.common.entity;

import java.beans.Transient;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(length = 128, nullable = false, unique = true)
	private String name;

	@Column(length = 64, nullable = false, unique = true)
	private String alias;

	@Column(length = 128, nullable = false)
	private String image;

	private boolean enabled;

	@OneToOne
	@JoinColumn(name = "parent_id")
	private Category parent;

	@OneToMany(mappedBy = "parent")
	private Set<Category> children = new HashSet<>();

	public Category() {
	}

	public Category(Integer id) {
		this.id = id;
	}
	
	public static Category copyIdAndName(Category category) {
		Category copy = new Category();
		copy.setId(category.getId());
		copy.setName(category.getName());
		return copy;
	}
	
	public static Category copyIdAndName(Integer id, String name) {
		Category copy = new Category();
		copy.setId(id);
		copy.setName(name);
		return copy;
	}
	
	public static Category copyFull(Category category) {
		Category copy = new Category();
		copy.setId(category.getId());
		copy.setName(category.getName());
		copy.setAlias(category.getAlias());
		copy.setImage(category.getImage());
		copy.setEnabled(category.isEnabled());
		
		return copy;
	}
	
	public static Category copyFull(Category category, String name) {
		Category copy = Category.copyFull(category);
		copy.setName(name);
		
		return copy;
	}
	
	public Category(Integer id, String name, String alias) {
		this.id = id;
		this.name = name;
		this.alias = alias;
	}

	public Category(String name) {
		this.name = name;
		this.alias = name;
		this.image = "default.png";
	}

	public Category(String name, Category category) {
		this(name);
		this.parent = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public Set<Category> getChildren() {
		return children;
	}

	public void setChildren(Set<Category> children) {
		this.children = children;
	}
	
	@Transient
	public String getImagePath() {
		if(id == null) return "/images/image-thumbnail.png";
		return "/category-images/" + this.id + "/" + this.getImage();
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", alias=" + alias + ", image=" + image + ", enabled="
				+ enabled + "]";
	}
}
