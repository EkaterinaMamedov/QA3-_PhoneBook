package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }
    @Test
    public void RegistrationSuccessWithClassUser() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt + "@gmail.com")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @Test
    public void RegistrationSuccessWithClassUser2() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail(randomInt + "@gmail.com")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @Test
    public void RegistrationSuccessWithClassUser3() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty_" + randomInt + "@gmail.com")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLogged());

    }


    @Test
    public void registrationWrongEmailWithAts() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt + "@@gmail.com")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertFalse(app.getHelperUser().isLogged());

    }
    @Test
    public void registrationWrongEmailWithoutAt() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt + "gmail.com")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertFalse(app.getHelperUser().isLogged());

    }
    @Test
    public void registrationWrongEmailWithSpase() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt +" "+ "@gmail.com")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertFalse(app.getHelperUser().isLogged());

    }
    @Test
    public void BugRegistrationWrongEmailWithChar() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt +"!"+ "@gmail.com")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertFalse(app.getHelperUser().isLogged());

    }
    @Test
    public void registrationWrongEmailOneCharAfterAt() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt + "@")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertFalse(app.getHelperUser().isLogged());
    }
    @Test
    public void registrationWrongEmailOneCharBeforeAt() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("@"+randomInt)
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertFalse(app.getHelperUser().isLogged());

    }
    @Test
    public void BugRegistrationWrongEmailChar() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("йцуке" + randomInt + "@пьфшд.сщь")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertFalse(app.getHelperUser().isLogged());

    }

    @Test
    public void registrationEmptyEmail() {
        User user = new User()
                .setEmail("")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertFalse(app.getHelperUser().isLogged());

    }

    @Test
    public void registrationWrongPasswordWithoutUpper() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt + "@gmail.com")
                .setPassword("qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertFalse(app.getHelperUser().isLogged());

    }
    @Test
    public void registrationWrongPasswordWithoutLower() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt + "@gmail.com")
                .setPassword("QWERTY!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertFalse(app.getHelperUser().isLogged());

    }
    @Test
    public void registrationWrongPasswordWithoutDigit() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt + "@gmail.com")
                .setPassword("Qwerty!!!");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertFalse(app.getHelperUser().isLogged());

    }
    @Test
    public void registrationWrongPasswordWithoutSymbol() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt + "@gmail.com")
                .setPassword("Qwerty123");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertFalse(app.getHelperUser().isLogged());

    }

    @Test
    public void registrationEmptyPassword() {
        User user = new User()
                .setEmail("qwerty123098@gmail.com")
                .setPassword("");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        Assert.assertFalse(app.getHelperUser().isLogged());

    }

}
