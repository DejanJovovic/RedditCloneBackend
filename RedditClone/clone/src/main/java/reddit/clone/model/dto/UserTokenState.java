package reddit.clone.model.dto;

public class UserTokenState {


    private String accessToken;

    private Long expiresIn;



    public UserTokenState() {
        this.accessToken = null;
        this.expiresIn = null;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

}
