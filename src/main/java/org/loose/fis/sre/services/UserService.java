package org.loose.fis.sre.services;

import javafx.collections.ObservableList;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;

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
        userRepository.insert(new User(username, encodePassword(username, password), role,"","","e", -1));
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }
    public static void deleteProgramare(String username){
        for(User user: userRepository.find())
            if(Objects.equals(user.getUsername(),username)) {
                user.setProgramare("");
                userRepository.update(user);
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
    public static String getUserProgramare(String username){
        for(User user: userRepository.find())
            if(Objects.equals(user.getUsername(),username)) {
                return user.getProgramare();
            }

            return null;
    }

    public static int checkUser(String nume){
        for(User user: userRepository.find())
            if(Objects.equals(user.getUsername(),nume)) {
                return 1;

            }
        return 0;
    }
    public static int addOffer(String offer,String username){
        for(User user:userRepository.find())
            if(Objects.equals(user.getUsername(),username)){
                if(user.getOffer().equals("e")) {
                    user.setOffer(offer);
                    userRepository.update(user);
                    return  1;
                }
                else{
                    return -1;
                }
            }
        return -2;
    }




    public static String getOffers(String username){
        for(User user:userRepository.find())
            if(Objects.equals(user.getUsername(),username)) {
                return user.getOffer();
            }
                return "Username not found";
    }
    public static void deleteOffers(String username ){
        for(User user:userRepository.find())
            if(Objects.equals(user.getUsername(),username)) {
                user.setOffer("e");
                userRepository.update(user);
            }
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

    public static void modifyUserReview(String name, String review){
        for (User user : userRepository.find()){
            if(Objects.equals(name,user.getUsername()))
            {

                user.setReview(user.getReview()+" "+review+"\n");
                userRepository.update(user);


            }
        }

    }
    public static String getUserReview(String name) {
        for (User user : userRepository.find()) {
            if (Objects.equals(name, user.getUsername())) {
                return user.getReview();
            }
        }
        return null;
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
