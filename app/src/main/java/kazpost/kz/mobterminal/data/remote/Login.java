package kazpost.kz.mobterminal.data.remote;

/**
 * Created by root on 11/2/17.
 */

public class Login {
    private int id;
    private Boolean isSuccess;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }
}
