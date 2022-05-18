package org.loose.fis.sre.services;

import javafx.collections.ObservableList;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.Offer;
import org.loose.fis.sre.model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class UserService {

    private static ObjectRepository<User> userRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("user.db").toFile())
                .openOrCreate("username", "password");

        userRepository = database.getRepository(User.class);
    }

    public static void addUser(String username, String password, String role) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        userRepository.insert(new User(username, encodePassword(username, password), role,"",-1));
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }


    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

    public static void getAgents(ObservableList<String> names){
        try{
            for (User user : userRepository.find()){
                if(Objects.equals("Agent",user.getRole())){
                    names.add(user.getUsername());

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static int checkUser(String nume){
        for(User user: userRepository.find())
            if(Objects.equals(user.getUsername(),nume)) {
                return 1;

            }
        return 0;
    }

    public static int checkStatus(String nume){
        for(User user: userRepository.find()) {
            if(Objects.equals(user.getUsername(),nume)){
                return user.getStatus();
            }
        }
        return -2;
    }

    public static void addProgramare(String nume,String programare){
        for(User user: userRepository.find())
            if(Objects.equals(user.getUsername(),nume)) {
                user.setProgramare(programare);
                user.setStatus(0);
                userRepository.update(user);

            }
    }


    public static void setUserStatus(String nume,int s){
        for(User user: userRepository.find())
            if(Objects.equals(user.getUsername(),nume)){
                user.setStatus(s);
                userRepository.update(user);

            }
    }

    public static int validateLogin(String username, String password) {
        for (User user : userRepository.find()) {
            if(Objects.equals(username, user.getUsername()))
            {
                String pass=encodePassword(username,password);

                if (Objects.equals(user.getPassword(),pass))
                {
                    if(Objects.equals(user.getRole(),"Agent")){
                        return 1;

                    }
                    if(Objects.equals(user.getRole(),"Client")){
                        return 2;
                    }
                }
            }
        }
        return 0;

    }
}
