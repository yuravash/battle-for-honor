package game.services.auth;

import game.services.auth.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {

    AuthService authService;

    User user;

    @Test
    void getNotSavedUser(){
        assertDoesNotThrow(()->authService = new AuthService());
        assertNull(authService.getUser());
    }

    @Test
    void getSavedUser(){
        assertDoesNotThrow(()->authService = new AuthService());
        assertDoesNotThrow(()->user = authService.newUser("Yura", "Password"));

        assertDoesNotThrow(()->authService = new AuthService());
        assertEquals(user, authService.getUser());
    }

    @Test
    void newUser() {
        assertDoesNotThrow(()->authService = new AuthService());
        assertDoesNotThrow(()->authService.newUser("Yura", "Password"));
        assertNotNull(authService.getUser());
    }

    @AfterEach
    void tearDown() {
        authService = null;
        user = null;
        new File("auth.out").delete();
    }

}