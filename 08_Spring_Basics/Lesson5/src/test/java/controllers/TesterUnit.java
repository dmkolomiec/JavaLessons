package controllers;

import lesson5.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/app-context.xml"})
public class TesterUnit {
    @Autowired
    User user;


    @Test
    public void testUser() {
        Assert.assertEquals("Vasily", user.getName());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUser2() {
        user.getAddress();
    }

}

