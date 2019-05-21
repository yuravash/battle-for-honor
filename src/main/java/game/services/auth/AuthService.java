package game.services.auth;

import game.services.auth.user.User;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class AuthService {

    private User user;

    public AuthService() throws IOException, ClassNotFoundException{
        try{loadUser();}catch (FileNotFoundException e){}
    }

    public User newUser(String name, String password) throws IOException{
        user = new User(0, name, encodePassword(password));
        saveUser();
        return user;
    }

    public User getUser() {
        return user;
    }

    private void saveUser() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("auth.out"));
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
    }

    private void loadUser() throws IOException, ClassNotFoundException, FileNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("auth.out"));
        user = (User) objectInputStream.readObject();
        objectInputStream.close();
    }

    private String encodePassword(String password){

        byte[] digest = new byte[0];

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(password.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {}

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while( md5Hex.length() < 32 ){md5Hex = "0" + md5Hex;}

        return md5Hex;
    }

}
