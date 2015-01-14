package utils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import models.User;

import org.apache.commons.codec.binary.Base64;

import dao.UserDAO;

public class AuthenticationParser {
    private User userObject;
    private String user;
    private String password;

    public AuthenticationParser(String authentication) {
        Map<String, String> parsed = this.parse(authentication);
        this.setUser(parsed.get("user"));
        this.setPassword(parsed.get("password"));
    }

    private Map<String, String> parse(String authentication) {
        if (authentication == null || !authentication.startsWith("Basic")) {
            throw new AuthenticationException();
        }

        Map<String, String> result = new HashMap<String, String>();

        for (String part : authentication.split(" ")) {
            if (part.startsWith("Basic")) {
                continue;
            }

            try {
                String base64 = new String(Base64.decodeBase64(part), "UTF-8");
                result.put("user", base64.split(":")[0]);
                result.put("password", base64.split(":")[1]);
            } catch (UnsupportedEncodingException e) {
                // Silenced
            }
        }

        return result;
    }

    public boolean isAuthenticated() {
        try {
            return this.getUser().authenticate(this.getPassword());
        } catch (NotFoundException | NoSuchAlgorithmException
                | UnsupportedEncodingException e) {
            return false;
        }
    }

    private String getUsername() {
        return this.user;
    }

    public User getUser() throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        if (this.userObject != null) {
            return this.userObject;
        }

        this.userObject = new UserDAO().byUser(this.getUsername());
        this.userObject.authenticate(this.getPassword());

        return this.userObject;
    }

    private void setUser(String user) {
        this.user = user;
    }

    private String getPassword() {
        return this.password;
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
