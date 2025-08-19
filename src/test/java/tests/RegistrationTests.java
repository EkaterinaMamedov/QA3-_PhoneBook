package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Before method finished logout");

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
        logger.info("test data user->" + user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");
        Assert.assertTrue(app.getHelperUser().isNoContactsHere());
        logger.info("Assert check text->  is No Contacts Here");

    }

    @Test
    public void RegistrationSuccessWithClassUser2() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail(randomInt + "@gmail.com")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("test data user->" + user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");
    }

    @Test
    public void RegistrationSuccessWithClassUser3() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty_" + randomInt + "@gmail.com")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("test data user->" + user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");
    }


    @Test
    public void registrationWrongEmailWithAts() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt + "@@gmail.com")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("test data user->" + user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        logger.info("Assert check is alert present-> Wrong email or password format ");
        Assert.assertFalse(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' not present");
    }

    @Test
    public void registrationWrongEmailWithoutAt() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt + "gmail.com")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("test data user->" + user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        logger.info("Assert check is alert present-> Wrong email or password format ");
        Assert.assertFalse(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' not present");
    }

    @Test
    public void registrationWrongEmailWithSpase() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt + " " + "@gmail.com")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("test data user->" + user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        logger.info("Assert check is alert present-> Wrong email or password format ");
        Assert.assertFalse(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' not present");
    }

    @Test
    public void BugRegistrationWrongEmailWithChar() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt + "!" + "@gmail.com")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("test data user->" + user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        logger.info("Assert check is alert present-> Wrong email or password format ");
        Assert.assertFalse(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' not present");
    }

    @Test
    public void registrationWrongEmailOneCharAfterAt() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt + "@")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("test data user->" + user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        logger.info("Assert check is alert present-> Wrong email or password format ");
        Assert.assertFalse(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' not present");
    }

    @Test
    public void registrationWrongEmailOneCharBeforeAt() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("@" + randomInt)
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("test data user->" + user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        logger.info("Assert check is alert present-> Wrong email or password format ");
        Assert.assertFalse(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' not present");
    }

    @Test(description = "bag", enabled = false)//тест не видим  пометка сохраняется
    public void BugRegistrationWrongEmailChar() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("йцуке" + randomInt + "@пьфшд.сщь")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("test data user->" + user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        logger.info("Assert check is alert present-> Wrong email or password format ");
        Assert.assertFalse(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' not present");
    }

    @Test
    public void registrationEmptyEmail() {
        User user = new User()
                .setEmail("")
                .setPassword("Qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("test data user->" + user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        logger.info("Assert check is alert present-> Wrong email or password format ");
        Assert.assertFalse(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' not present");
    }

    @Test
    public void registrationWrongPasswordWithoutUpper() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt + "@gmail.com")
                .setPassword("qwerty!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("test data user->" + user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        logger.info("Assert check is alert present-> Wrong email or password format ");
        Assert.assertFalse(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' not present");
    }

    @Test
    public void registrationWrongPasswordWithoutLower() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt + "@gmail.com")
                .setPassword("QWERTY!23");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("test data user->" + user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        logger.info("Assert check is alert present-> Wrong email or password format ");
        Assert.assertFalse(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' not present");
    }

    @Test
    public void registrationWrongPasswordWithoutDigit() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt + "@gmail.com")
                .setPassword("Qwerty!!!");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("test data user->" + user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        logger.info("Assert check is alert present-> Wrong email or password format ");
        Assert.assertFalse(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' not present");
    }

    @Test
    public void registrationWrongPasswordWithoutSymbol() {
        int randomInt = (int) (System.currentTimeMillis() / 1000 % 3600);
        User user = new User()
                .setEmail("qwerty" + randomInt + "@gmail.com")
                .setPassword("Qwerty123");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("test data user->" + user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        logger.info("Assert check is alert present-> Wrong email or password format ");
        Assert.assertFalse(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' not present");
    }

    @Test
    public void registrationEmptyPassword() {
        User user = new User()
                .setEmail("qwerty123098@gmail.com")
                .setPassword("");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("test data user->" + user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
        logger.info("Assert check is alert present-> Wrong email or password format ");
        Assert.assertFalse(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' not present");
    }

    @Test
    public void registrationRegisteredUser() {
        User user = new User()
                .setEmail("tmmmmmtttt@gmail.com")
                .setPassword("Qwerty!12");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("test data user->" + user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
        logger.info("Assert check is alert present-> User already exist: ");
        Assert.assertFalse(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out'not  present");
    }
}
