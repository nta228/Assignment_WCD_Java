package fpt.aptech.assignment_wcd.entity;

import fpt.aptech.assignment_wcd.entity.base.BaseEntity;
import fpt.aptech.assignment_wcd.entity.myEnum.FoodStatus;
import fpt.aptech.assignment_wcd.model.MySqlCategoryModel;
import fpt.aptech.assignment_wcd.model.CategoryModel;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Food extends BaseEntity {
    private int id;
    private String name;
    private int categoryId;
    private String description;
    private String thumbnail;
    private double price;
    private FoodStatus status;
    private HashMap<String, String> errors;
    private CategoryModel categoryModel;
    private LocalDateTime saleAt;

    public Food() {
        errors = new HashMap<>();
        categoryModel = new MySqlCategoryModel();
    }

    public Food(String name, int categoryId, String description, String thumbnail, double price, FoodStatus status, LocalDateTime saleAt) {
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.status = status;
        this.saleAt = saleAt;
    }

    public Food(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, int id, String name, int categoryId, String description, String thumbnail, double price, FoodStatus status, LocalDateTime saleAt) {
        super(createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy);
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.status = status;
        this.saleAt = saleAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public FoodStatus getStatus() {
        return status;
    }

    public void setStatus(FoodStatus status) {
        this.status = status;
    }

    public LocalDateTime getSaleAt() {
        return saleAt;
    }

    public void setSaleAt(LocalDateTime saleAt) {
        this.saleAt = saleAt;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public Category getCategory() {
        return categoryModel.findById(this.categoryId);
    }

    public static final class FoodBuilder {
        public LocalDateTime createdAt;
        public LocalDateTime updatedAt;
        public LocalDateTime deletedAt;
        public int createdBy;
        public int updatedBy;
        public int deletedBy;
        private int id;
        private String name;
        private int categoryId;
        private String description;
        private String thumbnail;
        private double price;
        private FoodStatus status;
        private LocalDateTime saleAt;

        private FoodBuilder() {
            this.name = "";
            this.description = "";
            this.thumbnail = "";
            this.createdAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
            this.saleAt = LocalDateTime.now();
            this.status = FoodStatus.ACTIVE;
        }

        public static FoodBuilder aFood() {
            return new FoodBuilder();
        }

        public FoodBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public FoodBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FoodBuilder withCategoryId(int categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public FoodBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public FoodBuilder withThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public FoodBuilder withPrice(double price) {
            this.price = price;
            return this;
        }

        public FoodBuilder withStatus(FoodStatus status) {
            this.status = status;
            return this;
        }

        public FoodBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public FoodBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public FoodBuilder withDeletedAt(LocalDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public FoodBuilder withSaleAt(LocalDateTime saleAt) {
            this.saleAt = saleAt;
            return this;
        }

        public FoodBuilder withCreatedBy(int createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public FoodBuilder withUpdatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public FoodBuilder withDeletedBy(int deletedBy) {
            this.deletedBy = deletedBy;
            return this;
        }

        public Food build() {
            Food food = new Food();
            food.setId(id);
            food.setName(name);
            food.setCategoryId(categoryId);
            food.setDescription(description);
            food.setThumbnail(thumbnail);
            food.setPrice(price);
            food.setStatus(status);
            food.setCreatedAt(createdAt);
            food.setUpdatedAt(updatedAt);
            food.setSaleAt(saleAt);
            food.setDeletedAt(deletedAt);
            food.setCreatedBy(createdBy);
            food.setUpdatedBy(updatedBy);
            food.setDeletedBy(deletedBy);
            return food;
        }
    }

    public boolean isValid() {
        this.checkValid();
        return this.errors.size() == 0;
    }

    public void checkValid() {
        }
}
