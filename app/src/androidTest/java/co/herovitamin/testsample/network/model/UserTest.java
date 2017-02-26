package co.herovitamin.testsample.network.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User mUser;
    private String nameToTest;
    private String usernameToTest;
    private String passwordToTest;

    @Before
    public void setUp() throws Exception {
        String defaultNameValue = "Jhon";
        String defaultUsernameValue = "Jhon";
        String defaultPasswordValue = "1234567890";
        mUser = new User(defaultNameValue, defaultUsernameValue, defaultPasswordValue);
    }

    @Test
    public void whenNameParamIsEmptyThenDontSaveValue(){
        nameToTest = "";
        mUser.setName(nameToTest);
        Assert.assertNotEquals("User name is not empty", nameToTest, mUser.getName());
    }

    @Test
    public void whenNameParamIsNullThenDontSaveValue(){
        nameToTest = null;
        mUser.setName(nameToTest);
        Assert.assertNotNull("User nameToTest is not null", mUser.getName());
    }

    @Test
    public void whenPasswordLengthIsSmallerThan6ThenReturnFalse(){
        passwordToTest = "123456";
        Assert.assertFalse("Password length is smaller than 6", mUser.setPassword(passwordToTest));
    }

    @Test
    public void whenPasswordLengthIsLargerThan6ThenReturnTrue(){
        passwordToTest = "12345678";
        Assert.assertTrue("Password length is largar than 6", mUser.setPassword(passwordToTest));
    }
}