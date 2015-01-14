package resources;

import models.User;
import dao.DAO;
import dao.UserDAO;

public class UsersResource extends APIResource<User> {
    @Override
    protected DAO<User> getDAO() {
        return new UserDAO();
    }
}
