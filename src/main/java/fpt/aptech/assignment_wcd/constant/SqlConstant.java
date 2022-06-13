package fpt.aptech.assignment_wcd.constant;

public class SqlConstant {
    public static final String ACCOUNT_INSERT = "INSERT INTO accounts (fullName, username, email, password, roleId, phoneNumber, createdAt, updatedAt, createdBy, updatedBy, status) " +
            "                                                   VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String ACCOUNT_UPDATE = "UPDATE accounts SET fullName = ?, username = ?, email =  ?, password = ?, roleId = ?, phoneNumber = ?," +
            "createdAt = ?, updatedAt = ?, deletedAt = ?, createdBy = ?, updatedBy = ?, deletedBy = ?, status = ? WHERE id = ?;";
    public static final String ACCOUNT_DELETE = "DELETE FROM accounts WHERE id = ?;";
    public static final String ACCOUNT_FIND_BY_ID = "SELECT * FROM accounts WHERE id = ?;";
    public static final String ACCOUNT_FIND_BY_USERNAME = "SELECT * FROM accounts WHERE username = ?;";
    public static final String ACCOUNT_FIND_ALL = "SELECT * FROM accounts ORDER BY createdAt DESC;";

    public static final String CATEGORY_INSERT = "INSERT INTO categories (name, parentId, createdAt, updatedAt, createdBy, updatedBy, status) " +
            "                                                   VALUES (?, ?, ?, ?, ?, ?, ?);";
    public static final String CATEGORY_UPDATE = "UPDATE categories SET name = ?, parentId = ?," +
            "createdAt = ?, updatedAt = ?, deletedAt = ?, createdBy = ?, updatedBy = ?, deletedBy = ?, status = ? WHERE id = ?;";
    public static final String CATEGORY_DELETE = "DELETE FROM categories WHERE id = ?;";
    public static final String CATEGORY_FIND_BY_ID = "SELECT * FROM categories WHERE id = ? AND status = ?;";
    public static final String CATEGORY_FIND_ALL = "SELECT * FROM categories WHERE status = ? ORDER BY createdAt DESC;";
        public static final String FOOD_INSERT = "INSERT INTO foods (name, price, thumbnail, description, categoryId, createdAt, updatedAt, createdBy, updatedBy, status, saleAt) " +
            "                                                   VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String FOOD_UPDATE = "UPDATE foods SET name = ?, price = ?, thumbnail = ?, description = ?, categoryId = ?," +
            "createdAt = ?, updatedAt = ?, deletedAt = ?, createdBy = ?, updatedBy = ?, deletedBy = ?, status = ?, saleAt = ? WHERE id = ?;";
    public static final String FOOD_DELETE = "DELETE FROM foods WHERE id = ?;";
    public static final String FOOD_FIND_BY_ID = "SELECT * FROM foods WHERE id = ?;";
    public static final String FOOD_FIND_ALL = "SELECT * FROM foods WHERE status = ? ORDER BY createdAt DESC;";
    public static final String ACCOUNT_FIELD_ID = "id";
    public static final String ACCOUNT_FIELD_USERNAME = "username";
    public static final String ACCOUNT_FIELD_FULL_NAME = "fullName";
    public static final String ACCOUNT_FIELD_PHONE_NUMBER = "phoneNumber";
    public static final String ACCOUNT_FIELD_EMAIL = "email";
    public static final String ACCOUNT_FIELD_PASSWORD = "password";
    public static final String ACCOUNT_FIELD_ROLE_ID = "roleId";
    public static final String ACCOUNT_FIELD_STATUS = "status";

    public static final String CATEGORY_FIELD_ID = "id";
    public static final String CATEGORY_FIELD_NAME = "name";
    public static final String CATEGORY_FIELD_PARENT_ID = "parentId";
    public static final String CATEGORY_FIELD_STATUS = "status";

    public static final String FOOD_FIELD_ID = "id";
    public static final String FOOD_FIELD_NAME = "name";
    public static final String FOOD_FIELD_CATEGORY_ID = "categoryId";
    public static final String FOOD_FIELD_PRICE = "price";
    public static final String FOOD_FIELD_THUMBNAIL = "thumbnail";
    public static final String FOOD_FIELD_DESCRIPTION = "description";
    public static final String FOOD_FIELD_SALE_AT = "saleAt";

    public static final String FIELD_CREATED_AT = "createdAt";
    public static final String FIELD_UPDATED_AT = "updatedAt";
    public static final String FIELD_DELETED_AT = "deletedAt";
    public static final String FIELD_CREATED_BY = "createdBy";
    public static final String FIELD_UPDATED_BY = "updatedBy";
    public static final String FIELD_DELETED_BY = "deletedBy";
}
