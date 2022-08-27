package reddit.clone.model.domain;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Admin extends User{

    public Admin() {

    }

    public Admin(Long id, String username, String password, String email, String avatar, String description, String displayName,
                 LocalDate registrationDate) {
        super(id, username, password, email, avatar, description, displayName, registrationDate);
    }
}
