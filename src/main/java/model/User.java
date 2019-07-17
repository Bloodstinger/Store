package model;

import java.util.Objects;

public class User {

    private Long id;
    private String email;
    private String password;
    private String role;
    private ShoppingCart shoppingCart;

    public User(Long id, String email, String password, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        shoppingCart = new ShoppingCart();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void addInCart(Item item) {
        shoppingCart.add(item);
    }

    public void removeFromCart(Item item) {
        shoppingCart.remove(item);
    }

    public ShoppingCart getShoppingCart() {
        return this.shoppingCart;
    }

    public int cartSize() {
        return shoppingCart.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(role, user.role) &&
                Objects.equals(shoppingCart, user.shoppingCart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, role, shoppingCart);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", shoppingCart=" + shoppingCart +
                '}';
    }
}
