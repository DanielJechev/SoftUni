package json.processing.model.dto.view.usersAndProductsQuery4;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class UsersViewModelWrapper {

    @Expose
    private Long usersCount;

    @Expose
    private List<UserViewModelQuery4> users;

    public UsersViewModelWrapper() {
        users = new ArrayList<>();
    }

    public UsersViewModelWrapper(Long usersCount, List<UserViewModelQuery4> userViewModel) {
        this.usersCount = usersCount;
        this.users = userViewModel;
    }

    public Long getUsersCount() {
        this.usersCount = (long)this.users.size();
        return usersCount;
    }

    public void setUsersCount(Long usersCount) {
        this.usersCount = usersCount;
    }

    public List<UserViewModelQuery4> getUsers() {
        return users;
    }

    public void setUsers(List<UserViewModelQuery4> users) {
        this.users = users;
    }
}
