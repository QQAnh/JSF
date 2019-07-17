package demo;

import javax.faces.bean.ManagedBean;
import java.util.logging.Logger;

@ManagedBean
public class Login {

    private static final Logger LOGGER = Logger.getLogger(RegisterView.class.getName());

    private User user = new User();

    public void doSubmit() {
        User var = Connect.fetchData(user);
//        LOGGER.info(String.format("Submitted information below: name = '%s', email = '%s', passsword = '%s'", user.getName(), user.getEmail(), user.getPassword()));
        System.out.println(var);
        if (var == null){

        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}