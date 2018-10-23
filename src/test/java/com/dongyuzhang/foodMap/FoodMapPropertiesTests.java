package com.dongyuzhang.foodMap;


import com.dongyuzhang.foodMap.service.FoodMapProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FoodMapApplication.class})
public class FoodMapPropertiesTests {

    @Autowired
    private FoodMapProperties foodMapProperties;

    @Test
    public void getProperties(){
        Assert.assertEquals(foodMapProperties.getName(), "DONGYUZHANG");
        Assert.assertEquals(foodMapProperties.getTitle(), "My Sweet Trip");
        Assert.assertTrue(foodMapProperties.getDescription().contains("DONGYUZHANG"));
        System.out.println(foodMapProperties.getDescription());
    }
}
