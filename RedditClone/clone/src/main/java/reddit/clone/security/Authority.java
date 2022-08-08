package reddit.clone.security;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;

@NoArgsConstructor
@Getter
@Setter
public class Authority implements GrantedAuthority {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
