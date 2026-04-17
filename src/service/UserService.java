package service;
import dao.UserDAO;
import model.User;

public class UserService {
    UserDAO userDAO = new UserDAO();
    public void registerUser(User user){
        try{
            User existingUser = userDAO.getUserByEmail(user.getEmail());
            if(existingUser != null ){
                System.out.println("email already exists");
            }
            else{
                userDAO.saveUser(user);
                System.out.println("user registered successfully");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public  User loginUser(String email,String password){
        User existingUser = userDAO.getUserByEmail(email);
        if(existingUser == null){
            System.out.println("email does not exist");
            return null;
        }
        if (!existingUser.getPassword().equals(password)) {
            System.out.println("wrong password retry");
            return null;
        }
        System.out.println("Login successful");
        return existingUser;

    }

}
