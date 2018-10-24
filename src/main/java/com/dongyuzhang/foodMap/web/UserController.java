package com.dongyuzhang.foodMap.web;

import com.dongyuzhang.foodMap.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    // create thread safe map
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value = "Get All Users", notes = "")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> res = new ArrayList<User>(users.values());
        return res;
    }

    @ApiOperation(value = "Create new user", notes = "Create User based on User Information of User Object")
    @ApiImplicitParam(name = "user", value = "User Information Entity", required = true, dataType = "User")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value = "Get User Information by User Id", notes = "")
    @ApiImplicitParam(name = "id", value = "User ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        return users.get(id);
    }

    @ApiOperation(value = "Update user information", notes = "Update User Information of the User found by ID based on the User Object passed")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "User ID used to locate the user needs to be updated", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "User information used to update desinated user", required = true, dataType = "User")

    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable long id,
                             @ModelAttribute User user){
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        return "success";
    }

    @ApiOperation(value = "Delete User", notes = "Delete user based on the ID provided")
    @ApiImplicitParam(name = "id", value = "User ID used to locate the user needs to be deleted", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable long id){
        users.remove(id);
        return "success";
    }

}
