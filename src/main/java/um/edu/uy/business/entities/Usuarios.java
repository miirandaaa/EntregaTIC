package um.edu.uy.business.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(generator="users_ids")
    @GenericGenerator(name="users_ids", strategy = "increment")
    public long id;

    public String username;

    public String password;

    public String userType;

    public String userRole;

    public Usuarios(String username, String password, String userType, String userRole) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.userRole = userRole;
    }

    public Usuarios() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
